package com.github.yizijian99.domegym.test.utils.sessions;

import com.github.yizijian99.domegym.domain.Session;
import com.github.yizijian99.domegym.test.constants.ConstantsSession;
import com.github.yizijian99.domegym.test.constants.ConstantsTrainer;
import com.github.yizijian99.domegym.utils.id.IdGenerator;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class SessionFactory {
    private SessionFactory() {}

    public static Session createSession(Integer maxParticipants) {
        return createSession(null, null, null, maxParticipants, null);
    }

    public static Session createSession(LocalDate date,
                                        LocalTime startTime,
                                        LocalTime endTime,
                                        Integer maxParticipants,
                                        Long id) {
        if (Objects.isNull(date)) {
            date = ConstantsSession.DATE;
        }
        if (Objects.isNull(startTime)) {
            startTime = ConstantsSession.START_TIME;
        }
        if (Objects.isNull(endTime)) {
            endTime = ConstantsSession.END_TIME;
        }
        if (Objects.isNull(maxParticipants)) {
            maxParticipants = ConstantsSession.MAX_PARTICIPANTS;
        }
        if (Objects.isNull(id)) {
            id = IdGenerator.generateId();
        }

        return Session.builder()
                .date(date)
                .startTime(startTime)
                .endTime(endTime)
                .maxParticipants(maxParticipants)
                .trainerId(ConstantsTrainer.ID)
                .id(id)
                .build();
    }
}
