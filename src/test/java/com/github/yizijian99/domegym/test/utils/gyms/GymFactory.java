package com.github.yizijian99.domegym.test.utils.gyms;

import com.github.yizijian99.domegym.domain.Gym;
import com.github.yizijian99.domegym.test.constants.ConstantsSubscriptions;
import com.github.yizijian99.domegym.utils.id.IdGenerator;

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

        Gym gym = new Gym();
        gym.setMaxRooms(maxRooms);
        gym.setSubscriptionId(ConstantsSubscriptions.ID);
        gym.setId(id);
        return gym;
    }
}
