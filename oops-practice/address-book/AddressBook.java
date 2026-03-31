package gcr_codebase.address_book;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AddressBook {

    private String name;
    private List<ContactPerson> contacts;

    public AddressBook(String name) {
        this.name = name;
        this.contacts = new ArrayList<>();
    }

    // UC-1, UC-6
    public void addContact(ContactPerson person) {
        if (contacts.contains(person)) {
            System.out.println("Duplicate contact not allowed.");
            return;
        }
        contacts.add(person);
    }

    // UC-2
    public void editContact(String firstName, String newCity) {
        for (ContactPerson person : contacts) {
            if (person.getFirstName().equalsIgnoreCase(firstName)) {
                person.setCity(newCity);
                return;
            }
        }
        System.out.println("Contact not found.");
    }

    // UC-3
    public void deleteContact(String firstName) {
        contacts.removeIf(p -> p.getFirstName().equalsIgnoreCase(firstName));
    }

    // UC-4
    public List<ContactPerson> getContacts() {
        return contacts;
    }

    // UC-10
    public void sortByName() {
        contacts.sort(Comparator.comparing(ContactPerson::getFirstName));
    }

    // UC-11
    public void sortByCity() {
        contacts.sort(Comparator.comparing(ContactPerson::getCity));
    }

    public void sortByState() {
        contacts.sort(Comparator.comparing(ContactPerson::getState));
    }

    public void sortByZip() {
        contacts.sort(Comparator.comparing(ContactPerson::getZip));
    }

    public void displayContacts() {
        contacts.forEach(System.out::println);
    }
}

