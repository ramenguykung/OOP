
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Abstract_Interface_L4 {

    public static void main(String[] args) {
        ArrayList<Employee> empList = new ArrayList<>();

        empList.add(new SalariedEmployee("John", "Doe", "S001", 30000));
        empList.add(new SalariedEmployee("Jane", "Smith", "S002", 35000));

        empList.add(new ComEmployee("Mike", "Johnson", "C001", 100000, 0.15));
        empList.add(new ComEmployee("Sarah", "Williams", "C002", 150000, 0.12));

        printEmpArrayList(empList);
    }

    public static void printEmpArrayList(ArrayList<Employee> empList) {
        
        double[] arrayEarn = new double[empList.size()];
        double[] arrayBonus = new double[empList.size()];

        for (int i = 0; i < empList.size(); i++) {
            Employee r = empList.get(i);
            arrayEarn[i] = r.earning();
            arrayBonus[i] = r.bonus(7); // ใช้ year = 7 สำหรับทดสอบ
        }

        String output = String.format("%-15s %-15s %-15s %-15s\n",
                "First name", "Last name", "Earning", "Bonus");
        output += "=".repeat(65) + "\n";

        for (int i = 0; i < empList.size(); i++) {
            Employee emp = empList.get(i);
            output += String.format("%-15s %-15s %-15.2f %-15.2f\n",
                    emp.getFirstname(), emp.getLastname(),
                    arrayEarn[i], arrayBonus[i]);
        }

        JOptionPane.showMessageDialog(null, output, "Employee Information",
                JOptionPane.INFORMATION_MESSAGE);
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

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getId() {
        return id;
    }

    public abstract double earning();

    public abstract double bonus(int year);
}

class SalariedEmployee extends Employee {

    int salary;

    public SalariedEmployee(String firstname, String lastname, String id, int salary) {
        super(firstname, lastname, id);
        this.salary = salary;
    }

    @Override
    public double bonus(int year) {
        if (year > 5) {
            return salary * 12; // 12 เท่าของเงินเดือน
        } else {
            return salary * 6; // 6 เท่าของเงินเดือน
        }
    }

    @Override
    public double earning() {
        return salary + (salary * 0.05); // เงินเดือน + 5% ของเงินเดือน
    }
}

class ComEmployee extends Employee {

    private double grossSale;
    private double ComRate;

    public ComEmployee(String firstname, String lastname, String id, double sales, double percent) {
        super(firstname, lastname, id);
        this.grossSale = sales;
        this.ComRate = percent;
    }

    @Override
    public double bonus(int year) {
        double sales = grossSale;
        if (year > 5) {
            return sales * 6; // 6 เท่าของยอดขาย
        } else {
            return sales * 3; // 3 เท่าของยอดขาย
        }
    }

    @Override
    public double earning() {
        return grossSale * ComRate; // Commission = grossSale * ComRate
    }
}
