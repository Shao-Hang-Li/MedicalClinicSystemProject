package mcs;
//References: Payable.java in class notes
/**
 * The Schedulable interface can make appointments in the schedule.
 * Classes that implement this interface must provide an implementation of the "getScheduleAppointment" method
 * which helps them schedule an appointment
 */
public interface Schedulable {

    /**
     * This method should return the schedule appointment for the specific object that implements this interface
     * @return the schedule appointment for the object
     */
    public void scheduleAppointment(); // no implementation
}
