package com.github.yizijian99.domegym.domain;

import com.github.yizijian99.domegym.common.TimeRange;
import com.github.yizijian99.domegym.exception.BusinessException;
import com.github.yizijian99.domegym.exception.CommonError;
import com.github.yizijian99.domegym.utils.id.IdGenerator;
import com.google.common.collect.Lists;
import lombok.Builder;
import lombok.Data;
import org.apache.commons.collections4.CollectionUtils;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Data
@Builder
public class Schedule {
    @Builder.Default
    private Map<LocalDate, List<TimeRange>> calendar = new HashMap<>(0);

    private Long id;

    public static Schedule empty() {
        return Schedule.builder().id(IdGenerator.generateId()).build();
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
