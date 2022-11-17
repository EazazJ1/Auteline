import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ATMHomePage extends main.java.BankDatabase {
    private JButton loginButton;
    private JPasswordField pinInput;
    private JTextField userNumberInput;
    private JLabel ATMLabel;
    private JPanel mainPanel;
    private JLabel userNumberLabel;
    private JLabel pinLabel;


    public ATMHomePage() {
        loginButton.addActionListener(new LogInBtnClicked());
}

    private class LogInBtnClicked implements ActionListener {
        //validate userNumber and pin
        @Override
        public void actionPerformed(ActionEvent e) {
            //check if user had enter data
            if(!userNumberInput.getText().isEmpty() && !pinInput.getText().isEmpty()) {
               //validate user input
                boolean accountValidation = authenticateUser(Integer.parseInt(userNumberInput.getText()), Integer.parseInt(pinInput.getText()));
                if (accountValidation == false) {
                    System.out.println("Invalid Input");
                    JOptionPane.showMessageDialog(null, "Incorrect user number or PIN");
                }
                else{
                    System.out.println("Login Successfully");
                    //navigate to next page
                }
            }
        }
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("ATMHomePage");
        frame.setContentPane(new ATMHomePage().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
      //new ATMHomePage();
    }

}
