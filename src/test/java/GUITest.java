import MainApp.*;
import org.junit.Test;

import javax.swing.*;

import static org.junit.Assert.*;

public class GUITest {
    BankDatabase bankDatabase = new BankDatabase();

    @Test
    public void T001_Login_validInput() {
        ATMHomePage loginPage = new ATMHomePage();
        loginPage.userNumberInput.setText("11111");
        loginPage.pinInput.setText("54321");
        loginPage.loginButton.doClick();
        assertFalse(loginPage.frame.isDisplayable());
    }

    @Test
    public void T002_Login_InvalidInput() {
        ATMHomePage loginPage = new ATMHomePage();
        loginPage.userNumberInput.setText("11111");
        loginPage.pinInput.setText("11121");
        loginPage.loginButton.doClick();
        assertTrue(loginPage.frame.isDisplayable());
    }
    @Test
    public void T003_Menu_ViewBalance() {
        MainMenuPage menu = new MainMenuPage(bankDatabase, "11111");
        menu.viewBalanceButton.doClick();
        assertTrue(menu.totalBalance == 2000);
        assertTrue(menu.availableBalance ==2000) ;
    }

    @Test
    public void T004_Menu_GoToDeposit() {
        MainMenuPage menu = new MainMenuPage(bankDatabase, "11111");
        menu.depositButton.doClick();
       // DepositPage depositPage = new DepositPage(bankDatabase,"1111");
        assertFalse(menu.frame.isDisplayable());
    }
    @Test
    public void T005_Menu_GoToWithdraw() {
        MainMenuPage menu = new MainMenuPage(bankDatabase, "11111");
        menu.withdrawButton.doClick();
        //WithdrawPage withdrawalPage = new WithdrawPage(bankDatabase,"12345");
        assertFalse(menu.frame.isDisplayable());
    }

    @Test
    public void T006_Menu_Exit() {
        MainMenuPage menu = new MainMenuPage(bankDatabase, "11111");
        menu.exitButton.doClick();
        assertFalse(menu.frame.isDisplayable());
    }

    @Test
    public void T007_Menu_MakeDeposit_1000cents() {
        DepositPage deposit = new DepositPage(bankDatabase, "11111");
        deposit.depositAmountInput.setText("1000");
        deposit.makeDepositButton.doClick();
        double updatedTotalBalance = bankDatabase.getTotalBalance(Integer.parseInt("11111"));
        assertTrue(updatedTotalBalance== 2010.0);
    }
    @Test
    public void T008_Menu_MakeWithdraw_20Dollar() {
        WithdrawPage withdrawPage = new WithdrawPage(bankDatabase, "11111");
        withdrawPage.twentyDollarButton.doClick();
        double updatedTotalBalance = bankDatabase.getTotalBalance(Integer.parseInt("11111"));
        double updatedAvailableBalance = bankDatabase.getAvailableBalance((Integer.parseInt("11111")));
        assertTrue(updatedTotalBalance == 1990.0);
        assertTrue(updatedAvailableBalance ==1980.0) ;
    }

    @Test
    public void T009_Menu_Deposit_BackToMenu() {
        MainMenuPage menu = new MainMenuPage(bankDatabase, "11111");
        DepositPage deposit = new DepositPage(menu.bankDatabase, "11111");
        deposit.backButton.doClick();
        assertFalse(deposit.frame.isDisplayable());
        assertTrue(menu.frame.isDisplayable());
    }
    @Test
    public void T010_Menu_Withdraw_BackToMenu() {
        MainMenuPage menu = new MainMenuPage(bankDatabase, "11111");
        WithdrawPage withdraw = new WithdrawPage(menu.bankDatabase, "11111");
        withdraw.backButton.doClick();
        assertFalse(withdraw.frame.isDisplayable());
        assertTrue(menu.frame.isDisplayable());
    }

}
