package com.github.yizijian99.domegym.domain.common;

import lombok.Getter;

@Getter
public abstract class AggregateRoot extends Entity {
    protected AggregateRoot(Long id) {
        super(id);
    }
}
