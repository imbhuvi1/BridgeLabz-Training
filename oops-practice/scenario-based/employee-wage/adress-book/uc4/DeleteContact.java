package address_book.uc4;

import address_book.uc2.AddressBook;

public class DeleteContact {
	public static void deleteContact(AddressBook ab, String deleteName) {
	    boolean deleted = ab.deleteTheContact(deleteName);

	    if (deleted) {
	        System.out.println("Contact deleted successfully.");
	    } else {
	        System.out.println("Contact not found.");
	    }
	}
}
