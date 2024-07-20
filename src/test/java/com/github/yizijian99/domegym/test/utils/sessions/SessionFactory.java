package com.github.yizijian99.domegym.test.utils.sessions;

import com.github.yizijian99.domegym.domain.Session;
import com.github.yizijian99.domegym.test.constants.ConstantsTrainer;
import com.github.yizijian99.domegym.utils.id.IdGenerator;

import java.util.Objects;

public class SessionFactory {
    private SessionFactory() {}

    public static Session createSession(Integer maxParticipants) {
        return createSession(maxParticipants, null);
    }

    public static Session createSession(Integer maxParticipants, Long id) {
        if (Objects.isNull(id)) {
            id = IdGenerator.generateId();
        }
        return new Session(maxParticipants, ConstantsTrainer.ID, id);
    }
}
