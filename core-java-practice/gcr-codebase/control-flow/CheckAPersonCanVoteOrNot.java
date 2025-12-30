package gcr_codebase.control_flow;

import java.util.Scanner;
public class CheckAPersonCanVoteOrNot {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

        // Taking age as input
        System.out.print("Enter age of the person: ");
        int age = sc.nextInt();

        // Checking voting eligibility
        if (age >= 18) {
            System.out.println("The person age is " + age + " and can vote.");
        } else {
            System.out.println("The person's age is " + age + " and cannot vote.");
        }
        sc.close();
	}

}
