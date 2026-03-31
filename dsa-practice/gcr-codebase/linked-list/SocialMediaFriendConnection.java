

import java.util.*;

// Node class representing a user
class FriendNode {
	int userId;
	String name;
	int age;
	List<Integer> listOfFriends = new ArrayList<>();

	FriendNode next;

	// constructor to initialize user details
	public FriendNode(int userId, String name, int age) {
		this.userId = userId;
		this.name = name;
		this.age = age;
		this.next = null;
	}
}

// Singly Linked List class
class FriendNodeList {
	FriendNode head;

	// Add a new user at the end of the list
	void addUser(int userId, String name, int age) {
		FriendNode newNode = new FriendNode(userId, name, age);

		// if list is empty, new node becomes head
		if (head == null) {
			head = newNode;
			return;
		}

		// traverse till the last node
		FriendNode temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}

		// linking last node with new node
		temp.next = newNode;
	}

	// Add friend connection between two users
	void addConnection(int userIdOfCurrentUser, int userIdOfAnotherUser) {

		FriendNode user1 = findNode(userIdOfCurrentUser);
		FriendNode user2 = findNode(userIdOfAnotherUser);

		if (user1 == null || user2 == null) {
			System.out.println("\nUser id didn't match. First add them.");
			return;
		}

		if (!user1.listOfFriends.contains(userIdOfAnotherUser))
			user1.listOfFriends.add(userIdOfAnotherUser);

		if (!user2.listOfFriends.contains(userIdOfCurrentUser))
			user2.listOfFriends.add(userIdOfCurrentUser);

		System.out.println("\nConnection Added.");
	}

	// Remove friend connection
	void removeConnection(int userIdOfCurrentUser, int userIdOfAnotherUser) {

		FriendNode user1 = findNode(userIdOfCurrentUser);
		FriendNode user2 = findNode(userIdOfAnotherUser);

		if (user1 == null || user2 == null) {
			System.out.println("\nUser not found.");
			return;
		}

		user1.listOfFriends.remove(Integer.valueOf(userIdOfAnotherUser));
		user2.listOfFriends.remove(Integer.valueOf(userIdOfCurrentUser));

		System.out.println("\nConnection Removed.");
	}

	// Find mutual friends
	void findMutualUsers(int userIdOfCurrentUser, int userIdOfAnotherUser) {

		FriendNode user1 = findNode(userIdOfCurrentUser);
		FriendNode user2 = findNode(userIdOfAnotherUser);

		if (user1 == null || user2 == null) {
			System.out.println("\nUser not found.");
			return;
		}

		Set<Integer> set = new HashSet<>(user1.listOfFriends);

		System.out.println("\nMutual Friends:");
		for (Integer id : user2.listOfFriends) {
			if (set.contains(id)) {
				displayDetails(id);
			}
		}
	}

	// Display all friends of a user
	void displayAllFriends(int userIdToCheck) {

		FriendNode user = findNode(userIdToCheck);

		if (user == null) {
			System.out.println("\nUser not found.");
			return;
		}

		System.out.println("\nFriends of " + user.name + ":");
		for (Integer id : user.listOfFriends) {
			displayDetails(id);
		}
	}

	// Search user by name
	void searchUserByName(String nameOfUser) {
		FriendNode temp = head;

		while (temp != null) {
			if (temp.name.equalsIgnoreCase(nameOfUser)) {
				displayDetails(temp.userId);
				return;
			}
			temp = temp.next;
		}
		System.out.println("\nUser not found.");
	}

	// Search user by userId
	void searchUserByUserId(int Id) {
		FriendNode user = findNode(Id);

		if (user == null) {
			System.out.println("\nUser not found.");
			return;
		}
		displayDetails(Id);
	}

	// Count friends
	int countFriends(int Id) {
		FriendNode user = findNode(Id);
		if (user == null)
			return 0;
		return user.listOfFriends.size();
	}

	// Display user details
	void displayDetails(int Id) {
		FriendNode temp = findNode(Id);
		if (temp == null)
			return;

		System.out.println("\nUser Id: " + temp.userId);
		System.out.println("Name: " + temp.name);
		System.out.println("Age: " + temp.age);
		System.out.println("No. of Friends: " + countFriends(temp.userId));
	}

	// Helper method to find node
	FriendNode findNode(int Id) {
		FriendNode temp = head;
		while (temp != null) {
			if (temp.userId == Id)
				return temp;
			temp = temp.next;
		}
		return null;
	}
}

// Main class
public class SocialMediaFriendConnection {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		FriendNodeList obj = new FriendNodeList();

		int choice;

		do {
			System.out.println("\nSOCIAL MEDIA FRIEND SYSTEM");
			System.out.println("1. Add User");
			System.out.println("2. Add Friend Connection");
			System.out.println("3. Remove Friend Connection");
			System.out.println("4. Find Mutual Friends");
			System.out.println("5. Display All Friends");
			System.out.println("6. Search User by ID");
			System.out.println("7. Search User by Name");
			System.out.println("8. Count Friends");
			System.out.println("0. Exit");
			System.out.print("Enter your choice: ");

			choice = sc.nextInt();
			sc.nextLine(); // consume newline

			switch (choice) {

			case 1:
				System.out.print("Enter User ID: ");
				int id = sc.nextInt();
				sc.nextLine();
				System.out.print("Enter Name: ");
				String name = sc.nextLine();
				System.out.print("Enter Age: ");
				int age = sc.nextInt();
				obj.addUser(id, name, age);
				break;

			case 2:
				System.out.print("Enter First User ID: ");
				int u1 = sc.nextInt();
				System.out.print("Enter Second User ID: ");
				int u2 = sc.nextInt();
				obj.addConnection(u1, u2);
				break;

			case 3:
				System.out.print("Enter First User ID: ");
				u1 = sc.nextInt();
				System.out.print("Enter Second User ID: ");
				u2 = sc.nextInt();
				obj.removeConnection(u1, u2);
				break;

			case 4:
				System.out.print("Enter First User ID: ");
				u1 = sc.nextInt();
				System.out.print("Enter Second User ID: ");
				u2 = sc.nextInt();
				obj.findMutualUsers(u1, u2);
				break;

			case 5:
				System.out.print("Enter User ID: ");
				id = sc.nextInt();
				obj.displayAllFriends(id);
				break;

			case 6:
				System.out.print("Enter User ID: ");
				id = sc.nextInt();
				obj.searchUserByUserId(id);
				break;

			case 7:
				System.out.print("Enter Name: ");
				name = sc.nextLine();
				obj.searchUserByName(name);
				break;

			case 8:
				System.out.print("Enter User ID: ");
				id = sc.nextInt();
				System.out.println("Total Friends: " + obj.countFriends(id));
				break;

			case 0:
				System.out.println("Exiting...");
				break;

			default:
				System.out.println("Invalid choice!");
			}

		} while (choice != 0);

		sc.close();
	}
}