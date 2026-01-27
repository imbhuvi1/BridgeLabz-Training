package gcr_codebase.streams;

import java.io.*;

public class ReadAndWriteTextFile {
	public static void main(String[] args) {

		String sourceFile = "source.txt";
		String destinationFile = "destination.txt";

		try (FileInputStream fis = new FileInputStream(sourceFile);
				FileOutputStream fos = new FileOutputStream(destinationFile);) {

			int data;
			while ((data = fis.read()) != -1) {
				fos.write(data);
			}

			System.out.println("File copied.");
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}