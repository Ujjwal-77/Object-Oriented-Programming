import java.util.ArrayList;
import java.util.List;

class Employee {
    private String name;

    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Department {
    private String name;
    private List<Employee> employees;

    public Department(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
    }

    public String getName() { // Getter method to access the private name field
        return name;
    }

    public void addEmployee(String employeeName) {
        employees.add(new Employee(employeeName));
    }

    public void displayEmployees() {
        System.out.println("Department: " + name);
        for (Employee emp : employees) {
            System.out.println(" - Employee: " + emp.getName());
        }
    }
}

class Company {
    private String name;
    private List<Department> departments;

    public Company(String name) {
        this.name = name;
        this.departments = new ArrayList<>();
    }

    public void addDepartment(String departmentName) {
        departments.add(new Department(departmentName));
    }

    public void addEmployeeToDepartment(String departmentName, String employeeName) {
        for (Department dept : departments) {
            if (dept.getName().equals(departmentName)) { // Use getter to access name
                dept.addEmployee(employeeName);
                return;
            }
        }
        System.out.println("Department not found: " + departmentName);
    }

    public void displayCompanyDetails() {
        System.out.println("Company: " + name);
        for (Department dept : departments) {
            dept.displayEmployees();
        }
    }
}

public class CompositionExample {
    public static void main(String[] args) {
        Company company = new Company("TechCorp");

        company.addDepartment("IT");
        company.addDepartment("HR");

        company.addEmployeeToDepartment("IT", "Alice");
        company.addEmployeeToDepartment("IT", "Bob");
        company.addEmployeeToDepartment("HR", "Charlie");

        company.displayCompanyDetails();
    }
}
