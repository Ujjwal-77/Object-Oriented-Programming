class Book {
    protected String title;
    protected int publicationYear;

    public Book(String title, int publicationYear) {
        this.title = title;
        this.publicationYear = publicationYear;
    }

    public void displayInfo() {
        System.out.println("Book Title: " + title);
        System.out.println("Publication Year: " + publicationYear);
    }
}

class Author extends Book {
    private String name;
    private String bio;

    public Author(String title, int publicationYear, String name, String bio) {
        super(title, publicationYear);
        this.name = name;
        this.bio = bio;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Author: " + name);
        System.out.println("Bio: " + bio);
    }
}

public class LibraryManagement {
    public static void main(String[] args) {
        Author author1 = new Author("The Great Gatsby", 1925, "F. Scott Fitzgerald", "American novelist, known for depicting the Jazz Age.");
        Author author2 = new Author("1984", 1949, "George Orwell", "English writer famous for dystopian themes.");

        System.out.println("Library Books:\n");
        author1.displayInfo();
        System.out.println();
        author2.displayInfo();
    }
}
