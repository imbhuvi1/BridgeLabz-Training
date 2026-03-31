class Book2 {
	private String title;
	private String author;
	private double price;

	Book2() {
		this.title = "Unknown";
		this.author = "Unknown";
		this.price = 0.0;
	}

	Book2(String title, String author, double price) {
		this.title = title;
		this.author = author;
		this.price = price;
	}

	void display() {
		System.out.println("Title: " + title + ", Author: " + author + ", Price: Rs" + price);
	}
}

public class DisplayBookDetails {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Book2 b = new Book2();
		Book2 b2 = new Book2("Lord Of The Rings", "Tolkien", 999.99);
		b.display();
		b2.display();
	}

}