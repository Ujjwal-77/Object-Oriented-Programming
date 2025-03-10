class Person {
    protected String name;
    protected int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void displayDetails() {
        System.out.println("Name: " + name + ", Age: " + age);
    }

    public void displayRole() {
        System.out.println("General Person in School");
    }
}

class Teacher extends Person {
    private String subject;

    public Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }

    @Override
    public void displayRole() {
        System.out.println("Teacher of Subject: " + subject);
    }
}

class Student extends Person {
    private String grade;

    public Student(String name, int age, String grade) {
        super(name, age);
        this.grade = grade;
    }

    @Override
    public void displayRole() {
        System.out.println("Student in Grade: " + grade);
    }
}

class Staff extends Person {
    private String position;

    public Staff(String name, int age, String position) {
        super(name, age);
        this.position = position;
    }

    @Override
    public void displayRole() {
        System.out.println("Staff Member, Position: " + position);
    }
}

public class SchoolSystem {
    public static void main(String[] args) {
        Person teacher = new Teacher("Alice", 35, "Mathematics");
        Person student = new Student("Bob", 16, "10th Grade");
        Person staff = new Staff("Charlie", 40, "Administrator");

        teacher.displayDetails();
        teacher.displayRole();

        student.displayDetails();
        student.displayRole();

        staff.displayDetails();
        staff.displayRole();
    }
}
