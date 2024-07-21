package com.github.yizijian99.domegym.domain;

import com.github.yizijian99.domegym.exception.BusinessException;
import com.github.yizijian99.domegym.exception.ParticipantError;
import com.github.yizijian99.domegym.test.constants.ConstantsSession;
import com.github.yizijian99.domegym.test.utils.common.TimeRangeFactory;
import com.github.yizijian99.domegym.test.utils.participants.ParticipantFactory;
import com.github.yizijian99.domegym.test.utils.sessions.SessionFactory;
import com.github.yizijian99.domegym.utils.id.IdGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class ParticipantTests {
    @ParameterizedTest
    @MethodSource("provideData_AddSessionToSchedule_WhenSessionOverlapsWithAnotherSession_ShouldFail")
    public void addSessionToSchedule_WhenSessionOverlapsWithAnotherSession_ShouldFail(Integer startHourSession1,
                                                                                      Integer endHourSession1,
                                                                                      Integer startHourSession2,
                                                                                      Integer endHourSession2) {
        // Arrange
        Participant participant = ParticipantFactory.createParticipant();

        Session session1 = SessionFactory.createSession(
                ConstantsSession.DATE,
                TimeRangeFactory.createFromHours(startHourSession1, endHourSession1),
                null,
                IdGenerator.generateId()
        );

        Session session2 = SessionFactory.createSession(
                ConstantsSession.DATE,
                TimeRangeFactory.createFromHours(startHourSession2, endHourSession2),
                null,
                IdGenerator.generateId()
        );

        // Action
        Executable executable1 = () -> participant.addToSchedule(session1);
        Executable executable2 = () -> participant.addToSchedule(session2);

        // Assert
        Assertions.assertDoesNotThrow(executable1);
        Assertions.assertThrowsExactly(BusinessException.class, executable2, ParticipantError.CANNOT_HAVE_TWO_OR_MORE_OVERLAPPING_SESSIONS.getCode());
    }

    private static Stream<Arguments> provideData_AddSessionToSchedule_WhenSessionOverlapsWithAnotherSession_ShouldFail() {
        return Stream.of(
                Arguments.of(1, 3, 1, 3),
                Arguments.of(1, 3, 2, 3),
                Arguments.of(1, 3, 2, 4),
                Arguments.of(1, 3, 0, 2)
        );
    }
}