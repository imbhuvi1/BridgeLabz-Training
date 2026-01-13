package scenario_based.LibraryManagementSystem;

// Custom exception
public class BookNotAvailableException extends Exception {

    public BookNotAvailableException(String message) {
        super(message);
    }
}
