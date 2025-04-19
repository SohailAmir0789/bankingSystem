import java.util.*;

public class Main {
    public static void main(String args[]) {
        // Step 1: Create a user map to store multiple users
        Map<String, User> users = new HashMap<>();

        // Step 2: Add users to the map
        users.put("1234", new User("Sohail", "1234", "0123", 12000));
        users.put("0789", new User("Hassan", "0789", "1234", 32000));

        // Step 3: Create an ATM and pass the user map
        ATM atm = new ATM(users);

        // Step 4: Start the ATM
        atm.startAtm();
    }
}

class User {
    private String name;
    private String accNum;
    private String pin;
    private double balance;

    public User(String name, String accNum, String pin, double balance) {
        this.name = name;
        this.accNum = accNum;
        this.pin = pin;
        this.balance = balance;
    }

    public boolean checkPin(String inputPin) {
        return pin.equals(inputPin);
    }

    public boolean checkAccNo(String inputAccNum) {
        return accNum.equals(inputAccNum);
    }

    public String showCustomerInfo() {
        return name + " - " + accNum;
    }

    public double retBalance() {
        return balance;
    }

    public void deposit(double depositAmount) {
        balance += depositAmount;
    }

    public void withdraw(double withdrawAmount) {
        if (balance < withdrawAmount) {
            System.out.println("Insufficient Funds");
        } else {
            balance -= withdrawAmount;
        }
    }
}

class ATM {
    private Map<String, User> users; // Store all users
    private Scanner scanner = new Scanner(System.in);

    public ATM(Map<String, User> users) {
        this.users = users;
    }

    public void startAtm() {
        System.out.println("Welcome to The ATM");

        System.out.print("Enter your Account Number: ");
        String inputAccNo = scanner.nextLine();

        User user = users.get(inputAccNo); // Fetch user by account number

        if (user == null) {
            System.out.println("Account not found.");
            return;
        }

        System.out.print("Enter your PIN: ");
        String inputPin = scanner.nextLine();

        if (user.checkPin(inputPin)) {
            System.out.println("Login successful. Welcome " + user.showCustomerInfo());
            showMenu(user);
        } else {
            System.out.println("Invalid PIN.");
        }
    }

    public void showMenu(User user) {
        int choice;
        do {
            System.out.println("\n1. Check Balance\n2. Deposit\n3. Withdraw\n4. Exit");
            System.out.print("Enter Choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Balance: Rs. " + user.retBalance());
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double deposit = scanner.nextDouble();
                    user.deposit(deposit);
                    System.out.println("New Balance: Rs. " + user.retBalance());
                    break;
                case 3:
                    System.out.print("Enter amount to withdraw: ");
                    double withdraw = scanner.nextDouble();
                    user.withdraw(withdraw);
                    System.out.println("New Balance: Rs. " + user.retBalance());
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 4);
    }
}
