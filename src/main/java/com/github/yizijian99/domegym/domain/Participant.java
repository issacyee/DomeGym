package com.github.yizijian99.domegym.domain;

import com.github.yizijian99.domegym.common.Entity;
import com.github.yizijian99.domegym.exception.BusinessException;
import com.github.yizijian99.domegym.exception.CommonError;
import com.github.yizijian99.domegym.exception.ParticipantError;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@SuppressWarnings("FieldMayBeFinal")
public class Participant extends Entity {
    private Long userId;

    private Schedule schedule = Schedule.empty();

    private List<Long> sessionIds = new ArrayList<>(0);

    public Participant(Long userId) {
        this(userId, null);
    }

    public Participant(Long userId, Long id) {
        super(id);
        this.userId = userId;
    }

    public void addToSchedule(Session session) {
        if (sessionIds.contains(session.getId())) {
            throw new BusinessException(CommonError.CONFLICT);
        }

        try {
            schedule.bookTimeSlot(session.getDate(), session.getTime());
        } catch (BusinessException e) {
            if (CommonError.CONFLICT.equals(e.getError())) {
                throw new BusinessException(ParticipantError.CANNOT_HAVE_TWO_OR_MORE_OVERLAPPING_SESSIONS);
            }
        }

        sessionIds.add(session.getId());
    }
}
