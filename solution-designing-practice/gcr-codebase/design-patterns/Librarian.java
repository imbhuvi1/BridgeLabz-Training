package gcr_codebase.design_patterns;

class Librarian implements User {

	@Override
	public String getRole() {
		// TODO Auto-generated method stub
		return "Librarian";
	}

	@Override
	public void notify(Book book) {
		System.out.println("Librarian notified: " + book.getTitle());
	}
}