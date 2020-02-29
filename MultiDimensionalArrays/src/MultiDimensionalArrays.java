/*
 * Created by: Logan Cantin
 * Created on: 29-Feb-20120
 * Created for: ICS4U
 * Day #13 (Multidimensional Arrays)
 * This program calculates the average of randomly generated student data
*/

import java.util.Random;

public class MultiDimensionalArrays {

    // Average of a multidimensional array
    static double average(int[][] input) {
        double sum = 0;
        double num = 0;
        
        // Adding up the  elements and keeping count of how many there are
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[i].length; j++) {
                num++;
                sum += input[i][j];
            }
        }

        // Return average
        return sum / num;
    }

    // Bell curved grades
    static int[][] randomClassGaussian(){
        Random rand = new Random();

        // Std deviation of 15, average value of 75
        int[][] output = new int[4][6];
        
        // Generating the random grades
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 6; j++) {
                
                // Generating a random number with std deviation of 15 and avg of 75
                int randomNumber = (int) ((rand.nextGaussian() * 15.) + 75.);
                
                // Clipping: 0 to 100
                if (randomNumber > 100) randomNumber = 100;
                else if (randomNumber < 0) randomNumber = 0;
                
                // Outputting number
                output[i][j] = randomNumber;
            }
        }
        return output;
    }

    public static void main(String[] args) {
        // Generate array
        int[][] studentsArray = randomClassGaussian();

        // Take the average of the array
        double average = average(studentsArray);

        // Print the average
        System.out.printf("Class average is %.1f", average);
    }
}
