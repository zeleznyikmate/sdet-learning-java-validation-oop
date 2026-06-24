import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserDatabaseTest {

    @Test
    public void should_ReturnTrue_When_CardAndPinMatchValidRecord() {
        // GIVEN
        UserDatabase db = new UserDatabase();

        // WHEN
        boolean result = db.isValidCard("12345678", "4321");

        // THEN
        assertTrue(result);
    }

    @Test
    public void should_ReturnFalse_When_PinIsIncorrect() {
        // GIVEN
        UserDatabase db = new UserDatabase();

        // WHEN
        boolean result = db.isValidCard("12345678", "0000");

        // THEN
        assertFalse(result);    }

    @Test
    public void should_ReturnFalse_When_CardDoesNotExist() {
        // GIVEN
        UserDatabase db = new UserDatabase();

        // WHEN
        boolean result = db.isValidCard("99999999", "4321");

        // THEN
        assertFalse(result);    }
}