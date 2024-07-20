package com.github.yizijian99.domegym.domain;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Subscription {
    private Long id;

    private List<Long> gymIds;
}
