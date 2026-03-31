class Book {
	String title;
	String author;
	double price;

	Book() {
		this.title = "";
		this.author = "";
		this.price = 0;
	}

	Book(String title, String author, double price) {
		this.author = author;
		this.title = title;
		this.price = price;
	}

	public void display() {
		System.out.println("Title of the book: " + title);
		System.out.println("Author of the book: " + author);
		System.out.println("Price of the book: " + price);
	}
}

public class BookDetails {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Book b1 = new Book();
		b1.title = "2States";
		b1.author = "Chetan Bhagat";
		b1.price = 500;
		Book b2 = new Book("Wings of Fire", "Abdul Kalam, A.P.J.", 500);

		b1.display();
		b2.display();
	}

}