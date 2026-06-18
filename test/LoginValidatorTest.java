import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

public class LoginValidatorTest {

    LoginValidator validator = new LoginValidator();

    @Test
    public void successfulLogin() {
        assertTrue(validator.validateLogin("admin", "titok"));
    }

    @Test
    public void caseInsensitiveUsername() {
        assertTrue(validator.validateLogin("ADMIN", "titok"));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/testdata/invalid_logins.csv")

    public void invalidLoginAttempts(String username, String password) {
        String finalUser = (username == null) ? "" : username;
        String finalPass = (password == null) ? "" : password;

        assertFalse(validator.validateLogin(finalUser, finalPass));
    }

    @Test
    public void nullInputsShouldReturnFalse() {
        assertFalse(validator.validateLogin(null, "titok"));
        assertFalse(validator.validateLogin("admin", null));
        assertFalse(validator.validateLogin(null, null));
    }
}