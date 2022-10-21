import main.java.Account;
import main.java.BankDatabase;
//import.main.*;

import static org.junit.Assert.*;

import org.junit.*;

//import main.java.Account.debit;

/*Acceptance test: mimic flow of signing into app with proper credentials,
make a withdrawal (debit), which deducts from available and total balance,
then deposit (credit) which updates total balance,
amount should still persist from the initial debit to give correct balance
 */

public class AcceptanceTest {

    @Test
    public void acceptanceTest() {
        Account testAccount = new Account(12345,
                54321,
                1000,
                1200);
        BankDatabase testDatabase = new BankDatabase();

        //sign in with correct account number and pin

        testDatabase.authenticateUser(12345, 54321);
        boolean authenticated = testDatabase.authenticateUser(12345, 54321);


        testAccount.debit(100);
        double finalAvailableBalance = testAccount.getAvailableBalance();

        //Withdrew $100, so total balance is now $1100, available is $900

        testAccount.credit(200);

        double finalTotalBalance = testAccount.getTotalBalance();

        //total balance was $1100 from withdraw, then deposited $200 so should now be $1300

        assertTrue(authenticated);
        assertEquals(900, finalAvailableBalance, 0);
        assertEquals(1300, finalTotalBalance, 0);
    }
}
