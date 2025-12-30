package gcr_codebase.extras;

import java.util.*;
public class PalindromicStringCheck {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the string: ");
		String str = sc.next();
		
		System.out.println(palindromeCheck(str));
		sc.close();
	}
	
	public static boolean palindromeCheck(String str) {
		
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) != str.charAt(str.length() - i - 1)) return false;
		}
		
		return true;
	}
}
