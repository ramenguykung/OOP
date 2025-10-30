package intro_code;

import java.util.Scanner;

public class L2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Input the amount in saving account
        System.out.print("Enter the amout in saving account: ");
        int amount = input.nextInt();

        double interestAmount = amount * Math.pow(1f + (0.05 / 12f), (12f * 0.5f)) ; // 5% interest rate

        System.out.printf("The amount after 6 months is: %.2f", interestAmount);
    }
}