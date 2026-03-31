
import java.util.*;
public class NumberOfHandshakes {

    //Method to calculate maximum number of handshakes
    public static int calculateHandshakes(int numberOfStudents) {
        return (numberOfStudents * (numberOfStudents - 1)) / 2;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Taking user input
        System.out.print("Enter the number of students: ");
        int numberOfStudents = sc.nextInt();

        // Calculating handshakes
        int handshakes = calculateHandshakes(numberOfStudents);

        // Displaying output
        System.out.println("The maximum number of possible handshakes is: " + handshakes);

        sc.close();
    }
}

