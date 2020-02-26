import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class RockPaperScissors {
    private JButton rockButton;
    private JButton paperButton;
    private JButton scissorsButton;
    private JPanel mainpanel;
    private Random random = new Random();

    // ROCK 1, PAPER 2, SCISSORS 3

    // Generates a random choice
    private int computerChoice(){
        int rand = random.nextInt(3) + 1;
        return rand;
    }

    // -1 is loss, 0 is tie, 1 is win
    private int outcome(int user, int computer){
        // Tie
        if (user == computer) {
            return 0;
        }
        // User loses
        else if (computer == 1 && user == 3) {
            return -1;
        }
        else if (computer == 2 && user == 1) {
            return -1;
        }
        else if (computer == 3 && user == 2) {
            return -1;
        }
        // User wins
        else {
            return 1;
        }
    }

    private void displayResults(int user, int computer) {
        // calculate outcome
        int outcome = outcome(user, computer);

        // Determine message
        String message;
        if (outcome == -1){
            message = "You lose!";
        }
        else if (outcome == 0) {
            message = "Tie!";
        }
        else {
            message = "You win!";
        }

        // Printing the message
        JOptionPane.showMessageDialog(null, message);
    }

    public RockPaperScissors() {
        rockButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                // User chooses rock
                int userChoice = 1;
                displayResults(userChoice, computerChoice());
            }
        });
        paperButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                // User chooses paper
                int userChoice = 2;
                displayResults(userChoice, computerChoice());
            }
        });
        scissorsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                // User chooses scissors
                int userChoice = 3;
                displayResults(userChoice, computerChoice());
            }
        });
    }

    // Intialize form
    public static void main(String[] args) {
        JFrame panel = new JFrame("App");
        panel.setContentPane(new RockPaperScissors().mainpanel);
        panel.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        panel.pack();
        panel.setVisible(true);
    }
}
