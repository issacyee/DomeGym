package com.github.yizijian99.domegym.test.utils.participants;

import com.github.yizijian99.domegym.domain.Participant;
import com.github.yizijian99.domegym.test.constants.ConstantsParticipant;
import com.github.yizijian99.domegym.test.constants.ConstantsUser;

import java.util.Objects;

public class ParticipantFactory {
    private ParticipantFactory() {
    }

    public static Participant createParticipant() {
        return createParticipant(null, null);
    }

    public static Participant createParticipant(Long id, Long userId) {
        if (Objects.isNull(id)) {
            id = ConstantsParticipant.ID;
        }
        if (Objects.isNull(userId)) {
            userId = ConstantsUser.ID;
        }

        return new Participant(userId, id);
    }
}
