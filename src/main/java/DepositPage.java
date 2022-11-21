import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DepositPage extends main.java.BankDatabase {
    private JTextField depositAmountInput;
    private JLabel depositLabel;
    private JPanel depositPanel;
    private JButton backButton;
    private JButton makeDepositButton;
    private String userNumber;
    private JFrame frame;
    private main.java.BankDatabase bankDatabase;
    public DepositPage(main.java.BankDatabase bankDatabase, String userNumber){
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
                    bankDatabase.credit(Integer.parseInt(userNumber), depositAmount);
                    JOptionPane.showMessageDialog(null, "Deposit Successful!");
            }else{
                JOptionPane.showMessageDialog(null, "Deposit a mount must greater than $0");

            }
        }
    }
    private class backButtonClicked implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.setVisible(false);
            new MainMenuPage(bankDatabase,userNumber);
        }
    }
}
