package junit_practice;

public class PasswordValidator {
	public boolean isValid(String password) {
		String regex = "^(?=.*[A-Z])(?=.*\\d).{8,}$";
		if (password == null) {
			return false;
		}
		return password.matches(regex);
	}
}
