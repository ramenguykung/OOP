package arr_code;
import java.util.Scanner;

public class Array_L5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rowsA, colsA, rowsB, colsB;
        
        do {
            System.out.println("Input the number of rows and columns for the matrix A: ");
            rowsA = sc.nextInt();
            colsA = sc.nextInt();
            System.out.println("Input the number of rows and columns for the matrix B: ");
            rowsB = sc.nextInt();
            colsB = sc.nextInt();
            
            if (colsA != rowsB) {
                System.out.println("Error: Number of columns in matrix A (" + colsA + ") must equal number of rows in matrix B (" + rowsB + ")");
            }
        } while (colsA != rowsB);

        Matrix matrixA = new Matrix(rowsA, colsA);
        Matrix matrixB = new Matrix(rowsB, colsB);
        
        System.out.println("Input values for matrix A:");
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsA; j++) {
                System.out.print("Enter value for A[" + i + "][" + j + "]: ");
                int value = sc.nextInt();
                matrixA.setValue(i, j, value);
            }
        }

        System.out.println("Input values for matrix B:");
        for (int i = 0; i < rowsB; i++) {
            for (int j = 0; j < colsB; j++) {
                System.out.print("Enter value for B[" + i + "][" + j + "]: ");
                int value = sc.nextInt();
                matrixB.setValue(i, j, value);
            }
        }

        System.out.println("Matrix A:");
        matrixA.printMatrix(matrixA);
        System.out.println("Matrix B:");
        matrixB.printMatrix(matrixB);

        Matrix result = matrixA.multiplication(matrixB);
        System.out.println("Result of multiplication:");
        matrixA.printMatrix(result);
    }
}
class Matrix {
    private int[][] data;
    private int rows;
    private int cols;

    public Matrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        data = new int[rows][cols];
    }

    public void setValue(int row, int col, int value) {
        if (row < 0 || row >= rows || col < 0 || col >= cols) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        data[row][col] = value;
    }

    public int getValue(int row, int col) {
        if (row < 0 || row >= rows || col < 0 || col >= cols) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        return data[row][col];
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }
    
    public Matrix multiplication(Matrix other) {
        Matrix result = new Matrix(this.rows, other.cols);
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < other.cols; j++) {
                int sum = 0;
                for (int k = 0; k < this.cols; k++) {
                    sum += this.getValue(i, k) * other.getValue(k, j);
                }
                result.setValue(i, j, sum);
            }
        }
        return result;
    }
    public void printMatrix(Matrix other) {
        for (int i = 0; i < other.getRows(); i++) {
            for (int j = 0; j < other.getCols(); j++) {
                System.out.print(other.getValue(i, j) + " ");
            }
            System.out.println();
        }
    }
}