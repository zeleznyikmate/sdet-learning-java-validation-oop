void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    LoginValidator validator = new LoginValidator();

    System.out.println("--- Üdvözöljük az ATM-nél! ---");

    for (int loginAttempts = 0; loginAttempts < 3; loginAttempts++) {

        System.out.println("\nFelhasználónév:");
        String un = sc.nextLine();

        System.out.println("Jelszó:");
        String pw = sc.nextLine();

        boolean isSuccess = validator.validateLogin(un, pw);

        if (isSuccess) {
            System.out.println("Sikeres belépés! Üdvözöljük a rendszerben.");
            break;
        } else {

            int remainingAttempts = 3 - (loginAttempts + 1);

            if (remainingAttempts > 0) {
                System.out.println("Hibás adatok! Hátralévő próbálkozások száma: " + remainingAttempts);
            } else {
                System.out.println("Sajnáljuk, a kártyáját / fiókját biztonsági okokból ZÁROLTUK!");
            }
        }
    }

    System.out.println("\n--- Program vége ---");
}