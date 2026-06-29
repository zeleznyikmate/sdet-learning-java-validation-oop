import java.util.Scanner;

public class CashWithdrawal {
    private final UserDatabase db;

    public CashWithdrawal(UserDatabase db) {
        this.db = db;
    }

    public void execute(String cardNumber, Scanner scanner) {
        System.out.print("\nAdja meg a felvenni kívánt összeget (Ft): ");

        if (!scanner.hasNextDouble()) {
            System.out.println("Hiba: Kérjük, csak számot adjon meg!");
            scanner.next();
            return;
        }

        double amount = scanner.nextDouble();
        scanner.nextLine();

        if (amount <= 0) {
            System.out.println("Hiba: Érvénytelen összeg!");
            return;
        }

        double currentBalance = db.getBalance(cardNumber);

        if (currentBalance < amount) {
            System.out.println("Hiba: Nincs elegendő fedezet a számláján! (Aktuális: " + currentBalance + " Ft)");
            return;
        }

        double newBalance = currentBalance - amount;
        boolean success = db.updateBalance(cardNumber, newBalance);

        if (success) {
            System.out.println("\n---------------------------------");
            System.out.println("Sikeres tranzakció! Kérjük, vegye át a készpénzt.");
            System.out.println("Új egyenleg: " + newBalance + " Ft");
            System.out.println("---------------------------------");
        } else {
            System.out.println("Hiba történt a tranzakció mentése során.");
        }
    }
}
