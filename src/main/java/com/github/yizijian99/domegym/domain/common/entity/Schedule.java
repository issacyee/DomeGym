package com.github.yizijian99.domegym.domain.common.entity;

import com.github.yizijian99.domegym.common.exception.BusinessException;
import com.github.yizijian99.domegym.common.utils.id.IdGenerator;
import com.github.yizijian99.domegym.domain.common.Entity;
import com.github.yizijian99.domegym.domain.common.error.CommonError;
import com.github.yizijian99.domegym.domain.common.valueobject.TimeRange;
import com.google.common.collect.Lists;
import lombok.Getter;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Getter
@SuppressWarnings({"FieldMayBeFinal", "UnusedAssignment"})
public class Schedule extends Entity {
    private Map<LocalDate, List<TimeRange>> calendar = new HashMap<>(0);

    public Schedule() {
        this(null, null);
    }

    public Schedule(Map<LocalDate, List<TimeRange>> calendar) {
        this(calendar, null);
    }

    public Schedule(Map<LocalDate, List<TimeRange>> calendar, Long id) {
        super(id);
        if (Objects.isNull(calendar)) {
            calendar = new HashMap<>(0);
        }
        this.calendar = calendar;
    }

    public static Schedule empty() {
        Schedule schedule = new Schedule();
        schedule.id = IdGenerator.generateId();
        return schedule;
    }

    public void bookTimeSlot(LocalDate date, TimeRange time) {
        List<TimeRange> timeSlots = calendar.get(date);
        if (Objects.isNull(timeSlots)) {
            calendar.put(date, Lists.newArrayList(time));
            return;
        }

        if (timeSlots.stream().anyMatch(timeSlot -> timeSlot.overlapsWith(time))) {
            throw new BusinessException(CommonError.CONFLICT);
        }

        timeSlots.add(time);
    }
}
