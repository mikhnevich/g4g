package tdd;

/**
 * Created on 4/26/2014.
 */
public class SavingsAccountYear {
    private int balance = 0;
    private int rate = 0;

    public SavingsAccountYear() {
    }

    public SavingsAccountYear(int amount) {
        this.balance = amount;
    }

    public SavingsAccountYear(int startingBalance, int annualInterestRate) {
        this.balance = startingBalance;
        this.rate = annualInterestRate;
    }

    public int balance() {
        return this.balance;
    }

    public SavingsAccountYear nextYear() {
        return new SavingsAccountYear(endingBalance(), rate);
    }

    public int endingBalance() {
        return balance + balance() * rate / 100;
    }

    public int startingBalance() {
        return balance;
    }
}
