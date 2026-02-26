package address_book.uc1;

public class Contact {
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String phoneNumber;
    private String email;

    public Contact(String firstName, String lastName, String address,
                   String city, String state, String zip,
                   String phoneNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
    
    public void displayDetails() {
    	System.out.printf("%s %s is from %s, %s, %s, %s\nHis contact details are: Phone Number: %s and Email: %s",firstName, lastName,
    			address, city, state, zip, phoneNumber, email);
    }
}
