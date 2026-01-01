package gcr_codebase.this_static_final_keywords;

public class Book {
	
	//initializing  instance variables
	String title;
	String author;
	final String isbn;
	
	//Use this to initialize title, author, and isbn in the constructor.
	public Book(String title, String author, String isbn) {
		this.title = title;
		this.author = author;
		this.isbn = isbn; 
	}
	
	//A static variable libraryName shared across all books.
	static String libraryName = "National library of India";
	
	//A static method displayLibraryName() to print the library name.
	static void displayLibraryName() {
		System.out.println("Library name: "+ libraryName);
	}
	
	//Verifying if an object is an instance of the Book class and then displaying it's details
	public void displayDetails(Book obj) {
		if(obj instanceof Book) {
			System.out.println("Title: "+title);
			System.out.println("Author: "+author);
			System.out.println("ISBN: "+isbn);
		}else {
			System.out.println("Not an instance of LibraryManagementSystem");
		}
	}
	//Main method
	public static void main(String[] args) {
		Book obj = new Book("The Alchemist", "Paulo Coelho", "9780060834838");
		
		//displaying library name
		obj.displayLibraryName();
		
		//displaying details
		obj.displayDetails(obj);
		
		
	}
}
