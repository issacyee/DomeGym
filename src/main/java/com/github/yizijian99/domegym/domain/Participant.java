package com.github.yizijian99.domegym.domain;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class Participant {
    private Long id;

    private Long userId;

    @Builder.Default
    private List<Long> sessionIds = new ArrayList<>(0);
}
