import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class CashWithdrawalTest {

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
    public void testSuccessfulWithdrawal() {
        UserDatabase db = new UserDatabase("src/test/resources/testdata/test_cards.csv");
        CashWithdrawal withdrawal = new CashWithdrawal(db);
        String testCardNumber = "12345678";
        double amountToWithdraw = 10000.0;

        withdrawal.execute(testCardNumber, amountToWithdraw);
        double finalBalance = db.getBalance(testCardNumber);

        assertEquals(40000.0, finalBalance, 0.001);
    }
}