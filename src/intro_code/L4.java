package intro_code;

import java.util.Scanner;

public class L4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the balance in your savings account and interest rate: ");
        double balance = input.nextDouble();
        double interestRate = input.nextDouble();

        double interestAmount = balance * (interestRate / 1200);

        System.out.printf("The interest amount is: %.6f%n", interestAmount);
    }
}
