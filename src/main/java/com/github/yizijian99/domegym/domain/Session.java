package com.github.yizijian99.domegym.domain;

import lombok.Data;

import java.util.List;

@Data
public class Session {
    private Long sessionId;

    private Long trainerId;

    private List<Long> participants;
}
