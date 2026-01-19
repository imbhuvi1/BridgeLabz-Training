import java.util.*;

// Book Class
class Book {
    String title;
    String author;

    Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    @Override
    public String toString() {
        return title + " by " + author;
    }

    // Prevent duplication
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Book)) return false;
        Book b = (Book) obj;
        return title.equals(b.title) && author.equals(b.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author);
    }
}

// Library System
class BookShelf {
    private Map<String, LinkedList<Book>> catalog = new HashMap<>();
    private Set<Book> uniqueBooks = new HashSet<>();

    // Add book
    public void addBook(String genre, Book book) {
        if (uniqueBooks.contains(book)) {
            System.out.println("Duplicate book not allowed: " + book);
            return;
        }

        catalog.putIfAbsent(genre, new LinkedList<>());
        catalog.get(genre).add(book);
        uniqueBooks.add(book);

        System.out.println("Book added: " + book);
    }

    // Remove book
    public void removeBook(String genre, Book book) {
        if (!catalog.containsKey(genre)) {
            System.out.println("Genre not found.");
            return;
        }

        if (catalog.get(genre).remove(book)) {
            uniqueBooks.remove(book);
            System.out.println("Book borrowed: " + book);
        } else {
            System.out.println("Book not found.");
        }
    }

    // Print catalog
    public void printCatalog() {
        System.out.println("\nLibrary Catalog:");
        for (String genre : catalog.keySet()) {
            System.out.println("Genre: " + genre);
            for (Book book : catalog.get(genre)) {
                System.out.println("  - " + book);
            }
        }
    }
}

// Main Class
public class LibraryManager {
    public static void main(String[] args) {
        BookShelf library = new BookShelf();

        Book b1 = new Book("Atomic Habits", "James Clear");
        Book b2 = new Book("Clean Code", "Robert Martin");
        Book b3 = new Book("Atomic Habits", "James Clear");

        library.addBook("Self Help", b1);
        library.addBook("Programming", b2);
        library.addBook("Self Help", b3); // Duplicate

        library.printCatalog();

        library.removeBook("Self Help", b1);
        library.printCatalog();
    }
}
