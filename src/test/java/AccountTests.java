import static org.junit.Assert.assertTrue;

import org.junit.*;

import main.java.Account;

public class AccountTests {
    Account testAccount = new Account(12345,54321,100,1000);
    @Test
    public void testPINTrue() {
        boolean testResult = testAccount.validatePIN(54321);

        assertTrue(testResult);

    }
}
