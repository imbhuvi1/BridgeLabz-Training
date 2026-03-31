package gcr_codebase.functional_interface;

interface SecurityUtils {
	static boolean isValid(String password) {
		if(password == null || password.isEmpty()) {
			return false;
		}
		String passwordRegex = ".*[A-Z].*" + ".*[a-z].*" + ".*\\d.*";
		return password.length() >= 8 && password.matches(passwordRegex);
	}
}


public class PasswordLengthValidator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String passwords[] = {"pass1234", "Password1234", "WeakPass", "Small"};
		for(String pass : passwords) {
			System.out.println(SecurityUtils.isValid(pass));
		}
	}

}
