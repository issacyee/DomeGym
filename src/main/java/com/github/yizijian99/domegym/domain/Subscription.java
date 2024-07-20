package com.github.yizijian99.domegym.domain;

import lombok.Data;

import java.util.List;

@Data
public class Subscription {
    private Long id;

    private List<Long> gymIds;
}
