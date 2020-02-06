import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HelloWorld {
    private JTextField txt_logs;
    private JLabel lbl_logs;
    private JButton btn_logs;
    private JPanel panelMain;
    private final Double MAX_WEIGHT = 1100.0;
    private final Double LOG_WEIGHT_PER_METER = 20.0;

    private static Boolean checkInput(String input){
        try {
            double logSize = Double.parseDouble(input);
            if (logSize == 0.25 | logSize == 0.5 | logSize == 1){
                return true;
            }
            else {
                return false;
            }
        }
        catch (Exception e) {
            return false;
        }
    }

    private Double calculateLogs(Double size) {
        Double weightPerLog = size * LOG_WEIGHT_PER_METER;
        Double maxLogs = MAX_WEIGHT / weightPerLog;

        return maxLogs;
    }

    public HelloWorld() {
        btn_logs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputText = txt_logs.getText();
                Boolean result = HelloWorld.checkInput(inputText);

                if (result == true){
                    Double numLogs = calculateLogs(Double.parseDouble(inputText));
                    JOptionPane.showMessageDialog(null, String.format("You can fit %.0f logs on the truck.", numLogs));

                }
                else {
                    JOptionPane.showMessageDialog(null, "Invalid Input. Please enter 0.25, 0.5, or 1.");
                }

            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("App");
        frame.setContentPane(new HelloWorld().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
