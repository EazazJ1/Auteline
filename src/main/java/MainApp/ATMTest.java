/**
 * SMTI06, 54411850, M Haidar Hanif
 * Task Five: Automated Teller Machine
 * Auteline | Simple ATM simulator with basic features
 */

// ATMTest.java
// Driver program to test ATM program

package MainApp;


public class ATMTest {

   //main method creates and runs the ATM
  public static void main(String[] args) {

      String mode = args.length != 0 ? args[0] : "1";
      String terminalApp = "1";
      String loadTest = "2";
      String guiApp = "3";

      if(mode.equals(terminalApp)){
          ATM mobileATM = new ATM();
          mobileATM.run();
      }
      if(mode.equals(loadTest)){
          BankDatabase db = new BankDatabase();
          db.loadTest(Integer.parseInt(args[1]));
      }
//      if(mode.equals(guiApp)){
//          ATMHomePage gui = new ATMHomePage();
//      }
    

  }


}
