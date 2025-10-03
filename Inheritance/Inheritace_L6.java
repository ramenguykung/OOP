
public class Inheritace_L6 {

    public static void main(String[] args) {
        FixAccount fixAccount = new FixAccount();
    }
}

class Account {

    private int id;
    private Person person;
    private double balance, annualInterestRate;
    private Date dateCreated;

    public Account() {
        this.id = 0;
        this.balance = 0.0;
        this.annualInterestRate = 0.0;
        this.dateCreated = new Date();
        this.person = new Person();
    }

    public Account(int id, double balance) {
        this.id = id;
        this.balance = balance;
        this.annualInterestRate = 0.0;
        this.person = new Person();
        this.dateCreated = new Date();
    }

    public Account(int year, String month, int day) {
        this.id = 0;
        this.balance = 0;
        this.annualInterestRate = 0.0;
        this.person = new Person();
        this.dateCreated = new Date(year, month, day);
    }

    public void setAccountName(String name, String surname) {
        this.person.setName(name);
        this.person.setSurname(surname);
    }

    /**
     * Returns the ID of the account.
     *
     * @return the account ID
     */
    public int getId() {
        return this.id;

    }

    /**
     * Sets the ID of the account.
     *
     * @param id the new ID to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Returns the current balance of the account.
     *
     * @return the current balance
     */
    public double getBalance() {
        return this.balance;
    }

    /**
     * Sets the balance of the account.
     *
     * @param balance the new balance to set
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Returns the date when the account was created.
     *
     * @return the date of account creation
     */
    public Date getDate() {
        return this.dateCreated;
    }

    /**
     * Sets the date when the account was created.
     *
     * @param dateCreated the date of account creation
     */
    public void setDate(int year, String month, int day) {
        this.dateCreated.setYear(year);
        this.dateCreated.setMonth(month);
        this.dateCreated.setDay(day);
    }

    /**
     * Returns the annual interest rate for the account.
     *
     * @return the annual interest rate
     */
    public double getAnnualInterestRate() {
        return this.annualInterestRate;
    }

    /**
     * Sets the annual interest rate for the account.
     *
     * @param annualInterestRate the annual interest rate as a percentage
     */
    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    /**
     * Calculates the monthly interest rate based on the annual interest rate.
     *
     * @return the monthly interest rate as a percentage
     */
    public double getMonthlyInterestRate() {
        return this.annualInterestRate / 12;
    }

    /**
     * Calculates the monthly interest based on the current balance and annual
     * interest rate.
     *
     * @return the monthly interest amount
     */
    public double getMonthlyInterest() {
        return this.balance * getMonthlyInterestRate() / 100;
    }

    /**
     * Withdraws a specified amount from the account if sufficient balance is
     * available.
     *
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
     *
     * @param amount the amount to deposit
     */
    public void deposit(double amount) {
        if (amount > 0.0) {
            this.balance += amount;
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public void transfer(Account other, double amount) {
        if (amount <= this.balance) {
            this.withdraw(amount);
            other.deposit(amount);
        } else {
            System.out.println("Insufficient balance for transfer.");
        }
    }
}

class Person {

    private String name, surname;
    private int age;
    private Date birthDate;

    public Person() {
        this.name = "";
        this.surname = "";
        this.age = 0;
        this.birthDate = new Date();
    }

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.birthDate = new Date();
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.birthDate = new Date();
    }

    public Person(String name, String surname, int age, int day, String month, int year) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.birthDate = new Date(year, month, day);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;

    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return this.age;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Date getBirthDate() {
        return this.birthDate;
    }
}

class Date {

    private int year, day;
    private String month;

    public Date() {
        this.year = 0;
        this.month = "";
        this.day = 0;
    }

    public Date(int year, String month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getYear() {
        return this.year;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getMonth() {
        return this.month;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getDay() {
        return this.day;
    }
}

class SavingAccount extends Account {

    private double fee = 20.0;

    public SavingAccount() {
        super();
    }

    public SavingAccount(int id, double balance) {
        super(id, balance);
    }

    public SavingAccount(int year, String month, int day, double interestRate) {
        super(year, month, day);
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    @Override
    public void transfer(Account other, double amount) {
        if (amount <= (this.getBalance() - fee)) {
            this.withdraw(amount);
            other.deposit(amount);
            System.out.printf("Transferred %f from %s to %s with transaction fee %f\n", amount, this.getId(), other.getId(), fee);
        } else {
            System.out.println("Insufficient balance for transfer.");
        }
    }
}

class FixAccount extends Account {

    private int maturityPeriod; // in months
    private boolean isMatured;

    public FixAccount() {
        super();
        this.maturityPeriod = 12; // default 12 months
        this.isMatured = false;
    }

    public FixAccount(int id, double balance) {
        super(id, balance);
        this.maturityPeriod = 0;
        this.isMatured = false;
    }

    public FixAccount(int year, String month, int day, double interestRate, int maturityPeriod) {
        super(year, month, day);
        this.maturityPeriod = maturityPeriod;
        this.isMatured = false;
    }

    public boolean maturityPeriod() {
        if (!isMatured) {
            //TODO fix with passing parameters
            // Get current date (you might want to pass current date as parameter)
            Date currentDate = new Date(2025, "August", 8); // Current date

            // Calculate if more than 12 months (1 year) have passed
            int yearsDifference = currentDate.getYear() - this.getDate().getYear();

            // If year difference is greater than 1, definitely matured
            if (yearsDifference > 1) {
                this.isMatured = true;
                return true;
            } // If exactly 1 year difference, check month and day
            else if (yearsDifference == 1) {
                // For simplicity, assuming maturity after 1 full year
                this.isMatured = true;
                return true;
            } // Less than 1 year
            else {
                return false;
            }
        }
        return this.isMatured;
    }

    /**
     * Checks if the account has reached its specific maturity period.
     *
     * @return true if the account has reached its maturity period, false
     * otherwise
     */
    public boolean hasReachedMaturityPeriod() {
        if (!isMatured) {
            // TODO fix with passing parameters
            Date currentDate = new Date(2025, "August", 8); // Current date
            int yearsDifference = currentDate.getYear() - this.getDate().getYear();

            // Convert maturity period from months to years for comparison
            double maturityYears = this.maturityPeriod / 12.0;

            // Check if the time elapsed exceeds the maturity period
            if (yearsDifference >= maturityYears) {
                this.isMatured = true;
                return true;
            } else {
                return false;
            }
        }
        return this.isMatured;
    }

    public int getMaturityPeriod() {
        return maturityPeriod;
    }

    public void setMaturityPeriod(int maturityPeriod) {
        this.maturityPeriod = maturityPeriod;
    }

    public boolean isMatured() {
        return isMatured;
    }
}
