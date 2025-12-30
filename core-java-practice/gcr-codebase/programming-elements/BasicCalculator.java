package gcr_codebase.programming_elements;

import java.util.*;
public class BasicCalculator {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//taking two numbers as input after creating two variables and storing user input value in it.
		System.out.println("Enter first number: ");
		double number1 = sc.nextDouble();
		
		System.out.println("Enter second number: ");
		double number2 = sc.nextDouble();
		
		//Performing addition, assigning value in a variable named additionOfTwoNumbers
		double additionOfTwoNumbers = number1 + number2;
		
		//Performing subtraction, assigning value in a variable named subtractionOfTwoNumbers
		double subtractionOfTwoNumbers = number1 - number2;
		
		//Performing division, assigning value in a variable named
		double divisionOfTwoNumbers = number1/number2;
		
		//Performing multiplication, assigning value in a variable named
		double multiplicationOfTwoNumbers = number1*number2;
		
		//Displaying additon, subraction, division, ultiplication
		System.out.printf("The addition, subtraction, multiplication, and division value of 2 numbers %s and %s is %s, %s, %s, and %s", number1, number2, additionOfTwoNumbers, subtractionOfTwoNumbers, multiplicationOfTwoNumbers, divisionOfTwoNumbers);
		
	}

}
