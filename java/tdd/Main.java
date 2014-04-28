package tdd;

/**
 * Created on 4/26/2014.
 */
public class Main {
    public static void main(String[] args) {
        SavingsAccountYear account = new SavingsAccountYear(10000);
        for (int i = 0; i < 60; i++) {
            System.out.println(i + ": $" + account.balance());
            account = account.nextYear();
        }
    }
}
