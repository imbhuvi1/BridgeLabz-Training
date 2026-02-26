package address_book;

import address_book.uc1.Contact;

import address_book.uc2.AddressBook;
import address_book.uc3.EditContact;
import address_book.uc4.DeleteContact;

import java.util.Scanner;

public class AddressBookMain {
	public static void main(String[] args) {

		System.out.println("WELCOME TO ADDRESS BOOK PROGRAM");

		Scanner sc = new Scanner(System.in);
		AddressBook ab = new AddressBook();

		boolean running = true;

		while (running) {

		    System.out.println("\n===== ADDRESS BOOK MENU =====");
		    System.out.println("1. Add Contact");
		    System.out.println("2. Edit Contact");
		    System.out.println("3. Delete Contact");
		    System.out.println("4. Display Contacts");
		    System.out.println("5. Exit");

		    System.out.print("Enter your choice: ");
		    int choice = sc.nextInt();
		    sc.nextLine(); // clear buffer

		    switch (choice) {

		    //UC2 - ADD CONTACT
		        case 1 -> {  
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

		            ab.addContact(new Contact(
		                    firstName, lastName, address, city, state, zip, phone, email
		            ));
		            System.out.println("Contact added successfully!");
		        }

		        //UC3 - EDIT CONTACT
		        case 2 -> {
		            System.out.print("Enter First Name to edit: ");
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

		            System.out.print("Enter field number: ");
		            int fieldChoice = sc.nextInt();
		            sc.nextLine();

		            System.out.print("Enter new value: ");
		            String newValue = sc.nextLine();

		            EditContact.editContact(ab, editName, fieldChoice, newValue);
		        }
		        // UC4 - DELETE CONTACT
		        case 3 -> {   
		            System.out.print("Enter First Name to delete: ");
		            String deleteName = sc.nextLine();
		            DeleteContact.deleteContact(ab, deleteName);
		        }

		        case 4 -> ab.displayContacts();   // DISPLAY

		        case 5 -> {   // EXIT
		            running = false;
		            System.out.println("Exiting Address Book. Bye!");
		        }

		        default -> System.out.println("Invalid choice.");
		    }
		}

		sc.close();
	}
}