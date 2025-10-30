package inheritance_code;

public class Animal {

    public static void main(String[] args) {
        Animal animal = new Animal();
        Bird bird = new Bird();
        Dog dog = new Dog();

        System.out.println();
        
        animal.sleep();
        animal.eat();

        bird.sleep();
        bird.eat();

        dog.sleep();
        dog.eat();
    }

    public Animal() {
        System.out.println("A new animal has been created!");
    } 

    public void sleep() {
        System.out.println("An animal is sleeping...");
    }
    
    public void eat() {
        System.out.println("An animal is eating...");
    }
}

class Bird extends Animal {

    public Bird() {
        super();
        System.out.println("A new bird has been created!");
    }

    @Override
    public void sleep() {
        System.out.println("A bird is sleeping...");
    }

    @Override
    public void eat() {
        System.out.println("A bird is eating...");
    }
}

class Dog extends Animal {

    public Dog() {
        super();
        System.out.println("A new dog has been created!");
    }

    @Override
    public void sleep() {
        System.out.println("A dog is sleeping...");
    }

    @Override
    public void eat() {
        System.out.println("A dog is eating...");
    }
}