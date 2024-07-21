package com.github.yizijian99.domegym.domain;

import com.github.yizijian99.domegym.common.exception.BusinessException;
import com.github.yizijian99.domegym.common.utils.id.IdGenerator;
import com.github.yizijian99.domegym.domain.aggregate.gym.Gym;
import com.github.yizijian99.domegym.domain.aggregate.gym.GymError;
import com.github.yizijian99.domegym.domain.aggregate.room.Room;
import com.github.yizijian99.domegym.test.utils.gyms.GymFactory;
import com.github.yizijian99.domegym.test.utils.rooms.RoomFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;


public class GymTests {
    @Test
    public void addRoom_WhenMoreThanSubscriptionAllows_ShouldFail() {
        // Arrange
        Gym gym = GymFactory.createGym(1);
        Room room1 = RoomFactory.createRoom(IdGenerator.generateId());
        Room room2 = RoomFactory.createRoom(IdGenerator.generateId());

        // Action
        Executable executable1 = () -> gym.addRoom(room1);
        Executable executable2 = () -> gym.addRoom(room2);

        // Assert
        Assertions.assertDoesNotThrow(executable1);
        Assertions.assertThrowsExactly(BusinessException.class, executable2, GymError.CANNOT_HAVE_MORE_ROOMS_THAN_SUBSCRIPTION_ALLOWS.getCode());
    }
}