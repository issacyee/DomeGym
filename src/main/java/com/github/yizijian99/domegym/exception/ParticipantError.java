package com.github.yizijian99.domegym.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ParticipantError implements IError {
    CANNOT_HAVE_TWO_OR_MORE_OVERLAPPING_SESSIONS(
            "Participant.CannotHaveTwoOrMoreOverlappingSessions",
            "Cannot have two or more overlapping sessions"
    ),
    ;

    private final String code;
    private final String desc;
}
