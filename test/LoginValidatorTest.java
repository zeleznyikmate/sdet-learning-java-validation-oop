import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import static org.junit.jupiter.api.Assertions.*;

public class LoginValidatorTest {

    @Test
    public void NullInputs() {
        LoginValidator validator = new LoginValidator();
        assertFalse(validator.validateLogin(null, "password"));
        assertFalse(validator.validateLogin("user", null));
        assertFalse(validator.validateLogin(null, null));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/testdata/invalid_logins.csv", numLinesToSkip = 1)
    public void InvalidAndEmptyLogins(String username, String password) {
        LoginValidator validator = new LoginValidator();
        assertFalse(validator.validateLogin(username, password));
    }
}