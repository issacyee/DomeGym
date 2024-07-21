package com.github.yizijian99.domegym.test.utils.subscriptions;

import com.github.yizijian99.domegym.domain.aggregate.subscription.Subscription;
import com.github.yizijian99.domegym.domain.aggregate.subscription.SubscriptionType;
import com.github.yizijian99.domegym.test.constants.ConstantsAdmin;
import com.github.yizijian99.domegym.test.constants.ConstantsSubscriptions;
import org.apache.commons.lang3.ObjectUtils;

public class SubscriptionFactory {
    private SubscriptionFactory() {
    }

    public static Subscription createSubscription() {
        return createSubscription(null, null, null);
    }

    public static Subscription createSubscription(SubscriptionType subscriptionType,
                                                  Long adminId,
                                                  Long id) {
        return new Subscription(
                ObjectUtils.defaultIfNull(subscriptionType, ConstantsSubscriptions.DEFAULT_SUBSCRIPTION_TYPE),
                ObjectUtils.defaultIfNull(adminId, ConstantsAdmin.ID),
                ObjectUtils.defaultIfNull(id, ConstantsSubscriptions.ID)
        );
    }
}
