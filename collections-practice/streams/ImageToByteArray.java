package gcr_codebase.streams;

import java.io.*;

public class ImageToByteArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String originalFile = "original.jpg";
		String newFile = "copy.jpg";
		try {
			File file = new File(originalFile);
			byte[] fileBytes = new byte[(int) file.length()];
			try (FileInputStream fis = new FileInputStream(file)) {
				fis.read(fileBytes);
			}
			byte[] copiedBytes;
			try (ByteArrayInputStream bais = new ByteArrayInputStream(fileBytes);
					ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
				int b;
				while ((b = bais.read()) != -1) {
					baos.write(b);
				}
				copiedBytes = baos.toByteArray();
			}
			try (FileOutputStream fos = new FileOutputStream(newFile)) {
				fos.write(copiedBytes);
			}
		} catch (IOException e) {
			System.out.println(e);
		}
	}

}
