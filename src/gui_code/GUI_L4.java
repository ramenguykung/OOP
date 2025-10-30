package gui_code;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI_L4 extends JFrame {
    JTextField jtfUSD = new JTextField(10);
    JTextField jtfCAD = new JTextField(10);
    JLabel jlbUSD = new JLabel("US Dollar");
    JLabel jlbCAD = new JLabel("Canadian Dollar");
    JButton jbtConvert = new JButton("Convert");
    GUI_L4() {
        jtfCAD.setEditable(false);
        JPanel p1 = new JPanel();
        p1.setLayout(new BorderLayout()); // Parent panel
        JPanel p2 = new JPanel();
        p2.setLayout(new GridLayout(2, 1)); // Text field panel
        JPanel p3 = new JPanel();
        p3.setLayout(new GridLayout(2, 1)); // Label panel
        JPanel p4 = new JPanel();
        p4.setLayout(new BorderLayout()); // "Convert" Button panel

        // p1 sub-panel
        p1.add(p2, BorderLayout.CENTER);
        p1.add(p3, BorderLayout.WEST);
        p1.add(p4, BorderLayout.SOUTH);

        p2.add(jtfUSD);
        p2.add(jtfCAD);
        p3.add(jlbUSD);
        p3.add(jlbCAD);
        p4.add(jbtConvert, BorderLayout.EAST);

        // Event Listener
        jtfUSD.addActionListener(new Listener());
        jtfCAD.addActionListener(new Listener());
        jbtConvert.addActionListener(new Listener());
        add(p1);
    }
    public static void main(String[] args) {
        JFrame frame = new GUI_L4();
        frame.setTitle("Currency Converter");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    class Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String text = jtfUSD.getText();
            try {
                int value = Integer.parseInt(text);
                double calculation = value * 1.39;
                jtfCAD.setText(Double.toString(calculation));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Please enter a valid integer.");
            }
        }
    }
}
