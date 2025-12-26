package gcr_codebase.methods;

import java.util.*;
public class FindSmallestAndLargest {

	
	//method to find smallest and largest
	public static int[] findSmallestAndLargest(int number1, int number2, int number3) {
		int small = 0, large = 0;
		if(number1>number2 && number1>number3) {
			large = number1;
			if(number2<number3) {
				small = number2;
			}else {
				small = number3;
			}
		}else if(number2>number1 && number2>number3) {
			large = number2;
			if(number1<number3) {
				small = number1;
			}else {
				small = number3;
			}
		}else {
			large = number3;
			if(number2<number1) {
				small = number2;
			}else {
				small = number1;
			}
		}
		
		return new int[]{small, large};
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//taking input of three numbers;
		System.out.println("Enter three numbers: ");
		
		System.out.println("1: ");
		int number1 = sc.nextInt();
		
		System.out.println("2: ");
		int number2 = sc.nextInt();
		
		System.out.println("3: ");
		int number3 = sc.nextInt();
		
		//calling method
		int result[] = findSmallestAndLargest(number1, number2, number3);
		System.out.println("The smallest number is "+result[0]+" and the largest number is "+result[1]);
		
		sc.close();
	}

}
