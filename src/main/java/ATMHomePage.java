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
                boolean accountValidation = authenticateUser(Integer.parseInt(userNumberInput.getText()), Integer.parseInt(pinInput.getText()));
                if (accountValidation == false) {
                    System.out.println("Invalid Input");
                    JOptionPane.showMessageDialog(null, "Incorrect user number or PIN");
                }
                else{
                    System.out.println("Login Successfully");
                    //navigate to next page
                    mainPanel.setVisible(false);
//                    frame.setContentPane(new MainMenuPage().mainMenuPanel);
//                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//                    frame.pack();
//                    frame.setVisible(true);
                    frame.setVisible(false);
                    new MainMenuPage();
                }
            }
        }
    }
    public static void main(String[] args) {
    new ATMHomePage();

    }

}
