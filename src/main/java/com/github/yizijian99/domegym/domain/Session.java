package com.github.yizijian99.domegym.domain;

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

    private LocalTime startTime;

    private LocalTime endTime;

    public void reserveSpot(Participant participant) {
        if (participantIds.size() >= maxParticipants) {
            throw new RuntimeException("Cannot have more reservations than participants.");
        }

        participantIds.add(participant.getId());
    }

    public void cancelReservation(Participant participant, IDateTimeProvider dateTimeProvider) {
        // session time - current time < 24 hours
        if (isTooCloseSession(dateTimeProvider.getUtcNow())) {
            throw new RuntimeException("Cannot cancel reservation too close to session");
        }

        if (!participantIds.remove(participant.getId())) {
            throw new RuntimeException("Reservation not found");
        }
    }

    private boolean isTooCloseSession(LocalDateTime utcNow) {
        final long minHours = 24;
        return Duration.between(utcNow, LocalDateTime.of(date, startTime)).toHours() < minHours;
    }
}
