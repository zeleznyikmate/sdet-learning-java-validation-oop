import java.util.Scanner;

public class CashWithdrawal {
    private final UserDatabase db;

    public CashWithdrawal(UserDatabase db) {
        this.db = db;
    }

    public void execute(String cardNumber, Scanner scanner) {
        System.out.print("Adja meg a felvenni kívánt összeget: ");
        String input = scanner.nextLine();
        try {
            double amount = Double.parseDouble(input);
            execute(cardNumber, amount);
        } catch (NumberFormatException e) {
            System.out.println("Sikertelen pénzfelvétel: Érvénytelen összegformátum!");
        }
    }

    public void execute(String cardNumber, double amount) {
        double currentBalance = db.getBalance(cardNumber);
        if (currentBalance >= amount) {
            db.updateBalance(cardNumber, currentBalance - amount);
            System.out.println("Sikeres pénzfelvétel: " + amount + " Ft");
        } else {
            System.out.println("Sikertelen pénzfelvétel: Nincs elég fedezet!");
        }
    }
}