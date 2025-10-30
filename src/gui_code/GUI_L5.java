package gui_code;

import java.awt.*;
import javax.swing.*;

public class GUI_L5 extends JFrame {

    GUI_L5() {
        JPanel p1 = new JPanel();
        p1.setLayout(new BorderLayout());
        add(new JTextField(), BorderLayout.NORTH);
        
        JPanel p2 = new JPanel();
        add(p2, BorderLayout.SOUTH);

        JPanel numPanel = new JPanel();
        numPanel.setLayout(new GridLayout(4, 3));
        for (int i = 1; i <= 9; i++) {
            JButton jbtButton = new JButton("" + i); 
        }
        p2.add(numPanel);
    }
    public static void main(String[] args) {
        JFrame calculator = new GUI_L5();
        calculator.setTitle("Simple Calculator");
        calculator.setSize(400, 600);
        calculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        calculator.setVisible(true);
    }
}
