package gcrcodebase.controlflow;

import java.util.Scanner;
public class CheckNaturalNumberAndFindSum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

        // Taking input from the user
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        // Checking whether the number is a natural number
        if (number > 0) {
            int sum = number * (number + 1) / 2; //formula
            System.out.printf("The sum of %s natural numbers is %s",number, sum);
        } else {
            System.out.printf("The number %s is not a natural number",number);
        }
        sc.close();
	}

}
