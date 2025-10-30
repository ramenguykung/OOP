package abstract_class;

import java.awt.*;
import javax.swing.*;

public class L3 extends JFrame {
	public L3() {
		getContentPane().setLayout(new GridLayout(1, 2, 5, 5));
		getContentPane().add(new Expo());
		getContentPane().add(new DrawSine());
		getContentPane().add(new DrawCos());
		getContentPane().add(new DrawCosand5Sin());
	}
	public static void main(String[] args) {
		L3 frame = new L3();
		frame.setSize(400, 400);
		frame.setTitle("Exercise 10.10");
		frame.setVisible(true);
	}
}

abstract class AbstractDrawFunction extends JPanel {
	private Polygon p = new Polygon();

	protected AbstractDrawFunction () {
		drawFunction();
		setBackground(Color.white);
	}
	public abstract double f(double x);
	public void drawFunction() {
		for(int x = -100; x < 100; x++) {
			p.addPoint(x+200, 200 - (int)f(x));
		}
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawLine(10, 200, 390, 200);
		g.drawLine(200, 30, 200, 290);
		g.drawLine(390, 200, 370, 190);
		g.drawLine(390, 200, 370, 210);
		g.drawLine(200, 30, 190, 50);
		g.drawLine(200, 30, 210, 50);
		g.drawString("X", 370, 170);
		g.drawString("Y", 220, 40);
		g.drawPolyline(p.xpoints, p.ypoints, p.npoints);
	}
}
class Expo extends AbstractDrawFunction {
	@Override
	public double f(double x) {
		return Math.pow(x, 2);
	}
}
class DrawSine extends AbstractDrawFunction {
	@Override
	public double f(double x) {
		return 20 * Math.sin(Math.toRadians(x));
	}
}
class DrawCos extends AbstractDrawFunction {
	@Override
	public double f(double x) {
		return 20 * Math.cos(Math.toRadians(x));
	}
}

class DrawTan extends AbstractDrawFunction {
	@Override
	public double f(double x) {
		return 20 * Math.tan(Math.toRadians(x));
	}
}
class DrawCosand5Sin extends AbstractDrawFunction {
	@Override
	public double f(double x) {
		return 20 * (Math.cos(Math.toRadians(x))) + (5 * Math.sin(Math.toRadians(x)));
	}
}