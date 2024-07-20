package com.github.yizijian99.domegym.domain;

import java.time.LocalDateTime;

public interface IDateTimeProvider {
    LocalDateTime getUtcNow();
}
