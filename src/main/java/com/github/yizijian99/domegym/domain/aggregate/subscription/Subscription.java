package com.github.yizijian99.domegym.domain.aggregate.subscription;

import com.github.yizijian99.domegym.common.exception.BusinessException;
import com.github.yizijian99.domegym.domain.aggregate.gym.Gym;
import com.github.yizijian99.domegym.domain.common.Entity;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@SuppressWarnings("FieldMayBeFinal")
public class Subscription extends Entity {
    private Long id;

    private List<Long> gymIds = new ArrayList<>(0);

    private SubscriptionType subscriptionType;

    private Long adminId;

    public Subscription(SubscriptionType subscriptionType, Long adminId) {
        this(subscriptionType, adminId, null);
    }

    public Subscription(SubscriptionType subscriptionType, Long adminId, Long id) {
        super(id);
        this.subscriptionType = subscriptionType;
        this.adminId = adminId;
    }

    public Integer getMaxGyms() {
        switch (subscriptionType) {
            case FREE, STARTER -> {
                return 1;
            }
            case PRO -> {
                return 3;
            }
            default -> throw new IllegalArgumentException();
        }
    }

    public void addGym(Gym gym) {
        if (gymIds.contains(gym.getId())) {
            throw new BusinessException(SubscriptionError.GYM_ALREADY_EXISTS);
        }

        if (gymIds.size() >= getMaxGyms()) {
            throw new BusinessException(SubscriptionError.CANNOT_HAVE_MORE_GYMS_THAN_SUBSCRIPTION_ALLOWS);
        }

        gymIds.add(gym.getId());
    }
}
