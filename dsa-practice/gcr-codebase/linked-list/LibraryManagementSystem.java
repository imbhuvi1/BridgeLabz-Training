import java.util.*;

// Node class representing a Book
class BookNode {
	String title;
	String author;
	String genre;
	int bookId;
	boolean isAvailable;

	BookNode prev; // pointer to previous node
	BookNode next; // pointer to next node

	// constructor to initialize book details
	public BookNode(int bookId, String title, String author, String genre, boolean isAvailable) {
		this.bookId = bookId;
		this.title = title;
		this.author = author;
		this.genre = genre;
		this.isAvailable = isAvailable;
		this.prev = null;
		this.next = null;
	}
}

// Doubly Linked List class
class Library {
	BookNode head;
	BookNode tail;

	// Add book at beginning
	void addAtBeginning(int id, String title, String author, String genre, boolean status) {
		BookNode newNode = new BookNode(id, title, author, genre, status);

		// if list is empty
		if (head == null) {
			head = tail = newNode;
			return;
		}

		newNode.next = head;
		head.prev = newNode;
		head = newNode;
	}

	// Add book at end
	void addAtEnd(int id, String title, String author, String genre, boolean status) {
		BookNode newNode = new BookNode(id, title, author, genre, status);

		// if list is empty
		if (head == null) {
			head = tail = newNode;
			return;
		}

		tail.next = newNode;
		newNode.prev = tail;
		tail = newNode;
	}

	// Add book at specific position
	void addAtPosition(int pos, int id, String title, String author, String genre, boolean status) {

		if (pos == 1) {
			addAtBeginning(id, title, author, genre, status);
			return;
		}

		BookNode temp = head;

		for (int i = 1; i < pos - 1 && temp != null; i++) {
			temp = temp.next;
		}

		if (temp == null || temp.next == null) {
			addAtEnd(id, title, author, genre, status);
			return;
		}

		BookNode newNode = new BookNode(id, title, author, genre, status);

		newNode.next = temp.next;
		newNode.prev = temp;
		temp.next.prev = newNode;
		temp.next = newNode;
	}

	// Remove book by Book ID
	void removeBook(int id) {

		// if list is empty
		if (head == null) {
			System.out.println("Library is empty.");
			return;
		}

		BookNode temp = head;

		while (temp != null) {
			if (temp.bookId == id) {

				// removing head
				if (temp == head) {
					head = head.next;
					if (head != null)
						head.prev = null;
				}
				// removing tail
				else if (temp == tail) {
					tail = tail.prev;
					tail.next = null;
				}
				// removing middle node
				else {
					temp.prev.next = temp.next;
					temp.next.prev = temp.prev;
				}

				System.out.println("Book removed successfully.");
				return;
			}
			temp = temp.next;
		}

		System.out.println("Book not found.");
	}

	// Search book by title
	void searchByTitle(String title) {
		BookNode temp = head;

		while (temp != null) {
			if (temp.title.equalsIgnoreCase(title)) {
				displayBook(temp);
				return;
			}
			temp = temp.next;
		}

		System.out.println("Book not found.");
	}

	// Search book by author
	void searchByAuthor(String author) {
		BookNode temp = head;
		boolean found = false;

		while (temp != null) {
			if (temp.author.equalsIgnoreCase(author)) {
				displayBook(temp);
				found = true;
			}
			temp = temp.next;
		}

		if (!found)
			System.out.println("No books found by this author.");
	}

	// Update availability status
	void updateAvailability(int id, boolean status) {
		BookNode temp = head;

		while (temp != null) {
			if (temp.bookId == id) {
				temp.isAvailable = status;
				System.out.println("Availability updated.");
				return;
			}
			temp = temp.next;
		}

		System.out.println("Book not found.");
	}

	// Display books in forward order
	void displayForward() {
		BookNode temp = head;

		if (temp == null) {
			System.out.println("Library is empty.");
			return;
		}

		while (temp != null) {
			displayBook(temp);
			temp = temp.next;
		}
	}

	// Display books in reverse order
	void displayReverse() {
		BookNode temp = tail;

		if (temp == null) {
			System.out.println("Library is empty.");
			return;
		}

		while (temp != null) {
			displayBook(temp);
			temp = temp.prev;
		}
	}

	// Count total books
	int countBooks() {
		int count = 0;
		BookNode temp = head;

		while (temp != null) {
			count++;
			temp = temp.next;
		}
		return count;
	}

	// Helper method to display book details
	void displayBook(BookNode b) {
		System.out.println("");
		System.out.println("Book ID    : " + b.bookId);
		System.out.println("Title      : " + b.title);
		System.out.println("Author     : " + b.author);
		System.out.println("Genre      : " + b.genre);
		System.out.println("Available  : " + (b.isAvailable ? "Yes" : "No"));
	}
}

// Main class
public class LibraryManagementSystem {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Library lib = new Library();
		int choice;

		do {
			System.out.println("\n===== LIBRARY MANAGEMENT SYSTEM =====");
			System.out.println("1. Add Book at Beginning");
			System.out.println("2. Add Book at End");
			System.out.println("3. Add Book at Position");
			System.out.println("4. Remove Book by ID");
			System.out.println("5. Search Book by Title");
			System.out.println("6. Search Book by Author");
			System.out.println("7. Update Availability");
			System.out.println("8. Display Books Forward");
			System.out.println("9. Display Books Reverse");
			System.out.println("10. Count Total Books");
			System.out.println("0. Exit");
			System.out.print("Enter choice: ");

			choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {

			case 1:
			case 2:
			case 3:
				if (choice == 3) {
					System.out.print("Enter Position: ");
					int pos = sc.nextInt();
					sc.nextLine();

					System.out.print("Enter Book ID: ");
					int id = sc.nextInt();
					sc.nextLine();
					System.out.print("Enter Title: ");
					String title = sc.nextLine();
					System.out.print("Enter Author: ");
					String author = sc.nextLine();
					System.out.print("Enter Genre: ");
					String genre = sc.nextLine();
					System.out.print("Is Available (true/false): ");
					boolean status = sc.nextBoolean();

					lib.addAtPosition(pos, id, title, author, genre, status);
					break;
				}

				System.out.print("Enter Book ID: ");
				int id = sc.nextInt();
				sc.nextLine();
				System.out.print("Enter Title: ");
				String title = sc.nextLine();
				System.out.print("Enter Author: ");
				String author = sc.nextLine();
				System.out.print("Enter Genre: ");
				String genre = sc.nextLine();
				System.out.print("Is Available (true/false): ");
				boolean status = sc.nextBoolean();

				if (choice == 1)
					lib.addAtBeginning(id, title, author, genre, status);
				else
					lib.addAtEnd(id, title, author, genre, status);
				break;

			case 4:
				System.out.print("Enter Book ID: ");
				lib.removeBook(sc.nextInt());
				break;

			case 5:
				System.out.print("Enter Title: ");
				lib.searchByTitle(sc.nextLine());
				break;

			case 6:
				System.out.print("Enter Author: ");
				lib.searchByAuthor(sc.nextLine());
				break;

			case 7:
				System.out.print("Enter Book ID: ");
				int bid = sc.nextInt();
				System.out.print("Is Available (true/false): ");
				lib.updateAvailability(bid, sc.nextBoolean());
				break;

			case 8:
				lib.displayForward();
				break;

			case 9:
				lib.displayReverse();
				break;

			case 10:
				System.out.println("Total Books: " + lib.countBooks());
				break;

			case 0:
				System.out.println("Exiting...");
				break;

			default:
				System.out.println("Invalid choice.");
			}

		} while (choice != 0);

		sc.close();
	}
}

