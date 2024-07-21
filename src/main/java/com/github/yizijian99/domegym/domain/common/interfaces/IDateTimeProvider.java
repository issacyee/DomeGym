package com.github.yizijian99.domegym.domain.common.interfaces;

import java.time.LocalDateTime;

public interface IDateTimeProvider {
    LocalDateTime getUtcNow();
}
