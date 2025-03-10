import java.util.ArrayList;
import java.util.List;

interface Department {
    void assignDepartment(String departmentName);
    String getDepartmentDetails();
}

abstract class Employee {
    private int employeeId;
    private String name;
    protected double baseSalary;
    private String department;

    public Employee(int employeeId, String name, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public abstract double calculateSalary();

    public void displayDetails() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Base Salary: " + baseSalary);
        System.out.println("Department: " + (department != null ? department : "Not assigned"));
        System.out.println("Final Salary: " + calculateSalary());
        System.out.println("--------------------------");
    }

    public void assignDepartment(String departmentName) {
        this.department = departmentName;
    }

    public String getDepartmentDetails() {
        return department;
    }
}

class FullTimeEmployee extends Employee implements Department {
    private double bonus;

    public FullTimeEmployee(int employeeId, String name, double baseSalary, double bonus) {
        super(employeeId, name, baseSalary);
        this.bonus = bonus;
    }

    @Override
    public double calculateSalary() {
        return baseSalary + bonus;
    }
}

class PartTimeEmployee extends Employee implements Department {
    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(int employeeId, String name, double hourlyRate, int hoursWorked) {
        super(employeeId, name, 0);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculateSalary() {
        return hoursWorked * hourlyRate;
    }
}

public class EmployeeManagementSystem {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();

        FullTimeEmployee emp1 = new FullTimeEmployee(101, "Alice", 5000, 1000);
        emp1.assignDepartment("HR");

        PartTimeEmployee emp2 = new PartTimeEmployee(102, "Bob", 20, 80);
        emp2.assignDepartment("IT");

        employees.add(emp1);
        employees.add(emp2);

        for (Employee emp : employees) {
            emp.displayDetails();
        }
    }
}
