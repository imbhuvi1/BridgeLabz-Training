class Book3 {
	private String title;
	private String author;
	private double price;
	private boolean available;

	Book3(String title, String author, double price) {
		this.title = title;
		this.author = author;
		this.price = price;
		this.available = true;
	}

	void borrowBook() {
		if (available) {
			available = false;
			System.out.println("Book borrowed: " + title);
		} else {
			System.out.println("Book not available");
		}
	}
}

public class LibraryBookSystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Book3 b = new Book3("LOTR", "Tolkien", 999.99);
		b.borrowBook();
		b.borrowBook();
	}

}
