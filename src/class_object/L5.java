package class_object;

import java.util.Scanner;

public class L5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] value = input.split(" ");
        double a = Double.parseDouble(value[0]);
        double b = Double.parseDouble(value[1]);
        double c = Double.parseDouble(value[2]);
        double d = Double.parseDouble(value[3]);
        double e = Double.parseDouble(value[4]);
        double f = Double.parseDouble(value[5]);

        LinearEquation obj = new LinearEquation(a, b, c, d, e, f);
        if (obj.isSolvable()) {
            System.out.printf("x = %.2f ", obj.getX());
            System.out.printf("y = %.2f%n", obj.getY());
        } else {
            System.out.println("Error");
        }
    }
}

class LinearEquation {
    private double a, b, c, d, e, f;

    /**
     * Constructor for LinearEquation
     * @param a the coefficient of x in the first equation
     * @param b the coefficient of y in the first equation
     * @param c the constant term in the first equation
     * @param d the coefficient of x in the second equation
     * @param e the coefficient of y in the second equation
     * @param f the constant term in the second equation
     */
    public LinearEquation(double a, double b, double c, double d, double e, double f) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
    }

    /**
     * Calculates the value of x for the system of linear equations.
     * @return the value of x if the equations are solvable.
     */
    double getX() {
        if (!isSolvable()) {
            throw new ArithmeticException("The equations are not solvable.");
        }
        return (e * d - b * f) / (a * d - b * c);
    }

    double getY() {
        if (!isSolvable()) {
            throw new ArithmeticException("The equations are not solvable.");
        }
        return (a * f - e * c) / (a * d - b * c);
    }
    /**
     * Checks if the linear equations are solvable.
     * @return true if the equations have a unique solution, false otherwise.
     */
    boolean isSolvable() {
        if ((a * d - b * c) == 0.0) {
            return false; // The equations are parallel or coincident
        } else {
            return true; // The equations have a unique solution
        }
    }
}