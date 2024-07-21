package com.github.yizijian99.domegym.test.constants;

import com.github.yizijian99.domegym.common.utils.id.IdGenerator;

public class ConstantsRoom {
    private ConstantsRoom() {
    }

    public static final Long ID = IdGenerator.generateId();
    public static final Integer MAX_DAILY_SESSIONS_FREE_TIER = ConstantsSubscriptions.MAX_DAILY_SESSIONS_FREE_TIER;
}
