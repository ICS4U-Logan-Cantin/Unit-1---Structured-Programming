/*
 * Created by: Logan Cantin
 * Created on: 29-Feb-20120
 * Created for: ICS4U
 * Day #14 (Planet Enumeration)
 * This program tells you which planet number you are going to.
*/

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlanetEnumeration {
    private JComboBox cmbPlanets;
    private JPanel panel1;
    private JButton goButton;

    //Planets enum
    public enum planets {

        //Planets
        MERCURY (1, "Mercury"),
        VENUS (2, "Venus"),
        EARTH (3, "Earth"),
        MARS (4, "Mars"),
        JUPITER (5, "Jupiter"),
        SATURN (6, "Saturn"),
        URANUS (7, "Uranus"),
        NEPTUNE (8, "Neptune");

        // Variables
        private int number;
        private String name;

        // Constructor sets variables
        planets(int number, String name) {
            this.number = number;
            this.name = name;
        }

        // Returns planet number
        int getNumber() {
            return number;
        }

        // Returns number
        String getName() {
            return name;
        }
    }

    // Constructor
    public PlanetEnumeration() {

        //Populating the combobox
        for (planets p : planets.values()) {
            cmbPlanets.addItem(p);
        }

        goButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                // Getting the planet and outputting it to the popup
                planets planet = (planets) cmbPlanets.getSelectedItem();
                JOptionPane.showMessageDialog(null, String.format("You want to go to %s, which is planet #%d.", planet.getName(), planet.getNumber()));
            }
        });
    }

    // Form Setup
    public static void main(String[] args) {
        JFrame panel = new JFrame("App");
        panel.setContentPane(new PlanetEnumeration().panel1);
        panel.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        panel.pack();
        panel.setVisible(true);
    }
}
