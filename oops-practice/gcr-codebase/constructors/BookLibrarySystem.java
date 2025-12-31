class Book4{
	public String isbn;
	protected String title;
	private String author;
	Book4(String isbn, String title, String author){
		this.isbn = isbn;
		this.title = title;
		this.author = author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getAuthor() {
		return author;
	}
}
class EBook extends Book4{
	EBook(String isbn, String title, String author){
		super(isbn, title, author);
	}
	void display() {
		System.out.println("ISBN Code: " + isbn);
		System.out.println("Title " + title);
	}
}
public class BookLibrarySystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EBook e = new EBook("OP0001","One Piece", "Oda");
		e.display();
		System.out.println("Author: " + e.getAuthor());
		e.setAuthor("Eiichira Oda");
		System.out.println("Updated Author: " + e.getAuthor());
	}

}
