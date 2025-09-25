import java.awt.Graphics;
import javax.swing.*;

public class Graphic_Demo1 extends JFrame{
    public static void main(String[] args) {
    // TODO Continue from lecture sildes
    }
}

class DrawArc extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int xCenter = getWidth() / 2;
        int yCenter = getHeight() / 2;
        int radius = (int) (Math.min(getWidth(), getHeight() * 2));
        
        int x = xCenter - radius;
        int y = yCenter - radius;

        g.fillArc(x, y, 2 * radius, 2 * radius, 0, 30);
        g.fillArc(x, y, 2 * radius, 2 * radius, 90, 30);
        g.fillArc(x, y, 2 * radius, 2 * radius, 180, 30);
        g.fillArc(x, y, 2 * radius, 2 * radius, 270, 30);
    }
}