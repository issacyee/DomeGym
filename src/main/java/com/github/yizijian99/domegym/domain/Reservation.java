package com.github.yizijian99.domegym.domain;

import com.github.yizijian99.domegym.common.Entity;
import com.github.yizijian99.domegym.utils.id.IdGenerator;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class Reservation extends Entity {
    private Long participantId;

    public Reservation(Long participantId) {
        this(participantId, null);
    }

    public Reservation(Long participantId, Long id) {
        super(Objects.nonNull(id) ? id : IdGenerator.generateId());
        this.participantId = participantId;
    }
}
