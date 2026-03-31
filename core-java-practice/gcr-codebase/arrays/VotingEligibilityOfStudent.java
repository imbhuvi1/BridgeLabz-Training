
import java.util.*;
public class VotingEligibilityOfStudent {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//creating an array where each element indicate age of 10 students
		int[] arrayOfAge = new int[10];
		
		//taking user input of age of 10 students
		System.out.println("Enter the age of 10 students: ");
		for(int i=0; i<10; i++) {
			arrayOfAge[i] = sc.nextInt();
		}
		
		//logic
		for(int i=0; i<arrayOfAge.length; i++) {
			if(arrayOfAge[i]<0) {
				System.err.println("Invalid Age");
				System.exit(0);
			}else if(arrayOfAge[i]>=18) {
				System.out.printf("The student with the age %s can vote.", arrayOfAge[i]);
				System.out.println();
			}else {
				System.out.printf("The student with the age %s cannot vote.", arrayOfAge[i]);
				System.out.println();
			}
		}
		
	}
}
