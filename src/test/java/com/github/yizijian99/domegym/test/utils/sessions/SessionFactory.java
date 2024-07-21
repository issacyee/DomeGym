package com.github.yizijian99.domegym.test.utils.sessions;

import com.github.yizijian99.domegym.common.utils.id.IdGenerator;
import com.github.yizijian99.domegym.domain.aggregate.session.Session;
import com.github.yizijian99.domegym.domain.common.valueobject.TimeRange;
import com.github.yizijian99.domegym.test.constants.ConstantsSession;

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

        return new Session(date, time, maxParticipants, id);
    }
}
