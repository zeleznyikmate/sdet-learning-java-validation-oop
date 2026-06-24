import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserDatabase db = new UserDatabase();
        LoginValidator validator = new LoginValidator(db);
        LoginSession session = new LoginSession();

        System.out.println("--- Üdvözöljük az ATM-nél ---");
        System.out.println("Kérjük, helyezze be a kártyáját (adja meg a kártyaszámot)!");

        while (session.canTryAgain()) {
            System.out.print("\nKártyaszám: ");
            String cardNumber = scanner.nextLine();

            System.out.print("\nPIN kód: ");
            String pinCode = scanner.nextLine();

            boolean loginSuccessful = validator.validateLogin(cardNumber, pinCode);
            session.registerAttempt(loginSuccessful);

            if (loginSuccessful) {
                System.out.println("\nSikeres azonosítás! Kártya elfogadva.");
                break;
            } else {
                System.out.println("\nHibás kártyaszám vagy PIN kód!");
            }
        }

        if (session.isBlocked()) {
            System.out.println("\nTúl sok hibás kísérlet. Az ATM a bankkártyát biztonsági okokból elnyelte!");
        }

        scanner.close();
    }
}