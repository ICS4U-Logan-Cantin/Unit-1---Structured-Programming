import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BoardFoot {
    private JTextField widthField;
    private JTextField lengthField;
    private JButton calculateButton;
    private JLabel thicknessLabel;
    private JPanel main;

    Double VOLUME = 144.;

    public BoardFoot() {
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                // Calculate the height
                Double width, length, height;

                // Error catching
                try {
                    // Reading the decimals
                    width = Double.parseDouble(widthField.getText());
                    length = Double.parseDouble(lengthField.getText());

                    // Calculating the height
                    height = VOLUME / (width * length);

                    // Changing the label
                    thicknessLabel.setText(String.format("The thickness of your board is %.1f inches.", height));
                }
                catch (Exception e) {
                    // Alerting the user that their input is invalid
                    JOptionPane.showMessageDialog(null, "Please enter an decimal number for the measurements");
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("App");
        frame.setContentPane(new BoardFoot().main);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
