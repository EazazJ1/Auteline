import static org.junit.Assert.*;

import org.junit.*;

import main.java.Account;

public class AccountTests {
    Account testAccount = new Account(12345,54321,100,1000);

    @Test
    public void T001_ValidatePIN_54321_True() {
        boolean actual = testAccount.validatePIN(54321);
        assertTrue(null, actual);
    }

    @Test
    public void T002_ValidatePIN_12345_False() {
        boolean actual = testAccount.validatePIN(12345);
        assertFalse(null, actual);
    }

    @Test
    public void T003_GetAvailableBalance_100() {
        double expected = 100;
        double actual = testAccount.getAvailableBalance();
        assertTrue(null, actual == expected);
    }

    @Test
    public void T004_GetTotalBalance_1000() {
        double expected = 1000;
        double actual = testAccount.getTotalBalance();
        assertTrue(null, actual == expected);
    }
    @Test
    public void T005_Credit_10_Expect_TotalBalance_1100() {
        double expected = 1010;
        testAccount.credit(10);
        double actual = testAccount.getTotalBalance();
        assertEquals(expected, actual, 0);
    }

    @Test
    public void T006_Debit_10_Expect_AvailableBalance_90() {
        double expected = 90;
        testAccount.debit(10);
        double actual = testAccount.getAvailableBalance();
        assertEquals(expected, actual, 0);
    }

    @Test
    public void T007_Debit_10_Expect_TotalBalance_990() {
        double expected = 990;
        testAccount.debit(10);
        double actual = testAccount.getTotalBalance();
        assertEquals(expected, actual, 0);
    }

    @Test
    public void T008_GetAccountNumber_12345() {
        double expected = 12345;
        double actual = testAccount.getAccountNumber();
        assertEquals(expected, actual, 0);
    }


}
