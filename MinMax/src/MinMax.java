import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class MinMax {
    private JButton btnGenerate;
    private JLabel maxlabel;
    private JLabel minlabel;
    private JPanel main;
    private JTextArea textArea1;
    private ListModel<Integer> model;

    private Random rand = new Random();

    public MinMax() {

        btnGenerate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                // Clearing text
                textArea1.setText("");

                // Declaring min and max variables
                int low = 101, high = 0;

                // Generating 10 numbers and adding them to the list
                for (int counter = 0; counter < 10; counter++) {
                    int random_number = rand.nextInt(100) + 1;
                    if (random_number < low)
                        low = random_number;
                    if (random_number > high)
                        high = random_number;
                    textArea1.append((random_number) + "\n");
                }

                // Alerting the user about the smallest and largest numbers
                maxlabel.setText(String.format("The largest value is %d.", high));
                minlabel.setText(String.format("The smallest value is %d.", low));
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("App");
        frame.setContentPane(new MinMax().main);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
