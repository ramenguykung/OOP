import javax.swing.*;
public class Jframe {
    public static void main(String[] args) {
        Jframe frame = new Ex();

    }
}
class Ex extends JFrame{
    JLabel jlbNamme = new JLabel("Name");
    JLabel jlbSurname = new JLabel("Surname");
    JLabel jlbAge = new JLabel("Age");
    JTextField jtfName = new JTextField(10);
    JTextField jtfSurname = new JTextField(10);
    JTextField jtfAge = new JTextField(10);
    JButton jbtnOK = new JButton("OK");
    JButton jbtnCancel = new JButton("Cancel");

    Ex() {
        
    }
}