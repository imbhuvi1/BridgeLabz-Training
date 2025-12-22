package gcrcodebase.strings;


import java.util.*;
public class CompareStrings {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//taking two strings as input
		System.out.println("Enter first string: ");
		String string1 = sc.next();
		
		System.out.println("Enter second string: ");
		String string2 = sc.next();
		
		//comparing using "charAt"
		if(string1.length()!=string2.length()) {
			System.out.printf("%s and %s are not equal (Using either 'charAt' or 'equals')",string1, string2);
		}else {
			boolean flag = true;
			for(int i=0; i<string1.length(); i++) {
				if(string1.charAt(i)!=string2.charAt(i)) {
					System.out.printf("%s and %s are not equal(Using 'charAt')",string1, string2);
					flag = false;
					break;
				}
			}
			if(flag) {
				System.out.printf("%s and %s are equal (Using 'charAt')",string1, string2);
			}
			
			System.out.println();
			//comparing using "equals"
			
			if(string1.equals(string2)) {
				System.out.printf("%s and %s are equal (Using 'equals')",string1, string2);
			}else {
				System.out.printf("%s and %s are not equal (Using 'equals')",string1, string2);
			}
		}
	}

}
