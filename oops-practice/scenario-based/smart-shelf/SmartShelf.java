package scenario_based.SmartShelf;

// Insertion Sort implementation
public class SmartShelf {

    private Book[] books;
    private int count;

    public SmartShelf(int size) {
        books = new Book[size];
        count = 0;
    }

    // Insert book in sorted order
    public void addBook(Book book) {
        int i = count - 1;

        while (i >= 0 && books[i].title.compareToIgnoreCase(book.title) > 0) {
            books[i + 1] = books[i];
            i--;
        }

        books[i + 1] = book;
        count++;
    }

    public void display() {
        for (int i = 0; i < count; i++) {
            System.out.println(books[i].title);
        }
    }
}
