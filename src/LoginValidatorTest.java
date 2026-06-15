import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginValidatorTest {

    LoginValidator validator = new LoginValidator();

    @Test
    public void SuccessfulLogin() {
        assertTrue(validator.validateLogin("admin", "titok"));
    }

    @Test
    public void CaseInsensitiveUsername() {
        assertTrue(validator.validateLogin("ADMIN", "titok"));
    }

    @Test
    public void WrongPassword() {
        assertFalse(validator.validateLogin("admin", "wrong_password"));
    }

    @Test
    public void WrongUsername() {
        assertFalse(validator.validateLogin("hacker", "titok"));
    }

    @Test
    public void EmptyInputs() {
        assertFalse(validator.validateLogin("", "titok"));
        assertFalse(validator.validateLogin("admin", ""));
        assertFalse(validator.validateLogin("", ""));
    }
}