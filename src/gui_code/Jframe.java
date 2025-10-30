package gui_code;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Jframe {
    public static void main(String[] args) {
        Ex frame = new Ex();
        frame.setSize(500, 400);

    }
}
class Ex extends JFrame{
    JLabel jlbName = new JLabel("Name");
    JLabel jlbSurname = new JLabel("Surname");
    JLabel jlbAge = new JLabel("Age");
    JTextField jtfName = new JTextField(10);
    JTextField jtfSurname = new JTextField(10);
    JTextField jtfAge = new JTextField(10);
    JButton jbtnOK = new JButton("OK");
    JButton jbtnCancel = new JButton("Cancel");

    Ex() {
        setLayout(new GridLayout(4, 2, 2, 2));
        add(jlbName);
        add(jtfName);
        add(jlbSurname);
        add(jtfSurname);
        add(jlbAge);
        add(jtfAge);
        add(jbtnOK);
        add(jbtnCancel);
        Listener objSpy = new Listener();
        jbtnCancel.addActionListener(objSpy);
        jbtnOK.addActionListener(objSpy); 
    }

    class Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == jbtnCancel) {
                jtfName.setText("");
                jtfSurname.setText("");
                jtfAge.setText("");
            } else if (e.getSource() == jbtnOK) {
                if (Integer.parseInt(jtfAge.getText()) < 0) {
                    
                }
            }
        }

    }
}