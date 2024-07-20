package com.github.yizijian99.domegym.test.constants;

import com.github.yizijian99.domegym.common.TimeRange;
import com.github.yizijian99.domegym.utils.id.IdGenerator;

import java.time.LocalDate;
import java.time.LocalTime;

public class ConstantsSession {
    private ConstantsSession() {}

    public static final Long ID = IdGenerator.generateId();
    public static final LocalDate DATE = LocalDate.now();
    public static final TimeRange TIME = new TimeRange(LocalTime.now(), LocalTime.now());
    public static final Integer MAX_PARTICIPANTS = 1;
}
