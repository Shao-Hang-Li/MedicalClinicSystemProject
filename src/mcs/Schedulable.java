package mcs;
//References: Payable.java in class notes
/**
 * The Schedulable interface can make appointments in the schedule.
 * Classes that implement this interface must provide an implementation of the "getScheduleAppointment" method
 * which helps them schedule an appointment
 * @see Date
 * @see Doctor
 * @see MedicalClinicSystem
 * @see Patient
 * @see Person
 * @see Receptionist
 * @see Treatable
 * @see Treatment
 */
public interface Schedulable {

    /**
     * method to schedule appointment
     */
    public void scheduleAppointment(); // no implementation
}
