//

/*
 * Created by: Logan Cantin
 * Created on: 07-Feb-2019
 * Created for: ICS4U
 * Day #4 (Logging Company GUI)
 * This program calculates the number of logs that fit on a truck using a GUI.
 */

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HelloWorld {

    // References to GUI objects
    private JTextField txt_logs;
    private JLabel lbl_logs;
    private JButton btn_logs;
    private JPanel panelMain;

    // Constants
    private final Double MAX_WEIGHT = 1100.0;
    private final Double LOG_WEIGHT_PER_METER = 20.0;

    // Check input to see if it is valid, return true if valid or false otherwise.
    private static Boolean checkInput(String input){
        try {
            // Try to parse a double
            double logSize = Double.parseDouble(input);

            // Check if the decimal is one of the acceptable sizes, return true.
            if (logSize == 0.25 | logSize == 0.5 | logSize == 1){
                return true;
            }
            // Not an acceptable log size
            else {
                return false;
            }
        }
        // Not a double, return false
        catch (Exception e) {
            return false;
        }
    }

    // Calculate number of logs based on the log size and return
    private Double calculateLogs(Double size) {
        Double weightPerLog = size * LOG_WEIGHT_PER_METER;
        Double maxLogs = MAX_WEIGHT / weightPerLog;

        return maxLogs;
    }

    // Constructor
    public HelloWorld() {
        btn_logs.addActionListener(new ActionListener() {

            // When the button gets pressed
            @Override
            public void actionPerformed(ActionEvent e) {

                // Read text from the input and check if it is valid
                String inputText = txt_logs.getText();
                Boolean result = HelloWorld.checkInput(inputText);

                // If it is valid, calculate the number of logs and show a messagebox to share that information with the user
                if (result == true){
                    Double numLogs = calculateLogs(Double.parseDouble(inputText));
                    JOptionPane.showMessageDialog(null, String.format("You can fit %.0f logs on the truck.", numLogs));

                }

                //Not valid, alert the user.
                else {
                    JOptionPane.showMessageDialog(null, "Invalid Input. Please enter 0.25, 0.5, or 1.");
                }

            }
        });
    }

    // GUI setup
    public static void main(String[] args) {
        JFrame frame = new JFrame("App");
        frame.setContentPane(new HelloWorld().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
