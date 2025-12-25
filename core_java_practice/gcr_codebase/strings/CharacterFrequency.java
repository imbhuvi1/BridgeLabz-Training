package gcr_codebase.strings;

import java.util.Scanner;

public class CharacterFrequency {

    // Method to find frequency of characters and return as 2D array
    public static Object[][] findCharacterFrequency(String text) {

        int[] frequency = new int[256]; 
        // Count frequency of each character
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            frequency[ch]++;
        }

        // Count unique characters
        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            if (frequency[text.charAt(i)] > 0) {
                count++;
                frequency[text.charAt(i)] = -frequency[text.charAt(i)];
            }
        }

        // Reset frequency values to positive
        for (int i = 0; i < 256; i++) {
            if (frequency[i] < 0) {
                frequency[i] = -frequency[i];
            }
        }

        // Create 2D array to store characters and frequencies
        Object[][] result = new Object[count][2];
        int index = 0;

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (frequency[ch] > 0) {
                result[index][0] = ch;
                result[index][1] = frequency[ch];
                frequency[ch] = 0;
                index++;
            }
        }

        return result;
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the text: ");
        String input = sc.nextLine();

        Object[][] frequencies = findCharacterFrequency(input);

        System.out.println("\nCharacter\tFrequency");

        for (int i = 0; i < frequencies.length; i++) {
            System.out.println(frequencies[i][0] + "\t\t" + frequencies[i][1]);
        }

        sc.close();
    }
}
