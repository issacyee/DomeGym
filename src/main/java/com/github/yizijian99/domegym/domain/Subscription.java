package com.github.yizijian99.domegym.domain;

import com.github.yizijian99.domegym.constants.SubscriptionType;
import com.github.yizijian99.domegym.exception.BusinessException;
import com.github.yizijian99.domegym.exception.SubscriptionError;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class Subscription {
    private Long id;

    @Builder.Default
    private List<Long> gymIds = new ArrayList<>(0);

    private SubscriptionType subscriptionType;

    private Long adminId;

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
