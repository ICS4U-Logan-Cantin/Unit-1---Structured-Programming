/*
 * Created by: Logan Cantin
 * Created on: 04-Feb-2019
 * Created for: ICS4U
 * Day #3 (Logging Company)
 * This program calculates the number of logs that can fit in a logging truck.
 */

import java.util.Scanner;

public class LoggingCompany {

    // Input function to get the size of the logs.
    public static double readInput(){

        // Initialize a new scanner
        Scanner input = new Scanner(System.in);

        // Read a line of input from the Scanner
        String data = input.nextLine();

        // Try catch statement to avoid crashing if a non-double is entered
        try {

            // Parse a double from the input
            double logSize = Double.parseDouble(data);

            // Check that the logSize is one of the acceptable sizes and return it
            if (logSize == 0.25 | logSize == 0.5 | logSize == 1){
                return logSize;
            }

            // logSize is not one of the acceptable sizes, alert the user and attempt input again
            else {
                System.out.println("Incorrect input, please input 0.25, 0.5 or 1.");
                return readInput();
            }
        }

        // Input was not a double. Alert the user and try again.
        catch (Exception e){
            System.out.println("Invalid input: please enter 0.25, 0.5, or 1.");
            return readInput();
        }
    }

    public static void main(String[] args) {

        final double MAX_WEIGHT = 1100; // Max weight the truck can carry, in kilograms
        final double WEIGHT_PER_METER = 20; // Weight of maple wood per meter, in kilograms

        final String banner =
                " _                       _       _            _ _   _       _                             \r\n" +
                "| |                     (_)     ( )          (_) | | |     | |                            \r\n" +
                "| |     ___   __ _  __ _ _ _ __ |/  __      ___| |_| |__   | |     ___   __ _  __ _ _ __  \r\n" +
                "| |    / _ \\ / _` |/ _` | | '_ \\    \\ \\ /\\ / / | __| '_ \\  | |    / _ \\ / _` |/ _` | '_ \\ \r\n" +
                "| |___| (_) | (_| | (_| | | | | |    \\ V  V /| | |_| | | | | |___| (_) | (_| | (_| | | | |\r\n" +
                "\\_____/\\___/ \\__, |\\__, |_|_| |_|     \\_/\\_/ |_|\\__|_| |_| \\_____/\\___/ \\__, |\\__,_|_| |_|\r\n" +
                "              __/ | __/ |                                                __/ |            \r\n" +
                "             |___/ |___/                                                |___/             ";



        System.out.println(banner);

        // Prompt the user to enter their logSize.
        System.out.print("What is the size of Log, in meters, that you have? (0.25 , 0.5, 1): ");
        double logSize = LoggingCompany.readInput();

        // Calculate the number of logs that can be placed on the truck
        double weight_per_log = WEIGHT_PER_METER * logSize;
        double number_of_logs = MAX_WEIGHT / weight_per_log;

        // Tell the user how many logs they can put on their truck.
        System.out.printf("You can fit %.0f logs on your truck!", number_of_logs);

    }

}
