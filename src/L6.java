import java.util.Date;

public class L6 {
    public static void main(String[] args) {
        Account account = new Account(1122, 20000);
        account.setDate(new Date(2025, 7, 24));
        account.setAnnualInterestRate(0.045);
        account.withdraw(2500);
        account.deposit(3000);
        System.out.printf("Current balance: %.2f with monthly interest rate of %.2f%%", account.getBalance(), account.getMonthlyInterestRate() * 100);
        //System.out.println("Current balance: " + account.getBalance() + " with interest rate: " + account.getMonthlyInterestRate() * 100 + "% per month");
    }
}

class Account {
    private int id;
    private double balance, annualInterestRate;
    private Date dateCreated;

    public Account() {
        this.id = 0;
        this.balance = 0.0;
        this.annualInterestRate = 0.0;
        this.dateCreated = new Date();
    }

    public Account(int id, double balance) {
        this.id = id;
        this.balance = balance;
        this.annualInterestRate = 0.0;
        this.dateCreated = new Date();
    }

    /**
     * Returns the ID of the account.
     * @return the account ID
     */
    public int getId() {
        return this.id;
        
    }

    /**
     * Sets the ID of the account.
     * @param id the new ID to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Returns the current balance of the account.
     * @return the current balance
     */
    public double getBalance() {
        return this.balance;
    }

    /**
     * Sets the balance of the account.
     * @param balance the new balance to set
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }
    /**
     * Returns the date when the account was created.
     * @return the date of account creation
     */
    public Date getDate() {
        return this.dateCreated;
    }

    /**
     * Sets the date when the account was created.
     * @param dateCreated the date of account creation
     */
    public void setDate(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    /**
     * Returns the ID of the account.
     * @return the account ID
     */
    public double getAnnualInterestRate() {
        return this.annualInterestRate;
    }

    /**
     * Sets the annual interest rate for the account.
     * @param annualInterestRate the annual interest rate as a percentage
     */
    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    /**
     * Calculates the monthly interest rate based on the annual interest rate.
     * @return the monthly interest rate as a percentage
     */
    public double getMonthlyInterestRate() {
        return this.annualInterestRate / 12;
    }

    /**
     * Calculates the monthly interest based on the current balance and annual interest rate.
     * @return the monthly interest amount
     */
    public double getMonthlyInterest() {
        return this.balance * getMonthlyInterestRate() / 100;
    }

    /**
     * Withdraws a specified amount from the account if sufficient balance is available.
     * @param amount the amount to withdraw
     */
    public void withdraw(double amount) {
        if (amount <= this.balance) {
            this.balance -= amount;
        } else {
            System.out.println("Insufficient balance for withdrawal.");
        }
    }

    /**
     * Deposits a specified amount into the account.
     * @param amount the amount to deposit
     */
    public void deposit(double amount) {
        if (amount > 0.0) {
            this.balance += amount;
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }
}