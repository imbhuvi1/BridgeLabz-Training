package scenario_based.LibraryManagementSystem;

import java.time.LocalDate;

// Issue / Return transaction
public class Transaction {

    private Book book;
    private Member member;
    private LocalDate issueDate;
    private LocalDate returnDate;

    public Transaction(Book book, Member member) {
        this.book = book;
        this.member = member;
        this.issueDate = LocalDate.now();
    }

    public void returnBook() {
        this.returnDate = LocalDate.now();
    }

    public long getLateDays() {
        return returnDate.toEpochDay() - issueDate.toEpochDay();
    }
}
