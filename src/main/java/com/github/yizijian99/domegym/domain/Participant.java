package com.github.yizijian99.domegym.domain;

import lombok.Data;

import java.util.List;

@Data
public class Participant {
    private Long id;

    private Long userId;

    private List<Long> sessionIds;
}
