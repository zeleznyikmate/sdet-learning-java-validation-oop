import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class UserDatabase {

    public boolean isValidUser(String username, String password) {
          String filePath = "users.csv";

        try {
                List<String> lines = Files.readAllLines(Paths.get(filePath));

            for (String line : lines) {
                   String[] parts = line.split(",");

                if (parts.length < 2) {
                    continue;
                }

                String fileUsername = parts[0].trim();
                String filePassword = parts[1].trim();

                if (fileUsername.equalsIgnoreCase(username) && filePassword.equals(password)) {
                    return true;
                }
            }
        } catch (IOException e) {
              System.err.println("Hiba az adatbázis fájl olvasása közben: " + e.getMessage());
        }

        return false;
    }
}
