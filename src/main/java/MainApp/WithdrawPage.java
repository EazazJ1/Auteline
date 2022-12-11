package MainApp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WithdrawPage {
    private JButton twoHundredDollarButton;
    private JPanel withdrawPanel;
    public JButton twentyDollarButton;
    private JButton sixtyDollarButton;
    private JButton fourtyDollarButton;
    private JLabel withdrawLabel;
    private JButton oneHundredDollarButton;
    public JButton backButton;
    public JFrame frame;
    private String userNumber;
    private BankDatabase bankDatabase;
    public WithdrawPage(BankDatabase bankDatabasePassed, String userNumber){
        frame = new JFrame("WithdrawPage");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(withdrawPanel);
        frame.pack();
        this.userNumber = userNumber;
        this.bankDatabase = bankDatabasePassed;

        twentyDollarButton.addActionListener(new withdrawAmountClicked(20));
        fourtyDollarButton.addActionListener(new withdrawAmountClicked(40));
        sixtyDollarButton.addActionListener(new withdrawAmountClicked(60));
        oneHundredDollarButton.addActionListener(new withdrawAmountClicked(100));
        twoHundredDollarButton.addActionListener(new withdrawAmountClicked(200));

        backButton.addActionListener(new backButtonClicked());
    }
    private class withdrawAmountClicked implements ActionListener{
        private int withdrawAmount =0;

        private withdrawAmountClicked(int amount){
            this.withdrawAmount = amount;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            double availableBalance = bankDatabase.getAvailableBalance(Integer.parseInt(userNumber));
            if(availableBalance>withdrawAmount) {//if enough fund
                bankDatabase.debit(Integer.parseInt(userNumber), withdrawAmount);
                JOptionPane.showMessageDialog(null, "Withdraw Successful!");
            }else {
                JOptionPane.showMessageDialog(null, "Current balance is not enough");
            }
        }
    }
    private class backButtonClicked implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.dispose();
            new MainMenuPage(bankDatabase,userNumber);
        }
    }
}
