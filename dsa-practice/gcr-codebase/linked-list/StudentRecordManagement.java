import java.util.*;

// Node class representing each student record.
// Each node contains student details and a reference to the next node
class StudentNode {
    int rollNo;
    String name;
    int age;
    char grade;
    StudentNode next; // Pointer to next node

    // Constructor to initialize student data
    StudentNode(int rollNo, String name, int age, char grade) {
        this.rollNo = rollNo;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}

// Singly Linked List class to manage student records
class StudentLinkedList {
    StudentNode head; // Head pointer of the list

    // Add a new student record at the beginning
    void addAtBeginning(int rollNo, String name, int age, char grade) {
        StudentNode newNode = new StudentNode(rollNo, name, age, grade);
        newNode.next = head; // New node points to old head
        head = newNode;      // Head updated to new node
    }

    // Add a new student record at the end
    void addAtEnd(int rollNo, String name, int age, char grade) {
        StudentNode newNode = new StudentNode(rollNo, name, age, grade);

        // If list is empty, new node becomes head
        if (head == null) {
            head = newNode;
            return;
        }

        // Traverse till last node
        StudentNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        // Attach new node at the end
        temp.next = newNode;
    }

    // Add a student record at a specific position
    void addAtPosition(int position, int rollNo, String name, int age, char grade) {

        // If position is 1 or less, insert at beginning
        if (position <= 1) {
            addAtBeginning(rollNo, name, age, grade);
            return;
        }

        StudentNode newNode = new StudentNode(rollNo, name, age, grade);
        StudentNode temp = head;

        // Traverse to the node before the desired position
        for (int i = 1; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }

        // If position is invalid
        if (temp == null) {
            System.out.println("Invalid position!");
            return;
        }

        // Insert new node
        newNode.next = temp.next;
        temp.next = newNode;
    }

    // Delete a student record by Roll Number
    void deleteByRollNo(int rollNo) {

        // If list is empty
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }

        // If head node needs to be deleted
        if (head.rollNo == rollNo) {
            head = head.next;
            System.out.println("Student deleted successfully.");
            return;
        }

        // Search for the node to be deleted
        StudentNode temp = head;
        while (temp.next != null && temp.next.rollNo != rollNo) {
            temp = temp.next;
        }

        // If student not found
        if (temp.next == null) {
            System.out.println("Student not found!");
        } else {
            // Skip the node to delete it
            temp.next = temp.next.next;
            System.out.println("Student deleted successfully.");
        }
    }

    // Search for a student record by Roll Number
    void searchByRollNo(int rollNo) {
        StudentNode temp = head;

        // Traverse the list
        while (temp != null) {
            if (temp.rollNo == rollNo) {
                System.out.println("Student Found:");
                displayStudent(temp);
                return;
            }
            temp = temp.next;
        }

        System.out.println("Student not found!");
    }

    // Update student grade using Roll Number
    void updateGrade(int rollNo, char newGrade) {
        StudentNode temp = head;

        // Traverse and update grade
        while (temp != null) {
            if (temp.rollNo == rollNo) {
                temp.grade = newGrade;
                System.out.println("Grade updated successfully.");
                return;
            }
            temp = temp.next;
        }

        System.out.println("Student not found!");
    }

    // Display all student records
    void displayAll() {
        if (head == null) {
            System.out.println("No student records available.");
            return;
        }

        StudentNode temp = head;
        while (temp != null) {
            displayStudent(temp);
            temp = temp.next;
        }
    }

    // Display details of a single student
    void displayStudent(StudentNode s) {
        System.out.println("");
        System.out.println("Roll No : " + s.rollNo);
        System.out.println("Name    : " + s.name);
        System.out.println("Age     : " + s.age);
        System.out.println("Grade   : " + s.grade);
    }
}

//Main class 
public class StudentRecordManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentLinkedList list = new StudentLinkedList();

        // Menu-driven loop
        while (true) {
            System.out.println("\n--- Student Record Management ---");
            System.out.println("1. Add at Beginning");
            System.out.println("2. Add at End");
            System.out.println("3. Add at Position");
            System.out.println("4. Delete by Roll No");
            System.out.println("5. Search by Roll No");
            System.out.println("6. Update Grade");
            System.out.println("7. Display All");
            System.out.println("8. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Roll No Name Age Grade: ");
                    list.addAtBeginning(sc.nextInt(), sc.next(), sc.nextInt(), sc.next().charAt(0));
                    break;

                case 2:
                    System.out.print("Roll No Name Age Grade: ");
                    list.addAtEnd(sc.nextInt(), sc.next(), sc.nextInt(), sc.next().charAt(0));
                    break;

                case 3:
                    System.out.print("Position Roll No Name Age Grade: ");
                    int pos = sc.nextInt();
                    list.addAtPosition(pos, sc.nextInt(), sc.next(), sc.nextInt(), sc.next().charAt(0));
                    break;

                case 4:
                    System.out.print("Enter Roll No to delete: ");
                    list.deleteByRollNo(sc.nextInt());
                    break;

                case 5:
                    System.out.print("Enter Roll No to search: ");
                    list.searchByRollNo(sc.nextInt());
                    break;

                case 6:
                    System.out.print("Enter Roll No and New Grade: ");
                    list.updateGrade(sc.nextInt(), sc.next().charAt(0));
                    break;

                case 7:
                    list.displayAll();
                    break;

                case 8:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
