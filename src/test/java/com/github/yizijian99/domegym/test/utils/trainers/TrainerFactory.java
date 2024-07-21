package com.github.yizijian99.domegym.test.utils.trainers;

import com.github.yizijian99.domegym.domain.Trainer;
import com.github.yizijian99.domegym.test.constants.ConstantsTrainer;
import com.github.yizijian99.domegym.test.constants.ConstantsUser;

import java.util.Objects;

public class TrainerFactory {
    private TrainerFactory() {
    }

    public static Trainer createTrainer() {
        return createTrainer(null, null);
    }

    public static Trainer createTrainer(Long userId, Long id) {
        if (Objects.isNull(userId)) {
            userId = ConstantsUser.ID;
        }
        if (Objects.isNull(id)) {
            id = ConstantsTrainer.ID;
        }

        Trainer trainer = new Trainer();
        trainer.setUserId(userId);
        trainer.setId(id);
        return trainer;
    }
}
