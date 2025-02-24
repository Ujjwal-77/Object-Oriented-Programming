import java.util.Scanner;
public class Student {
    private String name;
    private int rollnumber;
    private double marks;
    public void setDetails(String name,int rollnumber,double marks){
        this.name=name;
        this.rollnumber=rollnumber;
        this.marks=marks;
    }
    private char calculateGrade() {
        if (marks >= 90) return 'A';
        else if (marks >= 80) return 'B';
        else if (marks >= 70) return 'C';
        else if (marks >= 60) return 'D';
        else return 'F';
    }

    public void displayStudentDetails() {
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + rollnumber);
        System.out.println("Marks: " + marks);
        System.out.println("Grade: " + calculateGrade());
    }

    public static void main(String[] args) {
        Student obj=new Student();
        obj.setDetails("Ujjwal",21,90);
        obj.displayStudentDetails();
    }
}
