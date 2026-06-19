import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserDatabaseTest {

    @Test
    public void ValidUserFromCsv() {
        UserDatabase db = new UserDatabase();
        assertTrue(db.isValidUser("admin", "titok"));
    }

    @Test
    public void CaseInsensitivityForUsername() {
        UserDatabase db = new UserDatabase();
        assertTrue(db.isValidUser("ADMIN", "titok"));
        assertTrue(db.isValidUser("AdMiN", "titok"));
    }

    @Test
    public void CaseSensitivityForPassword() {
        UserDatabase db = new UserDatabase();
         assertFalse(db.isValidUser("admin", "TITOK"));
    }

    @Test
    public void WrongPassword() {
        UserDatabase db = new UserDatabase();
        assertFalse(db.isValidUser("admin", "hibasjelszo"));
    }

    @Test
    public void NonExistingUser() {
        UserDatabase db = new UserDatabase();
        assertFalse(db.isValidUser("nemletezo_user", "barmely_jelszo"));
    }
}