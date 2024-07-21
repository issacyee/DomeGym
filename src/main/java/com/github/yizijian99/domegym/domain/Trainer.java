package com.github.yizijian99.domegym.domain;

import com.github.yizijian99.domegym.common.Entity;
import com.github.yizijian99.domegym.exception.BusinessException;
import com.github.yizijian99.domegym.exception.CommonError;
import com.github.yizijian99.domegym.exception.TrainerError;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@SuppressWarnings({"FieldMayBeFinal", "UnusedAssignment"})
public class Trainer extends Entity {
    private Long id;

    private Long userId;

    private List<Long> sessionIds = new ArrayList<>(0);

    private Schedule schedule = Schedule.empty();

    public Trainer(Long userId, Schedule schedule) {
        this(userId, schedule, null);
    }

    public Trainer(Long userId, Schedule schedule, Long id) {
        super(id);
        this.userId = userId;
        if (Objects.isNull(schedule)) {
            schedule = Schedule.empty();
        }
        this.schedule = schedule;
    }

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
