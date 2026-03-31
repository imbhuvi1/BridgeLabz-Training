package gcr_codebase.address_book;

import java.util.Objects;

public class ContactPerson {

    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String phone;
    private String email;

    public ContactPerson(String firstName, String lastName, String address,
                         String city, String state, String zip,
                         String phone, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phone = phone;
        this.email = email;
    }

    // Getters
    public String getFirstName() {
        return firstName;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZip() {
        return zip;
    }

    // Setters
    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // UC-7: Duplicate check
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ContactPerson)) return false;
        ContactPerson that = (ContactPerson) o;
        return firstName.equalsIgnoreCase(that.firstName)
                && lastName.equalsIgnoreCase(that.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName.toLowerCase(), lastName.toLowerCase());
    }

    // UC-10: Print contact
    @Override
    public String toString() {
        return firstName + " " + lastName +
                ", " + address +
                ", " + city +
                ", " + state +
                ", Zip: " + zip +
                ", Phone: " + phone +
                ", Email: " + email;
    }
}
