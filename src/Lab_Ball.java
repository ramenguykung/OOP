import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;

public class Lab_Ball extends JFrame {
    public static void main(String args[]) {
        Lab_Ball a = new Lab_Ball();
        a.setSize(600, 500);
        a.setVisible(true);
    }

    private BalloonPanel paintPanel = new BalloonPanel();

    public Lab_Ball() {
        setLayout(new BorderLayout());
        add(paintPanel);
        setSize(500, 500);
    }

    class BalloonPanel extends JPanel {
        final static int BALLOON_RADIUS = 10;
        final static int BALL_RADIUS = 5;
        final static int GUN_LENGTH = 25;
        final static int PANEL_WIDTH = 200;
        final static int PANEL_HEIGHT = 100;

        private int x_Balloon = (int) (Math.random() * PANEL_WIDTH);
        private int y_Balloon = (int) (Math.random() * PANEL_HEIGHT);

        private int angle = 90;

        private boolean hit1 = false;
        private boolean hit2 = false;
        private int x_Balloon2 = (int) (Math.random() * PANEL_WIDTH);
        private int y_Balloon2 = (int) (Math.random() * PANEL_HEIGHT);

        private LinkedList<SmallBall> list = new LinkedList<SmallBall>();

        class SmallBall {
            int length;
            int angle;

            SmallBall(int length, int angle) {
                this.length = length;
                this.angle = angle;
            }
        }

        private Timer timer = new Timer(10, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                repaint();
            }
        });

        public BalloonPanel() {
            setFocusable(true);

            this.addKeyListener(new KeyAdapter() {
                public void keyPressed(KeyEvent e) {
                    if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                        if (angle < 180)
                            angle += 3;
                    } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                        if (angle > 0)
                            angle -= 3;
                    } else if (e.getKeyCode() == KeyEvent.VK_UP) {
                        // Launch a small ball
                        list.add(new SmallBall(GUN_LENGTH, angle));
                    }

                    repaint();
                }
            });
            timer.start();
        }

        /** Paint message */
        public void paint(Graphics g) {
            super.paintComponent(g);

            // Display the gun
            int x = (int) (GUN_LENGTH * Math.cos(Math.toRadians(angle)) +
                    getWidth() / 2);
            int y = (int) (getHeight() -
                    GUN_LENGTH * Math.sin(Math.toRadians(angle)));
            g.drawLine(getWidth() / 2, getHeight(), x, y);
            g.drawLine(getWidth() / 2 - 1, getHeight(), x - 1, y);
            g.drawLine(getWidth() / 2 - 2, getHeight(), x - 2, y);
            g.drawLine(getWidth() / 2 + 1, getHeight(), x + 1, y);
            g.drawLine(getWidth() / 2 + 2, getHeight(), x + 2, y);

            if (hit1) {
                // Display three small pieces
                g.drawOval(x_Balloon - BALLOON_RADIUS / 2 - 5,
                        y_Balloon - BALLOON_RADIUS / 2, BALLOON_RADIUS,
                        BALLOON_RADIUS);
                g.drawOval(x_Balloon + 2 * BALLOON_RADIUS + 5 - BALLOON_RADIUS / 2,
                        y_Balloon - BALLOON_RADIUS / 2, BALLOON_RADIUS,
                        BALLOON_RADIUS);
                g.drawOval(x_Balloon - BALLOON_RADIUS / 2,
                        y_Balloon + 2 * BALLOON_RADIUS + 5 - BALLOON_RADIUS / 2, BALLOON_RADIUS,
                        BALLOON_RADIUS);
                g.drawOval(x_Balloon - BALLOON_RADIUS / 2,
                        y_Balloon - 2 * BALLOON_RADIUS - 5 - BALLOON_RADIUS / 2, BALLOON_RADIUS,
                        BALLOON_RADIUS);

                hit1 = false;

                // New random location
                x_Balloon = (int) (Math.random() * PANEL_WIDTH);
                y_Balloon = (int) (Math.random() * PANEL_HEIGHT);

                return;
            }

            if (hit2) {
                // Display three small pieces
                g.drawOval(x_Balloon2 - BALLOON_RADIUS / 2 - 5,
                        y_Balloon2 - BALLOON_RADIUS / 2, BALLOON_RADIUS,
                        BALLOON_RADIUS);
                g.drawOval(x_Balloon2 + 2 * BALLOON_RADIUS + 5 - BALLOON_RADIUS / 2,
                        y_Balloon2 - BALLOON_RADIUS / 2, BALLOON_RADIUS,
                        BALLOON_RADIUS);
                g.drawOval(x_Balloon2 - BALLOON_RADIUS / 2,
                        y_Balloon + 2 * BALLOON_RADIUS + 5 - BALLOON_RADIUS / 2, BALLOON_RADIUS,
                        BALLOON_RADIUS);
                g.drawOval(x_Balloon2 - BALLOON_RADIUS / 2,
                        y_Balloon2 - 2 * BALLOON_RADIUS - 5 - BALLOON_RADIUS / 2, BALLOON_RADIUS,
                        BALLOON_RADIUS);

                hit2 = false;

                // New random location
                x_Balloon2 = (int) (Math.random() * PANEL_WIDTH);
                y_Balloon2 = (int) (Math.random() * PANEL_HEIGHT);

                return;
            }

            g.drawOval(x_Balloon - BALLOON_RADIUS,
                    y_Balloon - BALLOON_RADIUS, 2 * BALLOON_RADIUS,
                    2 * BALLOON_RADIUS);// love ajansatid;

            g.drawOval(x_Balloon2 - BALLOON_RADIUS,
                    y_Balloon2 - BALLOON_RADIUS, 2 * BALLOON_RADIUS,
                    2 * BALLOON_RADIUS);

            // Draw small hitting balls
            for (int i = 0; i < list.size(); i++) {
                SmallBall ball = list.get(i);// eiei
                ball.length += 5;// yeye

                x = (int) (ball.length * Math.cos(Math.toRadians(ball.angle)) +
                        getWidth() / 2);
                y = (int) (getHeight() -
                        ball.length * Math.sin(Math.toRadians(ball.angle)));

                g.fillOval(x - BALL_RADIUS, y - BALL_RADIUS, 2 * BALL_RADIUS,
                        2 * BALL_RADIUS);

                if (overlaps(x, y, BALL_RADIUS,
                        x_Balloon, y_Balloon, BALLOON_RADIUS)) {
                    list.remove(i);
                    hit1 = true;
                    i--;
                } else if (overlaps(x, y, BALL_RADIUS,
                        x_Balloon2, y_Balloon2, BALLOON_RADIUS)) {
                    list.remove(i);
                    hit2 = true;
                    i--;
                }

                if (x > getWidth() || x < 0 || y < 0) {
                    list.remove(i);
                    i--;
                }
            }
        }
    }

    public static boolean overlaps(double x1, double y1, double radius1,
            double x2, double y2, double radius2) {
        return Math.sqrt((x1 - x2) * (x1 - x2)
                + (y1 - y2) * (y1 - y2)) <= radius1 + radius2;
    }
}
