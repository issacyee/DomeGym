package com.github.yizijian99.domegym.domain;

import com.github.yizijian99.domegym.common.Entity;
import com.github.yizijian99.domegym.common.TimeRange;
import com.github.yizijian99.domegym.exception.BusinessException;
import com.github.yizijian99.domegym.exception.CommonError;
import com.github.yizijian99.domegym.exception.SessionError;
import lombok.Getter;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Getter
@SuppressWarnings("FieldMayBeFinal")
public class Session extends Entity {
    private Long trainerId;

    private List<Reservation> reservations = new ArrayList<>(0);

    private Integer maxParticipants;

    private LocalDate date;

    private TimeRange time;

    public Session(LocalDate date, TimeRange time, Integer maxParticipants, Long trainerId) {
        this(date, time, maxParticipants, trainerId, null);
    }

    public Session(LocalDate date, TimeRange time, Integer maxParticipants, Long trainerId, Long id) {
        super(id);
        this.date = date;
        this.time = time;
        this.maxParticipants = maxParticipants;
        this.trainerId = trainerId;
    }

    public void reserveSpot(Participant participant) {
        if (reservations.size() >= maxParticipants) {
            throw new BusinessException(SessionError.CANNOT_HAVE_MORE_RESERVATIONS_THAN_PARTICIPANTS);
        }

        if (reservations.stream().anyMatch(reservation -> Objects.equals(reservation.getParticipantId(), participant.getId()))) {
            throw new BusinessException(CommonError.CONFLICT);
        }

        reservations.add(new Reservation(participant.getId()));
    }

    public void cancelReservation(Participant participant, IDateTimeProvider dateTimeProvider) {
        // session time - current time < 24 hours
        if (isTooCloseSession(dateTimeProvider.getUtcNow())) {
            throw new BusinessException(SessionError.CANNOT_CANCEL_RESERVATION_TOO_CLOSE_TO_SESSION);
        }

        Optional<Reservation> optional = reservations.stream()
                .filter(reservation -> Objects.equals(reservation.getParticipantId(), participant.getId()))
                .findFirst();
        if (optional.isEmpty()) {
            throw new BusinessException(SessionError.RESERVATION_NOT_FOUND);
        }
        Reservation reservation = optional.get();

        reservations.remove(reservation);
    }

    private boolean isTooCloseSession(LocalDateTime utcNow) {
        final long minHours = 24;
        return Duration.between(utcNow, LocalDateTime.of(date, time.getStart())).toHours() < minHours;
    }
}
