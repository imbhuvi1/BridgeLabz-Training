/*
1. Checked Exception (Compile-time Exception)
💡 Problem Statement:
Create a Java program that reads a file named "data.txt". If the file does not exist, handle the IOException properly and display a user-friendly message.
Expected Behavior:
If the file exists, print its contents.
If the file does not exist, catch the IOException and print "File not found".
*/

package gcr_codebase.exceptions;

import java.io.*;

public class FileReadExample {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("collections-practice/gcr_codebase/exceptions/data.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line); // Print file content
            }
        } catch (IOException e) {
            System.out.println("File not found"); // Handle missing file
        }
    }
}

