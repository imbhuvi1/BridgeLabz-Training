
import java.util.Scanner;

public class FindVowelConsonantCount {

    // Method to check if character is vowel or consonant
    static String checkCharacter(char ch) {

        // Convert uppercase to lowercase using ASCII
        if (ch>='A' && ch<='Z') {
            ch=(char)(ch + 32);
        }

        // Check if alphabet
        if (ch>='a' && ch<='z') {

            // Check for vowels
            if (ch=='a' || ch=='e' || ch=='i' || 
                ch=='o' || ch=='u') {
                return "Vowel";
            } else {
                return "Consonant";
            }
        }

        return "Not a Letter";
    }

    // Method to count vowels and consonants using charAt()
    static int[] countVowelsAndConsonants(String text) {

        int vowels = 0;
        int consonants = 0;

        for (int i = 0; i < text.length(); i++) {
            String result = checkCharacter(text.charAt(i));

            if (result.equals("Vowel")) {
                vowels++;
            } else if (result.equals("Consonant")) {
                consonants++;
            }
        }

        return new int[]{vowels, consonants};
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Taking input
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        // Calling method
        int[] count = countVowelsAndConsonants(input);

        // Displaying result
        System.out.println("Number of Vowels: " + count[0]);
        System.out.println("Number of Consonants: " + count[1]);

        sc.close();
    }
}
