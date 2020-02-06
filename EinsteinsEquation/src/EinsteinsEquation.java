import java.beans.ExceptionListener;
import java.util.Scanner;

public class EinsteinsEquation {

    final static Double C = 2.998e8;
    final static Double J_PER_KILOTON_BOMB = 4.0e12;

    private static Double EnergyCalculator(Double mass){
        return mass * (Math.pow(EinsteinsEquation.C, 2.));
    }

    private static Double inputChecker(String input){
        try {
            Double mass = Double.parseDouble(input);
            if (mass >= 0) {
                return mass;
            }
            else {
                return -1.;
            }
        }
        catch (Exception e){
            return -2.;
        }
    }

    private static String doubleToScientific(Double d){
        int exp = (int) Math.floor(Math.log10(d));
        double coeff = d / Math.pow(10., exp);
        return String.format("%.3fe%d", coeff, exp);
    }

    private static Long numKilotonBombs(Double joules){
        return (long) Math.round(joules / J_PER_KILOTON_BOMB);
    }

    public static void main(String[] args) {
        System.out.print("What is the mass of the object in kilograms? ");

        Scanner input = new Scanner(System.in);
        Double mass = inputChecker(input.nextLine());

        if (mass >= 0){
            Double energy = EnergyCalculator(mass);
            System.out.printf("The amount of energy released is %sJ.", doubleToScientific(energy));
            System.out.printf("The number of kiloton bombs this is equal to is %d.", numKilotonBombs(energy));
        }
    }
}
