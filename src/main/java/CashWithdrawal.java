import java.util.Scanner;

public class CashWithdrawal {
    private final UserDatabase db;

    public CashWithdrawal(UserDatabase db) {
        this.db = db;
    }

    public void execute(String cardNumber, Scanner scanner) {
        System.out.print("Adja meg a felvenni kívánt összeget: ");
        double amount = scanner.nextDouble();
        execute(cardNumber, amount); // Meghívja az alatta lévő verziót
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