import MainApp.*;
import org.junit.Test;

import javax.swing.*;

import static org.junit.Assert.*;

public class GUITest {
    @Test
    public void T001_Login_validInput() {
        ATMHomePage loginPage = new ATMHomePage();
        MainMenuPage menu = new MainMenuPage(loginPage.bankDatabase, "12345");
        loginPage.userNumberInput.setText("12345");
        loginPage.pinInput.setText("54321");
        loginPage.loginButton.doClick();
        assertFalse(loginPage.frame.isDisplayable());
        assertTrue(menu.frame.isDisplayable());
    }

    @Test
    public void T002_Login_InvalidInput() {
        ATMHomePage loginPage = new ATMHomePage();
        loginPage.userNumberInput.setText("12346");
        loginPage.pinInput.setText("54321");
        loginPage.loginButton.doClick();
        assertTrue(loginPage.frame.isDisplayable());
    }
    @Test
    public void T003_Menu_ViewBalance() {
        BankDatabase bankDatabase = new BankDatabase();
        MainMenuPage menu = new MainMenuPage(bankDatabase, "12345");
        menu.viewBalanceButton.doClick();
        assertTrue(menu.totalBalance == 4450.0);
        assertTrue(menu.availableBalance ==-8720.0) ;
    }

    @Test
    public void T004_Menu_GoToDeposit() {
        BankDatabase bankDatabase = new BankDatabase();
        MainMenuPage menu = new MainMenuPage(bankDatabase, "12345");
        menu.depositButton.doClick();
        DepositPage depositPage = new DepositPage(bankDatabase,"12345");
        assertTrue(depositPage.frame.isDisplayable());
    }
    @Test
    public void T005_Menu_GoToWithdraw() {
        BankDatabase bankDatabase = new BankDatabase();
        MainMenuPage menu = new MainMenuPage(bankDatabase, "12345");
        menu.withdrawButton.doClick();
        WithdrawPage withdrawalPage = new WithdrawPage(bankDatabase,"12345");
        assertTrue(withdrawalPage.frame.isDisplayable());
    }

    @Test
    public void T006_Menu_Exit() {
        BankDatabase bankDatabase = new BankDatabase();
        MainMenuPage menu = new MainMenuPage(bankDatabase, "12345");
        menu.exitButton.doClick();
        ATMHomePage loginPage = new ATMHomePage();
        assertTrue(loginPage.frame.isDisplayable());
        assertFalse(menu.frame.isDisplayable());
    }

    @Test
    public void T007_Menu_MakeDeposit_1000cents() {
        BankDatabase bankDatabase = new BankDatabase();
        DepositPage deposit = new DepositPage(bankDatabase, "12345");
        deposit.depositAmountInput.setText("1000");
        deposit.makeDepositButton.doClick();
        double updatedTotalBalance = bankDatabase.getTotalBalance(Integer.parseInt("12345"));
        assertTrue(updatedTotalBalance== 4510.0);
    }
    @Test
    public void T008_Menu_MakeWithdraw_20Dollar() {
        BankDatabase bankDatabase = new BankDatabase();
        WithdrawPage withdrawPage = new WithdrawPage(bankDatabase, "12345");
        withdrawPage.twentyDollarButton.doClick();
        double updatedTotalBalance = bankDatabase.getTotalBalance(Integer.parseInt("12345"));
        double updatedAvailableBalance = bankDatabase.getAvailableBalance((Integer.parseInt("12345")));
        System.out.println(updatedAvailableBalance+ " " +updatedTotalBalance);
        assertTrue(updatedTotalBalance == 4460.0);
        assertTrue(updatedAvailableBalance ==-8740.0) ;
    }

    @Test
    public void T009_Menu_Deposit_BackToMenu() {
        BankDatabase bankDatabase = new BankDatabase();
        MainMenuPage menu = new MainMenuPage(bankDatabase, "12345");
        DepositPage deposit = new DepositPage(bankDatabase, "12345");
        deposit.backButton.doClick();
        assertFalse(deposit.frame.isDisplayable());
        assertTrue(menu.frame.isDisplayable());
    }
    @Test
    public void T010_Menu_Withdraw_BackToMenu() {
        BankDatabase bankDatabase = new BankDatabase();
        MainMenuPage menu = new MainMenuPage(bankDatabase, "12345");
        WithdrawPage withdraw = new WithdrawPage(bankDatabase, "12345");
        withdraw.backButton.doClick();
        assertFalse(withdraw.frame.isDisplayable());
        assertTrue(menu.frame.isDisplayable());
    }

}
