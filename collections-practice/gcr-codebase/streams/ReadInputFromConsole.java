package gcr_codebase.streams;

import java.io.*;

public class ReadInputFromConsole {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fileName = "user.txt";
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				FileWriter fw = new FileWriter(fileName);) {
			System.out.print("Enter your name");
			String name = br.readLine();
			System.out.print("Enter your age");
			String age = br.readLine();
			System.out.print("Enter your favorite programming language");
			String language = br.readLine();
			fw.write("Name: " + name + "\n");
			fw.write("Age: " + age + "\n");
			fw.write("Favorite Programming Language: " + language + "\n");
		} catch (IOException e) {
			System.out.println(e);
		}
	}

}