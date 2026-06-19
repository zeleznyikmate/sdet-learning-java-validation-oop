import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import static org.junit.jupiter.api.Assertions.*;

public class LoginValidatorTest {

    @Test
    public void NullAndEmptyInputs() {
        UserDatabase db = new UserDatabase();
        LoginValidator validator = new LoginValidator(db);

        assertFalse(validator.validateLogin(null, "1234"));
        assertFalse(validator.validateLogin("12345678", null));
        assertFalse(validator.validateLogin("", "1234"));
        assertFalse(validator.validateLogin("12345678", ""));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/testdata/invalid_pins.csv", numLinesToSkip = 0)
    public void InvalidPinFormatsFromCsv(String invalidPin) {
        UserDatabase db = new UserDatabase();
        LoginValidator validator = new LoginValidator(db);

        assertFalse(validator.validateLogin("12345678", invalidPin));
    }
}