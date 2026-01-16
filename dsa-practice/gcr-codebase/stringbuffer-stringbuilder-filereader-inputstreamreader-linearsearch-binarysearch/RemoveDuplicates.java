package gcr_codebase.stringbuffer_stringbuilder_filereader_inputstreamreader_linearsearch_binarysearch;

//Remove Duplicates from String using StringBuilder

import java.util.HashSet;

public class RemoveDuplicates {

    public static void main(String[] args) {
        String input = "programming";
        HashSet<Character> seen = new HashSet<>();
        StringBuilder result = new StringBuilder();

        // Loop through each character
        for (char ch : input.toCharArray()) {

            // If character is not already seen, add it
            if (!seen.contains(ch)) {
                seen.add(ch);
                result.append(ch);
            }
        }

        System.out.println("Without duplicates: " + result.toString());
    }
}
