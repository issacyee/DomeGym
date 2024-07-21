package com.github.yizijian99.domegym.test.utils.participants;

import com.github.yizijian99.domegym.domain.aggregate.participant.Participant;
import com.github.yizijian99.domegym.test.constants.ConstantsParticipant;
import com.github.yizijian99.domegym.test.constants.ConstantsUser;
import org.apache.commons.lang3.ObjectUtils;

public class ParticipantFactory {
    private ParticipantFactory() {
    }

    public static Participant createParticipant() {
        return createParticipant(null, null);
    }

    public static Participant createParticipant(Long id, Long userId) {
        return new Participant(
                ObjectUtils.defaultIfNull(userId, ConstantsUser.ID),
                ObjectUtils.defaultIfNull(id, ConstantsParticipant.ID)
        );
    }
}
