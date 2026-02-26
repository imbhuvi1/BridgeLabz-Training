package address_book.uc2;

import address_book.uc1.Contact;
import java.util.*;

public class AddressBook {
	private ArrayList<Contact> contacts = new ArrayList<>();

	public void addContact(Contact contact) {
		contacts.add(contact);
	}
	
	public void displayContact() {
		for(Contact c : contacts) {
			c.displayDetails();
		}
	}

}
