package com.github.yizijian99.domegym.utils.id;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class IdGenerator {

    private static final Snowflake snowflake = new Snowflake(1, 1);

    public static long generateId() {
        return snowflake.nextId();
    }
}