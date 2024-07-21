package com.github.yizijian99.domegym.test.utils.trainers;

import com.github.yizijian99.domegym.domain.Trainer;

public class TrainerFactory {
    private TrainerFactory() {}

    public static Trainer createTrainer() {
        return Trainer.builder().build();
    }
}
