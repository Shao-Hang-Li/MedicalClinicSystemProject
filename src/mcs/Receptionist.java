package mcs;

public class Receptionist extends Person implements Schedulable {
    // Data members (fields)

    public Receptionist(String name, Date dateOfBirth, String phoneNumber, String address) {
        super(name, dateOfBirth, phoneNumber, address);
    }

    @Override
    public void scheduleAppointment() {
        System.out.println(getName() + " is scheduling an appointment for the patient.");
    }

    public void updateInfo() {
        // Implementation of the abstract method from Person class
        // You can define how the receptionist updates their information here.
        System.out.println(getName() + " is updating their personal information.");
    }

    public void displayInfo() {
        System.out.println(getName() + " is displaying their personal information.");
    }
}

