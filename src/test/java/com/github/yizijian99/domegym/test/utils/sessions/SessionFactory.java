package com.github.yizijian99.domegym.test.utils.sessions;

import com.github.yizijian99.domegym.common.utils.id.IdGenerator;
import com.github.yizijian99.domegym.domain.aggregate.session.Session;
import com.github.yizijian99.domegym.domain.common.valueobject.TimeRange;
import com.github.yizijian99.domegym.test.constants.ConstantsSession;
import org.apache.commons.lang3.ObjectUtils;

import java.time.LocalDate;

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
        return new Session(
                ObjectUtils.defaultIfNull(date, ConstantsSession.DATE),
                ObjectUtils.defaultIfNull(time, ConstantsSession.TIME),
                ObjectUtils.defaultIfNull(maxParticipants, ConstantsSession.MAX_PARTICIPANTS),
                ObjectUtils.getIfNull(id, IdGenerator::generateId)
        );
    }
}
