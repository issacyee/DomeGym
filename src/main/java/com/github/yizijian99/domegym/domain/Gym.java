package com.github.yizijian99.domegym.domain;

import com.github.yizijian99.domegym.common.Entity;
import com.github.yizijian99.domegym.exception.BusinessException;
import com.github.yizijian99.domegym.exception.GymError;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@SuppressWarnings("FieldMayBeFinal")
public class Gym extends Entity {
    private Integer maxRooms;

    private Long subscriptionId;

    private List<Long> roomIds = new ArrayList<>(0);

    public Gym(Integer maxRooms, Long subscriptionId) {
        this(maxRooms, subscriptionId, null);
    }

    public Gym(Integer maxRooms, Long subscriptionId, Long id) {
        super(id);
        this.maxRooms = maxRooms;
        this.subscriptionId = subscriptionId;
    }

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
