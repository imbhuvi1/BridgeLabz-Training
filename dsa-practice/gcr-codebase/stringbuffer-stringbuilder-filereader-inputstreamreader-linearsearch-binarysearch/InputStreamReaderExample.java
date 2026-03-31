package gcr_codebase.stringbuffer_stringbuilder_filereader_inputstreamreader_linearsearch_binarysearch;

//Convert Byte Stream to Character Stream

import java.io.*;
import java.nio.charset.StandardCharsets;

public class InputStreamReaderExample {

    public static void main(String[] args) {

        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream("sample.txt"),
                        StandardCharsets.UTF_8))) {

            String line;

            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

