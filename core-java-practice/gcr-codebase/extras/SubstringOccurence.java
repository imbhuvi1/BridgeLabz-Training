package gcr_codebase.extras;
import java.util.Scanner;

public class SubstringOccurence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the main string: ");
        String mainStr = sc.nextLine();

        System.out.println("Enter the sub-string: ");
        String subStr = sc.nextLine();

        int count = 0;
        int mainLength = mainStr.length();
        int subLength = subStr.length();

        // Loop through main string
        for (int i = 0; i <= mainLength - subLength; i++) {
            boolean match = true;

            // Check character by character
            for (int j = 0; j < subLength; j++) {
                if (mainStr.charAt(i + j) != subStr.charAt(j)) {
                    match = false;
                    break;
                }
            }

            if (match) {
                count++;
            }
        }

        System.out.println("The substring occurs " + count + " times.");
        sc.close();
    }
}