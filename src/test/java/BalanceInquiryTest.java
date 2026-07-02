import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BalanceInquiryTest {

    @BeforeEach
    public void setUp() throws IOException {
         List<String> lines = List.of(
                "12345678,1234,50000.0",
                "87654321,2222,12500.0",
                "11112222,3333,0.0"
        );
        Files.write(Paths.get("src/test/resources/testdata/test_cards.csv"), lines);
    }

    @Test
    public void testGetBalanceForValidCard() {
        UserDatabase db = new UserDatabase("src/test/resources/testdata/test_cards.csv");
        BalanceInquiry inquiry = new BalanceInquiry(db);

        String testCardNumber = "12345678";

        double actualBalance = inquiry.execute(testCardNumber);

        assertEquals(50000.0, actualBalance, 0.001);
    }
}