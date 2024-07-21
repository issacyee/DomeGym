package com.github.yizijian99.domegym.test.utils.common;

import com.github.yizijian99.domegym.domain.common.valueobject.TimeRange;

import java.time.LocalTime;

public class TimeRangeFactory {
    private TimeRangeFactory() {
    }

    public static TimeRange createFromHours(int startHour, int endHour) {
        if (startHour >= endHour
                || startHour < 0
                || startHour > 23) {
            throw new RuntimeException("start hour is invalid");
        }

        if (endHour > 24) {
            throw new RuntimeException("end hour is valid");
        }

        return new TimeRange(LocalTime.MIN.plusHours(startHour), LocalTime.MIN.plusHours(endHour));
    }
}
