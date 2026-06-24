import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginSessionTest {

    @Test
    public void should_AllowAttempts_When_UnderMaxLimit() {
        // GIVEN
        LoginSession session = new LoginSession();

        // WHEN
        session.registerAttempt(false);

        // THEN
        assertTrue(session.canTryAgain());
        assertFalse(session.isBlocked());
    }

    @Test
    public void should_NotBlockSession_When_LoginIsSuccessful() {
        // GIVEN
        LoginSession session = new LoginSession();

        // WHEN
        session.registerAttempt(true);

        // THEN
        assertFalse(session.isBlocked());
        assertEquals(2, session.getRemainingAttempts());
    }

    @Test
    public void should_BlockSession_When_ThreeConsecutiveAttemptsFail() {
        // GIVEN
        LoginSession session = new LoginSession();

        // --- FIRST FAILED ATTEMPT ---
        // WHEN
        session.registerAttempt(false);
        // THEN
        assertFalse(session.isBlocked());
        assertEquals(2, session.getRemainingAttempts());
        assertTrue(session.canTryAgain());

        // --- SECOND FAILED ATTEMPT ---
        // WHEN
        session.registerAttempt(false);
        // THE
        assertFalse(session.isBlocked());
        assertEquals(1, session.getRemainingAttempts());
        assertTrue(session.canTryAgain());

        // --- THIRD FAILED ATTEMPT ---
        // WHEN
        session.registerAttempt(false);
        // THEN
        assertTrue(session.isBlocked());
        assertEquals(0, session.getRemainingAttempts());
        assertFalse(session.canTryAgain());
    }
}