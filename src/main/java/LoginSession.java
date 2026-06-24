public class LoginSession {

    private final int maxAttempts = 3;
    private int attempts = 0;
    private boolean isBlocked = false;

    public boolean canTryAgain() {
        return attempts < maxAttempts && !isBlocked;
    }

    public void registerAttempt(boolean success) {
        attempts++;
        if (!success && attempts >= maxAttempts) {
            isBlocked = true;
        }
    }

    public int getRemainingAttempts() {
        return maxAttempts - attempts;
    }

    public boolean isBlocked() {
        return isBlocked;
    }
}