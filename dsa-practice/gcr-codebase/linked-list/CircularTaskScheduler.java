package gcr_codebase.linked_list;

import java.util.*;

// Node class representing a Task
class TaskNode {
	int taskId;
	String taskName;
	int priority;
	String dueDate;

	TaskNode next; // pointer to next task

	// constructor to initialize task details
	public TaskNode(int taskId, String taskName, int priority, String dueDate) {
		this.taskId = taskId;
		this.taskName = taskName;
		this.priority = priority;
		this.dueDate = dueDate;
		this.next = null;
	}
}

// Circular Linked List class
class TaskScheduler {
	TaskNode head = null;
	TaskNode current = null; // to track current task

	// Add task at beginning
	void addAtBeginning(int id, String name, int priority, String date) {
		TaskNode newNode = new TaskNode(id, name, priority, date);

		// if list is empty
		if (head == null) {
			head = newNode;
			newNode.next = head; // circular link
			current = head;
			return;
		}

		// find last node
		TaskNode temp = head;
		while (temp.next != head) {
			temp = temp.next;
		}

		newNode.next = head;
		temp.next = newNode;
		head = newNode;
	}

	// Add task at end
	void addAtEnd(int id, String name, int priority, String date) {
		TaskNode newNode = new TaskNode(id, name, priority, date);

		// if list is empty
		if (head == null) {
			head = newNode;
			newNode.next = head;
			current = head;
			return;
		}

		// traverse till last node
		TaskNode temp = head;
		while (temp.next != head) {
			temp = temp.next;
		}

		temp.next = newNode;
		newNode.next = head;
	}

	// Add task at specific position
	void addAtPosition(int pos, int id, String name, int priority, String date) {

		if (pos == 1) {
			addAtBeginning(id, name, priority, date);
			return;
		}

		TaskNode newNode = new TaskNode(id, name, priority, date);
		TaskNode temp = head;

		for (int i = 1; i < pos - 1 && temp.next != head; i++) {
			temp = temp.next;
		}

		newNode.next = temp.next;
		temp.next = newNode;
	}

	// Remove task by taskId
	void removeTask(int id) {

		if (head == null) {
			System.out.println("List is empty.");
			return;
		}

		TaskNode temp = head;
		TaskNode prev = null;

		// if head needs to be removed
		if (head.taskId == id) {

			// only one node
			if (head.next == head) {
				head = null;
				current = null;
				return;
			}

			// find last node
			while (temp.next != head) {
				temp = temp.next;
			}

			temp.next = head.next;
			head = head.next;
			current = head;
			return;
		}

		// removing non-head node
		prev = head;
		temp = head.next;

		while (temp != head) {
			if (temp.taskId == id) {
				prev.next = temp.next;
				return;
			}
			prev = temp;
			temp = temp.next;
		}

		System.out.println("Task not found.");
	}

	// View current task and move to next task
	void viewCurrentTask() {

		if (current == null) {
			System.out.println("No tasks available.");
			return;
		}

		System.out.println("\nCurrent Task:");
		displayTask(current);

		// move to next task
		current = current.next;
	}

	// Display all tasks starting from head
	void displayAllTasks() {

		if (head == null) {
			System.out.println("No tasks to display.");
			return;
		}

		TaskNode temp = head;

		do {
			displayTask(temp);
			temp = temp.next;
		} while (temp != head);
	}

	// Search task by priority
	void searchByPriority(int priority) {

		if (head == null) {
			System.out.println("No tasks available.");
			return;
		}

		TaskNode temp = head;
		boolean found = false;

		do {
			if (temp.priority == priority) {
				displayTask(temp);
				found = true;
			}
			temp = temp.next;
		} while (temp != head);

		if (!found) {
			System.out.println("No task found with given priority.");
		}
	}

	// Helper method to display task details
	void displayTask(TaskNode t) {
		System.out.println("----------------------");
		System.out.println("Task ID   : " + t.taskId);
		System.out.println("Task Name : " + t.taskName);
		System.out.println("Priority  : " + t.priority);
		System.out.println("Due Date  : " + t.dueDate);
	}
}

// Main class
public class CircularTaskScheduler {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		TaskScheduler scheduler = new TaskScheduler();
		int choice;

		do {
			System.out.println("\n===== TASK SCHEDULER MENU =====");
			System.out.println("1. Add Task at Beginning");
			System.out.println("2. Add Task at End");
			System.out.println("3. Add Task at Position");
			System.out.println("4. Remove Task by ID");
			System.out.println("5. View Current Task");
			System.out.println("6. Display All Tasks");
			System.out.println("7. Search Task by Priority");
			System.out.println("0. Exit");
			System.out.print("Enter choice: ");

			choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {

			case 1:
				System.out.print("Enter Task ID: ");
				int id = sc.nextInt();
				sc.nextLine();
				System.out.print("Enter Task Name: ");
				String name = sc.nextLine();
				System.out.print("Enter Priority: ");
				int p = sc.nextInt();
				sc.nextLine();
				System.out.print("Enter Due Date: ");
				String d = sc.nextLine();
				scheduler.addAtBeginning(id, name, p, d);
				break;

			case 2:
				System.out.print("Enter Task ID: ");
				id = sc.nextInt();
				sc.nextLine();
				System.out.print("Enter Task Name: ");
				name = sc.nextLine();
				System.out.print("Enter Priority: ");
				p = sc.nextInt();
				sc.nextLine();
				System.out.print("Enter Due Date: ");
				d = sc.nextLine();
				scheduler.addAtEnd(id, name, p, d);
				break;

			case 3:
				System.out.print("Enter Position: ");
				int pos = sc.nextInt();
				System.out.print("Enter Task ID: ");
				id = sc.nextInt();
				sc.nextLine();
				System.out.print("Enter Task Name: ");
				name = sc.nextLine();
				System.out.print("Enter Priority: ");
				p = sc.nextInt();
				sc.nextLine();
				System.out.print("Enter Due Date: ");
				d = sc.nextLine();
				scheduler.addAtPosition(pos, id, name, p, d);
				break;

			case 4:
				System.out.print("Enter Task ID to remove: ");
				id = sc.nextInt();
				scheduler.removeTask(id);
				break;

			case 5:
				scheduler.viewCurrentTask();
				break;

			case 6:
				scheduler.displayAllTasks();
				break;

			case 7:
				System.out.print("Enter Priority: ");
				p = sc.nextInt();
				scheduler.searchByPriority(p);
				break;

			case 0:
				System.out.println("Exiting...");
				break;

			default:
				System.out.println("Invalid choice.");
			}

		} while (choice != 0);

		sc.close();
	}
}
