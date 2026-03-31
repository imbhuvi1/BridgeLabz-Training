package gcr_codebase.streams;

import java.io.*;

public class UppercaseToLowercase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String inputFile = "input.txt";
		String outputFile = "output.txt";
		try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
				BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
			String line;
			while ((line = br.readLine()) != null) {
				bw.write(line.toLowerCase());
				bw.newLine();
			}
		} catch (IOException e) {
			System.out.println("I/O Error: " + e.getMessage());
		}
	}

}