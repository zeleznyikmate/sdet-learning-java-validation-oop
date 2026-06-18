public class LoginValidator {

    public boolean validateLogin(String inputUser, String inputPass) {

        UserDatabase db = new UserDatabase();

        if (inputUser == null || inputPass == null) {
            return false;
        }

        if (inputUser.isEmpty() || inputPass.isEmpty()) {
            return false;
        }

        String expectedUsername = db.getExpectedUsername();
        String expectedPassword = db.getExpectedPassword();

        return inputUser.equalsIgnoreCase(expectedUsername) && inputPass.equals(expectedPassword);
    }
}