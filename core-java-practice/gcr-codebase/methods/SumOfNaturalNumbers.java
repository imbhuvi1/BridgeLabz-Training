
import java.util.*;

public class SumOfNaturalNumbers {

	//Method to return sum of 
	public static int getSum(int number) {
		int sum = 0;
		for(int i=1; i<=number; i++) {
			sum+=i;
		}
		return sum;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//taking input
		System.out.println("Enter the number: ");
		int number = sc.nextInt();
		
		System.out.println("The sum of the natural number "+number+" is: "+getSum(number));
		
		sc.close();
	}

}
