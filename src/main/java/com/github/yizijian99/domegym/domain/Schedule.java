package com.github.yizijian99.domegym.domain;

import com.github.yizijian99.domegym.common.Entity;
import com.github.yizijian99.domegym.common.TimeRange;
import com.github.yizijian99.domegym.exception.BusinessException;
import com.github.yizijian99.domegym.exception.CommonError;
import com.github.yizijian99.domegym.utils.id.IdGenerator;
import com.google.common.collect.Lists;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Getter
@Setter
public class Schedule extends Entity {
    private Map<LocalDate, List<TimeRange>> calendar = new HashMap<>(0);

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
