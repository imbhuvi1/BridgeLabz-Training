package scenerio_based;

import java.util.*;

//Custom exception for invalid phone number
class InvalidPhoneNumberException extends Exception {
	public InvalidPhoneNumberException(String message) {
		super(message);
	}
}

//Contact class
class Contact {
	private String name;
	private String phoneNumber;

	// Constructor
	public Contact(String name, String phoneNumber) {
		this.name = name;
		this.phoneNumber = phoneNumber;
	}
	
	//Getter for name
	public String getName() {
	    return name;
	}

	// Getter for phone number
	public String getPhoneNumber() {
		return phoneNumber;
	}

	// Display contact details
	public void displayContact() {
		System.out.println("Name: " + name);
		System.out.println("Phone Number: " + phoneNumber);
	}
}

//Main organizer class
public class PhoneContactOrganizer {

	private static List<Contact> contacts = new ArrayList<>();
	private static Scanner sc = new Scanner(System.in);

	// Add contact method
	public static void addContact() {
		try {
			System.out.print("Enter Name: ");
			String name = sc.nextLine();

			System.out.print("Enter Phone Number: ");
			String phoneNumber = sc.nextLine();

			if (phoneNumber.length() != 10) {
				throw new InvalidPhoneNumberException("Phone number must be exactly 10 digits");
			}

			for (Contact c : contacts) {
				if (c.getPhoneNumber().equals(phoneNumber)) {
					System.out.println("Duplicate contact not allowed");
					return;
				}
			}

			contacts.add(new Contact(name, phoneNumber));
			System.out.println("Contact added successfully");

		} catch (InvalidPhoneNumberException e) {
			System.out.println(e.getMessage());
		}
	}

	// Delete contact method
	public static void deleteContact() {
		System.out.print("Enter Phone Number to delete: ");
		String phoneNumber = sc.nextLine();

		for (Contact c : contacts) {
			if (c.getPhoneNumber().equals(phoneNumber)) {
				contacts.remove(c);
				System.out.println("Contact deleted successfully");
				return;
			}
		}
		System.out.println("Contact not found");
	}

	// Search contact by name
	public static void searchContact() {

		System.out.print("Enter Name to search: ");
		String name = sc.nextLine();

		boolean found = false;

		for (Contact c : contacts) {
			if (c.getName().equalsIgnoreCase(name)) {
				c.displayContact();
				found = true;
			}
		}

		if (!found) {
			System.out.println("Contact not found");
		}
	}
	
	//Display all contacts
	public static void showAllContacts() {

	    if (contacts.isEmpty()) {
	        System.out.println("No contacts available");
	        return;
	    }

	    System.out.println("\nContact List:");
	    for (Contact c : contacts) {
	        c.displayContact();
	    }
	}


	// Main method
	public static void main(String[] args) {

		int choice;

		do {
			System.out.println("\nPhone Contact Organizer");
			System.out.println("1 Add Contact");
			System.out.println("2 Delete Contact");
			System.out.println("3 Search Contact");
			System.out.println("4 Display Contacts");
			System.out.println("5 Exit");
			System.out.print("Enter your choice: ");

			try {
				choice = Integer.parseInt(sc.nextLine());

				switch (choice) {
				case 1:
					addContact();
					break;
				case 2:
					deleteContact();
					break;
				case 3:
					searchContact();
					break;
				case 4:
					showAllContacts();
					break;
				case 5:
					System.out.println("Exiting application");
					break;
				default:
					System.out.println("Invalid choice");
				}
			} catch (NumberFormatException e) {
				System.out.println("Please enter a valid number");
				choice = 0;
			}

		} while (choice != 5);
	}
}
