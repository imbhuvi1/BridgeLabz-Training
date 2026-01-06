package gcr_codebase.encapsulation_polymorphism_interface_abstraction;

interface Reservable {
    void reserveItem();
    boolean checkAvailability();
}

abstract class LibraryItem {
    private int itemId;
    private String title;
    private String author;

    protected boolean isAvailable = true;

    public LibraryItem(int itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
    }

    // Abstract method
    public abstract int getLoanDuration();

    // Concrete method
    public void getItemDetails() {
        System.out.println("ID: " + itemId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Available: " + isAvailable);
    }
}

class Book extends LibraryItem implements Reservable {

    public Book(int itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 14; // days
    }

    @Override
    public void reserveItem() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("Book reserved successfully.");
        } else {
            System.out.println("Book is already reserved.");
        }
    }

    @Override
    public boolean checkAvailability() {
        return isAvailable;
    }
}

class Magazine extends LibraryItem implements Reservable {

    public Magazine(int itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 7;
    }

    @Override
    public void reserveItem() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("Magazine reserved successfully.");
        } else {
            System.out.println("Magazine not available.");
        }
    }

    @Override
    public boolean checkAvailability() {
        return isAvailable;
    }
}

class DVD extends LibraryItem implements Reservable {

    public DVD(int itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 3;
    }

    @Override
    public void reserveItem() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("DVD reserved successfully.");
        } else {
            System.out.println("DVD already issued.");
        }
    }

    @Override
    public boolean checkAvailability() {
        return isAvailable;
    }
}

class Borrower {
    private String name;
    private String contactNumber;

    public Borrower(String name, String contactNumber) {
        this.name = name;
        this.contactNumber = contactNumber;
    }

    public String getName() {
        return name;
    }
}

public class LibraryManagementSystem {

    public static void main(String[] args) {

        // Polymorphism: parent reference
        LibraryItem item1 = new Book(1, "Java Programming", "James Gosling");
        LibraryItem item2 = new Magazine(2, "Tech Monthly", "Editorial Team");
        LibraryItem item3 = new DVD(3, "Inception", "Christopher Nolan");

        displayItem(item1);
        displayItem(item2);
        displayItem(item3);

        // Reserving items
        ((Reservable) item1).reserveItem();
        ((Reservable) item3).reserveItem();

        System.out.println("\nLoan Duration:");
        System.out.println("Book: " + item1.getLoanDuration() + " days");
        System.out.println("Magazine: " + item2.getLoanDuration() + " days");
        System.out.println("DVD: " + item3.getLoanDuration() + " days");

        // Encapsulation demo
        Borrower b = new Borrower("Rahul", "9876543210");
        System.out.println("\nBorrower Name: " + b.getName());
    }

    // Polymorphic method
    public static void displayItem(LibraryItem item) {
        System.out.println("\nItem Details:");
        item.getItemDetails();
    }
}
