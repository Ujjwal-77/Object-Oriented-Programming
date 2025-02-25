import java.util.Scanner;
public class Circle {
    private double radius;

    Circle(){
        this(5.0);
    }
    Circle(double radius){
        this.radius=radius;
    }
    public void displayDetails(){
        System.out.println("Radius: "+radius);
    }
    public static void main(String[] args) {
        Circle obj=new Circle();
        obj.displayDetails();
        Scanner sc=new Scanner(System.in);
        double radius=sc.nextDouble();
        Circle obj1=new Circle(radius);
        obj1.displayDetails();
    }
}
