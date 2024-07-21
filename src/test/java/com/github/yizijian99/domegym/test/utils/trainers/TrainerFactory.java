package com.github.yizijian99.domegym.test.utils.trainers;

import com.github.yizijian99.domegym.domain.aggregate.trainer.Trainer;
import com.github.yizijian99.domegym.test.constants.ConstantsTrainer;
import com.github.yizijian99.domegym.test.constants.ConstantsUser;
import org.apache.commons.lang3.ObjectUtils;

public class TrainerFactory {
    private TrainerFactory() {
    }

    public static Trainer createTrainer() {
        return createTrainer(null, null);
    }

    public static Trainer createTrainer(Long userId, Long id) {
        return new Trainer(
                ObjectUtils.defaultIfNull(userId, ConstantsUser.ID),
                null,
                ObjectUtils.defaultIfNull(id, ConstantsTrainer.ID)
        );
    }
}
