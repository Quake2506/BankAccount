import java.util.Scanner;

class BankAccount {
    private int accountNum;
    private String accountName;
    private int balance;

    public BankAccount(int accountNum, String accountName, int balance) {
        this.accountNum = accountNum;
        this.accountName = accountName;
        this.balance = balance;
    }

    public void deposit(int amount) {
        if (amount >0) {
            this.balance += amount;
        }
        else {
            System.out.println("Invalid deposit amount. Please enter a positive amount.");
        }
    }
    public void withdraw(int amount) {
        if (amount >0 && amount <= balance) {
            this.balance -= amount;
        }
        else if (amount <0) {
            System.out.println("Invalid withdraw amount. Please enter a positive amount.");
        }
        else {
            System.out.println("Insufficient balance.");
        }
    }
    public int getBalance() {
        return balance;
    }
}
    public class Main {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter account number: ");
            int accountNumber = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            System.out.print("Enter account holder name: ");
            String accountHolderName = scanner.nextLine();
            System.out.print("Enter initial balance: ");
            int initialBalance = scanner.nextInt();

            BankAccount account = new BankAccount(accountNumber, accountHolderName, initialBalance);

            while (true) {
                System.out.println("Menu:");
                System.out.println("1. Deposit");
                System.out.println("2. Withdraw");
                System.out.println("3. Check Balance");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");

                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter the deposit amount: ");
                        int depositAmount = scanner.nextInt();
                        account.deposit(depositAmount);
                        break;
                    case 2:
                        System.out.print("Enter the withdrawal amount: ");
                        int withdrawalAmount = scanner.nextInt();
                        account.withdraw(withdrawalAmount);
                        break;
                    case 3:
                        System.out.println("Current balance: " + account.getBalance());
                        break;
                    case 4:
                        System.out.println("Thank you for using our bank services.");
                        scanner.close();
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice. Please enter a valid option.");
                }
            }
        }
}
