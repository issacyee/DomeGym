package com.github.yizijian99.domegym.application.common.interfaces;

import com.github.yizijian99.domegym.domain.aggregate.session.Session;

public interface ISessionRepository {
    void addSession(Session session);

    void updateSession(Session session);
}
