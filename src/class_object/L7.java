package class_object;

import java.util.Scanner;

public class L7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter r1's center x-, y-coordinate, width, and height: ");
        String input = sc.nextLine();
        String[] r1 = input.split(" ");

        System.out.print("Enter r2's center x-, y-coordinate, width, and height: ");
        String input2 = sc.nextLine();
        String[] r2 = input2.split(" ");

        rectangle rect1 = new rectangle(Double.parseDouble(r1[0]), Double.parseDouble(r1[1]), Double.parseDouble(r1[2]), Double.parseDouble(r1[3]));
        rectangle rect2 = new rectangle(Double.parseDouble(r2[0]), Double.parseDouble(r2[1]), Double.parseDouble(r2[2]), Double.parseDouble(r2[3]));

        if (rect1.contains(rect2)) {
            System.out.println("r2 is inside r1");
        } else {
            System.out.println("r2 is not inside r1");
        }
    }
}

class rectangle {
    private double x, y;
    private double width, height;

    /**
     * Constructor to create a rectangle with specified position and size.
     * 
     * @param x      the x-coordinate of the rectangle's position
     * @param y      the y-coordinate of the rectangle's position
     * @param width  the width of the rectangle
     * @param height the height of the rectangle
     */
    public rectangle(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    double getLeft() {
        return x - width / 2;
    }

    double getRight() {
        return x + width / 2;
    }   

    double getTop() {
        return y + height / 2;
    }

    double getBottom() {
        return y - height / 2;
    }   

    public boolean contains(rectangle other) {
        return (other.getLeft() >= this.getLeft() &&
                other.getRight() <= this.getRight() &&
                other.getTop() <= this.getTop() &&
                other.getBottom() >= this.getBottom());
    }
}