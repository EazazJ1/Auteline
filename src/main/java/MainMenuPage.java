import main.java.Account;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuPage  {
    private JButton viewBalanceButton;
    private JButton depositButton;
    private JButton withdrawButton;
    private JButton exitButton;
    private JLabel mainMenuLable;
    public JPanel mainMenuPanel;
    private JFrame frame;
    private main.java.BankDatabase bankDatabase;
    private String userNumber;
    public MainMenuPage(main.java.BankDatabase database, String userNumber) {
        frame = new JFrame("MainMenuPage");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(mainMenuPanel);
        frame.setSize(500, 500);
        frame.pack();
        this.bankDatabase = database;
        this.userNumber = userNumber;

        withdrawButton.addActionListener(new withdrawButtonClicked());
        depositButton.addActionListener(new depositButtonClicked());
        viewBalanceButton.addActionListener(new viewBalanceButtonClicked());
        exitButton.addActionListener(new exitButtonClicked());
    }
    private class withdrawButtonClicked implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            mainMenuPanel.setVisible(false);
            frame.setVisible(false);
            new WithdrawPage(bankDatabase,userNumber);
        }
    }
    private class depositButtonClicked implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            mainMenuPanel.setVisible(false);
            frame.setVisible(false);
            new DepositPage(bankDatabase,userNumber);
        }
    }
    private class viewBalanceButtonClicked implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            double availableBalance =bankDatabase.getAvailableBalance(Integer.parseInt(userNumber));
            double totalBalance =bankDatabase.getTotalBalance(Integer.parseInt(userNumber));
            JOptionPane.showMessageDialog(null, "Available balance: " +availableBalance+"\nTotal Balance: "+totalBalance);
        }
    }
    private class exitButtonClicked implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            mainMenuPanel.setVisible(false);
            frame.setVisible(false);
            userNumber ="";
            new ATMHomePage();
        }
    }
}