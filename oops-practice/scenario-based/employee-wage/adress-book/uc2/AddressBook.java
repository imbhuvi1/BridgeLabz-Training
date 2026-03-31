package address_book.uc2;

import address_book.uc1.Contact;
import java.util.ArrayList;
import java.util.Iterator;

public class AddressBook {
	private ArrayList<Contact> contacts = new ArrayList<>();

	public void addContact(Contact contact) {
		contacts.add(contact);
	}

	public void displayContacts() {
		if (contacts.isEmpty()) {
			System.out.println("No contacts available.");
			return;
		}
		for (Contact c : contacts) {
			c.displayDetails();
		}
	}

	public Contact getContactByFirstName(String firstName) {
		for (Contact c : contacts) {
			if (c.getFirstName().equalsIgnoreCase(firstName)) {
				return c;
			}
		}
		return null;
	}

	public boolean deleteTheContact(String deleteName) {
	    Iterator<Contact> iterator = contacts.iterator();

	    while (iterator.hasNext()) {
	        Contact c = iterator.next();
	        if (c.getFirstName().equalsIgnoreCase(deleteName)) {
	            iterator.remove();
	            return true;
	        }
	    }
	    return false;
	}
}