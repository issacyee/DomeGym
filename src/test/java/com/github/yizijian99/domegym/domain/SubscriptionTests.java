package com.github.yizijian99.domegym.domain;

import com.github.yizijian99.domegym.exception.BusinessException;
import com.github.yizijian99.domegym.exception.SubscriptionError;
import com.github.yizijian99.domegym.test.utils.gyms.GymFactory;
import com.github.yizijian99.domegym.test.utils.subscriptions.SubscriptionFactory;
import com.github.yizijian99.domegym.utils.id.IdGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.List;
import java.util.stream.IntStream;

public class SubscriptionTests {
    @Test
    public void addGym_WhenMoreThanSubscriptionAllows_ShouldFail() {
        // Arrange
        Subscription subscription = SubscriptionFactory.createSubscription();

        List<Gym> gyms = IntStream.range(0, subscription.getMaxGyms() + 1)
                .mapToObj(v -> GymFactory.createGym(null, IdGenerator.generateId()))
                .toList();

        // Action
        Executable executable1 = () -> gyms.stream().limit(gyms.size() - 1).forEach(subscription::addGym);
        Executable executable2 = () -> gyms.stream().skip(gyms.size() - 1).forEach(subscription::addGym);

        // Assert
        Assertions.assertDoesNotThrow(executable1);
        Assertions.assertThrowsExactly(BusinessException.class, executable2, SubscriptionError.CANNOT_HAVE_MORE_GYMS_THAN_SUBSCRIPTION_ALLOWS.getCode());
    }
}
