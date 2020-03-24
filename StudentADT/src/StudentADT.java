import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentADT {
    private JTextField txtFirst;
    private JSpinner spnGrade;
    private JTextField txtLast;
    private JTextField txtSecond;
    private JCheckBox chkIdentified;
    private JButton enterButton;
    private JPanel main;

    private void alert(Student student) {
        JOptionPane.showMessageDialog(null, student.StudentInfo());
    }

    public StudentADT() {
        enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                // Getting student information
                Student student = new Student(txtFirst.getText(), txtSecond.getText(), txtLast.getText(), (int)spnGrade.getValue(), chkIdentified.isSelected());

                // Alerting the user about the new student.
                alert(student);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("app");
        frame.setContentPane(new StudentADT().main);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
