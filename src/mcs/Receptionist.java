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

    @Override
    public void updateInfo() {
        System.out.println(getName() + " is scheduling an appointment for the patient.");
    }

}

