import java.util.Random;

public class MultiDimensionalArrays {

    static double average(int[][] input) {
        double sum = 0;
        double num = 0;
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[i].length; j++) {
                num++;
                sum += input[i][j];
            }
        }

        return sum / num;
    }

    // Bell curved grades
    static int[][] randomClassGaussian(){
        Random rand = new Random();

        // Std deviation of 15, average value of 75
        int[][] output = new int[4][6];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 6; j++) {
                int randomNumber = (int) ((rand.nextGaussian() * 15.) + 75.);
                if (randomNumber > 100) randomNumber = 100;
                else if (randomNumber < 0) randomNumber = 0;
                output[i][j] = randomNumber;
            }
        }
        return output;
    }

    // Even distribution
    static int[][] randomClass(){
        Random rand = new Random();
        int[][] output = new int[4][6];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 6; j++) {
                output[i][j] = rand.nextInt(101);
            }
        }
        return output;
    }

    public static void main(String[] args) {
        int[][] studentsArray = randomClassGaussian();

        double average = average(studentsArray);

        System.out.printf("Class average is %.1f", average);
    }
}
