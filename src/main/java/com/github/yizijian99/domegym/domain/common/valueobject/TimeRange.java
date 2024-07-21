package com.github.yizijian99.domegym.domain.common.valueobject;

import com.github.yizijian99.domegym.common.exception.BusinessException;
import com.github.yizijian99.domegym.domain.common.ValueObject;
import com.github.yizijian99.domegym.domain.common.error.CommonError;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Getter
public class TimeRange extends ValueObject {
    private final LocalTime start;
    private final LocalTime end;

    public TimeRange(LocalTime start, LocalTime end) {
        if (start.isAfter(end)) {
            throw new RuntimeException("%s is after %s".formatted(start, end));
        }
        this.start = start;
        this.end = end;
    }

    public static TimeRange fromDateTimes(LocalDateTime start, LocalDateTime end) {
        if (Objects.equals(start.toLocalDate(), end.toLocalDate())) {
            throw new BusinessException(CommonError.START_AND_END_DATE_TIME_MUST_BE_ON_THE_SAME_DAY);
        }

        if (start.isAfter(end)) {
            throw new BusinessException(CommonError.END_TIME_MUST_BE_GREATER_THAN_THE_START_TIME);
        }

        return new TimeRange(start.toLocalTime(), end.toLocalTime());
    }

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