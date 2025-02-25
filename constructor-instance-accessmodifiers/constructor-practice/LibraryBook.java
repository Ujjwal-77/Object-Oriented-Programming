import java.util.Scanner;
public class LibraryBook {
    private String title;
    private String author;
    private double price;
    private int availability;

    public void setDetails(String title,String author,double price,int availability){
        this.title=title;
        this.author=author;
        this.price=price;
        this.availability=availability;
    }

    public void borrow(int required){
        if(availability>0 && required>0){
            availability-=1;
        }
        else{
            System.out.println("Book not available");
        }
    }
    public static void main(String[] args) {
        LibraryBook obj=new LibraryBook();
        obj.setDetails("Success","Ujjwal",500,5);
        Scanner sc=new Scanner(System.in);
        int required=sc.nextInt();
        obj.borrow(required);
        sc.close();
    }
}
