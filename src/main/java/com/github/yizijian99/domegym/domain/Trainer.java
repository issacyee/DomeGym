package com.github.yizijian99.domegym.domain;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Trainer {
    private Long id;

    private Long userId;

    private List<Long> sessionIds;
}
