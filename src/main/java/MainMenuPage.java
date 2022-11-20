import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuPage {
    private JButton viewBalanceButton;
    private JButton depositButton;
    private JButton withdrawButton;
    private JButton exitButton;
    private JLabel mainMenuLable;
    public JPanel mainMenuPanel;
    private JFrame frame;

    public MainMenuPage() {
        frame = new JFrame("MainMenuPage");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(mainMenuPanel);
        frame.pack();
        withdrawButton.addActionListener(new withdrawButtonClicked());

    }
    private class withdrawButtonClicked implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            mainMenuPanel.setVisible(false);
            frame.setVisible(false);
            new WithdrawPage();
        }
    }
}