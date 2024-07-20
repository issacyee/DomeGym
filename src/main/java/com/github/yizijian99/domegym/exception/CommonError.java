package com.github.yizijian99.domegym.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CommonError implements IError {
    CONFLICT(
            "Common.Conflict",
            "Conflict"
    ),
    ;

    private final String code;
    private final String desc;
}
