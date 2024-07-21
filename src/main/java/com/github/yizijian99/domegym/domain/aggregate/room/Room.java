package com.github.yizijian99.domegym.domain.aggregate.room;

import com.github.yizijian99.domegym.common.exception.BusinessException;
import com.github.yizijian99.domegym.domain.aggregate.session.Session;
import com.github.yizijian99.domegym.domain.aggregate.session.SessionError;
import com.github.yizijian99.domegym.domain.common.AggregateRoot;
import com.github.yizijian99.domegym.domain.common.entity.Schedule;
import com.github.yizijian99.domegym.domain.common.error.CommonError;
import lombok.Getter;
import org.apache.commons.lang3.ObjectUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@SuppressWarnings({"FieldMayBeFinal", "UnusedAssignment"})
public class Room extends AggregateRoot {
    private Integer maxDailySessions;

    private Long gymId;

    private Schedule schedule = Schedule.empty();

    private List<Long> sessionIds = new ArrayList<>(0);

    public Room(Integer maxDailySessions, Long gymId) {
        this(maxDailySessions, gymId, null, null);
    }

    public Room(Integer maxDailySessions, Long gymId, Schedule schedule) {
        this(maxDailySessions, gymId, schedule, null);
    }

    public Room(Integer maxDailySessions, Long gymId, Schedule schedule, Long id) {
        super(id);
        this.maxDailySessions = maxDailySessions;
        this.gymId = gymId;
        this.schedule = ObjectUtils.getIfNull(schedule, Schedule::empty);
    }

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
