import java.util.ArrayList;
import java.util.List;

class Course {
    private String courseName;
    private Professor professor;
    private List<Student> enrolledStudents;

    public Course(String courseName) {
        this.courseName = courseName;
        this.enrolledStudents = new ArrayList<>();
    }

    public void assignProfessor(Professor professor) {
        this.professor = professor;
        System.out.println(professor.getName() + " is assigned to teach " + courseName);
    }

    public void enrollStudent(Student student) {
        enrolledStudents.add(student);
        System.out.println(student.getName() + " enrolled in " + courseName);
    }

    public void displayCourseDetails() {
        System.out.println("Course: " + courseName);
        System.out.println("Professor: " + (professor != null ? professor.getName() : "Not assigned"));
        System.out.println("Enrolled Students:");
        for (Student student : enrolledStudents) {
            System.out.println("- " + student.getName());
        }
        System.out.println("-----------------------------");
    }
}

class Professor {
    private String name;

    public Professor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Student {
    private String name;
    private List<Course> courses;

    public Student(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }

    public void enrollCourse(Course course) {
        courses.add(course);
        course.enrollStudent(this);
    }

    public String getName() {
        return name;
    }

    public void displayEnrolledCourses() {
        System.out.println("Student: " + name);
        System.out.println("Enrolled Courses:");
        for (Course course : courses) {
            System.out.println("- " + course);
        }
        System.out.println("-----------------------------");
    }
}

public class UniversityManagementSystem {
    public static void main(String[] args) {
        Professor profSmith = new Professor("Dr. Smith");
        Professor profJohnson = new Professor("Dr. Johnson");

        Course math = new Course("Mathematics");
        Course physics = new Course("Physics");

        math.assignProfessor(profSmith);
        physics.assignProfessor(profJohnson);

        Student alice = new Student("Alice");
        Student bob = new Student("Bob");

        alice.enrollCourse(math);
        bob.enrollCourse(math);
        alice.enrollCourse(physics);

        math.displayCourseDetails();
        physics.displayCourseDetails();

        alice.displayEnrolledCourses();
        bob.displayEnrolledCourses();
    }
}
