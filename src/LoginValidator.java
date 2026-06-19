public class LoginValidator {

    public boolean validateLogin(String inputUser, String inputPass) {

        UserDatabase db = new UserDatabase();

        if (inputUser == null || inputPass == null) {
            return false;
        }

        if (inputUser.isEmpty() || inputPass.isEmpty()) {
            return false;
        }

        return db.isValidUser(inputUser, inputPass);
    }
}