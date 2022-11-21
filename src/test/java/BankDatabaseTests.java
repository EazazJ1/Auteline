import static org.junit.Assert.*;
import org.junit.*;
import MainApp.BankDatabase;


public class BankDatabaseTests {

    @Test
    public void T001_AuthenticateUser_AuthenticateWithCorrectCredentials_SuccessfullyAuthenticated() {
        BankDatabase testDatabase = new BankDatabase();

        boolean result = testDatabase.authenticateUser(12345, 54321);
        assertTrue(result);
    }

    @Test
    public void T002_AuthenticateUser_AuthenticateWithIncorrectCredentials_UnsuccessfullyAuthenticated() {
        BankDatabase testDatabase = new BankDatabase();

        boolean result = testDatabase.authenticateUser(000, 000);
        assertFalse(result);
    }

    @Test
    public void T003_getAvailableBalance_OneThousandAvailableBalance_ReturnsOneThousand() {
        BankDatabase testDatabase = new BankDatabase();

        double initResult = testDatabase.getAvailableBalance(12345);

        double result = testDatabase.getAvailableBalance(12345);
        assertTrue(result == initResult);
    }

    @Test
    public void T004_getTotalBalance_OneThousandTwoHundredTotalBalance_ReturnsOneThousandTwoHundredTotalBalance() {
        BankDatabase testDatabase = new BankDatabase();

        double initResult = testDatabase.getAvailableBalance(12345);
        double result = testDatabase.getAvailableBalance(12345);
        assertTrue(result == initResult);
    }

    @Test
    public void T005_Credit_OneHundredCredit_ThirteenHundredTotalBalance() {
        BankDatabase testDatabase = new BankDatabase();
        double initResult = testDatabase.getTotalBalance(12345);

        testDatabase.credit(12345, 100);

        double result = testDatabase.getTotalBalance(12345);
        assertTrue(result == initResult + 100);
    }

    @Test
    public void T006_Debit_OneHundredDebit_NineHundredTotalBalance() {
        BankDatabase testDatabase = new BankDatabase();

        double initResult = testDatabase.getAvailableBalance(12345);
        testDatabase.debit(12345, 100);

        double result = testDatabase.getAvailableBalance(12345);
        assertTrue(result == initResult - 100);
    }
}
