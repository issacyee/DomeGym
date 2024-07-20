package com.github.yizijian99.domegym.domain;

import com.github.yizijian99.domegym.utils.id.IdGenerator;
import lombok.Data;
import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
public class Session {
    private Long sessionId;

    private Long trainerId;

    private List<Long> participantIds = new ArrayList<>(0);

    private Integer maxParticipants;

    public Session(Integer maxParticipants, Long trainerId) {
        this(maxParticipants, trainerId, null);
    }

    public Session(Integer maxParticipants, Long trainerId, Long sessionId) {
        this.maxParticipants = maxParticipants;
        if (Objects.isNull(sessionId)) {
            sessionId = IdGenerator.generateId();
        }
        this.trainerId = trainerId;
        this.sessionId = sessionId;
    }

    public void reserveSpot(Participant participant) {
        if (CollectionUtils.size(participantIds) >= maxParticipants) {
            throw new RuntimeException("Cannot have more reservations than participants.");
        }

        participantIds.add(participant.getId());
    }
}
