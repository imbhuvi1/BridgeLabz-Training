package gcr_codebase.stringbuffer_stringbuilder_filereader_inputstreamreader_linearsearch_binarysearch;

//Concatenate Strings using StringBuffer

public class StringBufferConcat {

    public static void main(String[] args) {
        String[] words = {"Java", " ", "is", " ", "powerful"};

        // Thread-safe mutable string
        StringBuffer sb = new StringBuffer();

        for (String word : words) {
            sb.append(word);
        }

        System.out.println("Concatenated String: " + sb.toString());
    }
}

