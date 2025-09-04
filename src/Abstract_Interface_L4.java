public class Abstract_Interface_L4 {
    public static void main(String[] args) {
        
    }
}

abstract class Employee {
    private String firstname;
    private String lastname;
    private String id;

    public Employee(String firstname, String lastname, String id) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.id = id;
    }

    public abstract double earning();

    public abstract double bonus(int year);
}
class SalariedEmployee extends Employee {
    int salary;

    public SalariedEmployee(String firstname, String lastname, String id, double sal) {
    }
}