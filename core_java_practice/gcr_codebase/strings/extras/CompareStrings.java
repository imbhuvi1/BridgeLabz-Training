package gcr_codebase.strings.extras;

import java.util.*;
public class CompareStrings {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter first string: ");
		String firstStr = sc.nextLine();
		
		System.out.println("Enter second string: ");
		String secondStr = sc.nextLine();
		
		int ans = firstStr.compareTo(secondStr);
		
		if(ans < 0) {
			System.out.println(firstStr + " comes before " + secondStr + " in lexicographical order");
		}
		
		else if(ans > 0) {
			System.out.println(secondStr + " comes before " + firstStr + " in lexicographical order");
		}
		
		else {
			System.out.println("Both Strings are equal");
		}
		sc.close();
		
	}
}