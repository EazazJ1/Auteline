import static org.junit.Assert.*;

import org.junit.*;

//import main.java.Deposit;
//import main.java.Screen;
import main.java.*;

public class DepositTests {

//    @Test
//    public void checkDepositInput()
//    {
//        Screen testScreen = new Screen();
//        BankDatabase testDatabase = new BankDatabase();
//        Keypad testKeypad = new Keypad();
//        DepositSlot testDepositSlot = new DepositSlot();
//        Deposit testDeposit = new Deposit(12345, testScreen, testDatabase, testKeypad, testDepositSlot);
//
//
//        double res = testDeposit.
//    }

    @Test
    public void checkGreater(){
        boolean res = false;
        int one = 2;
        int two = 1;


        if(one > two){
            res = true;
        }

        assertTrue(res);
    }

}
