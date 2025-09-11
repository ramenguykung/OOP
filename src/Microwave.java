import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Microwave extends JFrame {
        JTextField jtfmonitor = new JTextField();
        JButton jbtmonitor = new JButton();
        Microwave() {
            jtfmonitor.setEditable(false);
            jtfmonitor.setHorizontalAlignment(JTextField.RIGHT);
            JPanel p1 = new JPanel();
            p1.setLayout(new GridLayout(4, 3));
            for (int i = 1; i <= 9; i++) {
                JButton jbtButton = new JButton("" + i);
                
            }
            JButton jbtZero = new JButton("0");
            JButton jbtStart = new JButton("Start");
            JButton jbtStop = new JButton("Stop");
            jbtZero.addActionListener(new Listener());
            jbtStart.addActionListener(new Listener());
            jbtStop.addActionListener(new Listener());
            p1.add(jbtZero);
            p1.add(jbtStart);
            p1.add(jbtStop);
            JPanel p2 = new JPanel(new BorderLayout());
            p2.add(new JTextField(10), BorderLayout.NORTH);
            p2.add(p1, BorderLayout.CENTER);
            add(p2, BorderLayout.EAST);
            add(new JButton("Huh"), BorderLayout.CENTER);
            add(p2);
        }
    public static void main(String[] args) {
        JFrame microwave = new Microwave();
        microwave.setTitle("Microwave Demo");
        microwave.setSize(400, 250);
        microwave.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        microwave.setVisible(true);
    }   
    class Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            for (int i = 1; i <= 9; i++) {
                if (e.getActionCommand().equals(i)) {
                    jtfmonitor.setText("" + i);
                }
            }
            if (e.getActionCommand().equals("0")) {
                jtfmonitor.setText("0");
            }
            if (e.getActionCommand().equals("Start")) {
                jtfmonitor.setText("Start...");
            }
            if (e.getActionCommand().equals("Stop")) {
                
            }
        }
    }
}
