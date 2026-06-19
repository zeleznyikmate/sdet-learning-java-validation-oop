import java.util.Scanner;

public class Main {

    static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        LoginValidator validator = new LoginValidator();
        LoginSession session = new LoginSession();

        System.out.println("\n--- Üdvözöljük az ATM-nél ---");

        while (session.canTryAgain()) {
            System.out.print("\nFelhasználónév: ");
            String username = scanner.nextLine();

            System.out.print("\nJelszó: ");
            String password = scanner.nextLine();

            boolean loginSuccessful = validator.validateLogin(username, password);
            session.registerAttempt(loginSuccessful);

            if (loginSuccessful) {
                System.out.println("\nSikeres bejelentkezés! Üdvözöljük, " + username + "!");
                break;
            } else {
                System.out.println("\nHibás felhasználónév vagy jelszó!");
            }
        }

        if (session.isBlocked()) {
            System.out.println("\nTúl sok hibás kísérlet. A bankkártyáját biztonsági okokból ideiglenesen letiltottuk!");
        }

        scanner.close();
    }
}