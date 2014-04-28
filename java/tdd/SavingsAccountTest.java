package tdd;

import junit.framework.Assert;
import org.junit.Ignore;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created on 4/26/2014.
 */
public class SavingsAccountTest {

    @Test
    public void nextYear() {
        SavingsAccountYear account = new SavingsAccountYear(10000);
        SavingsAccountYear nextYear = account.nextYear();
        assertEquals(account.endingBalance(), nextYear.startingBalance());
    }

    @Test
    public void endingBalance() {
        SavingsAccountYear account = new SavingsAccountYear(10000, 10);
        assertEquals(11000, account.endingBalance());
    }
}
