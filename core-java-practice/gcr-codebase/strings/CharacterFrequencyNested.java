
import java.util.Scanner;

public class CharacterFrequencyNested {

    // Method to find character frequency using nested loops
    public static String[] findFrequency(String text) {

        char[] chars = text.toCharArray();
        int length = chars.length;
        int[] freq = new int[length];

        // Initialize frequency
        for (int i = 0; i < length; i++) {
            freq[i] = 1;
        }

        // Nested loops to calculate frequency
        for (int i = 0; i < length; i++) {
            if (chars[i] == '0') {
                continue;
            }

            for (int j = i + 1; j < length; j++) {
                if (chars[i] == chars[j]) {
                    freq[i]++;
                    chars[j] = '0'; // mark duplicate
                }
            }
        }

        // Count valid characters
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (chars[i] != '0') {
                count++;
            }
        }

        // Create 1D String array to store result
        String[] result = new String[count];
        int index = 0;

        for (int i = 0; i < length; i++) {
            if (chars[i] != '0') {
                result[index] = chars[i] + " : " + freq[i];
                index++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the text: ");
        String input = sc.nextLine();

        String[] output = findFrequency(input);

        System.out.println("\nCharacter Frequency:");

        for (int i = 0; i < output.length; i++) {
            System.out.println(output[i]);
        }

        sc.close();
    }
}
