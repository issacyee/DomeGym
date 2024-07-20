package com.github.yizijian99.domegym.domain;

import com.github.yizijian99.domegym.exception.BusinessException;
import com.github.yizijian99.domegym.exception.SessionError;
import com.github.yizijian99.domegym.test.constants.ConstantsSession;
import com.github.yizijian99.domegym.test.utils.participants.ParticipantFactory;
import com.github.yizijian99.domegym.test.utils.services.TestDateTimeProvider;
import com.github.yizijian99.domegym.test.utils.sessions.SessionFactory;
import com.github.yizijian99.domegym.utils.id.IdGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class SessionTest {
    @Test
    public void reserveSpot_WhenNoMoreRoom_ShouldFailReservation() {
        // Arrange
        // Create a session with a maximum participants of 1
        Session session = SessionFactory.createSession(1);
        // Create 2 participants
        Participant participant1 = ParticipantFactory.createParticipant(IdGenerator.generateId(), IdGenerator.generateId());
        Participant participant2 = ParticipantFactory.createParticipant(IdGenerator.generateId(), IdGenerator.generateId());

        // Action
        // Add participant 1
        session.reserveSpot(participant1);
        Executable executable = () -> {
            // Add participant 2
            session.reserveSpot(participant2);
        };

        // Assert
        // Participant 2 reservation failed
        Assertions.assertThrows(BusinessException.class, executable, SessionError.CANNOT_HAVE_MORE_RESERVATIONS_THAN_PARTICIPANTS.getCode());
    }

    @Test
    public void cancelReservation_WhenCancellationIsTooCloseToSession_ShouldFailCancellation() {
        // Arrange
        // Create a session
        Session session = SessionFactory.createSession(
                ConstantsSession.DATE,
                ConstantsSession.START_TIME,
                ConstantsSession.END_TIME,
                null,
                null
        );
        // Create a participant
        Participant participant = ParticipantFactory.createParticipant();
        // Reserve a spot for the participant in the session
        session.reserveSpot(participant);

        LocalDateTime cancellationDateTime = LocalDateTime.of(ConstantsSession.DATE, LocalTime.MIN);

        // Action
        // Cancel the reservation less than 24 hours before the session
        Executable executable = () -> session.cancelReservation(participant, new TestDateTimeProvider(cancellationDateTime));

        // Assert
        // The cancellation fails
        Assertions.assertThrowsExactly(BusinessException.class, executable, SessionError.CANNOT_CANCEL_RESERVATION_TOO_CLOSE_TO_SESSION.getCode());
    }
}