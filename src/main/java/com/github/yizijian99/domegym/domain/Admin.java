package com.github.yizijian99.domegym.domain;

import com.github.yizijian99.domegym.common.Entity;
import lombok.Getter;

@Getter
public class Admin extends Entity {
    private Long userId;

    private Long subscriptionId;
}
