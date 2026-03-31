package scenerio_based;

import java.util.*;

// Custom exception for unavailable book
class BookNotAvailableException extends Exception {
    public BookNotAvailableException(String message) {
        super(message);
    }
}

// Book class to hold book details
class Book {
    private String title;
    private String author;
    private boolean isAvailable;

    // Constructor initializes book details
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isAvailable = true; // initially available
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    // Check availability
    public boolean isAvailable() {
        return isAvailable;
    }

    // Update status to checked out
    public void checkOut() throws BookNotAvailableException {
        if (!isAvailable) {
            throw new BookNotAvailableException("Book '" + title + "' is currently not available.");
        }
        isAvailable = false;
    }

    // Update status to available (for returns)
    public void returnBook() {
        isAvailable = true;
    }

    // Display book details
    public void display() {
        System.out.println("Title : " + title);
        System.out.println("Author: " + author);
        System.out.println("Status: " + (isAvailable ? "Available" : "Checked Out"));
        System.out.println("");
    }
}

// Library management class
public class LibraryManagementSystem {

    // Array to hold initial book data
    private static Book[] bookArray = {
        new Book("Java Programming", "James Gosling"),
        new Book("Clean Code", "Robert Martin"),
        new Book("Algorithms", "Robert Sedgewick"),
        new Book("Effective Java", "Joshua Bloch"),
        new Book("Design Patterns", "Erich Gamma")
    };

    // List to store books for dynamic operations
    private static List<Book> bookList = new ArrayList<>();

    private static Scanner sc = new Scanner(System.in);

    // Load books from array to list
    private static void loadBooks() {
        for (Book b : bookArray) {
            bookList.add(b);
        }
    }

    // Search books by partial title (case insensitive)
    public static List<Book> searchBooks(String query) {
        List<Book> results = new ArrayList<>();
        String lowerQuery = query.toLowerCase();

        for (Book b : bookList) {
            if (b.getTitle().toLowerCase().contains(lowerQuery)) {
                results.add(b);
            }
        }
        return results;
    }

    // Display list of books
    public static void displayBooks(List<Book> books) {
        if (books.isEmpty()) {
            System.out.println("No books found matching your search.");
        } else {
            for (Book b : books) {
                b.display();
            }
        }
    }

    // Checkout a book by exact title
    public static void checkOutBook(String title) {
        for (Book b : bookList) {
            if (b.getTitle().equalsIgnoreCase(title)) {
                try {
                    b.checkOut();
                    System.out.println("You have successfully checked out '" + b.getTitle() + "'.");
                    return;
                } catch (BookNotAvailableException e) {
                    System.out.println(e.getMessage());
                    return;
                }
            }
        }
        System.out.println("Book with title '" + title + "' not found.");
    }

    // Main menu-driven method
    public static void main(String[] args) {
        loadBooks();

        int choice;

        do {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Search Books by Title");
            System.out.println("2. Checkout Book");
            System.out.println("3. Display All Books");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1:
                        System.out.print("Enter partial title to search: ");
                        String query = sc.nextLine();
                        List<Book> results = searchBooks(query);
                        displayBooks(results);
                        break;
                    case 2:
                        System.out.print("Enter exact title of the book to checkout: ");
                        String title = sc.nextLine();
                        checkOutBook(title);
                        break;
                    case 3:
                        displayBooks(bookList);
                        break;
                    case 4:
                        System.out.println("Exiting system. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
                choice = 0;
            }
        } while (choice != 4);
    }
}
