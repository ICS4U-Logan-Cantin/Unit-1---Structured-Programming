/*
 * Created by: Logan Cantin
 * Created on: 29-Feb-20120
 * Created for: ICS4U
 * Day #8 (Dice Game)
 * This program is a guessing game.
*/

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class DiceGame {
    private JPanel panel1;
    private JButton btnGuess;
    private JLabel lblwrongguesses;
    private JComboBox comboBox1;

    // Declaring variables
    private int randomInt;
    private int numWrong = 0;

    // Get a new random number
    private void RandomizeNumber(){
        randomInt = new Random().nextInt(6);
    }

    // The user's guess was wrong. Update the counter and alert user.
    private void Wrong() {
        numWrong++;
        lblwrongguesses.setText(String.format("Number of wrong guesses: %d", numWrong));
        JOptionPane.showMessageDialog(null, "Failure.");
    }

    // The user's guess was right. Reset the counter, generate a new random number, and alert user.
    private void Right() {
        RandomizeNumber();
        numWrong = 0;
        lblwrongguesses.setText(String.format("Number of wrong guesses: %d", numWrong));
        JOptionPane.showMessageDialog(null, "Success!");
    }

    // Constructor
    public DiceGame(){
        //Generate new random number
        RandomizeNumber();

        // When the button gets pressed, evaluate if the guess is correct
        btnGuess.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (comboBox1.getSelectedIndex() == randomInt){
                    Right();
                }
                else {
                    Wrong();
                }
            }
        });
    }


    // Initialize application
    public static void main(String[] args) {
        JFrame frame = new JFrame("DiceGame");
        frame.setContentPane(new DiceGame().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
