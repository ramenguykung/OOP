
public class Ingeritance_L7 {

}

abstract class GeometricObject {

    private String color = "white";
    private boolean filled;

    /**
     * Default constructor
     */
    protected GeometricObject() {
    }

    /**
     * Convenience constructor
     */
    protected GeometricObject(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public abstract double findArea();

    public abstract double findPerimeter();
}

class Circle extends GeometricObject {

    private double radius;

    /**
     * Default constructor
     */
    public Circle() {
        this(1.0);
    }

    /**
     * Radius convenience constructor
     */
    public Circle(double radius) {
        this(radius, "white", false);
    }

    /**
     * Convenience constructor for all properties
     */
    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    /**
     * Return the radius
     *
     * @return radius Current radius of Circle
     */
    public double getRadius() {
        return radius;
    }

    /**
     * Set the radius of the circle
     */
    public void setRadius(double radius) {
        this.radius = radius;
    }

    /**
     * Returns the area of the current circle Implemention of abstract method in
     * GeometricObject
     *
     * @return area of the circle
     */
    public double findArea() {
        return radius * radius * Math.PI;
    }

    /**
     * Returns the perimeter of the current circle Implemention of abstract
     * method in GeometricObject
     *
     * @return perimeter of the circle
     */
    public double findPerimeter() {
        return 2 * radius * Math.PI;
    }

    /**
     * Provide a string representation of the object
     */
    public String toString() {
        return "Circle: radius = " + radius;
    }
}

abstract class Rectangle extends GeometricObject {

    private double width, height;

    public Rectangle() {
        this(1.0, 1.0);
    }

    public Rectangle(double width, double height) {
        this(width, height, "white", false);
    }

    public Rectangle(double width, double height, String color, boolean filled) {
        super(color, filled);
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double findArea() {
        return width * height;
    }

    @Override
    public double findPerimeter() {
        return 2 * (width + height);
    }
}

class MyRectangle2D extends Rectangle {

    private double x, y, width, height;

    public MyRectangle2D() {
        this.height = 1.0;
        this.width = 1.0;
        this.x = 0.0;
        this.y = 0.0;
    }

    public MyRectangle2D(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    @Override
    public double findArea() {
        return width * height;
    }
    
    @Override
    public double findPerimeter() {
        return super.findPerimeter();
    }
    
    public boolean contains(MyRectangle2D r) {
        return (Math.abs(r.x - this.x) <= Math.abs(this.width - r.width) / 2) && (Math.abs(r.y - this.y) <= Math.abs(this.height - r.height) / 2);
    }

    public boolean overlaps(MyRectangle2D r) {
        return (Math.abs(r.x - this.x) <= (this.width + r.width) / 2) && (Math.abs(r.y - this.y) <= (this.height + r.height) / 2);
    }
} 