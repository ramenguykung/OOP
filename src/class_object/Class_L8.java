package class_object;

public class Class_L8 {
    public static void main(String[] args) {
        RegularPolygon p1 = new RegularPolygon();
        RegularPolygon p2 = new RegularPolygon(6, 4);
        RegularPolygon p3 = new RegularPolygon(10, 4, 5.6, 7.8);
        
        System.out.printf("Polygon 1: Sides = %d, Length = %.2f, Perimeter = %.2f, Area = %.2f%n",
        p1.getNumberOfSides(), p1.getSideLength(), p1.getPerimeter(), p1.getArea());

        System.out.printf("Polygon 2: Sides = %d, Length = %.2f, Perimeter = %.2f, Area = %.2f%n",
        p2.getNumberOfSides(), p2.getSideLength(), p2.getPerimeter(), p2.getArea());

        System.out.printf("Polygon 3: Sides = %d, Length = %.2f, Perimeter = %.2f, Area = %.2f%n",
        p3.getNumberOfSides(), p3.getSideLength(), p3.getPerimeter(), p3.getArea());
    }
}

class RegularPolygon {
    private int numberOfSides;
    private double sideLength, x, y;

    public RegularPolygon() {
        this.numberOfSides = 0;
        this.sideLength = 0.0;
        this.x = 0.0;
        this.y = 0.0;
    }

    /**
     * Constructor for Polygon with specified number of sides and side length.
     * @param numberOfSides
     * @param sideLength
     */
    public RegularPolygon(int numberOfSides, double sideLength) {
        this.numberOfSides = numberOfSides;
        this.sideLength = sideLength;
        this.x = 0.0;
        this.y = 0.0;
    }

    /**
     * Constructor for Polygon with specified number of sides, side length, and position.
     * @param numberOfSides
     * @param sideLength
     * @param x
     * @param y
     */
    public RegularPolygon(int numberOfSides, double sideLength, double x, double y) {
        this.numberOfSides = numberOfSides;
        this.sideLength = sideLength;
        this.x = x;
        this.y = y;
    }

    public double getPerimeter() {
        return this.numberOfSides * this.sideLength;
    }

    /**
     * Calculates the area of the polygon.
     * @return the area of the polygon, or 0 if the number of sides is less than 3
     */
    public double getArea() {
        if (this.numberOfSides < 3) {
            return 0;
        }
        return (this.numberOfSides * Math.pow(this.sideLength, 2)) / (4 * Math.tan(Math.PI / this.numberOfSides));
    }

    public int getNumberOfSides() {
        return this.numberOfSides;
    }

    public void setNumberOfSides(int numberOfSides) {
        this.numberOfSides = numberOfSides;
    }

    public double getSideLength() {
        return this.sideLength;
    }

    public void setSideLength(double sideLength) {
        this.sideLength = sideLength;
    }

    public double getX() {
        return this.x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return this.y;
    }

    public void setY(double y) {
        this.y = y;
    }
}