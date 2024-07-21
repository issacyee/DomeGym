package com.github.yizijian99.domegym.common;

import com.github.yizijian99.domegym.utils.id.IdGenerator;
import lombok.Getter;

import java.util.Objects;

@Getter
public abstract class Entity {
    protected Long id;

    public Entity(Long id) {
        if (Objects.isNull(id)) {
            id = IdGenerator.generateId();
        }
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entity entity = (Entity) o;
        return Objects.equals(id, entity.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
