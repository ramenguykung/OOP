package inheritance_code;

public class Inheritance_EX {
    public static void main(String[] args) {
    Calculation obj = new Calculation();
    MyCalculation obj2 = new MyCalculation();
    System.out.println(obj.toString());
    System.out.println(obj2.toString());
    System.out.println("obj2 = " + obj2);
    } 
}
class Calculation {
    protected int z; // `protected` keyword used to allow access in subclasses. But it is still not accessible outside the package.

    public void add(int x, int y) {
        z = x + y;
        System.out.println("Add: " + z);
    }
    public void subtract(int x, int y) {
        z = x - y;
        System.out.println("Subtract: " + z);
    }
    @Override
    public String toString() {
        return "From calculation z = " + z;
    }
}
// Example of inheritance when the super class is restricted
class MyCalculation extends Calculation {
    public void multiply(int x, int y) {
        z = x * y;
        System.out.println("Multiply: " + z);
    }
    public void divide(int x, int y) {
        z = x / y;
        System.out.println("Divide: " + z);
    }
    @Override
    public String toString() {
        return "From MyCalculation z = " + super.z; // Accessing protected variable from superclass.
    }
}
