import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EinsteinsEquation {
    private JButton btn_calculate;
    private JTextField txt_mass;
    private JPanel panelMain;

    // Defining Constants
    final static Double C = 2.998e8; // speed of light, in m/s
    final static Double J_PER_KILOTON_BOMB = 4.0e15; // Number of joules in a kiloton bomb

    // Calculates the amount of energy, in joules, released by <mass> kilograms of matter
    private static Double EnergyCalculator(Double mass){
        return mass * (Math.pow(EinsteinsEquation.C, 2.));
    }

    // Converting from a double to scientific notation
    private static String doubleToScientific(Double d){

        // Reducing the number between 1 ≤ coeff < 10
        int exp = (int) Math.floor(Math.log10(d));
        double coeff = d / Math.pow(10., exp);

        // Formatting the coefficient to have a maximum of 3 decimal places and return it as a string
        return String.format("%.3fe%d", coeff, exp);
    }

    // Calculates the number of kiloton bombs that is equal to the amount of energy released
    private static String numKilotonBombs(Double joules){

        double KTBombs = joules / J_PER_KILOTON_BOMB;

        // Return scientific notation if the value is greater than 1000, otherwise return the original value.
        if (joules > 1000){
            return doubleToScientific(KTBombs);
        }
        else {
            return Double.toString(KTBombs);
        }
    }

    // Gets a mass value from the user
    private static Double checkInput(String input){

        try {
            // Try to parse a double from the user's input
            Double mass = Double.parseDouble(input);

            // Checking that the mass is non-negative.
            if (mass >= 0) {

                // Return mass
                return mass;
            }

            // Negative value was passed
            else {
                // Alert user
                JOptionPane.showMessageDialog(null, "Enter a positive value.");

                // Pass a -1
                return -1.;
            }
        }

        //Value passed was not a string.
        catch (Exception e){
            // Alert user
            JOptionPane.showMessageDialog(null, "Enter a number.");

            return -2.;
        }
    }

    public EinsteinsEquation() {
        btn_calculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // Get input from the text field
                String input = txt_mass.getText();
                // convert input to a double
                Double mass = checkInput(input);

                // non-error mass values are positive, all other values have already been handled
                if (mass >= 0.){
                    // Calculate amount of energy
                    Double energy = EnergyCalculator(mass);
                    // Calculate number of kiloton bombs
                    String ktbombs = numKilotonBombs(energy);

                    // Output energy and kiloton bombs in a messagebox
                    JOptionPane.showMessageDialog(null, String.format(
                            "The amount of energy released by %.1fkg is %sJ. That is equal to %s kiloton bombs.", mass,
                            doubleToScientific(energy), ktbombs));
                }

            }
        });
    }

    // Setting up the GUI
    public static void main(String[] args) {
        JFrame frame = new JFrame("App");
        frame.setContentPane(new EinsteinsEquation().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
