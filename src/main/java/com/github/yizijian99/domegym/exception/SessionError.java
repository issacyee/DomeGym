package com.github.yizijian99.domegym.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SessionError implements IError {
    CANNOT_HAVE_MORE_RESERVATIONS_THAN_PARTICIPANTS(
            "Session.CannotHaveMoreReservationsThanParticipants",
            "Cannot have more reservations than participants"
    ),
    CANNOT_CANCEL_RESERVATION_TOO_CLOSE_TO_SESSION(
            "Session.CannotCancelReservationTooCloseToSession",
            "Cannot cancel reservation too close to session"
    ),
    RESERVATION_NOT_FOUND(
            "Session.ReservationNotFound",
            "Reservation not found"
    )
    ;

    private final String code;
    private final String desc;
}
