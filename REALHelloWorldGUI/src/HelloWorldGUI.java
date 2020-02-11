import javax.swing.*;

public class HelloWorldGUI {
    private JPanel panel1;

    public static void main(String[] args) {
        JFrame frame = new JFrame("App");
        frame.setContentPane(new HelloWorldGUI().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
