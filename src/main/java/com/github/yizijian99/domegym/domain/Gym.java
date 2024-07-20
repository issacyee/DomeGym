package com.github.yizijian99.domegym.domain;

import com.github.yizijian99.domegym.exception.BusinessException;
import com.github.yizijian99.domegym.exception.GymError;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class Gym {
    private Long id;

    @Builder.Default
    private List<Long> roomIds = new ArrayList<>(0);

    private Integer maxRooms;

    private Long subscriptionId;

    public void addRoom(Room room) {
        if (roomIds.contains(room.getId())) {
            throw new BusinessException(GymError.ROOM_ALREADY_EXISTS_IN_GYM);
        }

        if (roomIds.size() >= maxRooms) {
            throw new BusinessException(GymError.CANNOT_HAVE_MORE_ROOMS_THAN_SUBSCRIPTION_ALLOWS);
        }

        roomIds.add(room.getId());
    }
}
