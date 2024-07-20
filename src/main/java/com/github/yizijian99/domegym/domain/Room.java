package com.github.yizijian99.domegym.domain;

import lombok.Data;

import java.util.List;

@Data
public class Room {
    private Long id;

    private List<Long> sessionIds;
}
