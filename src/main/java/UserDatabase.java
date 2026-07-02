import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class UserDatabase {
    private final String filePath;

    public UserDatabase() {
        this.filePath = "cards.csv";
    }

    public UserDatabase(String alternativeFilePath) {
        this.filePath = alternativeFilePath;
    }

    public boolean isValidCard(String cardNumber, String pinCode) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(this.filePath));
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

    public double getBalance(String cardNumber) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(this.filePath));
            for (String line : lines) {
                String[] parts = line.split(",");
                if (parts.length >= 3 && parts[0].trim().equals(cardNumber)) {
                    return Double.parseDouble(parts[2].trim());
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Hiba az egyenleg keresése közben: " + e.getMessage());
        }
        return 0.0;
    }

    public boolean updateBalance(String cardNumber, double newBalance) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(this.filePath));
            List<String> updatedLines = new ArrayList<>();
            boolean isCardFound = false;

            for (String line : lines) {
                String[] parts = line.split(",");
                if (parts.length >= 3 && parts[0].trim().equals(cardNumber)) {
                    String updatedLine = parts[0].trim() + "," + parts[1].trim() + "," + newBalance;
                    updatedLines.add(updatedLine);
                    isCardFound = true;
                } else {
                    updatedLines.add(line);
                }
            }

            if (isCardFound) {
                Files.write(Paths.get(this.filePath), updatedLines);
                return true;
            }
        } catch (IOException e) {
            System.err.println("Hiba a kártya egyenlegének frissítésekor: " + e.getMessage());
        }
        return false;
    }
}