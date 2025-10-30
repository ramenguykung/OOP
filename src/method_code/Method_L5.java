package method_code;

import java.util.Scanner;

public class Method_L5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the initial roach population: ");
        int initialPopulation = sc.nextInt();
        RoachPopulation roachPopulation = new RoachPopulation(initialPopulation);
        
        for(int i = 0; i < 3; i++) {
            roachPopulation.waitMonth();
            roachPopulation.spray();
        }
        
        System.out.println(roachPopulation.getPopulation());
    }
}

class RoachPopulation {
    private int population;

    public RoachPopulation(int initialPopulation) {
        this.population = initialPopulation;
    }

    public void waitMonth() {
        this.population *= 2;
    }

    public void spray() {
        this.population -= this.population / 10;
        if (this.population < 0) {
            this.population = 0; // Prevent negative population
        }
    }

    public int getPopulation() {
        return this.population;
    }
}