/*
 * Created by: Logan Cantin
 * Created on: 06-Feb-2019
 * Created for: ICS4U
 * Day #4 (Einstein's Equation)
 * This program calculates the amount of energy contained in a specified amount of matter.
 * It also calculates the number of kiloton bombs that this is equal to.
 */

import java.util.Scanner;

public class EinsteinsEquation {

    // Defining Constants
    final static Double C = 2.998e8; // speed of light, in m/s
    final static Double J_PER_KILOTON_BOMB = 4.0e15; // Number of joules in a kiloton bomb

    // Calculates the amount of energy, in joules, released by <mass> kilograms of matter
    private static Double EnergyCalculator(Double mass){
        return mass * (Math.pow(EinsteinsEquation.C, 2.));
    }

    // Gets a mass value from the user
    private static Double getMass(){

        // Create a new scanner
        Scanner input = new Scanner(System.in);

        try {
            // Try to parse a double from the user's input
            Double mass = Double.parseDouble(input.nextLine());

            // Checking that the mass is non-negative.
            if (mass >= 0) {

                // Return mass
                return mass;
            }

            // Negative value was passed
            else {
                // Pass a -1
                return -1.;
            }
        }

        //Value passed was not a string.
        catch (Exception e){
            return -2.;
        }
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

    public static void main(String[] args) {

        while (true) {
            // Ask the user how much mass they want to calculate the energy for.
            System.out.print("What is the mass of the object in kilograms? ");

            // Read mass from the user
            Double mass = getMass();

            // Checking for a positive mass value
            if (mass >= 0) {
                Double energy = EnergyCalculator(mass);
                System.out.printf("The amount of energy released is %sJ.%n", doubleToScientific(energy));
                System.out.printf("The number of kiloton bombs this is equal to is %s.%n", numKilotonBombs(energy));
            }
            // Negative mass value error
            else if (mass == -1.) {
                System.out.println("Please enter a positive number.");
            }
            // Non-number string entered
            else if (mass == -2.) {
                System.out.println("Enter a number");
            }
        }
    }
}
