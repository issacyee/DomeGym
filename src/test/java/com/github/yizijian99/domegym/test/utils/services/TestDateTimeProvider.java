package com.github.yizijian99.domegym.test.utils.services;

import com.github.yizijian99.domegym.domain.IDateTimeProvider;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
public class TestDateTimeProvider implements IDateTimeProvider {
    private LocalDateTime fixDateTime;

    @Override
    public LocalDateTime getUtcNow() {
        return Objects.nonNull(fixDateTime) ? fixDateTime : LocalDateTime.now();
    }
}
