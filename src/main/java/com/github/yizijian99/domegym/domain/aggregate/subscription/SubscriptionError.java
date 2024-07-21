package com.github.yizijian99.domegym.domain.aggregate.subscription;

import com.github.yizijian99.domegym.common.exception.IError;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SubscriptionError implements IError {
    GYM_ALREADY_EXISTS(
            "Subscription.GymAlreadyExists",
            "Gym already exists"
    ),
    CANNOT_HAVE_MORE_GYMS_THAN_SUBSCRIPTION_ALLOWS(
            "Subscription.CannotHaveMoreGymsThanSubscriptionAllows",
            "A subscription cannot have more gyms than the subscription allows"
    ),
    ;

    private final String code;
    private final String desc;
}
