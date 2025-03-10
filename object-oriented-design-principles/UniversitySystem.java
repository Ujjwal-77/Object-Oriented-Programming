import java.util.ArrayList;
import java.util.List;

class Faculty {
    private String name;

    public Faculty(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Department {
    private String name;
    private List<Faculty> facultyMembers;

    public Department(String name) {
        this.name = name;
        this.facultyMembers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addFaculty(Faculty faculty) {
        facultyMembers.add(faculty);  // Aggregation: Faculty can exist independently
    }

    public void displayFaculty() {
        System.out.println("Department: " + name + " | Faculty Members:");
        for (Faculty faculty : facultyMembers) {
            System.out.println(" - " + faculty.getName());
        }
    }
}

class University {
    private String name;
    private List<Department> departments;
    private List<Faculty> facultyMembers;  // Aggregated faculty members

    public University(String name) {
        this.name = name;
        this.departments = new ArrayList<>();
        this.facultyMembers = new ArrayList<>();
    }

    public void addDepartment(String deptName) {
        departments.add(new Department(deptName));  // Composition: Departments belong to the University
    }

    public void addFaculty(Faculty faculty) {
        facultyMembers.add(faculty);  // Aggregation: Faculty can exist independently
    }

    public void assignFacultyToDepartment(String deptName, Faculty faculty) {
        for (Department dept : departments) {
            if (dept.getName().equals(deptName)) {
                dept.addFaculty(faculty);
                return;
            }
        }
        System.out.println("Department not found: " + deptName);
    }

    public void displayUniversityDetails() {
        System.out.println("University: " + name);
        
        System.out.println("Departments:");
        for (Department dept : departments) {
            System.out.println(" - " + dept.getName());
        }

        System.out.println("University Faculty Members (Aggregated):");
        for (Faculty faculty : facultyMembers) {
            System.out.println(" - " + faculty.getName());
        }

        System.out.println("Faculty assigned to Departments:");
        for (Department dept : departments) {
            dept.displayFaculty();
        }
    }

    public void closeUniversity() {
        System.out.println("Closing university: " + name);
        departments.clear();  // Deletes all departments (Composition)
        facultyMembers.clear();  // Faculties are not deleted since they exist independently
    }
}

public class UniversitySystem {
    public static void main(String[] args) {
        University university = new University("Tech University");

        university.addDepartment("Computer Science");
        university.addDepartment("Mechanical Engineering");

        Faculty faculty1 = new Faculty("Dr. Smith");
        Faculty faculty2 = new Faculty("Prof. Johnson");
        Faculty faculty3 = new Faculty("Dr. Emily");

        university.addFaculty(faculty1);
        university.addFaculty(faculty2);
        university.addFaculty(faculty3);

        university.assignFacultyToDepartment("Computer Science", faculty1);
        university.assignFacultyToDepartment("Mechanical Engineering", faculty2);
        university.assignFacultyToDepartment("Mechanical Engineering", faculty3);

        university.displayUniversityDetails();

        System.out.println("\n=== Deleting University ===");
        university.closeUniversity();
    }
}
