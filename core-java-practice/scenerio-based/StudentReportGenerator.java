package scenerio_based;

import java.util.*;

// Custom exception for invalid marks
class InvalidMarkException extends Exception {
    public InvalidMarkException(String message) {
        super(message);
    }
}

// Student class to hold marks and name
class Student {
    private String name;
    private String[] subjects;
    private int[] marks;

    // Constructor initializes name, subjects and marks array
    public Student(String name, String[] subjects) {
        this.name = name;
        this.subjects = subjects;
        this.marks = new int[subjects.length];
    }

    // Setter for marks with validation
    public void setMark(int index, int mark) throws InvalidMarkException {
        if (mark < 0 || mark > 100) {
            throw new InvalidMarkException("Mark must be between 0 and 100");
        }
        marks[index] = mark;
    }

    // Calculate average marks
    public double calculateAverage() {
        int total = 0;
        for (int mark : marks) {
            total += mark;
        }
        return (double) total / marks.length;
    }

    // Assign grade based on average
    public String getGrade() {
        double avg = calculateAverage();
        if (avg >= 90) return "A";
        else if (avg >= 75) return "B";
        else if (avg >= 60) return "C";
        else if (avg >= 50) return "D";
        else return "F";
    }

    // Display formatted report card
    public void displayReport() {
        System.out.println("Report Card for: " + name);
        System.out.println("");
        System.out.printf("%-15s %s%n", "Subject", "Marks");
        System.out.println("");
        for (int i = 0; i < subjects.length; i++) {
            System.out.printf("%-15s %3d%n", subjects[i], marks[i]);
        }
        System.out.println("");
        System.out.printf("Average Marks: %.2f%n", calculateAverage());
        System.out.println("Grade: " + getGrade());
        System.out.println();
    }
}

// Main class to manage multiple students and input
public class StudentReportGenerator {

    private static Scanner sc = new Scanner(System.in);
    private static List<Student> students = new ArrayList<>();

    public static void main(String[] args) {

        System.out.print("Enter number of students: ");
        int n = Integer.parseInt(sc.nextLine());

        String[] subjects = {"Math", "Physics", "Chemistry", "English", "History"};

        for (int i = 0; i < n; i++) {
            System.out.print("\nEnter name of student " + (i + 1) + ": ");
            String name = sc.nextLine();

            Student student = new Student(name, subjects);

            // Input marks with validation
            for (int j = 0; j < subjects.length; j++) {
                while (true) {
                    try {
                        System.out.print("Enter marks for " + subjects[j] + ": ");
                        int mark = Integer.parseInt(sc.nextLine());
                        student.setMark(j, mark);
                        break;
                    } catch (InvalidMarkException e) {
                        System.out.println("Error: " + e.getMessage());
                    } catch (NumberFormatException e) {
                        System.out.println("Error: Please enter a valid integer.");
                    }
                }
            }
            students.add(student);
        }

        System.out.println("\nAll Student Reports\n");
        for (Student s : students) {
            s.displayReport();
        }
    }
}
