package mcs;

import java.time.LocalDateTime;

// followed p.5 format example for Person class
public abstract class Person {

    // Data members (fields)
    private String name;
    private Date dateOfBirth;
    private String phoneNumber;
    private String address;

    // Constructor with parameters
    public Person(String name, Date dateOfBirth, String phoneNumber, String address) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    // Default constructor
    public Person() {

        this.name = "";
        this.dateOfBirth = new Date();
        this.phoneNumber = "";
        this.address = "";
    }

    // Mutators and accessors
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return String.format("Name: %s %nDate of birth: %s %nPhone number: %s %nAddress: %s", name, dateOfBirth,
                phoneNumber, address);
    }
}
