package mcs;
/**
 * This is the person abstract class. It is used as the default class for patients and doctor
 * 
 * It stores basic information like name and date of birth which can be transfered to the subclasses.
 * @see Date
 * @see Doctor
 * @see MedicalClinicSystem
 * @see MenuOption
 * @see Patient
 * @see Receptionist
 * @see Schedulable
 * @see Treatable
 * @see Treatment
 */
public abstract class Person {

    // Data members (fields)
    private String name;
    private Date dateOfBirth;
    private String phoneNumber;
    private String address;

    /**
     * main constructor
     * @param name person name
     * @param dateOfBirth person date of birth
     * @param phoneNumber person phone number
     * @param address person address
     */
    public Person(String name, Date dateOfBirth, String phoneNumber, String address) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    /**
     * alt constructor
     * @param name person name
     */
    public Person(String name) {
        this.name = name;
    }

    /**
     * Default constructor for person
     */
    public Person() {

        this.name = "";
        this.dateOfBirth = new Date();
        this.phoneNumber = "";
        this.address = "";
    }

    /**
     * getter for name
     * @return name
     */
    public String getName() {
        return name;
    }
    /**
     * setter for name
     * @param name name
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * getter for date of birth
     * @return date of birth
     */
    public Date getDateOfBirth() {
        return dateOfBirth;
    }
    /**
     * setter for date of birth
     * @param dateOfBirth date of birth
     */
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    /**
     * getter for phone number
     * @return phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }
    /**
     * setter for phone number
     * @param phoneNumber phone number
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    /**
     * getter for address
     * @return address
     */
    public String getAddress() {
        return address;
    }
    /**
     * setter for address
     * @param address address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * abstract method for displaying info
     */
    public abstract void displayInfo();

    /**
     * abstract method for updating info
     */
    public abstract void updateInfo();
    /**
     * default toString for every person
     */
    @Override
    public String toString() {
        return String.format("%s %n Date of birth: %s %n Phone number: %s %n Address: %s", name, dateOfBirth,
                phoneNumber, address);
    }
}
