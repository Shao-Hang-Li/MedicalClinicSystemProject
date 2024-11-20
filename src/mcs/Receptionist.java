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
    /**
     * One constructor from person super class, default constructor
     * @param name receptionist name
     */
    public Receptionist(String name) {
        super(name);
    }
    /**
     * method to schedule an appointment
     */
    @Override
    public void scheduleAppointment() {
        System.out.println(getName() + " is scheduling an appointment for the patient");
    }


    /**
     * unused method due to subclass of person
     */
    @Override
    public void updateInfo() {
        System.out.println(getName() + " is updating the personal informations of the patient/doctor.");
    }
    /**
     * unused method due to subclass of person
     */
    @Override
    public void displayInfo() {
        System.out.println("Receptionist: " + getName());
    }
}

