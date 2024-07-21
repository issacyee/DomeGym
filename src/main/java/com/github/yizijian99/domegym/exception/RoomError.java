package com.github.yizijian99.domegym.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RoomError implements IError {
    CANNOT_HAVE_MORE_SESSION_THAN_SUBSCRIPTION_ALLOWS(
            "Room.CannotHaveMoreSessionThanSubscriptionAllows",
            "A room cannot have more scheduled sessions than the subscription allows"
    ),
    CANNOT_HAVE_TWO_OR_MORE_OVERLAPPING_SESSIONS(
            "Room.CannotHaveTwoOrMoreOverlappingSessions",
            "A room cannot have two or more overlapping sessions"
    ),
    ;

    private final String code;
    private final String desc;
}
