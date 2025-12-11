import java.util.ArrayList;

public class User {

    private String userId;
    private String pin;
    private double balance;
    private ArrayList<Transaction> transactions = new ArrayList<>();

    public User(String userId, String pin) {
        this.userId = userId;
        this.pin = pin;
        this.balance = 0.0;
    }

    public String getUserId() {
        return userId;
    }

    public String getPin() {
        return pin;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double newBalance) {
        this.balance = newBalance;
    }

    public void addTransaction(Transaction t) {
        transactions.add(t);
    }

    public void showTransactions() {
        if (transactions.isEmpty()) {
            System.out.println("No Transactions Found!");
            return;
        }

        System.out.println("\n===== Transaction History =====");
        for (Transaction t : transactions) {
            System.out.println(t);
        }
    }
}
