package com.github.yizijian99.domegym.domain.common.valueobject;

import com.github.yizijian99.domegym.domain.common.ValueObject;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalTime;
import java.util.Collection;
import java.util.List;

@Getter
@AllArgsConstructor
public class TimeRange extends ValueObject {
    private LocalTime start;
    private LocalTime end;

    public boolean overlapsWith(TimeRange other) {
        if (!start.isBefore(other.end))
            return false;
        return other.start.isBefore(end);
    }

    @Override
    public Collection<Object> getEqualityComponents() {
        return List.of(start, end);
    }
}