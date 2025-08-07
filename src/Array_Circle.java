import java.util.Scanner;

public class Array_Circle {
    double radius;
    double area;

    public Array_Circle() {
    }

    public Array_Circle(double radius) {
        this.radius = radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    void calArea() {
        this.area = radius * radius * Math.PI;
    }
    public double getArea() {
        calArea();
        return this.area;
    }
    @Override
    public String toString() {
        return " radius: " + radius + ", area: " + area;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input circle instance(s): ");
        int n = sc.nextInt();
        Array_Circle[] arrCir = new Array_Circle[n];

        for (int i = 0; i < arrCir.length; i++) {
            System.out.print("Input radius: ");
            double radius = sc.nextDouble();
            arrCir[i] = new Array_Circle(radius);
        }

        for (int i = 0; i < arrCir.length; i++) {
            System.out.println("Circle " + (i + 1) + ": " + arrCir[i]);
        }
    }
}
