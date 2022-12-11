package MainApp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DepositPage extends BankDatabase {
    public JTextField depositAmountInput;
    private JLabel depositLabel;
    private JPanel depositPanel;
    public JButton backButton;
    public JButton makeDepositButton;
    private String userNumber;
    public JFrame frame;
    private BankDatabase bankDatabase;
    public DepositPage(BankDatabase bankDatabase, String userNumber){
        frame = new JFrame("DepositPage");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(depositPanel);
        frame.pack();
        this.bankDatabase = bankDatabase;
        this.userNumber = userNumber;
        backButton.addActionListener(new backButtonClicked());
        makeDepositButton.addActionListener(new makeDepositButtonClicked());
    }

    private class makeDepositButtonClicked implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            int depositAmount = Integer.parseInt(depositAmountInput.getText());
            if(depositAmount>0) {
                double availableBalance = bankDatabase.getAvailableBalance(Integer.parseInt(userNumber));
                    bankDatabase.credit(Integer.parseInt(userNumber), depositAmount / 100);
                    JOptionPane.showMessageDialog(null, "Deposit Successful!");
            }else{
                JOptionPane.showMessageDialog(null, "Deposit a mount must greater than $0");

            }
        }
    }
    private class backButtonClicked implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.dispose();
            new MainMenuPage(bankDatabase,userNumber);
        }
    }
}
