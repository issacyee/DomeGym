package com.github.yizijian99.domegym.test.utils.subscriptions;

import com.github.yizijian99.domegym.constants.SubscriptionType;
import com.github.yizijian99.domegym.domain.Subscription;
import com.github.yizijian99.domegym.test.constants.ConstantsAdmin;
import com.github.yizijian99.domegym.test.constants.ConstantsSubscriptions;

import java.util.Objects;

public class SubscriptionFactory {
    private SubscriptionFactory() {
    }

    public static Subscription createSubscription() {
        return createSubscription(null, null, null);
    }

    public static Subscription createSubscription(SubscriptionType subscriptionType,
                                                  Long adminId,
                                                  Long id) {
        if (Objects.isNull(subscriptionType)) {
            subscriptionType = ConstantsSubscriptions.DEFAULT_SUBSCRIPTION_TYPE;
        }
        if (Objects.isNull(adminId)) {
            adminId = ConstantsAdmin.ID;
        }
        if (Objects.isNull(id)) {
            id = ConstantsSubscriptions.ID;
        }

        return new Subscription(subscriptionType, adminId, id);
    }
}
