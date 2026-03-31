package gcr_codebase.address_book;

public class AddressBookMain {

    public static void main(String[] args) {

        System.out.println("Welcome to Address Book Program");

        AddressBookSystem system = new AddressBookSystem();

        system.addAddressBook("Personal");
        AddressBook personalBook = system.getAddressBook("Personal");

        ContactPerson person1 = new ContactPerson(
                "Bhuvnesh", "Singh",
                "MG Road", "Pune", "MH",
                "411001", "9999999999", "bhuv@gmail.com"
        );

        ContactPerson person2 = new ContactPerson(
                "Amit", "Sharma",
                "FC Road", "Pune", "MH",
                "411004", "8888888888", "amit@gmail.com"
        );

        personalBook.addContact(person1);
        personalBook.addContact(person2);

        System.out.println("\nAll Contacts:");
        personalBook.displayContacts();

        personalBook.sortByName();
        System.out.println("\nAfter Sorting by Name:");
        personalBook.displayContacts();

        System.out.println("\nPeople in Pune: " + system.countByCity("Pune"));
    }
}
