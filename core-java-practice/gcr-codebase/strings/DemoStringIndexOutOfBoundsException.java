
import java.util.*;
public class DemoStringIndexOutOfBoundsException {

    //Generate StringIndexOutOfBoundsException
    public static void generateException(String text) {
        System.out.println("Character at invalid index:");
        System.out.println(text.charAt(text.length()));
    }

    //Handle StringIndexOutOfBoundsException
    public static void handleException(String text) {
        try {
            System.out.println("Character at invalid index:");
            System.out.println(text.charAt(text.length())); // Exception occurs
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("StringIndexOutOfBoundsException handled.");
            System.out.println("Reason: " + e);
        }
    }

    // Main method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Take user input
        System.out.println("Enter a string:");
        String text = sc.next();

        // Call method to generate exception
        try {
            generateException(text);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Exception generated in generateException()");
        }

        // Call method to handle exception
        handleException(text);

        sc.close();
    }
}

