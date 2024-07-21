package com.github.yizijian99.domegym.domain.aggregate.admin;

import com.github.yizijian99.domegym.domain.common.Entity;
import lombok.Getter;

@Getter
@SuppressWarnings("FieldMayBeFinal")
public class Admin extends Entity {
    private Long userId;

    private Long subscriptionId;

    public Admin(Long userId, Long subscriptionId) {
        this(userId, subscriptionId, null);
    }

    public Admin(Long userId, Long subscriptionId, Long id) {
        super(id);
        this.userId = userId;
        this.subscriptionId = subscriptionId;
    }
}
