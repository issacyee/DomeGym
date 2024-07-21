package com.github.yizijian99.domegym.domain;

import com.github.yizijian99.domegym.exception.BusinessException;
import com.github.yizijian99.domegym.exception.CommonError;
import com.github.yizijian99.domegym.exception.TrainerError;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class Trainer {
    private Long id;

    private Long userId;

    @Builder.Default
    private List<Long> sessionIds = new ArrayList<>(0);

    @Builder.Default
    private Schedule schedule = Schedule.empty();

    public void addSessionToSchedule(Session session) {
        if (sessionIds.contains(session.getId())) {
            throw new BusinessException(TrainerError.SESSION_ALREADY_EXISTS_IN_TRAINERS_SCHEDULE);
        }

        try {
            schedule.bookTimeSlot(session.getDate(), session.getTime());
        } catch (BusinessException e) {
            if (CommonError.CONFLICT.equals(e.getError())) {
                throw new BusinessException(TrainerError.CANNOT_HAVE_TWO_OR_MORE_OVERLAPPING_SESSIONS);
            }
        }

        sessionIds.add(session.getId());
    }
}
