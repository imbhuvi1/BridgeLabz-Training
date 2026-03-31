/*
3. Custom Exception (User-defined Exception)
💡 Problem Statement:
Create a custom exception called InvalidAgeException.
Write a method validateAge(int age) that throws InvalidAgeException if the age is below 18.
In main(), take user input and call validateAge().
If an exception occurs, display "Age must be 18 or above".
Expected Behavior:
If the age is >=18, print "Access granted!".
If age <18, throw InvalidAgeException and display the message.

*/

package gcr_codebase.exceptions;

import java.util.*;

class InvalidAgeException extends Exception {
    InvalidAgeException(String msg) {
        super(msg);
    }
}

public class AgeValidator {

    static void validateAge(int age) throws InvalidAgeException {
        if (age < 18) throw new InvalidAgeException("Age must be 18 or above");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int age = sc.nextInt();

        try {
            validateAge(age);
            System.out.println("Access granted!");
        } catch (InvalidAgeException e) {
            System.out.println(e.getMessage());
        }
    }
}
