package com.github.yizijian99.domegym.test.utils.gyms;

import com.github.yizijian99.domegym.common.utils.id.IdGenerator;
import com.github.yizijian99.domegym.domain.aggregate.gym.Gym;
import com.github.yizijian99.domegym.test.constants.ConstantsSubscriptions;
import org.apache.commons.lang3.ObjectUtils;

public class GymFactory {
    private GymFactory() {
    }

    public static Gym createGym(Integer maxRooms) {
        return createGym(maxRooms, null);
    }

    public static Gym createGym(Integer maxRooms,
                                Long id) {
        return new Gym(
                ObjectUtils.defaultIfNull(maxRooms, ConstantsSubscriptions.MAX_ROOMS_FREE_TIER),
                ConstantsSubscriptions.ID,
                ObjectUtils.getIfNull(id, IdGenerator::generateId)
        );
    }
}
