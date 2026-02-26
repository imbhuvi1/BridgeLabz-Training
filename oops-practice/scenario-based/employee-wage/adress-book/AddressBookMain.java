package address_book;

import address_book.uc1.Contact;
import address_book.uc2.AddressBook;
import java.util.*;

public class AddressBookMain {
	public static void main(String[] args) {
		System.out.println("Welcome to Address Book Program.");

		AddressBook ab = new AddressBook();

		Scanner sc = new Scanner(System.in);
		AddressBook addressBook = new AddressBook();

		System.out.print("Enter First Name: ");
		String firstName = sc.nextLine();

		System.out.print("Enter Last Name: ");
		String lastName = sc.nextLine();

		System.out.print("Enter Address: ");
		String address = sc.nextLine();

		System.out.print("Enter City: ");
		String city = sc.nextLine();

		System.out.print("Enter State: ");
		String state = sc.nextLine();

		System.out.print("Enter Zip: ");
		String zip = sc.nextLine();

		System.out.print("Enter Phone Number: ");
		String phone = sc.nextLine();

		System.out.print("Enter Email: ");
		String email = sc.nextLine();

		Contact contact = new Contact(firstName, lastName, address, city, state, zip, phone, email);
		
		ab.addContact(contact);
		ab.displayContact();

	}
}
