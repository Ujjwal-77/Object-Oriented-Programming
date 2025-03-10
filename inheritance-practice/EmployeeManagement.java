class Employee{
    protected String name;
    protected double id;
    protected double salary;

    Employee(String name,double id,double salary){
        this.name=name;
        this.id=id;
        this.salary=salary;
    }

    public void displayDetails(){
        System.out.println("Name: "+name);
        System.out.println("ID: "+id);
        System.out.println("Salary: "+salary);
    }
}

class Manager extends Employee{
    protected int teamSize;
    Manager(int teamsize,String name,double id,double salary){
        super(name,id,salary);
        this.teamSize=teamSize;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Role: Manager, Team Size: " + teamSize);
    }
}

class Developer extends Employee{
    protected String programmingLanguage;
    Developer(String programmingLanguage,String name,double id,double salary){
        super(name,id,salary);
        this.programmingLanguage=programmingLanguage;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Role: Developer, Programming Language: " + programmingLanguage);
    }
}

class Intern extends Employee{
    Intern(String name,double id,double salary){
        super(name,id,salary);
    }
}

public class EmployeeManagement {
    public static void main(String[] args) {
        Employee man=new Manager(5,"revanth",1234567,500000);
        Employee dev=new Developer("java","amritansh",12345,50000);
        Employee intern=new Intern("aryan",123,500000);

        System.out.println();
        man.displayDetails();

        System.out.println();

        dev.displayDetails();
        System.out.println();

        intern.displayDetails();

    }
}
