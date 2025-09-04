import javax.swing.*;
import java.awt.*;

public class Abstract_Interface_L3 extends JFrame {
    public Abstract_Interface_L3() {
        getContentPane().setLayout(new GridLayout(2, 4, 5, 5));
        getContentPane().add(new DrawPow());
        getContentPane().add(new DrawSin());
        getContentPane().add(new DrawCos());
        getContentPane().add(new DrawTan());
        getContentPane().add(new DrawCos_5Sin());
        getContentPane().add(new Draw5Cos_Sin());
        getContentPane().add(new DrawLog_X());

}
    public static void main(String[] args) {
        Abstract_Interface_L3 frame = new Abstract_Interface_L3();
        frame.setSize(1000, 1000);
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
class DrawPow extends AbstractDrawFunction {
    @Override
    public double f(double x) {
        return Math.pow(x, 2);
    }
}
class DrawSin extends AbstractDrawFunction {
    @Override
    public double f(double x) {
        return 50 * Math.sin(Math.toRadians(x));
    }
}
class DrawCos extends AbstractDrawFunction {
    @Override
    public double f(double x) {
        return 50 * Math.cos(Math.toRadians(x));
    }
}
class DrawTan extends AbstractDrawFunction {
    @Override
    public double f(double x) {
        return 100 * Math.tan(Math.toRadians(x));
    }
}
class DrawCos_5Sin extends AbstractDrawFunction {
    @Override
    public double f(double x) {
        return (10 * Math.cos(Math.toRadians(x))) + (50 * Math.sin(Math.toRadians(x)));
    }
}
class Draw5Cos_Sin extends AbstractDrawFunction {
    @Override
    public double f(double x) {
        return (100 * Math.cos(x)) + (10 * Math.sin(x));
    }
}
class DrawLog_X extends AbstractDrawFunction {
    @Override
    public double f(double x) {
        return (Math.log(x)) + (Math.pow(x, 2));
    }
}