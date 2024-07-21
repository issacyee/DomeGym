package com.github.yizijian99.domegym.domain.common;

import org.apache.commons.collections4.CollectionUtils;

import java.util.Collection;
import java.util.Objects;

public abstract class ValueObject {
    public abstract Collection<Object> getEqualityComponents();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ValueObject valueObject = (ValueObject) o;
        return CollectionUtils.isEqualCollection(
                valueObject.getEqualityComponents(), getEqualityComponents()
        );
    }

    @Override
    public int hashCode() {
        return getEqualityComponents().stream()
                .map(v -> Objects.nonNull(v) ? v.hashCode() : 0)
                .reduce((a, b) -> a ^ b)
                .orElse(0);
    }
}
