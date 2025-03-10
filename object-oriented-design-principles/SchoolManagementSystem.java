import java.util.ArrayList;
import java.util.List;

class Course {
    private String name;
    private List<Student> enrolledStudents;

    public Course(String name) {
        this.name = name;
        this.enrolledStudents = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void enrollStudent(Student student) {
        if (!enrolledStudents.contains(student)) {
            enrolledStudents.add(student);
            student.addCourse(this);
        }
    }

    public void displayStudents() {
        System.out.println("Course: " + name + " | Enrolled Students:");
        for (Student student : enrolledStudents) {
            System.out.println(" - " + student.getName());
        }
    }
}

class Student {
    private String name;
    private List<Course> courses;

    public Student(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addCourse(Course course) {
        if (!courses.contains(course)) {
            courses.add(course);
            course.enrollStudent(this);
        }
    }

    public void displayCourses() {
        System.out.println("Student: " + name + " | Enrolled Courses:");
        for (Course course : courses) {
            System.out.println(" - " + course.getName());
        }
    }
}

class School {
    private String name;
    private List<Student> students;

    public School(String name) {
        this.name = name;
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        if (!students.contains(student)) {
            students.add(student);
        }
    }

    public void displayStudents() {
        System.out.println("School: " + name + " | Students:");
        for (Student student : students) {
            System.out.println(" - " + student.getName());
        }
    }
}

public class SchoolManagementSystem {
    public static void main(String[] args) {
        School school = new School("Greenwood High");

        Student student1 = new Student("Alice");
        Student student2 = new Student("Bob");
        Student student3 = new Student("Charlie");

        school.addStudent(student1);
        school.addStudent(student2);
        school.addStudent(student3);

        Course course1 = new Course("Mathematics");
        Course course2 = new Course("Science");
        Course course3 = new Course("History");

        student1.addCourse(course1);
        student1.addCourse(course2);

        student2.addCourse(course1);
        student2.addCourse(course3);

        student3.addCourse(course3);

        school.displayStudents();
        System.out.println();
        
        student1.displayCourses();
        student2.displayCourses();
        student3.displayCourses();
        System.out.println();

        course1.displayStudents();
        course2.displayStudents();
        course3.displayStudents();
    }
}
