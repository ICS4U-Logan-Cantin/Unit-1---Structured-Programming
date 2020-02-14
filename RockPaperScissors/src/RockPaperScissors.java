import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class RockPaperScissors {
    private JButton rockButton;
    private JButton paperButton;
    private JButton scissorsButton;
    private Random random = new Random();
    private enum Signs {
        ROCK, PAPER, SCISSORS
    }

    private Signs computerChoice(){
        int rand = random.nextInt(3);
        if (rand == 1) {
            return Signs.ROCK;
        }
        else if (rand == 2) {
            return Signs.SCISSORS;
        }
        else {
            return Signs.PAPER;
        }
    }

    private int userWin(Signs user, Signs computer){
        if (user == computer) {
            return 1;
        }
        else if ()
    }

    public RockPaperScissors() {
        rockButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        paperButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        scissorsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
    }
}
