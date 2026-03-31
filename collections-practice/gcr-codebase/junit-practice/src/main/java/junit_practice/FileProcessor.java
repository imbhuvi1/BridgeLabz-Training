package junit_practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileProcessor {

	public void writeToFile(String fileName, String content) throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
		bw.write(content);
		bw.close();
	}

	public String readFromFile(String fileName) throws IOException {
		StringBuilder content = new StringBuilder();
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		String line;
		while ((line = br.readLine()) != null) {
			content.append(line);
		}
		br.close();
		return content.toString();
	}

}
