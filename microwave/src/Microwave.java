/*
 * Created by: Logan Cantin
 * Created on: 29-Feb-20120
 * Created for: ICS4U
 * Day #7 (Microwave)
 * This program calculates the amount of time it takes to microwave food.
*/

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Microwave {
    private JPanel mainpanel;
    private JButton btnCalculate;
    private JComboBox foodCombo;
    private JComboBox numberCombo;
    private JLabel answerLabel;

    private static double[] TIMES = {45., 60., 105.}; // Amount of time for Pizza, Sub, Soup respectively.
    private static double[] MULTIPLIERS = {1.0, 1.5, 2.0}; // Multiplier for one, two, and three items respectively.

    public Microwave() {

        // Calculate the number
        btnCalculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                double time = TIMES[foodCombo.getSelectedIndex()] * MULTIPLIERS[numberCombo.getSelectedIndex()];
                answerLabel.setText(String.valueOf(time));
            }
        });
    }

    // Initializing frame
    public static void main(String[] args) {
        JFrame frame = new JFrame("App");
        frame.setContentPane(new Microwave().mainpanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
