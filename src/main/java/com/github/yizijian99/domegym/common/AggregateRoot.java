package com.github.yizijian99.domegym.common;

import lombok.Getter;

@Getter
public abstract class AggregateRoot extends Entity {
    protected AggregateRoot(Long id) {
        super(id);
    }
}
