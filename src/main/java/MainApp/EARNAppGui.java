package MainApp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class EARNAppGui {
    //variables and functions for internal use
    private final BankDatabase atmDatabase = new BankDatabase();

    private final CashDispenser atmDispenser = new CashDispenser();
    private int currUser = 0;

    private boolean withdrawCash(int withdrawValue){
        if(0 != currUser){
            if(withdrawValue <= atmDatabase.getAvailableBalance(currUser)) {
                if (atmDispenser.isSufficientCashAvailable(withdrawValue)) {

                    //if atm has enough available AND dispenser has enough bills then withdraw
                    atmDatabase.debit(currUser, withdrawValue);
                    atmDispenser.dispenseCash(withdrawValue);
                    System.out.printf("Withdrew $%d, new Balance: $%.2f\n", withdrawValue, atmDatabase.getTotalBalance(currUser));
                    return true;
                }
            }
        }
        //if it doesn't return through second if, must be a fail
        return false;
    }

    //wrapper for withdrawCash to not reuse code in withdraw buttons
    private void withdrawWrapper(int withdrawValue){
        String outputMsg;

        if(withdrawCash(withdrawValue)){
            outputMsg = String.format("Withdrew value of $%d",withdrawValue);

        }
        else{
            outputMsg = String.format("Unable to Withdraw value of $%d",withdrawValue);
        }

        JOptionPane.showMessageDialog(null,outputMsg);
    }

    //Swing element objects etc
    private JPanel mainPanel;
    private JPanel loginPage;
    private JPanel homePage;
    private JTextField userNumberInput;
    private JPasswordField userPinInput;
    private JButton loginBtn;
    private JButton viewBalanceBtn;
    private JButton depositBtn;
    private JButton withdrawBtn;
    private JButton exitBtn;
    private JPanel depositPage;
    private JPanel withdrawPage;
    private JButton withdraw20Btn;
    private JButton withdraw40Btn;
    private JButton withdraw60Btn;
    private JButton withdraw100Btn;
    private JButton withdraw200Btn;
    private JButton retWithdrawBtn;
    private JTextField depositAmountInput;
    private JButton depAmountBtn;
    private JButton retDepositBtn;
    private JLabel loginIcon;

    public EARNAppGui() {

        //Login Page Buttons
        loginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!userNumberInput.getText().isBlank() && 0 != userPinInput.getPassword().length){
                    boolean correctLogin = atmDatabase.authenticateUser(
                            Integer.parseInt(userNumberInput.getText()),
                            Integer.parseInt(String.valueOf(userPinInput.getPassword()))
                    );

                    if(correctLogin){
                        System.out.println("Login Success, Going to Home Page");

                        currUser = Integer.parseInt(userNumberInput.getText());
                        mainPanel.removeAll();
                        mainPanel.add(homePage);
                        mainPanel.repaint();
                        mainPanel.revalidate();
                    }
                    else{
                        System.out.println("Login Failed");
                        JOptionPane.showMessageDialog(null,"Incorrect User Number or PIN");
                    }
                }
            }
        });

        //Home Page Buttons
        viewBalanceBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double currBalance = atmDatabase.getTotalBalance(currUser);

                System.out.printf("User Requested View Balance, Returned: $%.2f",currBalance);
                String viewBalMsg = String.format("Your Balance is: $%.2f", currBalance);
                JOptionPane.showMessageDialog(null,viewBalMsg);
            }
        });

        depositBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Going to Deposit Page");
                mainPanel.removeAll();
                mainPanel.add(depositPage);
                mainPanel.repaint();
                mainPanel.revalidate();
            }
        });

        withdrawBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Going to Withdraw Page");
                mainPanel.removeAll();
                mainPanel.add(withdrawPage);
                mainPanel.repaint();
                mainPanel.revalidate();
            }
        });

        exitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Going Back to Login Page");
                mainPanel.removeAll();
                mainPanel.add(loginPage);
                mainPanel.repaint();
                mainPanel.revalidate();
            }
        });

        //Withdraw Page Buttons
        withdraw20Btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                withdrawWrapper(20);
            }
        });

        withdraw40Btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                withdrawWrapper(40);
            }
        });

        withdraw60Btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                withdrawWrapper(60);
            }
        });

        withdraw100Btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                withdrawWrapper(100);
            }
        });

        withdraw200Btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                withdrawWrapper(200);
            }
        });

        retWithdrawBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Going Back to Home Page");
                mainPanel.removeAll();
                mainPanel.add(homePage);
                mainPanel.repaint();
                mainPanel.revalidate();
            }
        });

        //Deposit Page Buttons
        depAmountBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BigDecimal depositAmount = new BigDecimal(depositAmountInput.getText()).setScale(2,RoundingMode.HALF_UP);

                if(!depositAmountInput.getText().isBlank() && 0 < depositAmount.doubleValue())
                {
                    atmDatabase.credit(currUser,depositAmount.doubleValue());
                    String outputMsg = String.format("Deposited $%.2f, new Balance: $%.2f",
                            depositAmount.doubleValue(),
                            atmDatabase.getTotalBalance(currUser));
                    System.out.println(outputMsg);

                    JOptionPane.showMessageDialog(null, outputMsg);
                }
            }
        });

        retDepositBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Going Back to Home Page");
                mainPanel.removeAll();
                mainPanel.add(homePage);
                mainPanel.repaint();
                mainPanel.revalidate();
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("EARN ATM App");
        frame.setContentPane(new EARNAppGui().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        loginIcon = new JLabel(new ImageIcon("assets/EARNLogo.png"));
    }
}
