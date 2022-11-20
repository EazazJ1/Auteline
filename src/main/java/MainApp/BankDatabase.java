/**
 * SMTI06, 54411850, M Haidar Hanif
 * Task Five: Automated Teller Machine
 * Auteline | Simple ATM simulator with basic features
 */

// BankDatabase.java
// Represents the bank account information database

package MainApp;

import database.DbManager;
import java.sql.*;

public class BankDatabase {

  private Account accounts[]; // array of Accounts

  private DbManager db;
  private Connection con;


  // no-argument BankDatabase constructor initializes accounts
  public BankDatabase(){
//    accounts = new Account[2]; // just 2 accounts for testing
//    accounts[0] = new Account(12345, 54321, 1000.0, 1200.0);
//    accounts[1] = new Account(98765, 56789, 200.0, 200.0);
    con = db.connect();
//    try {
//      accounts[0] = this.getAccountDB(12345);
//    } catch (SQLException e) {
//      throw new RuntimeException(e);
//    }
  }

   //retrieve Account object containing specified account number
//  private Account getAccount(int accountNumber) {
//    // loop through accounts searching for matching account number
//    for (Account currentAccount : accounts) {
//      // return current account if match found
//      if (currentAccount.getAccountNumber() == accountNumber) {
//        return currentAccount;
//      }
//    }
//    return null; // if no matching account was found
//  }

  private Account getAccount(int accountNumber)  {
    String query = "select * from clients where AccountNumber = ?";

    PreparedStatement stmt = null;
    try {
      stmt = this.con.prepareStatement(query);
      stmt.setInt(1, accountNumber);
      ResultSet rs = stmt.executeQuery();
      if(rs.next()){
        Account newAcc = new Account(rs.getInt(1),rs.getInt(2),  rs.getDouble(3),  rs.getDouble(4));
        return newAcc;
      }
      else{
        return null;
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  // determine whether user-specified account number and PIN match
  // those of an account in the database
  public boolean authenticateUser(int userAccountNumber, int userPIN) {
    // attempt to retrieve the account with the account number
    Account userAccount = getAccount(userAccountNumber);
    // if account exists, return result of Account method validatePIN
    return userAccount != null ? userAccount.validatePIN(userPIN) : false;
  }

  // return available balance of Account with specified account number
  public double getAvailableBalance(int userAccountNumber) {
    return getAccount(userAccountNumber).getAvailableBalance();
  }

  // return total balance of Account with specified account number
  public double getTotalBalance(int userAccountNumber)  {
    return getAccount(userAccountNumber).getTotalBalance();
  }

  // credit an amount to Account with specified account number
  public void credit(int userAccountNumber, double amount)  {
    getAccount(userAccountNumber).credit(amount);
  }

//  public void credit(int userAccountNumber, double amount){
//    String query = "select * from clients where AccountNumber = ?";
//
//    PreparedStatement stmt = null;
//    try {
//      stmt = this.con.prepareStatement(query);
//      stmt.setInt(1, userAccountNumber);
//      ResultSet rs = stmt.executeQuery();
//      if(rs.next()){
//        Account newAcc = new Account(rs.getInt(1),rs.getInt(2),  rs.getDouble(3),  rs.getDouble(4));
//
//      }
//
//    } catch (SQLException e) {
//      throw new RuntimeException(e);
//    }
//  }

  // debit an amount from of Account with specified account number
  public void debit(int userAccountNumber, double amount)  {
    getAccount(userAccountNumber).debit(amount);
  }

}
