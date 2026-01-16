package gcr_codebase.stringbuffer_stringbuilder_filereader_inputstreamreader_linearsearch_binarysearch;

//Reverse a String using StringBuilder

public class ReverseStringSB {

    public static void main(String[] args) {
        String input = "hello";

        // StringBuilder is used because strings are mutable here
        StringBuilder sb = new StringBuilder(input);

        // reverse() is an in-built efficient method
        sb.reverse();

        // Convert back to String
        String reversed = sb.toString();

        System.out.println("Reversed String: " + reversed);
    }
}
