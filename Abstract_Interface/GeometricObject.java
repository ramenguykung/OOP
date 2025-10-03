public abstract class GeometricObject {

    private String color = "white";
    private boolean filled;

    protected GeometricObject() {
    }

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

    public abstract double getArea();

    public abstract double getPerimeter();
}

class Circle extends GeometricObject implements Comparable<Circle> {

    private double radius;

    public Circle() {
        this(1.0);
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Circle circle = (Circle) obj;
        return Double.compare(circle.radius, radius) == 0;
    }

    @Override
    public int compareTo(Circle other) {
        return Double.compare(this.radius, other.radius);
    }

    @Override
    public String toString() {
        return "Circle[radius=" + radius + ", color=" + getColor() + ", filled=" + isFilled() + "]";
    }
}

class Rectangle extends GeometricObject implements Comparable<Rectangle> {

    private double width;
    private double height;

    public Rectangle() {
        this(1.0, 1.0);
    }

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
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
    public double getArea() {
        return width * height;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + height);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Rectangle rectangle = (Rectangle) obj;
        return Double.compare(rectangle.width, width) == 0
                && Double.compare(rectangle.height, height) == 0;
    }

    @Override
    public int compareTo(Rectangle other) {
        double thisArea = this.getArea();
        double otherArea = other.getArea();
        return Double.compare(thisArea, otherArea);
    }

    @Override
    public String toString() {
        return "Rectangle[width=" + width + ", height=" + height
                + ", color=" + getColor() + ", filled=" + isFilled() + "]";
    }
}

class Octagon extends GeometricObject implements Comparable<Octagon>, Cloneable {

    private double side;

    public Octagon() {
        this(1.0);
    }

    public Octagon(double side) {
        this.side = side;
    }

    public Octagon(double side, String color, boolean filled) {
        super(color, filled);
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    @Override
    public double getArea() {
        // Formula: area = (2 + 4/sqrt(2)) * side * side
        return (2 + 4 / Math.sqrt(2)) * side * side;
    }

    @Override
    public double getPerimeter() {
        return 8 * side;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Octagon octagon = (Octagon) obj;
        return Double.compare(octagon.side, side) == 0;
    }

    @Override
    public int compareTo(Octagon other) {
        return Double.compare(this.side, other.side);
    }

    @Override
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    @Override
    public String toString() {
        return "Octagon[side=" + side + ", color=" + getColor()
                + ", filled=" + isFilled() + ", area=" + String.format("%.2f", getArea()) + "]";
    }
}

class ComparableCircle extends Circle {

    public ComparableCircle() {
        super();
    }

    public ComparableCircle(double radius) {
        super(radius);
    }

    public ComparableCircle(double radius, String color, boolean filled) {
        super(radius, color, filled);
    }

    @Override
    public int compareTo(Circle other) {
        // Compare by area instead of radius
        return Double.compare(this.getArea(), other.getArea());
    }

    @Override
    public String toString() {
        return "ComparableCircle[radius=" + getRadius() + ", area="
                + String.format("%.2f", getArea()) + ", color=" + getColor()
                + ", filled=" + isFilled() + "]";
    }
}
