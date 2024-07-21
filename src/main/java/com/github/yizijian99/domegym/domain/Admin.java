package com.github.yizijian99.domegym.domain;

import com.github.yizijian99.domegym.common.Entity;
import lombok.Getter;

@Getter
@SuppressWarnings("FieldMayBeFinal")
public class Admin extends Entity {
    private Long userId;

    private Long subscriptionId;

    public Admin(Long userId, Long subscriptionId, Long id) {
        super(id);
        this.userId = userId;
        this.subscriptionId = subscriptionId;
    }
}
