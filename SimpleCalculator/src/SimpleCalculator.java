import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleCalculator {
    private JPanel mainForm;
    private JTextField firstNumber;
    private JTextField secondField;
    private JButton btnPlus;
    private JButton btnMultiply;
    private JButton btnMinus;
    private JButton btnDivide;
    private JLabel lblAnswer;

    // Function to get the first and second numbers from the textFields
    private String firstNumber(){
        return firstNumber.getText();
    }
    private String secondNumber() {
        return secondField.getText();
    }

    public SimpleCalculator() {
        // Plus pushed
        btnPlus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                // Add the numbers and add it to the label
                double answer = Double.parseDouble(firstNumber()) + Double.parseDouble(secondNumber());
                lblAnswer.setText("Answer: " + String.valueOf(answer));
            }
        });

        // Subtraction pushed
        btnMinus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                // Subtract the numbers and add it to the label
                double answer = Double.parseDouble(firstNumber()) - Double.parseDouble(secondNumber());
                lblAnswer.setText("Answer: " + String.valueOf(answer));
            }
        });

        // Multiply pushed
        btnMultiply.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                // Multiply the numbers and add it to the label
                double answer = Double.parseDouble(firstNumber()) * Double.parseDouble(secondNumber());
                lblAnswer.setText("Answer: " + String.valueOf(answer));
            }
        });


        btnDivide.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                // Divide the numbers and add it to the label
                double answer = Double.parseDouble(firstNumber()) / Double.parseDouble(secondNumber());
                lblAnswer.setText("Answer: " + String.valueOf(answer));
            }
        });
    }

    // Setup the GUI
    public static void main(String[] args) {
        JFrame frame = new JFrame("App");
        frame.setContentPane(new SimpleCalculator().mainForm);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
