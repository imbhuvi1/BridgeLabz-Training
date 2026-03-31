package gcr_codebase.design_patterns;

class UserFactory {
	public static User createUser(String type) {
		switch (type.trim().toLowerCase()) {
		case "student" -> {
			return new Student();
		}
		case "faculty" -> {
			return new Faculty();
		}
		case "librarian" -> {
			return new Librarian();
		}
		default -> {
			throw new IllegalArgumentException("Invalid role");
		}
		}
	}
}
