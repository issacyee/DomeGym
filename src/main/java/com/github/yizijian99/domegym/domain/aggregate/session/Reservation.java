package com.github.yizijian99.domegym.domain.aggregate.session;

import com.github.yizijian99.domegym.common.utils.id.IdGenerator;
import com.github.yizijian99.domegym.domain.common.Entity;
import lombok.Getter;

import java.util.Objects;

@Getter
@SuppressWarnings("FieldMayBeFinal")
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
