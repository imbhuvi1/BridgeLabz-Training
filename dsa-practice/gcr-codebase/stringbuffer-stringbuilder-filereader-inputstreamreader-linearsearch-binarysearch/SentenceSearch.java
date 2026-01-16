package gcr_codebase.stringbuffer_stringbuilder_filereader_inputstreamreader_linearsearch_binarysearch;

//Search Word in Sentences - linear search

public class SentenceSearch {

    public static String search(String[] sentences, String word) {

        for (String sentence : sentences) {
            if (sentence.contains(word)) {
                return sentence;
            }
        }
        return "Not Found";
    }

    public static void main(String[] args) {
        String[] sentences = {
                "Java is fun",
                "I love coding",
                "Data structures are important"
        };

        System.out.println(search(sentences, "coding"));
    }
}
