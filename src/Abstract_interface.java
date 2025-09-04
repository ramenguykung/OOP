public class Abstract_interface {
    public static void main(String[] args) {
        Superman obj = new Superman();
        obj.fly();
        obj.fight();

        Flyable b = new bird();
        b.fly();
        Flyable superman = new Superman();
        superman.fly();
        Flyable plane = new Plane();
        plane.fly();
    }
}
class Human {
    String name, surname;

    void eat() {}
    void walk() {}
}
class bird implements Flyable {
    @Override
    public void fly() {
        System.out.println("Fly from bird");
    }
}
class Plane implements Flyable {
    @Override
    public void fly() {
        System.out.println("Fly from Airplane");
    }
}
interface Flyable {
    int speed = 10;
    void fly();
}
interface Fightable {
    void fight();
}
class Actor extends Human {

}
class Superman extends Human implements Flyable, Fightable {
    @Override
    public void fly() {
        System.out.println("Fly from Superman");
    }
    @Override
    public void fight() {
        System.out.println("Fight from Superman");
    }
}
