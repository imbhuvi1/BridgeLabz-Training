package junit_practice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FileProcessorTest {

	FileProcessor fp;
	String fileName;

	@BeforeEach
	public void setUp() {
		fp = new FileProcessor();
		fileName = "file.txt";
	}

	@Test
	public void testWriteAndReadFile() throws IOException {
		String content = "Hello";

		fp.writeToFile(fileName, content);

		StringBuilder readContent = new StringBuilder();
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		String line;
		while ((line = br.readLine()) != null) {
			readContent.append(line);
		}
		assertEquals(content, readContent.toString());
		new File(fileName).delete();
	}

	@Test
	public void testFileExists() throws IOException {
		fp.writeToFile(fileName, "Hi");
		File file = new File(fileName);
		assertTrue(file.exists());
		file.delete();
	}

	@Test
	public void testNonExisitingFile() {
		assertThrows(IOException.class, () -> {
			fp.readFromFile("f.txt");
		});
	}
}