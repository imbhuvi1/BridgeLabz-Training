package sceneriobased;

import java.util.*;

public class ElectionBoothManager {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int vote1 =0,vote2 = 0,vote3 = 0;
		
		while(true) {
			
			//take input age
			System.out.println("Enter the age or -1 to exit: ");
			int age = sc.nextInt();
			
			if(age == -1) {
				System.out.println("Voting ended.");
				break;
			}
			
			if(age>=18) {
				System.out.println("Eligible to vote");
				System.out.println("Choose a number to give vote to respective candidate");
				System.out.println("1 : Narendra-BJP");
				System.out.println("2 : Rahul-Congress");
				System.out.println("3 : Arvind-AAP");
				
				int vote = sc.nextInt();
				
				if(vote == 1) {
					vote1++;
				}else if(vote == 2) {
					vote2++;
				}else if(vote == 3) {
					vote3++;
				}else {
					System.out.println("Not voted. Choose your candidate again.");
				}
			}else {
				System.out.println("Not eligible to vote !");
			}
			
		}
		
		System.out.println("Candidate A's votes: "+vote1);
		System.out.println("Candidate B's votes: "+vote2);
		System.out.println("Candidate B's votes: "+vote3);
		
		sc.close();
	}
}
