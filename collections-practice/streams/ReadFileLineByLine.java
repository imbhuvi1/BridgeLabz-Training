package gcr_codebase.streams;

import java.io.*;

public class ReadFileLineByLine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fileName = "largefile.txt";
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			String line;
			while ((line = br.readLine()) != null) {
				if (line.toLowerCase().contains("error")) {
					System.out.println(line);
				}
			}
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}