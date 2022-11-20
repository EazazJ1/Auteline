import javax.swing.*;

public class WithdrawPage {
    private JButton twoHundredDollarButton;
    private JPanel withdrawPanel;
    private JButton twentyDollarButton;
    private JButton sixtyDollarButton;
    private JButton fourtyDollarButton;
    private JLabel withdrawLabel;
    private JButton oneHundredDollarButton;
    private JFrame frame;

    public WithdrawPage(){
        frame = new JFrame("WithdrawPage");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(withdrawPanel);
        frame.pack();
    }
}
