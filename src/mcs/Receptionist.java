package mcs;

public class Receptionist extends Person implements Schedulable {
    // Data members (fields)

    public Receptionist(String name) {
        super(name);
    }

    @Override
    public void scheduleAppointment() {
        System.out.println(getName() + " is scheduling an appointment for the patient.");
    }

    @Override
    public void updateInfo() {
        System.out.println(getName() + " is updating the personal information of the person.");
    }

    public void displayInfo() {
        System.out.println("Receptionist: " + getName());
    }
}

