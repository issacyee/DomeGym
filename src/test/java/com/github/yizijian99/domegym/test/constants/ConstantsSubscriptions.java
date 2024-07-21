package com.github.yizijian99.domegym.test.constants;

import com.github.yizijian99.domegym.constants.SubscriptionType;
import com.github.yizijian99.domegym.utils.id.IdGenerator;

public class ConstantsSubscriptions {
    private ConstantsSubscriptions() {}

    public static final Long ID = IdGenerator.generateId();
    public static final Integer MAX_DAILY_SESSIONS_FREE_TIER = 4;
    public static final Integer MAX_ROOMS_FREE_TIER = 1;
    public static final Integer MAX_GYMS_FREE_TIER = 1;
    public static final SubscriptionType DEFAULT_SUBSCRIPTION_TYPE = SubscriptionType.FREE;
}
