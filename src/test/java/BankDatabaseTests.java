import static org.junit.Assert.*;
import org.junit.*;
import main.java.BankDatabase;

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

        double result = testDatabase.getAvailableBalance(12345);
        assertTrue(result == 1000);
    }

    @Test
    public void T004_getTotalBalance_OneThousandTwoHundredTotalBalance_ReturnsOneThousandTwoHundredTotalBalance() {
        BankDatabase testDatabase = new BankDatabase();

        double result = testDatabase.getAvailableBalance(12345);
        assertTrue(result == 1000);
    }

    @Test
    public void T005_Credit_OneHundredCredit_ThirteenHundredTotalBalance() {
        BankDatabase testDatabase = new BankDatabase();
        testDatabase.credit(12345, 100);

        double result = testDatabase.getTotalBalance(12345);
        assertTrue(result == 1300);
    }

    @Test
    public void T006_Debit_OneHundredDebit_NineHundredTotalBalance() {
        BankDatabase testDatabase = new BankDatabase();
        testDatabase.debit(12345, 100);

        double result = testDatabase.getAvailableBalance(12345);
        assertTrue(result == 900);
    }
}
