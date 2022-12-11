import MainApp.ATMHomePage;
import MainApp.MainMenuPage;
import MainApp.DepositSlot;
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

    }
}
