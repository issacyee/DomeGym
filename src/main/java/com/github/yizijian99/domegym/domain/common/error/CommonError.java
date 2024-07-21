package com.github.yizijian99.domegym.domain.common.error;

import com.github.yizijian99.domegym.common.exception.IError;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CommonError implements IError {
    CONFLICT(
            "Common.Conflict",
            "Conflict"
    ),
    START_AND_END_DATE_TIME_MUST_BE_ON_THE_SAME_DAY(
            "Common.StartAndEndDateTimeMustBeOnTheSameDay",
            "Start and end date time must be on the same day"
    ),
    END_TIME_MUST_BE_GREATER_THAN_THE_START_TIME(
            "Common.EndTimeMustBeGreaterThanTheStartTime",
            "End time must be greater than the start time"
    ),
    ;

    private final String code;
    private final String desc;
}
