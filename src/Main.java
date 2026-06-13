void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    UserDatabase db = new UserDatabase();

    for (int loginAttempts = 0; loginAttempts < 3; loginAttempts++) {

        System.out.println("User: ");
        String Username = sc.nextLine();

        System.out.println("Pass: ");
        String Password = sc.nextLine();

        String dbUser = db.getExpectedUsername();
        String dbPass = db.getExpectedPassword();

        if (Username.isEmpty() || Password.isEmpty()){
            System.out.println("User or Pass is empty!");
        }  else if (Username.equalsIgnoreCase(dbUser) && Password.equals(dbPass)){
            System.out.println(" ");
            System.out.println("login successful");
            break;
        } else {
            System.out.println(" ");
            System.out.println("login failed, try again");
            System.out.println(" ");
        }
    }
}