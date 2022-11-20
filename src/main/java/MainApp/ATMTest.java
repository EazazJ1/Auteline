/**
 * SMTI06, 54411850, M Haidar Hanif
 * Task Five: Automated Teller Machine
 * Auteline | Simple ATM simulator with basic features
 */

// ATMTest.java
// Driver program to test ATM program

package MainApp;

import database.DbManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ATMTest {

  // main method creates and runs the ATM
  public static void main(String[] args) throws SQLException {
//    DbManager db = new DbManager();
//    Connection con = db.connect();
//    String query = "select * from clients where AccountNumber = ?";
//
//    PreparedStatement stmt = con.prepareStatement(query);
//
//    stmt.setInt(1, 12345);
//    ResultSet rs = stmt.executeQuery();
//
//    if (rs.next()) {
//      //String Name = rs.getString(1);
//      System.out.print("AccountNumber: " + rs.getInt(1) + " PIN: " + rs.getInt(2) + " AccountBalance " + rs.getDouble(3) + " TotalBalance " + rs.getDouble(4));
//    }
//    else{
//      System.out.println("Nothing is coming");
//    }


    //ResultSet rs = stmt.executeQuery(query);
    //Account acc = new Account();
    ATM mobileATM = new ATM();
    mobileATM.run();
  }

}
