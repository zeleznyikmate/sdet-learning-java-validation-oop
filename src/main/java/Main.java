import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserDatabase db = new UserDatabase();
        LoginValidator validator = new LoginValidator(db);
        LoginSession session = new LoginSession();
        BalanceInquiry balanceInquiry = new BalanceInquiry(db);
        CashWithdrawal cashWithdrawal = new CashWithdrawal(db);

        System.out.println("--- Üdvözöljük az ATM-nél ---");
        System.out.println("Kérjük, helyezze be a kártyáját (adja meg a kártyaszámot)!");

        String loggedInCard = null;

        while (session.canTryAgain()) {
            System.out.print("\nKártyaszám: ");
            String cardNumber = scanner.nextLine();

            System.out.print("PIN kód: ");
            String pinCode = scanner.nextLine();

            boolean loginSuccessful = validator.validateLogin(cardNumber, pinCode);
            session.registerAttempt(loginSuccessful);

            if (loginSuccessful) {
                System.out.println("\nSikeres azonosítás! Kártya elfogadva.");
                loggedInCard = cardNumber;
                break;
            } else {
                System.out.println("\nHibás kártyaszám vagy PIN kód!");
            }
        }

        // --- ATM FUNKCIÓ MENÜ ---
        if (loggedInCard != null) {
            boolean exit = false;

            while (!exit) {
                System.out.println("\nKérjük, válasszon az alábbi lehetőségek közül:");
                System.out.println("1. Egyenleg lekérdezés");
                System.out.println("2. Pénzfelvétel");
                System.out.println("3. Kijelentkezés");
                System.out.print("Választott menüpont (1-3): ");

                String choice = scanner.nextLine();

                switch (choice) {
                    case "1":
                        balanceInquiry.execute(loggedInCard);
                        break;
                    case "2":
                        cashWithdrawal.execute(loggedInCard, scanner);
                        break;
                    case "3":
                        System.out.println("\nKöszönjük, hogy az ATM-et használta! Viszontlátásra!");
                        exit = true;
                        break;
                    default:
                        System.out.println("\nÉrvénytelen menüpont! Kérjük, 1, 2 vagy 3-as gombot nyomjon.");
                        break;
                }
            }
        }

        if (session.isBlocked()) {
            System.out.println("\nTúl sok hibás kísérlet. Az ATM a bankkártyát biztonsági okokból elnyelte!");
        }

        scanner.close();
    }
}