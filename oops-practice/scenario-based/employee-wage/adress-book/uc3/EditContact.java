package address_book.uc3;

import address_book.uc1.Contact;
import address_book.uc2.AddressBook;

public class EditContact {

	public static void editContact(AddressBook ab, String firstName, int fieldChoice, String newValue) {

		Contact c = ab.getContactByFirstName(firstName);

		if (c == null) {
			System.out.println("Contact not found.");
			return;
		}

		switch (fieldChoice) {
		case 1 -> c.setFirstName(newValue);
		case 2 -> c.setLastName(newValue);
		case 3 -> c.setAddress(newValue);
		case 4 -> c.setCity(newValue);
		case 5 -> c.setState(newValue);
		case 6 -> c.setZip(newValue);
		case 7 -> c.setPhoneNumber(newValue);
		case 8 -> c.setEmail(newValue);
		default -> System.out.println("Invalid choice.");
		}

		System.out.println("Contact updated successfully!");
	}
}