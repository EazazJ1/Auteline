import static org.junit.Assert.*;

import org.junit.*;

import main.java.CashDispenser;

public class CashDispenserTests {
    @Test
    public void T001_isSufficientCashAvailable_CountGreaterThanBillsRequired_True() {
        CashDispenser testCashDispenser = new CashDispenser();

        boolean testResult = testCashDispenser.isSufficientCashAvailable(100);

        assertTrue(testResult);
    }

    @Test
    public void T002_isSufficientCashAvailable_CountLessThanBillsRequired_False() {
        CashDispenser testCashDispenser = new CashDispenser();

        boolean testResult = testCashDispenser.isSufficientCashAvailable(15000);

        assertFalse(testResult);
    }

    @Test
    public void T003_dispenseCash_CountLessThanBillsRequired_False() {
        CashDispenser testCashDispenser = new CashDispenser();

        testCashDispenser.dispenseCash(10000);
        //count should be 0 now so isSufficientCashAvailable should return false if I send
        //amount > 0

        boolean testResult = testCashDispenser.isSufficientCashAvailable(100);
        assertFalse(testResult);
    }
}
