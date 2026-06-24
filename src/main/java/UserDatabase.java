import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class UserDatabase {

    public boolean isValidCard(String cardNumber, String pinCode) {
        String filePath = "cards.csv";

        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));

            for (String line : lines) {
                String[] parts = line.split(",");

                if (parts.length < 2) {
                    continue;
                }

                String fileCardNumber = parts[0].trim();
                String filePinCode = parts[1].trim();

                if (fileCardNumber.equals(cardNumber) && filePinCode.equals(pinCode)) {
                    return true;
                }
            }
        } catch (IOException e) {
            System.err.println("Hiba a kártyaadatbázis olvasása közben: " + e.getMessage());
        }

        return false;
    }
}