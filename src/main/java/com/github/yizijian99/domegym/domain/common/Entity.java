package com.github.yizijian99.domegym.domain.common;

import com.github.yizijian99.domegym.common.utils.id.IdGenerator;
import lombok.Getter;
import org.apache.commons.lang3.ObjectUtils;

import java.util.Objects;

@Getter
public abstract class Entity {
    protected Long id;

    public Entity(Long id) {
        this.id = ObjectUtils.getIfNull(id, IdGenerator::generateId);
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
