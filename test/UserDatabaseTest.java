import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserDatabaseTest {

    @Test
    public void ValidCardFromCsv() {
        UserDatabase db = new UserDatabase();
         assertTrue(db.isValidCard("12345678", "4321"));
    }

    @Test
    public void WrongPinCode() {
        UserDatabase db = new UserDatabase();
        assertFalse(db.isValidCard("12345678", "0000"));
    }

    @Test
    public void NonExistingCardNumber() {
        UserDatabase db = new UserDatabase();
         assertFalse(db.isValidCard("99999999", "4321"));
    }
}