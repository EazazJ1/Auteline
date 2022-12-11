import org.junit.Test;
import MainApp.Account;
import MainApp.BankDatabase;
import MainApp.CashDispenser;

//import.main.*;

import static org.junit.Assert.*;

import org.junit.*;

//import main.java.Account.debit;
import static org.junit.Assert.assertTrue;


public class Asn3SysIntegrationTests {

    @Test
    public void T001_Withdraw_HappyPath() {

        //Create fake account, need it for proper credentials
        Account fakeAccount = new Account(12345,
                54321,
                1000,
                1000);

        //Create dummy database just required to authenticate and complete the test
        BankDatabase dummyDatabase = new BankDatabase();


        dummyDatabase.authenticateUser(12345, 54321);

        //withdrawing 100 from fake account whose balance is 1000, should result in 900
        fakeAccount.debit(100);
        double finalAvailableBalance = fakeAccount.getAvailableBalance();

        assertEquals(900, finalAvailableBalance, 0);
    }

    //created stub function to test withdrawal verification since we couldn't directly use the withdrawal object
    public static boolean StubWithdrawal(int withdrawAmount, BankDatabase testDatabase, int testAccountNumber) {
        double availableBalance = testDatabase.getAvailableBalance(testAccountNumber);

        if(withdrawAmount > availableBalance)
            return false;
        else
            return true;
    }
    @Test
    public void T002_Withdraw_SadPath() {

        //Create fake account, need it for proper credentials
        Account fakeAccount = new Account(12345,
                54321,
                1000,
                1000);

        //Create dummy database just required to authenticate and complete the test
        BankDatabase dummyDatabase = new BankDatabase();

        dummyDatabase.authenticateUser(12345, 54321);


        //Use stub function to confirm that withdrawing an amount greater than available balance should return false
        boolean result = StubWithdrawal(2000, dummyDatabase, fakeAccount.getAccountNumber());

        assertFalse(result);
    }


    @Test
    public void T003_Authentication_HappyPath() {

        //Create fake account, need it for proper credentials
        Account fakeAccount = new Account(98765,
                56789,
                1000,
                1000);

        //Create dummy database just required to authenticate and complete the test
        BankDatabase dummyDatabase = new BankDatabase();

        //Responders with valid input to ensure login passes
        int userAccountNumberResponder = 98765;
        int userPinResponder = 56789;

        boolean result = dummyDatabase.authenticateUser(userAccountNumberResponder, userPinResponder);
        assertTrue(result);
    }

    @Test
    public void T004_Authentication_SadPath() {

        //Declare dummy objects
        Account fakeAccount = new Account(7171,
                0001,
                1000,
                1000);
        BankDatabase dummyDatabase = new BankDatabase();

        //Saboteurs with invalid input to ensure login fails
        int userAccountNumberSaboteur = 43234;
        int userPinSaboteur = 233;

        boolean result = dummyDatabase.authenticateUser(userAccountNumberSaboteur, userPinSaboteur);
        assertFalse(result);
    }

}
