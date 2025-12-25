package gcr_codebase.strings;

import java.util.Random;

public class VotingEligibility {

    // Generate random 2-digit ages
    static int[] generateAges(int n) {
        int[] ages = new int[n];
        Random r = new Random();

        for (int i = 0; i < n; i++) {
            ages[i] = r.nextInt(90) + 10;
        }
        return ages;
    }

    // Check voting eligibility
    static String[][] checkVoting(int[] ages) {
        String[][] result = new String[ages.length][2];

        for (int i = 0; i < ages.length; i++) {
            result[i][0] = String.valueOf(ages[i]);

            if (ages[i] < 0) {
                result[i][1] = "false";
            } else if (ages[i] >= 18) {
                result[i][1] = "true";
            } else {
                result[i][1] = "false";
            }
        }
        return result;
    }

    // Display table
    static void display(String[][] data) {
        System.out.println("Age\tCan Vote");

        for (String[] row : data) {
            System.out.println(row[0] + "\t" + row[1]);
        }
    }

    public static void main(String[] args) {
        int[] ages = generateAges(10);
        String[][] result = checkVoting(ages);
        display(result);
    }
}
