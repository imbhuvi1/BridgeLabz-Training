package gcr_codebase.streams;

import java.io.*;

public class DataStreams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fileName = "students.dat";
		try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName))) {
			int[] rollNumbers = { 101, 102, 103 };
			String[] names = { "Akash", "Govind", "Nitai" };
			double[] gpas = { 9.2, 9.5, 9.1 };
			for (int i = 0; i < rollNumbers.length; i++) {
				dos.writeInt(rollNumbers[i]);
				dos.writeUTF(names[i]);
				dos.writeDouble(gpas[i]);
			}
		} catch (IOException e) {
			System.out.println(e);
		}
		try (DataInputStream dis = new DataInputStream(new FileInputStream(fileName))) {
			System.out.println("Student Details:");
			for (int i = 0; i < 3; i++) {
				int roll = dis.readInt();
				String name = dis.readUTF();
				double gpa = dis.readDouble();
				System.out.println("Roll: " + roll + " Name: " + name + " GPA: " + gpa);
			}
		} catch (IOException e) {
			System.out.println(e);
		}
	}

}