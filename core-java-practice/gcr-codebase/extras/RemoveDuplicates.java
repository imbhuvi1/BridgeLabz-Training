package gcr_codebase.extras;

import java.util.*;
public class RemoveDuplicates {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the string: ");
		String str = sc.next();
		
		Set<Character> set = new HashSet<>();
		
		StringBuilder ansString = new StringBuilder();
		
		for(char c : str.toCharArray()) {
			if(set.add(c)) {
				ansString.append(c);
			}
			
		}
		System.out.println(ansString.toString());
		sc.close();
	}
}
