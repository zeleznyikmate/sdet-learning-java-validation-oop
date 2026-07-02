public class BalanceInquiry {
    private final UserDatabase db;

    public BalanceInquiry(UserDatabase db) {
        this.db = db;
    }

    public double execute(String cardNumber) {
        double balance = db.getBalance(cardNumber);
        System.out.println("\n=================================");
        System.out.println("Az Ön jelenlegi egyenlege: " + balance + " Ft");
        System.out.println("=================================");
        return balance;
    }
}