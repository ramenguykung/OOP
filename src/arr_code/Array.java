package arr_code;
import java.util.Scanner;

public class Array {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input n: ");
        int n = sc.nextInt();
        double[] x = new double[n];

        for (int i = 0; i < x.length; i++) {
            x[i] = sc.nextDouble();
        }

        double sum = 0;
        double mean = 0;
        double sd = 0;
        double sumDiff = 0;

        for (int i = 0; i < x.length; i++) {
            sum += x[i];
        }

        mean = sum / x.length;
        
        for (int i = 0; i < x.length; i++) {
            sumDiff = sumDiff + Math.pow(x[i] - mean, 2);
        }

        sd = Math.sqrt(sumDiff / (x.length - 1));

        double min = x[0];
        double max = x[0];

        for (int i = 1; i < x.length; i++) {
            if (x[i] < min) {
                min = x[i];
            }
            if (x[i] > max) {
                max = x[i];
            }
        }

        System.out.printf("Sum: %.2f%n", sum);
        System.out.printf("Mean: %.2f%n", mean);
        System.out.printf("Standard Deviation: %.2f%n", sd);
        System.out.printf("Min: %.2f%n", min);
        System.out.printf("Max: %.2f%n", max);
    }
}

class MyArray {
    double[] x;

    MyArray () {
    }

    public MyArray(double[] x) {
        this.x = x;
    }

    MyArray(int n) {
        x = new double[n];
    }
    
    void inputArray(int n) {
        Scanner sc = new Scanner(System.in);
        x = new double[n];
        for (int i = 0; i < n; i++) {
            this.x[i] = sc.nextDouble();
        }
    }

    double calSum() {
        double sum = 0;
        for (int i = 0; i < x.length; i++) {
            sum += x[i];
        }
        return sum;
    }

    double calMean() {
        return calSum() / x.length;
    }

    double calSD() {
        double sd = 0;
        double sumDiff = 0;
        double mean = calMean();
        for (int i = 0; i < x.length; i++) {
            sumDiff = sumDiff + Math.pow(x[i] - mean, 2);
        }
        sd = Math.sqrt(sumDiff / (x.length - 1));
        return sd;
    }
    
    double calMin() {
        double min = this.x[0];
        for (int i = 0; i < x.length; i++) {
            if (x[i] < min) {
                min = x[i];
            }
        }
        return min;
    }

    double calMax() {
        double max = this.x[0];
        for (int i = 0; i < x.length; i++) {
            if (x[i] > max) {
                max = x[i];
            }
        }
        return max;
    }

    void printDetails() {
        System.out.printf("Sum: %.2f%n", calSum());
        System.out.printf("Mean: %.2f%n", calMean());
        System.out.printf("Standard Deviation: %.2f%n", calSD());
        System.out.printf("Min: %.2f%n", calMin());
        System.out.printf("Max: %.2f%n", calMax());
    }
}