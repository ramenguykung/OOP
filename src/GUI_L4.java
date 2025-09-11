import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.*;

public class GUI_L4 extends JFrame {
    JTextField jtfmonitor = new JTextField();
    JButton jbtmonitir = new JButton();
    GUI_L4() {
        JPanel p1 = new JPanel();
        p1.setLayout(new BorderLayout()); // Parent panel
        JPanel p2 = new JPanel();
        p2.setLayout(new FlowLayout()); // Text field panel
        JPanel p3 = new JPanel();
        p3.setLayout(new FlowLayout()); // Label panel
        JPanel p4 = new JPanel();
        p4.setLayout(new BorderLayout()); // "Convert" Button panel
        p1.add(p2, BorderLayout.CENTER);
        p1.add(p3, BorderLayout.WEST);
        p1.add(p4, BorderLayout.SOUTH);

    }
    public static void main(String[] args) {
        JFrame frame = new GUI_L4();
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
