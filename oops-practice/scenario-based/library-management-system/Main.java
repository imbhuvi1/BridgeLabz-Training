package scenario_based.LibraryManagementSystem;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // book input
        System.out.print("Enter Book ID: ");
        int bookId = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Book Title: ");
        String title = sc.nextLine();

        Book book = new Book(bookId, title);

        // member input
        System.out.print("Enter Member ID: ");
        int memberId = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Member Name: ");
        String memberName = sc.nextLine();

        System.out.print("Member Type (Student/Staff): ");
        String type = sc.nextLine();

        Member member = new Member(memberId, memberName, type);

        try {
            if (!book.isAvailable()) {
                throw new BookNotAvailableException("Book is not available");
            }

            // issue book
            book.setAvailable(false);
            Transaction transaction = new Transaction(book, member);
            System.out.println("Book Issued Successfully");

            // return book
            System.out.print("Return Book? (yes/no): ");
            String choice = sc.nextLine();

            if (choice.equalsIgnoreCase("yes")) {
                transaction.returnBook();
                book.setAvailable(true);

                FineCalculator fineCalculator;
                if (member.getMemberType().equalsIgnoreCase("student")) {
                    fineCalculator = new StudentFineCalculator();
                } else {
                    fineCalculator = new StaffFineCalculator();
                }

                double fine = fineCalculator.calculateFine(transaction.getLateDays());
                System.out.println("Late Fine: ₹" + fine);
            }

        } catch (BookNotAvailableException e) {
            System.out.println(e.getMessage());
        }

        sc.close();
    }
}
