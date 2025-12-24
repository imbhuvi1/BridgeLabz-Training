package gcrcodebase.strings;

import java.util.Scanner;

public class SplitTextWithoutSplitAndCompare {

    // Method to find length of string without using length()
    static int findLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (RuntimeException e) {
            return count;
        }
    }

    // Method to split text into words without using split()
    static String[] customSplit(String text) {

        int len = findLength(text);

        //Count number of words
        int wordCount = 1;
        for (int i = 0; i < len; i++) {
            if (text.charAt(i) == ' ') {
                wordCount++;
            }
        }

        //Store indexes of spaces
        int[] spaceIndex = new int[wordCount + 1];
        int index = 0;
        spaceIndex[index++] = -1;

        for (int i = 0; i < len; i++) {
            if (text.charAt(i) == ' ') {
                spaceIndex[index++] = i;
            }
        }
        spaceIndex[index] = len;

        //Extract words using indexes
        String[] words = new String[wordCount];

        for (int i = 0; i < wordCount; i++) {
            String word = "";
            for (int j = spaceIndex[i] + 1; j < spaceIndex[i + 1]; j++) {
                word = word + text.charAt(j);
            }
            words[i] = word;
        }
        return words;
    }

    //Method to compare two string arrays
    static boolean compareArrays(String[] arr1, String[] arr2) {

        if (arr1.length != arr2.length) {
            return false;
        }

        for (int i = 0; i < arr1.length; i++) {
            if (!arr1[i].equals(arr2[i])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //Taking full text input
        System.out.print("Enter text: ");
        String input = sc.nextLine();

        //User-defined split
        String[] customWords = customSplit(input);

        //Built-in split
        String[] builtInWords = input.split(" ");

        //Compare results
        boolean result = compareArrays(customWords, builtInWords);

        //Display result
        System.out.println("Comparison result: " + result);

        sc.close();
    }
}

