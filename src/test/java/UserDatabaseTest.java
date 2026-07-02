import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class UserDatabaseTest {

    private List<String> originalLines;
    private final String path = "cards.csv";

    @BeforeEach
    public void setUp() throws IOException {
        if (Files.exists(Paths.get(path))) {
            originalLines = Files.readAllLines(Paths.get(path));
        }

        List<String> testLines = List.of(
                "12345678,1234,50000.0",
                "87654321,2222,12500.0"
        );
        Files.write(Paths.get(path), testLines);
    }

    @AfterEach
    public void tearDown() throws IOException {
        if (originalLines != null) {
            Files.write(Paths.get(path), originalLines);
        }
    }

    @Test
    public void should_ReturnTrue_When_CardAndPinMatchValidRecord() {
        UserDatabase db = new UserDatabase();

        boolean result = db.isValidCard("12345678", "1234");

        assertTrue(result);
    }

    @Test
    public void should_ReturnFalse_When_PinIsIncorrect() {
        UserDatabase db = new UserDatabase();

        boolean result = db.isValidCard("12345678", "4321");

        assertFalse(result);
    }

    @Test
    public void should_ReturnFalse_When_CardDoesNotExist() {
        UserDatabase db = new UserDatabase();

        boolean result = db.isValidCard("99999999", "1234");

        assertFalse(result);
    }
}