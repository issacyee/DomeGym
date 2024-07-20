package com.github.yizijian99.domegym.domain;

import com.github.yizijian99.domegym.exception.BusinessException;
import com.github.yizijian99.domegym.exception.RoomError;
import com.github.yizijian99.domegym.test.constants.ConstantsSession;
import com.github.yizijian99.domegym.test.utils.common.TimeRangeFactory;
import com.github.yizijian99.domegym.test.utils.rooms.RoomFactory;
import com.github.yizijian99.domegym.test.utils.sessions.SessionFactory;
import com.github.yizijian99.domegym.utils.id.IdGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class RoomTests {
    @Test
    public void scheduleSession_WhenMoreThanSubscriptionAllows_ShouldFail() {
        // Arrange
        Room room = RoomFactory.createRoom(1, null, null);

        Session session1 = SessionFactory.createSession(IdGenerator.generateId());
        Session session2 = SessionFactory.createSession(IdGenerator.generateId());

        // Action
        Executable executable1 = () -> room.scheduleSession(session1);
        Executable executable2 = () -> room.scheduleSession(session2);

        // Assert
        Assertions.assertDoesNotThrow(executable1);
        Assertions.assertThrowsExactly(BusinessException.class, executable2, RoomError.CANNOT_HAVE_MORE_SESSION_THAN_SUBSCRIPTION_ALLOWS.getCode());
    }

    @ParameterizedTest
    @MethodSource("provideData_ScheduleSession_WhenSessionOverlapsWithAnotherSession_ShouldFail_ProvideData")
    public void scheduleSession_WhenSessionOverlapsWithAnotherSession_ShouldFail(Integer startHoursSession1,
                                                                                 Integer endHoursSession1,
                                                                                 Integer startHoursSession2,
                                                                                 Integer endHoursSession2) {
        // Arrange
        Room room = RoomFactory.createRoom(2, null, null);

        Session session1 = SessionFactory.createSession(ConstantsSession.DATE,
                TimeRangeFactory.createFromHours(startHoursSession1, endHoursSession1),
                null, null
        );

        Session session2 = SessionFactory.createSession(ConstantsSession.DATE,
                TimeRangeFactory.createFromHours(startHoursSession2, endHoursSession2),
                null, null
        );

        // Action
        Executable executable1 = () -> room.scheduleSession(session1);
        Executable executable2 = () -> room.scheduleSession(session2);

        // Assert
        Assertions.assertDoesNotThrow(executable1);
        Assertions.assertThrowsExactly(BusinessException.class, executable2, RoomError.CANNOT_HAVE_TWO_OR_MORE_OVERLAPPING_SESSIONS.getCode());
    }

    private static Stream<Arguments> provideData_ScheduleSession_WhenSessionOverlapsWithAnotherSession_ShouldFail_ProvideData() {
        return Stream.of(
                Arguments.of(1, 3, 1, 3),   // exact overlap
                Arguments.of(1, 3, 2, 3),   // second session inside first session
                Arguments.of(1, 3, 2, 4),   // second session ends after session, but overlaps
                Arguments.of(1, 3, 0, 2)    // second session starts before second session, but overlaps
        );
    }
}
