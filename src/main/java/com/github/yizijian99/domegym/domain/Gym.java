package com.github.yizijian99.domegym.domain;

import lombok.Data;

import java.util.List;

@Data
public class Gym {
    private Long id;

    private List<Long> roomIds;
}
