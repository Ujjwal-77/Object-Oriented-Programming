import java.util.Scanner;
public class Book {
    Book(){

    }

    Book(String title,String author,double price){

    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String title=sc.nextLine();
        String author=sc.nextLine();
        Double price=sc.nextDouble();
        Book obj=new Book();
        Book obj1=new Book(title,author,price);
    }
}
