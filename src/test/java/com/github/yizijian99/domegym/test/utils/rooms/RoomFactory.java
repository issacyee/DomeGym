package com.github.yizijian99.domegym.test.utils.rooms;

import com.github.yizijian99.domegym.domain.Room;
import com.github.yizijian99.domegym.test.constants.ConstantsGym;
import com.github.yizijian99.domegym.test.constants.ConstantsRoom;

import java.util.Objects;

public class RoomFactory {
    public RoomFactory() {
    }

    public static Room createRoom(Long id) {
        return createRoom(null, null, id);
    }

    public static Room createRoom(Integer maxDailySessions,
                                  Long gymId,
                                  Long id) {
        if (Objects.isNull(maxDailySessions)) {
            maxDailySessions = ConstantsRoom.MAX_DAILY_SESSIONS_FREE_TIER;
        }
        if (Objects.isNull(gymId)) {
            gymId = ConstantsGym.ID;
        }
        if (Objects.isNull(id)) {
            id = ConstantsRoom.ID;
        }

        return new Room(maxDailySessions, gymId, null, id);
    }
}
