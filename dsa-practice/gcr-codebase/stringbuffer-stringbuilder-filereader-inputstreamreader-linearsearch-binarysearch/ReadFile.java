package gcr_codebase.stringbuffer_stringbuilder_filereader_inputstreamreader_linearsearch_binarysearch;

//Read File Line by Line

import java.io.*;

public class ReadFile {

    public static void main(String[] args) {

        try (BufferedReader br = new BufferedReader(new FileReader("sample.txt"))) {

            String line;

            // Read file line by line
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
