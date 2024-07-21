package com.github.yizijian99.domegym.test.utils.rooms;

import com.github.yizijian99.domegym.domain.aggregate.room.Room;
import com.github.yizijian99.domegym.test.constants.ConstantsGym;
import com.github.yizijian99.domegym.test.constants.ConstantsRoom;
import org.apache.commons.lang3.ObjectUtils;

public class RoomFactory {
    public RoomFactory() {
    }

    public static Room createRoom(Long id) {
        return createRoom(null, null, id);
    }

    public static Room createRoom(Integer maxDailySessions,
                                  Long gymId,
                                  Long id) {
        return new Room(
                ObjectUtils.defaultIfNull(maxDailySessions, ConstantsRoom.MAX_DAILY_SESSIONS_FREE_TIER),
                ObjectUtils.defaultIfNull(gymId, ConstantsGym.ID),
                null,
                ObjectUtils.defaultIfNull(id, ConstantsRoom.ID)
        );
    }
}
