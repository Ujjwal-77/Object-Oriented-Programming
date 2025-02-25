import java.util.Scanner;
public class Book {
    private String title;
    private String author;
    private double price;

    Book(){
       title="Unknown Title";
       author="Unknown Author";
       price=500;
    }

    Book(String title,String author,double price){
        this.title=title;
        this.author=author;
        this.price=price;
    }
    public void displayDetails() {
        System.out.println("Book Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: " + price);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String title=sc.nextLine();
        String author=sc.nextLine();
        Double price=sc.nextDouble();

        Book obj=new Book();
        Book obj1=new Book(title,author,price);
        obj.displayDetails();
        obj1.displayDetails();
    }
}
