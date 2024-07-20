package com.github.yizijian99.domegym.domain;

import com.github.yizijian99.domegym.test.utils.participants.ParticipantFactory;
import com.github.yizijian99.domegym.test.utils.sessions.SessionFactory;
import com.github.yizijian99.domegym.utils.id.IdGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

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
        Assertions.assertThrows(RuntimeException.class, executable);
    }
}