package mcs;

// followed p.5 format example for Person class
public abstract class Person {
    private String name;
    private String dateOfBirth;
    private String phoneNumber;
    private String address;

    public Person(String name, String dateOfBirth, String phoneNumber, String address) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public Person() {
        this.name = "John Doe";
        this.dateOfBirth = "24-03-1996";
        this.phoneNumber = "514-224-8232";
        this.address = "123 Playground Street";    
    }
}
