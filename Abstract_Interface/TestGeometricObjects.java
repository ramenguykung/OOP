public class TestGeometricObjects {
    public static void main(String[] args) {
        System.out.println("=== Testing Circle ===");
        Circle c1 = new Circle(5.0, "red", true);
        Circle c2 = new Circle(3.0, "blue", false);
        Circle c3 = new Circle(5.0);
        
        System.out.println(c1);
        System.out.println("Area: " + String.format("%.2f", c1.getArea()));
        System.out.println("Perimeter: " + String.format("%.2f", c1.getPerimeter()));
        System.out.println("c1 equals c2? " + c1.equals(c2));
        System.out.println("c1 equals c3? " + c1.equals(c3));
        System.out.println("c1 compared to c2: " + c1.compareTo(c2));
        
        System.out.println("\n=== Testing Rectangle ===");
        Rectangle r1 = new Rectangle(4.0, 5.0, "green", true);
        Rectangle r2 = new Rectangle(3.0, 6.0, "yellow", false);
        Rectangle r3 = new Rectangle(4.0, 5.0);
        
        System.out.println(r1);
        System.out.println("Area: " + String.format("%.2f", r1.getArea()));
        System.out.println("Perimeter: " + String.format("%.2f", r1.getPerimeter()));
        System.out.println("r1 equals r2? " + r1.equals(r2));
        System.out.println("r1 equals r3? " + r1.equals(r3));
        System.out.println("r1 compared to r2 (by area): " + r1.compareTo(r2));
        
        System.out.println("\n=== Testing Octagon ===");
        Octagon o1 = new Octagon(5.0, "purple", true);
        Octagon o2 = new Octagon(3.0);
        
        System.out.println(o1);
        System.out.println("Area: " + String.format("%.2f", o1.getArea()));
        System.out.println("Perimeter: " + String.format("%.2f", o1.getPerimeter()));
        System.out.println("o1 compared to o2: " + o1.compareTo(o2));
        
        // Test cloning
        Octagon o3 = (Octagon) o1.clone();
        System.out.println("Cloned octagon: " + o3);
        System.out.println("Original equals clone? " + o1.equals(o3));
        System.out.println("Original == clone? " + (o1 == o3));
        
        System.out.println("\n=== Testing ComparableCircle ===");
        ComparableCircle cc1 = new ComparableCircle(5.0, "orange", true);
        ComparableCircle cc2 = new ComparableCircle(3.0, "pink", false);
        
        System.out.println(cc1);
        System.out.println(cc2);
        System.out.println("cc1 compared to cc2 (by area): " + cc1.compareTo(cc2));
        
        // Test with array sorting
        System.out.println("\n=== Testing Array Sorting ===");
        Circle[] circles = {
            new Circle(5.0),
            new Circle(2.0),
            new Circle(8.0),
            new Circle(3.5)
        };
        
        System.out.println("Before sorting (by radius):");
        for (Circle c : circles) {
            System.out.println("  Radius: " + c.getRadius() + ", Area: " + String.format("%.2f", c.getArea()));
        }
        
        java.util.Arrays.sort(circles);
        
        System.out.println("After sorting (by radius):");
        for (Circle c : circles) {
            System.out.println("  Radius: " + c.getRadius() + ", Area: " + String.format("%.2f", c.getArea()));
        }
        
        ComparableCircle[] comparableCircles = {
            new ComparableCircle(5.0),
            new ComparableCircle(2.0),
            new ComparableCircle(8.0),
            new ComparableCircle(3.5)
        };
        
        System.out.println("\nBefore sorting ComparableCircle (by area):");
        for (ComparableCircle cc : comparableCircles) {
            System.out.println("  Radius: " + cc.getRadius() + ", Area: " + String.format("%.2f", cc.getArea()));
        }
        
        java.util.Arrays.sort(comparableCircles);
        
        System.out.println("After sorting ComparableCircle (by area):");
        for (ComparableCircle cc : comparableCircles) {
            System.out.println("  Radius: " + cc.getRadius() + ", Area: " + String.format("%.2f", cc.getArea()));
        }
    }
}
