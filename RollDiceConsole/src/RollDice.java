/*
 * Created by: Logan Cantin
 * Created on: 29-Feb-20120
 * Created for: ICS4U
 * Day #9 (Roll Dice)
 * This program generates a random number between 1 and n.
*/

import java.util.Scanner;
import java.util.Random;

public class RollDice {

    public static void RollDice() {
        // Prompting the user
        System.out.print("What is the maximum integer you would like to generate: ");

        // Getting input from the user
        Scanner input = new Scanner(System.in);
        String inputString = input.nextLine();

        try {
            // Getting the int from the input
            int maxInt = Integer.parseInt(inputString);

            // Making sure that the inputted number is positive
            if (maxInt < 1) throw new Exception();

            // Generating a number from 1 to maxInt inclusive
            int random = new Random().nextInt(maxInt) + 1;

            // Printing the answer
            System.out.printf("The random number is: %d", random);
        }

        //Erroneous input
        catch (Exception e){

            // Alert user and restart.
            System.out.println("Incorrect input, you must input a positive integer.");
            RollDice();
        }
    }

    public static void main(String[] args) {
        RollDice();
    }
}
