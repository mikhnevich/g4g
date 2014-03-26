package binary_search;

/**
 * Created by user2 on 2/25/14.
 */
public class AutoLoan {
    // You have been checking out some of the cars at your local dealership, TopAuto.
    // An excited salesman has just approached you, shouting about how you can have the car
    // you are looking at for a payment of only monthlyPayment for only loanTerm months!
    // You are to return a double indicating the annual percentage rate of the loan,
    // assuming that the initial balance of the loan is price.

    public static double interestRate(double price, double monthlyPayment, int loanTerm) {
        double priceToPay = monthlyPayment * loanTerm;
        double lo = 0;
        double hi = 100;
        double mid = 0;

        while ((hi - lo) > 1e-9) {
            mid = lo + (hi - lo) / 2;
            double tmp = price;
            for (int i = 0; i < loanTerm; i++) {
                tmp += mid/1200*tmp - monthlyPayment;
            }
            if (tmp == 0) {
                return mid;
            }
            if (tmp < 0) {
                lo = mid;
            } else {
                hi = mid;
            }
        }
        return mid;
    }

    public static double interestRate2(double p, double mp, int lt)
    {
        double low = 0;
        double high = 100;
        double pay = mp*lt;
        double mid = 0;
        while(high - low > 1e-9)
        {
            mid = (high+low)/2;
            double temp = p;
            for(int i = 0; i < lt; i++)
            {
                temp = temp+((mid/1200)*temp)-mp;
            }
            if(temp==0)
                return mid;
            else
            if(temp < 0)
            {
                low = mid;
            }
            else
            {
                high = mid;
            }
        }
        return mid;
    }

    public static void main(String[] args) {
        System.out.println(interestRate(6800, 100, 68));
        System.out.println(interestRate(2000, 510, 4));
        System.out.println(interestRate2(2000, 510, 4));
    }
}
