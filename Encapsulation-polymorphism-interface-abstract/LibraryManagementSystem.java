import java.util.ArrayList;
import java.util.List;


abstract class LibraryItem {
    private String itemId;
    private String title;
    private String author;
    protected boolean isAvailable = true;

    public LibraryItem(String itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
    }

    
    public String getItemId() {
        return itemId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    
    public abstract int getLoanDuration(); 
    
    public void getItemDetails() {
        System.out.println("Item ID: " + itemId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Availability: " + (isAvailable ? "Available" : "Checked Out"));
    }
}


interface Reservable {
    boolean reserveItem();
    boolean checkAvailability();
}


class Book extends LibraryItem implements Reservable {
    public Book(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    
    @Override
    public int getLoanDuration() {
        return 14;
    }

    
    @Override
    public boolean reserveItem() {
        if (isAvailable) {
            isAvailable = false;
            return true;
        }
        return false;
    }

    @Override
    public boolean checkAvailability() {
        return isAvailable;
    }
}


class Magazine extends LibraryItem {
    public Magazine(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    
    @Override
    public int getLoanDuration() {
        return 7;
    }
}


class DVD extends LibraryItem implements Reservable {
    public DVD(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    
    @Override
    public int getLoanDuration() {
        return 5;
    }

    
    @Override
    public boolean reserveItem() {
        if (isAvailable) {
            isAvailable = false;
            return true;
        }
        return false;
    }

    @Override
    public boolean checkAvailability() {
        return isAvailable;
    }
}


public class LibraryManagementSystem {
    public static void main(String[] args) {
       
        List<LibraryItem> libraryItems = new ArrayList<>();

        Book book = new Book("B101", "The Great Gatsby", "F. Scott Fitzgerald");
        Magazine magazine = new Magazine("M202", "National Geographic", "NatGeo Team");
        DVD dvd = new DVD("D303", "Inception", "Christopher Nolan");

        
        libraryItems.add(book);
        libraryItems.add(magazine);
        libraryItems.add(dvd);

        for (LibraryItem item : libraryItems) {
            item.getItemDetails();
            System.out.println("Loan Duration: " + item.getLoanDuration() + " days");

            
            if (item instanceof Reservable) {
                Reservable reservableItem = (Reservable) item;
                System.out.println("Reserving Item: " + (reservableItem.reserveItem() ? "Success" : "Failed - Already Reserved"));
            }

            System.out.println("----------------------------");
        }
    }
}

