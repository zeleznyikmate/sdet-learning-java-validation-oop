import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import static org.junit.jupiter.api.Assertions.*;

public class LoginValidatorTest {

    @Test
    public void should_RejectLogin_When_InputsAreNullOrEmpty() {
        // GIVEN
        UserDatabase db = new UserDatabase();
        LoginValidator validator = new LoginValidator(db);

        // WHEN & THEN
        assertFalse(validator.validateLogin(null, "1234"));
        assertFalse(validator.validateLogin("12345678", null));
        assertFalse(validator.validateLogin("", "1234"));
        assertFalse(validator.validateLogin("12345678", ""));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/testdata/invalid_pins.csv")
    public void should_RejectLogin_When_PinFormatIsInvalid(String invalidPin) {
        // GIVEN
        UserDatabase db = new UserDatabase();
        LoginValidator validator = new LoginValidator(db);

        // WHEN
        assertFalse(validator.validateLogin("12345678", invalidPin));
    }
}