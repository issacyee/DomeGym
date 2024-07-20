package com.github.yizijian99.domegym.domain;

import com.github.yizijian99.domegym.utils.id.IdGenerator;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
public class Participant {
    private Long id;

    private Long userId;

    private List<Long> sessionIds = new ArrayList<>(0);

    public Participant(Long userId, Long id) {
        this.userId = userId;
        if (Objects.isNull(id)) {
            id = IdGenerator.generateId();
        }
        this.id = id;
    }
}
