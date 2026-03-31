
import java.util.Scanner;

public class ShortestAndLongestWord {

    // Method to find string length without using length()
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
    static String[] splitWords(String text) {

        int len = findLength(text);

        // Count number of words
        int wordCount = 1;
        for (int i = 0; i < len; i++) {
            if (text.charAt(i) == ' ') {
                wordCount++;
            }
        }

        // Store space indexes
        int[] spaceIndex = new int[wordCount + 1];
        int idx = 0;
        spaceIndex[idx++] = -1;

        for (int i = 0; i < len; i++) {
            if (text.charAt(i) == ' ') {
                spaceIndex[idx++] = i;
            }
        }
        spaceIndex[idx] = len;

        // Extract words
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

    // Method to create 2D array of word and its length
    static String[][] createWordLengthArray(String[] words) {

        String[][] result = new String[words.length][2];

        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(findLength(words[i]));
        }

        return result;
    }

    // Method to find shortest and longest word indexes
    static int[] findShortestAndLongest(String[][] wordLengthArray) {

        int minIndex = 0;
        int maxIndex = 0;

        int minLen = Integer.parseInt(wordLengthArray[0][1]);
        int maxLen = minLen;

        for (int i = 1; i < wordLengthArray.length; i++) {
            int currentLen = Integer.parseInt(wordLengthArray[i][1]);

            if (currentLen < minLen) {
                minLen = currentLen;
                minIndex = i;
            }

            if (currentLen > maxLen) {
                maxLen = currentLen;
                maxIndex = i;
            }
        }

        return new int[] { minIndex, maxIndex };
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Taking input
        System.out.print("Enter text: ");
        String input = sc.nextLine();

        // User-defined methods
        String[] words = splitWords(input);
        String[][] wordLengthArray = createWordLengthArray(words);
        int[] resultIndex = findShortestAndLongest(wordLengthArray);

        // Display result
        System.out.println("\nShortest Word: " + wordLengthArray[resultIndex[0]][0] + " (Length: "  + wordLengthArray[resultIndex[0]][1] + ")");

        System.out.println("Longest Word: " + wordLengthArray[resultIndex[1]][0]+ " (Length: " + wordLengthArray[resultIndex[1]][1] + ")");

        sc.close();
    }
}


