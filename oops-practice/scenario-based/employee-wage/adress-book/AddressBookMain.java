package address_book;

import address_book.uc1.Contact;
import address_book.uc2.AddressBook;
import address_book.uc3.EditContact;

import java.util.Scanner;

public class AddressBookMain {
	public static void main(String[] args) {

		System.out.println("WELCOME TO ADDRESS BOOK PROGRAM");

		Scanner sc = new Scanner(System.in);
		AddressBook ab = new AddressBook();

		// UC2 – Add Contact
		System.out.print("Do you want to add a contact? (y/n): ");
		if (sc.nextLine().equalsIgnoreCase("y")) {

			System.out.print("First Name: ");
			String firstName = sc.nextLine();

			System.out.print("Last Name: ");
			String lastName = sc.nextLine();

			System.out.print("Address: ");
			String address = sc.nextLine();

			System.out.print("City: ");
			String city = sc.nextLine();

			System.out.print("State: ");
			String state = sc.nextLine();

			System.out.print("Zip: ");
			String zip = sc.nextLine();

			System.out.print("Phone: ");
			String phone = sc.nextLine();

			System.out.print("Email: ");
			String email = sc.nextLine();

			ab.addContact(new Contact(firstName, lastName, address, city, state, zip, phone, email));
		}

		// Display
		ab.displayContacts();

		// UC4 – Edit Contact
		System.out.print("\nDo you want to edit a contact? (y/n): ");
		if (sc.nextLine().equalsIgnoreCase("y")) {

			System.out.print("Enter First Name of contact to edit: ");
			String editName = sc.nextLine();

			System.out.println("""
					1. First Name
					2. Last Name
					3. Address
					4. City
					5. State
					6. Zip
					7. Phone
					8. Email
					""");

			System.out.print("Enter your choice: ");
			int choice = sc.nextInt();
			sc.nextLine();

			System.out.print("Enter new value: ");
			String newValue = sc.nextLine();

			EditContact.editContact(ab, editName, choice, newValue);
		}

		sc.close();
	}
}