package gcr_codebase.stringbuffer_stringbuilder_filereader_inputstreamreader_linearsearch_binarysearch;

//Count Word Occurrences in a File

import java.io.*;

public class WordCount {

    public static void main(String[] args) {
        String target = "java";
        int count = 0;

        try (BufferedReader br = new BufferedReader(new FileReader("sample.txt"))) {

            String line;

            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");

                for (String word : words) {
                    if (word.equalsIgnoreCase(target)) {
                        count++;
                    }
                }
            }

            System.out.println("Word count: " + count);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
