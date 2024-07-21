package com.github.yizijian99.domegym.test.utils.sessions;

import com.github.yizijian99.domegym.common.TimeRange;
import com.github.yizijian99.domegym.domain.Session;
import com.github.yizijian99.domegym.test.constants.ConstantsSession;
import com.github.yizijian99.domegym.utils.id.IdGenerator;

import java.time.LocalDate;
import java.util.Objects;

public class SessionFactory {
    private SessionFactory() {
    }

    public static Session createSession(Integer maxParticipants) {
        return createSession(null, null, maxParticipants, null);
    }

    public static Session createSession(Long id) {
        return createSession(null, null, null, id);
    }

    public static Session createSession(LocalDate date,
                                        TimeRange time,
                                        Integer maxParticipants,
                                        Long id) {
        if (Objects.isNull(date)) {
            date = ConstantsSession.DATE;
        }
        if (Objects.isNull(time)) {
            time = ConstantsSession.TIME;
        }
        if (Objects.isNull(maxParticipants)) {
            maxParticipants = ConstantsSession.MAX_PARTICIPANTS;
        }
        if (Objects.isNull(id)) {
            id = IdGenerator.generateId();
        }

        Session session = new Session();
        session.setDate(date);
        session.setTime(time);
        session.setMaxParticipants(maxParticipants);
        session.setId(id);
        return session;
    }
}
