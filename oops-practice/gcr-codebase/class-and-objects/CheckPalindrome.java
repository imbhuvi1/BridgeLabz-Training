class PalindromeChecker {
	String text;

	PalindromeChecker(String text) {
		this.text = text;
	}

	public boolean isPalindrome() {
		int start = 0;
		int end = text.length() - 1;
		String s = text.toLowerCase();
		while (start < end) {
			if (s.charAt(start) == ' ') {
				start++;
				continue;
			}
			if (s.charAt(end) == ' ') {
				end--;
				continue;
			}
			if (s.charAt(start) != s.charAt(end)) {
				return false;
			}
			start++;
			end--;
		}
		return true;
	}

	public void checkIsPalindrome() {
		if (isPalindrome()) {
			System.out.println(text + " is palindrome");
		} else {
			System.out.println(text + " is not Palindrome");
		}
	}
}

public class CheckPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PalindromeChecker pc1 = new PalindromeChecker("A man a plan a canal Panama");
		PalindromeChecker pc2 = new PalindromeChecker("Hello");

		pc1.checkIsPalindrome();
		pc2.checkIsPalindrome();
	}

}