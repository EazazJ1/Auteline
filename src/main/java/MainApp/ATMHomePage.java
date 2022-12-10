package MainApp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ATMHomePage extends BankDatabase {
    private JButton loginButton;
    private JPasswordField pinInput;
    private JTextField userNumberInput;
    private JLabel ATMLabel;
    private JPanel mainPanel;
    private JLabel userNumberLabel;
    private JLabel pinLabel;
    private BankDatabase bankDatabase = new BankDatabase();

    private JFrame frame;
    public ATMHomePage() {
        frame = new JFrame("ATMHomePage");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(mainPanel);
        frame.pack();

        loginButton.addActionListener(new LogInBtnClicked());
}

    private class LogInBtnClicked implements ActionListener {
        //validate userNumber and pin
        @Override
        public void actionPerformed(ActionEvent e) {
            //check if user had enter data
            if(!userNumberInput.getText().isEmpty() && !pinInput.getText().isEmpty()) {
               //validate user input
                boolean accountValidation = bankDatabase.authenticateUser(Integer.parseInt(userNumberInput.getText()), Integer.parseInt(pinInput.getText()));
                if (accountValidation == false) {
                    System.out.println("Invalid Input");
                    JOptionPane.showMessageDialog(null, "Incorrect user number or PIN");
                }
                else{
                    System.out.println("Login Successfully");
                    //navigate to next page
                    String userNumber = userNumberInput.getText();
                    userNumberInput.setText("");
                    pinInput.setText("");
                    //mainPanel.setVisible(false);
                    frame.dispose();
                    new MainMenuPage(bankDatabase,userNumber);
                }
            }
        }
    }
    // public static void main(String[] args) {
    // new ATMHomePage();

    // }

}
