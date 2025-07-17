import java.util.Scanner;

public class L1_2 {
    public static void main(String[] args) throws Exception {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter the temperature: ");
    double temperature = input.nextDouble();
    double celcius = (5f / 9f) * (temperature - 32);
    System.out.println("The temperature in Celsius is: " + celcius);
    }
}
