import javax.swing.*;
import java.awt.*;

public class Abstract_Interface_L1 extends JFrame {
    public Abstract_Interface_L1() {
        getContentPane().setLayout(new GridLayout(4, 2, 5, 5));
}
    public static void main(String[] args) {
        Abstract_Interface_L1 frame = new Abstract_Interface_L1();
        frame.setSize(400, 400);
        frame.setTitle("Exercise 10.10");
        frame.setVisible(true);
    }
}

abstract class AbstractDrawFunction extends JPanel {
    /** Polygon to hold the points */
    private Polygon p = new Polygon();

    /** Default constructor */
    protected AbstractDrawFunction() {
        drawFunction();
        setBackground(Color.white);
    }

    /** Draw the function */
    public abstract double f(double x);

    /** Obtain points for x coordinates 100, 101, ..., 300 */
    public void drawFunction() {
        for (int x = -100; x <= 100; x++) {
            p.addPoint(x + 200, 200 - (int) f(x));
        }
    }

    /** Paint the function diagram */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw x axis
        g.drawLine(10, 200, 390, 200);
        // Draw y axis
        g.drawLine(200, 30, 200, 390);
        // Draw arrows on x axis
        g.drawLine(390, 200, 370, 190);
        g.drawLine(390, 200, 370, 210);
        // Draw arrows on y axis
        g.drawLine(200, 30, 190, 50);
        g.drawLine(200, 30, 210, 50);
        // Draw x, y
        g.drawString("X", 370, 170);
        g.drawString("Y", 220, 40);
        // Draw a polygon line by connecting the points in the polygon
        g.drawPolyline(p.xpoints, p.ypoints, p.npoints);
    }
}
