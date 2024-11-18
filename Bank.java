import java.util.Scanner;


class Account {
    protected String customerName;
    protected String accountNumber;
    protected String accountType;
    protected double balance;


    public Account(String customerName, String accountNumber, String accountType, double initialBalance) {
        this.customerName = customerName;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = initialBalance;
    }

    public void displayBalance() {
        System.out.println("Account Balance: " + balance);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit Successful. Updated Balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }
}


class SavAcct extends Account {
    private static final double INTEREST_RATE = 0.05; 
    public SavAcct(String customerName, String accountNumber, double initialBalance) {
        super(customerName, accountNumber, "Savings", initialBalance);
    }

  
    public void computeAndDepositInterest(int years) {
        double interest = balance * Math.pow(1 + INTEREST_RATE, years) - balance;
        balance += interest;
        System.out.println("Interest of " + interest + " deposited. Updated Balance: " + balance);
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal Successful. Updated Balance: " + balance);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient balance.");
        }
    }
}


class CurAcct extends Account {
    private static final double MIN_BALANCE = 1000.0; 
    private static final double PENALTY = 50.0;      

    public CurAcct(String customerName, String accountNumber, double initialBalance) {
        super(customerName, accountNumber, "Current", initialBalance);
    }

  
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal Successful. Updated Balance: " + balance);
            if (balance < MIN_BALANCE) {
                balance -= PENALTY;
                System.out.println("Balance below minimum. Penalty of " + PENALTY + " imposed. Updated Balance: " + balance);
            }
        } else {
            System.out.println("Invalid withdrawal amount or insufficient balance.");
        }
    }
}


public class Bank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        SavAcct savings = new SavAcct("Alice", "S123", 5000.0);

       
        CurAcct current = new CurAcct("Bob", "C456", 2000.0);

        System.out.println("Savings Account Operations:");
        savings.displayBalance();
        savings.deposit(2000);
        savings.computeAndDepositInterest(2);
        savings.withdraw(3000);

        System.out.println("\nCurrent Account Operations:");
        current.displayBalance();
        current.deposit(1000);
        current.withdraw(2500); 
        current.withdraw(500);
        
        scanner.close();
    }
}
