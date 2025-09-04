public class Abstract_exp {
    public static void main(String[] args) {
        Geometric c = new Circle();
        c.r = 10;
        c.calArea();
        c.calPerimeter();
        System.out.println("Area = " +c.area);
    }
}

abstract class Geometric {
    double area, perimeter;
    double r, w, h;

    abstract void calArea(); //abstract method
    abstract void calPerimeter();
}

class Circle extends Geometric {
    double r;

    @Override
    void calArea() {
        area = 3.141 * r * r;
    }
    void calPerimeter() {
        perimeter = 3.141 * 2 * r;
    }
}

class Square extends Geometric {
    double w, h;

    @Override
    void calArea () {
        area = 0;
    }
    void calPerimeter() {
        perimeter = 0;
    }
}