package gcr_codebase.strings.extras;

import java.util.*;
public class RemoveSpecificCharacter {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the string: ");
		String str = sc.next();
		char character = sc.next().charAt(0);
		
		StringBuilder sb = new StringBuilder();
		
		for(char ch : str.toCharArray()) {
			if(ch != character) {
				sb.append(ch);
			}
		}
		
		System.out.println(sb.toString());
		sc.close();
	}
}
