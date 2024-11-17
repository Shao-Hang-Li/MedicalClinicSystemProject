package mcs;

//References: Payable.java in class notes
/**
 * The Treatable interface can show the treatment given to the patient by the doctor
 * Classes that implement this interface must provide an implementation of the "getPerformTreatment" method
 * which helps perform a treatment
 */
public interface Treatable {

    /**
     * This method should print the performed treatment for the specific object that implements this interface
     */
    public void performTreatment(); // no implementation
}
