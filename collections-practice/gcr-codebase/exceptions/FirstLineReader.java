package gcr_codebase.exceptions;

import java.io.*;

public class FirstLineReader {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("collections-practice/gcr_codebase/exceptions/data.txt"))) {
            System.out.println(br.readLine()); // Read first line
        } catch (IOException e) {
            System.out.println("Error reading file");
        }
    }
}
