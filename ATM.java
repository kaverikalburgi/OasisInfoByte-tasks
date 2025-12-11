import java.util.Scanner;

public class ATM {

    private User user;
    private Scanner sc = new Scanner(System.in);

    public ATM(User user) {
        this.user = user;
    }

    public void showMenu() {
        while (true) {
            System.out.println("\n===== ATM MENU =====");
            System.out.println("1. Transaction History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> user.showTransactions();
                case 2 -> withdraw();
                case 3 -> deposit();
                case 4 -> transfer();
                case 5 -> {
                    System.out.println("Thank you for using ATM!");
                    return;
                }
                default -> System.out.println("Invalid Option!");
            }
        }
    }

    private void withdraw() {
        System.out.print("Enter amount to withdraw: ");
        double amt = sc.nextDouble();

        if (amt > user.getBalance()) {
            System.out.println("Insufficient Balance!");
            return;
        }

        user.setBalance(user.getBalance() - amt);
        user.addTransaction(new Transaction("Withdraw", amt));
        System.out.println("Withdrawal Successful.");
    }

    private void deposit() {
        System.out.print("Enter amount to deposit: ");
        double amt = sc.nextDouble();

        user.setBalance(user.getBalance() + amt);
        user.addTransaction(new Transaction("Deposit", amt));
        System.out.println("Deposit Successful.");
    }

    private void transfer() {
        System.out.print("Enter receiver User ID: ");
        String receiverId = sc.next();

        System.out.print("Enter amount to transfer: ");
        double amt = sc.nextDouble();

        if (amt > user.getBalance()) {
            System.out.println("Insufficient Balance!");
            return;
        }

        user.setBalance(user.getBalance() - amt);
        user.addTransaction(new Transaction("Transfer to " + receiverId, amt));

        System.out.println("Transfer Successful.");
    }
}
