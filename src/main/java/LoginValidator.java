public class LoginValidator {

    private final UserDatabase db;

    public LoginValidator(UserDatabase db) {
        this.db = db;
    }

    public boolean validateLogin(String cardNumber, String pinCode) {
         if (cardNumber == null || pinCode == null || cardNumber.isEmpty() || pinCode.isEmpty()) {
            return false;
        }

         if (!pinCode.matches("\\d{4}")) {
            return false;
        }

        return db.isValidCard(cardNumber, pinCode);
    }
}