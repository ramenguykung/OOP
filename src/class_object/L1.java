package class_object;

public class L1 {
    public static void main(String[] args) {
    Complex a = new Complex(1.0, 2.0);
    Complex b = new Complex(3.0, 4.0);
    Complex c = new Complex(a);
    c.divide(b);
    c.print();
    }
}

class Complex {
    private double r, i;
    Complex(double r, double i) {
        this.r = r;
        this.i = i;
    }

    Complex(Complex c) {
        this(c.r, c.i);
    }

    public void add(Complex c) {
        r += c.r;
        i += c.i;
    }

    public void subtract(Complex c) {
        r -= c.r;
        i -= c.i;
    }

    public void multiply(Complex z) {
        double temp1, temp2;
        temp1 = this.r * z.r - this.i * z.i;
        temp2 = this.r * z.i + this.i * z.r;
        this.r = temp1;
        this.i = temp2;
    }

    public void divide(Complex z) {
        double temp1, temp2;
        double denominator = z.r * z.r + z.i * z.i;
        if (denominator == 0) {
            throw new ArithmeticException("Division by zero");
        }
        temp1 = (this.r * z.r + this.i * z.i) / denominator;
        temp2 = (this.i * z.r - this.r * z.i) / denominator;
        this.r = temp1;
        this.i = temp2;
    }

    public void print() {
        System.out.println(r + " + i" + i);
    }
}