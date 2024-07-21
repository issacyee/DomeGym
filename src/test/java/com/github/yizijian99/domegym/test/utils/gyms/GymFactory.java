package com.github.yizijian99.domegym.test.utils.gyms;

import com.github.yizijian99.domegym.common.utils.id.IdGenerator;
import com.github.yizijian99.domegym.domain.aggregate.gym.Gym;
import com.github.yizijian99.domegym.test.constants.ConstantsSubscriptions;

import java.util.Objects;

public class GymFactory {
    private GymFactory() {
    }

    public static Gym createGym(Integer maxRooms) {
        return createGym(maxRooms, null);
    }

    public static Gym createGym(Integer maxRooms,
                                Long id) {
        if (Objects.isNull(maxRooms)) {
            maxRooms = ConstantsSubscriptions.MAX_ROOMS_FREE_TIER;
        }
        if (Objects.isNull(id)) {
            id = IdGenerator.generateId();
        }

        return new Gym(maxRooms, ConstantsSubscriptions.ID, id);
    }
}
