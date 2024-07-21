package com.github.yizijian99.domegym.domain;

import com.github.yizijian99.domegym.common.Entity;
import com.github.yizijian99.domegym.exception.BusinessException;
import com.github.yizijian99.domegym.exception.CommonError;
import com.github.yizijian99.domegym.exception.RoomError;
import com.github.yizijian99.domegym.exception.SessionError;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@SuppressWarnings("FieldMayBeFinal")
public class Room extends Entity {
    private List<Long> sessionIds = new ArrayList<>(0);

    private Integer maxDailySessions;

    private Long gymId;

    private Schedule schedule = Schedule.empty();

    public void scheduleSession(Session session) {
        if (sessionIds.stream().anyMatch(id -> Objects.equals(id, session.getId()))) {
            throw new BusinessException(SessionError.SESSION_ALREADY_EXISTS_IN_ROOM);
        }

        if (sessionIds.size() >= maxDailySessions) {
            throw new BusinessException(RoomError.CANNOT_HAVE_MORE_SESSION_THAN_SUBSCRIPTION_ALLOWS);
        }

        try {
            schedule.bookTimeSlot(session.getDate(), session.getTime());
        } catch (BusinessException e) {
            if (CommonError.CONFLICT.equals(e.getError())) {
                throw new BusinessException(RoomError.CANNOT_HAVE_TWO_OR_MORE_OVERLAPPING_SESSIONS);
            }
        }

        sessionIds.add(session.getId());
    }
}
