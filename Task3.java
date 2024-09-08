import java.util.Scanner;
public class Task3 {
    public static void main(String[] args) {
        Account accountObj = new Account(); // Create an Account object
        Scanner scanner = new Scanner(System.in); // Scanner object created here

        System.out.println("Welcome...");
        System.out.println("Please enter your Account number:");
        long account = scanner.nextLong();

        System.out.println("PIN:");
        int pin = scanner.nextInt();

        accountObj.handleAccount(account, pin, scanner); // Pass scanner to Account method
        scanner.close(); // Close scanner
    }
}

class Account {
    private long[] org_account = { 1122335896L, 7845961235L, 8456217890L, 7895136547L };
    private int[] org_pin = { 123, 123, 123, 123 };
    private long[] balance = { 10000L, 30000L, 25000L, 80000L };

    public void handleAccount(long account, int pin, Scanner scanner) {
        boolean authenticated = false;

        for (int i = 0; i < org_account.length; i++) {
            if (org_account[i] == account && org_pin[i] == pin) {
                authenticated = true;
                boolean transactionComplete = false;

                while (!transactionComplete) {
                    System.out.println("Select your option:");
                    System.out.println("1. Deposit");
                    System.out.println("2. Withdrawal");
                    System.out.println("3. Check Balance");

                    int opt = scanner.nextInt();

                    switch (opt) {
                        case 1:
                            System.out.println("Enter amount:");
                            long dep = scanner.nextLong();
                            balance[i] += dep;
                            System.out.println("Amount deposited successfully.");
                            transactionComplete = true;
                            break;

                        case 2:
                            System.out.println("Enter amount:");
                            long wdr = scanner.nextLong();
                            if (wdr <= balance[i]) {
                                balance[i] -= wdr;
                                System.out.println("Amount withdrawn successfully.");
                            } else {
                                System.out.println("Insufficient balance.");
                            }
                            transactionComplete = true;
                            break;

                        case 3:
                            System.out.println("Your available balance is " + balance[i]);
                            transactionComplete = true;
                            break;

                        default:
                            System.out.println("Please enter a correct option...");
                    }
                }
                System.out.println("Thank You");
                break;
            }
        }

        if (!authenticated) {
            System.out.println("Invalid account number or PIN.");
        }
    }
}
