import java.awt.Graphics;
import java.awt.event.*;

import javax.swing.*;

public class Graphic_Demo1 extends JFrame{
    int angle = 0;
    public Graphic_Demo1() {
        setTitle("DrawArcs");
        add(new ArcPanel());
    }
    public static void main(String[] args) {
        Graphic_Demo1 frame = new Graphic_Demo1();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(250, 300);
        frame.setVisible(true);
    }
}

class ArcPanel extends JPanel {
    int angle = 0;
    ArcPanel() {
        t.start();
    }
    Timer t = new Timer(1, new Listerner());
    class Listerner implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            angle += 1;
            repaint();
        }
    }
    @Override 
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int xCenter = getWidth() / 2;
        int yCenter = getHeight() / 2;
        int radius = (int) (Math.min(getWidth(), getHeight()) * 0.4);
        
        int x = xCenter - radius;
        int y = yCenter - radius;

        g.fillArc(x, y, 2 * radius, 2 * radius, angle, 30);
        g.fillArc(x, y, 2 * radius, 2 * radius, angle + 90, 30);
        g.fillArc(x, y, 2 * radius, 2 * radius, angle + 180, 30);
        g.fillArc(x, y, 2 * radius, 2 * radius, angle + 270, 30);
    }
}