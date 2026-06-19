import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginSessionTest {

    @Test
    public void InitialState() {
        LoginSession session = new LoginSession();

        assertTrue(session.canTryAgain());
        assertFalse(session.isBlocked());
        assertEquals(3, session.getRemainingAttempts());
    }

    @Test
    public void SuccessfulLoginDoesNotBlock() {
        LoginSession session = new LoginSession();

        session.registerAttempt(true);
        assertFalse(session.isBlocked());
        assertEquals(2, session.getRemainingAttempts());
    }

    @Test
    public void ThreeFailedAttemptsBlocksSession() {
        LoginSession session = new LoginSession();

        session.registerAttempt(false);
        assertFalse(session.isBlocked());
        assertEquals(2, session.getRemainingAttempts());
        assertTrue(session.canTryAgain());

        session.registerAttempt(false);
        assertFalse(session.isBlocked());
        assertEquals(1, session.getRemainingAttempts());
        assertTrue(session.canTryAgain());

        session.registerAttempt(false);
        assertTrue(session.isBlocked());
        assertEquals(0, session.getRemainingAttempts());
        assertFalse(session.canTryAgain());
    }
}