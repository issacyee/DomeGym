package com.github.yizijian99.domegym.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalTime;

@Getter
@AllArgsConstructor
public class TimeRange {
    private LocalTime start;
    private LocalTime end;

    public boolean overlapsWith(TimeRange other) {
        if (!start.isBefore(other.end))
            return false;
        return other.start.isBefore(end);
    }
}