package com.github.yizijian99.domegym.domain.aggregate.gym;

import com.github.yizijian99.domegym.common.exception.IError;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum GymError implements IError {
    ROOM_ALREADY_EXISTS_IN_GYM(
            "Gym.RoomAlreadyExistsInGym",
            "Room already exists in gym"
    ),
    CANNOT_HAVE_MORE_ROOMS_THAN_SUBSCRIPTION_ALLOWS(
            "Gym.CannotHaveMoreRoomsThanSubscriptionAllows",
            "A gym cannot have more rooms than the subscription allows"
    ),
    ;

    private final String code;
    private final String desc;
}
