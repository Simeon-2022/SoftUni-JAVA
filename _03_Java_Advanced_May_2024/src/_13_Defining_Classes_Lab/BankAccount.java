package _13_Defining_Classes_Lab;

public class BankAccount {

    private final static double DEFAULT_INTEREST_RATE = 0.02;

    private static int bankAccountDefaultIdCounter = 1;
    public static double interestRate = DEFAULT_INTEREST_RATE;
    private int id;
    private double balance;

    BankAccount() {
        this.id = bankAccountDefaultIdCounter++;
    }


    static void setInterestRate(double interestRate) {
        BankAccount.interestRate = interestRate;
    }

    public double getInterest(int years) {
        return BankAccount.interestRate * years * this.balance;
    }

    public double getBalance() {
        return this.balance;
    }

    public int getId() {
        return id;
    }

    public void depositInto(double amount) {
        this.balance += amount;
    }

}


