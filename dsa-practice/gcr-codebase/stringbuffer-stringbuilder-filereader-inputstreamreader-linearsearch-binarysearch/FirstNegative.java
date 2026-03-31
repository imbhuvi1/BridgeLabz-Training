package gcr_codebase.stringbuffer_stringbuilder_filereader_inputstreamreader_linearsearch_binarysearch;

//First Negative Number - linear search

public class FirstNegative {

    public static int findFirstNegative(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                return i; // return immediately
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 7, -2, 6};
        System.out.println(findFirstNegative(arr));
    }
}
