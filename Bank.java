import java.util.Scanner;

public class Bank {

    private User user = new User("12345", "6789"); // demo user
    private Scanner sc = new Scanner(System.in);

    public void startATM() {
        System.out.println("===== Welcome to ATM Interface =====");

        System.out.print("Enter User ID: ");
        String id = sc.next();

        System.out.print("Enter PIN: ");
        String pin = sc.next();

        if (id.equals(user.getUserId()) && pin.equals(user.getPin())) {
            ATM atm = new ATM(user);
            atm.showMenu();
        } else {
            System.out.println("Invalid User ID or PIN!");
        }
    }
}
