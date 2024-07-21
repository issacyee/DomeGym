package com.github.yizijian99.domegym.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TrainerError implements IError {
    SESSION_ALREADY_EXISTS_IN_TRAINERS_SCHEDULE(
            "Trainer.SessionAlreadyExistsInTrainer'sSchedule",
            "Session already exists in trainer's schedule"
    ),
    CANNOT_HAVE_TWO_OR_MORE_OVERLAPPING_SESSIONS(
            "Trainer.CannotHaveTwoOrMoreOverlappingSessions",
            "Cannot have two or more overlapping sessions"
    )
    ;

    private final String code;
    private final String desc;
}
