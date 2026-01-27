package gcr_codebase.streams;

import java.io.*;

public class BufferedStreams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String sourceFile = "largefile.dat";
		String unbufferedFile = "destination.txt";
		String bufferedFile = "destination1.txt";
		int bufferSize = 4096;
		byte[] buffer = new byte[bufferSize];
		long startTime = System.nanoTime();
		try (FileInputStream fis = new FileInputStream(sourceFile);
				FileOutputStream fos = new FileOutputStream(unbufferedFile)) {

			int bytesRead;
			while ((bytesRead = fis.read(buffer)) != -1) {
				fos.write(buffer, 0, bytesRead);
			}

		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}
		long endTime = System.nanoTime();
		System.out.println("Unbuffered Stream Time: " + (endTime - startTime) + " ns");
		startTime = System.nanoTime();
		try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(sourceFile));
				BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(bufferedFile))) {
			int bytesRead;
			while ((bytesRead = bis.read(buffer)) != -1) {
				bos.write(buffer, 0, bytesRead);
			}

		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}

		endTime = System.nanoTime();
		System.out.println("Buffered Stream Time: " + (endTime - startTime) + " ns");
	}

}
