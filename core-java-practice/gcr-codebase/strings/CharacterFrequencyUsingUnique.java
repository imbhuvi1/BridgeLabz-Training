
import java.util.Scanner;

public class CharacterFrequencyUsingUnique {

    // Method to find unique characters using nested loops
    public static char[] findUniqueCharacters(String text) {
        int length = text.length();
        char[] temp = new char[length];
        int uniqueCount = 0;

        for (int i=0; i<length; i++) {
            char current = text.charAt(i);
            boolean isUnique = true;

            for (int j=0; j<i; j++) {
                if (current == text.charAt(j)) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) {
                temp[uniqueCount] = current;
                uniqueCount++;
            }
        }

        // Create exact size array
        char[] uniqueChars = new char[uniqueCount];
        for (int i=0; i<uniqueCount; i++) {
            uniqueChars[i] = temp[i];
        }

        return uniqueChars;
    }

    // Method to find frequency using unique characters
    public static String[][] findFrequency(String text) {

        int[] frequency = new int[256]; // ASCII characters

        // Count frequency of characters
        for (int i=0; i<text.length(); i++) {
            char ch = text.charAt(i);
            frequency[ch]++;
        }

        // Get unique characters
        char[] uniqueChars = findUniqueCharacters(text);

        // Create 2D String array
        String[][] result = new String[uniqueChars.length][2];

        for (int i=0; i<uniqueChars.length; i++) {
            result[i][0] = String.valueOf(uniqueChars[i]);
            result[i][1] = String.valueOf(frequency[uniqueChars[i]]);
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the text: ");
        String input = sc.nextLine();

        String[][] output = findFrequency(input);

        System.out.println("\nCharacter\tFrequency");

        for (int i = 0; i < output.length; i++) {
            System.out.println(output[i][0] + "\t\t" + output[i][1]);
        }

        sc.close();
    }
}
