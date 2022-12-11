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
    }


    @Test //need to update
    public void T007_Menu_MakeDeposit_1000cents() {
        ATMHomePage loginPage = new ATMHomePage();
        DepositPage deposit = new DepositPage(loginPage.bankDatabase, "12345");
        deposit.depositAmountInput.setText("1000");
        deposit.makeDepositButton.doClick();
        MainMenuPage menu = new MainMenuPage(loginPage.bankDatabase, "12345");
        assertTrue(menu.totalBalance == 4480.0);
        //assertTrue(menu.availableBalance ==-8720.0) ;
    }
    @Test //need to update
    public void T008_Menu_MakeWithdraw_20Dollar() {
        ATMHomePage loginPage = new ATMHomePage();
        WithdrawPage withdrawPage = new WithdrawPage(loginPage.bankDatabase, "12345");
        withdrawPage.twentyDollarButton.doClick();
        MainMenuPage menu = new MainMenuPage(loginPage.bankDatabase, "12345");
        assertTrue(menu.totalBalance == 4500.0);
        //assertTrue(menu.availableBalance ==-8720.0) ;
    }
}
