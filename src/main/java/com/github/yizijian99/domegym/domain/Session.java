package com.github.yizijian99.domegym.domain;

import com.github.yizijian99.domegym.common.TimeRange;
import com.github.yizijian99.domegym.exception.BusinessException;
import com.github.yizijian99.domegym.exception.SessionError;
import lombok.Builder;
import lombok.Data;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class Session {
    private Long id;

    private Long trainerId;

    @Builder.Default
    private List<Long> participantIds = new ArrayList<>(0);

    private Integer maxParticipants;

    private LocalDate date;

    private TimeRange time;

    public void reserveSpot(Participant participant) {
        if (participantIds.size() >= maxParticipants) {
            throw new BusinessException(SessionError.CANNOT_HAVE_MORE_RESERVATIONS_THAN_PARTICIPANTS);
        }

        participantIds.add(participant.getId());
    }

    public void cancelReservation(Participant participant, IDateTimeProvider dateTimeProvider) {
        // session time - current time < 24 hours
        if (isTooCloseSession(dateTimeProvider.getUtcNow())) {
            throw new BusinessException(SessionError.CANNOT_CANCEL_RESERVATION_TOO_CLOSE_TO_SESSION);
        }

        if (!participantIds.remove(participant.getId())) {
            throw new BusinessException(SessionError.RESERVATION_NOT_FOUND);
        }
    }

    private boolean isTooCloseSession(LocalDateTime utcNow) {
        final long minHours = 24;
        return Duration.between(utcNow, LocalDateTime.of(date, time.getStart())).toHours() < minHours;
    }
}
