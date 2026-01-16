package gcr_codebase.address_book;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AddressBookSystem {

    private Map<String, AddressBook> addressBookMap;

    public AddressBookSystem() {
        addressBookMap = new HashMap<>();
    }

    // UC-5
    public void addAddressBook(String name) {
        addressBookMap.putIfAbsent(name, new AddressBook(name));
    }

    public AddressBook getAddressBook(String name) {
        return addressBookMap.get(name);
    }

    // UC-8
    public List<ContactPerson> searchByCity(String city) {
        return addressBookMap.values().stream()
                .flatMap(book -> book.getContacts().stream())
                .filter(person -> person.getCity().equalsIgnoreCase(city))
                .collect(Collectors.toList());
    }

    public List<ContactPerson> searchByState(String state) {
        return addressBookMap.values().stream()
                .flatMap(book -> book.getContacts().stream())
                .filter(person -> person.getState().equalsIgnoreCase(state))
                .collect(Collectors.toList());
    }

    // UC-9
    public long countByCity(String city) {
        return searchByCity(city).size();
    }

    public long countByState(String state) {
        return searchByState(state).size();
    }
}

