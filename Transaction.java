public class Transaction {

    private String type;
    private double amount;
    private String time;

    public Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
        this.time = java.time.LocalDateTime.now().toString();
    }

    @Override
    public String toString() {
        return type + " ₹" + amount + " at " + time;
    }
}
