package com.github.yizijian99.domegym.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Admin {
    private Long userId;

    private Long subscriptionId;
}
