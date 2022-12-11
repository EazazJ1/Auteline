package MainApp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuPage  {
    public JButton viewBalanceButton;
    public JButton depositButton;
    public JButton withdrawButton;
    public JButton exitButton;
    private JLabel mainMenuLable;
    public JPanel mainMenuPanel;
    public JFrame frame;
    private BankDatabase bankDatabase;
    private String userNumber;
    public double availableBalance;
    public double totalBalance;
    public MainMenuPage(BankDatabase database, String userNumber) {
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
            frame.dispose();
            new WithdrawPage(bankDatabase,userNumber);
        }
    }
    private class depositButtonClicked implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            mainMenuPanel.setVisible(false);
            frame.dispose();
            new DepositPage(bankDatabase,userNumber);
        }
    }
    public class viewBalanceButtonClicked implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            availableBalance =bankDatabase.getAvailableBalance(Integer.parseInt(userNumber));
            totalBalance =bankDatabase.getTotalBalance(Integer.parseInt(userNumber));
            JOptionPane.showMessageDialog(null, "Available balance: " +availableBalance+"\nTotal Balance: "+totalBalance);
        }
    }
    private class exitButtonClicked implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            mainMenuPanel.setVisible(false);
            frame.dispose();
            userNumber ="";
            new ATMHomePage();
        }
    }
}