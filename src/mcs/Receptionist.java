package mcs;
/**
 * This is the receptionist class. 
 * 
 * The receptionist class is used to schedule appointments for patients
 * @see Date
 * @see Doctor
 * @see MedicalClinicSystem
 * @see MenuOption
 * @see Patient
 * @see Person
 * @see Schedulable
 * @see Treatable
 * @see Treatment
 */
public class Receptionist extends Person implements Schedulable {
    // we used the one parameter constructor from Person
    public Receptionist(String name) {
        super(name);
    }

    @Override
    public void scheduleAppointment() {
        System.out.println(getName() + " is scheduling an appointment for the patient");
    }


    // THESE TWO METHODS ARE NOT CALLED except updateInfo()
    // IT'S ONLY FOR THE METHOD TO WORK SINCE IT IS A SUB CLASS OF PERSON
    @Override
    public void updateInfo() {
        System.out.println(getName() + " is updating the personal informations of the patient/doctor.");
    }

    @Override
    public void displayInfo() {
        System.out.println("Receptionist: " + getName());
    }
}

