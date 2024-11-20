package mcs;

/**
 * This is the treatment class
 * 
 * this class is used to store the various treatments and how and when they will be done
 * @see Date
 * @see Doctor
 * @see MedicalClinicSystem
 * @see Patient
 * @see Person
 * @see Receptionist
 * @see Schedulable
 * @see Treatable
 */
public class Treatment implements Treatable{
    //data members
    private String treatmentID;
    private Date date;
    private Doctor doctor;
    private Patient patient;
    private String treatmentType;
    private double cost;

    /**
     * constructor to build a treatment object that is associated with doctors and patients
     * @param treatmentID ID of a treatment, may be used for searching
     * @param date date of treatment
     * @param doctor associated doctor
     * @param patient associated patient
     * @param treatmentType description of the treatment
     * @param cost cost of treatment
     */
    public Treatment(String treatmentID, Date date, Doctor doctor, Patient patient, String treatmentType,double cost) {
        this.treatmentID = treatmentID;
        this.date = date;
        this.doctor = doctor;
        this.patient = patient;
        this.treatmentType = treatmentType;
        setCost(cost);
    }

    //mutator methods

    /**
     * The method sets/modifies the doctor responsible for the treatment
     * @param doctor doctor responsible
     */
    public void assignDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    /**
     * The method sets/modifies the patient associated for the treatment
     * @param patient patient associated
     */
    public void assignPatient(Patient patient) {
        this.patient = patient;
    }

    /**
     * The method sets/modifies treatment Type
     * @param treatmentType description of the treatment
     */
    public void setTreatmentType(String treatmentType) {
        this.treatmentType = treatmentType;
    }

    /**
     * the method updates the date of the treatment.
     * @param newDate modified date
     */
    public void setDate(Date newDate) {
        this.date = newDate;
    }

    /**
     * getter for treatment ID
     * @return treatment ID
     */
    public String getTreatmentID() {
        return treatmentID;
    }
    /**
     * getter for date
     * @return date
     */
    public Date getDate() {
        return date;
    }
    /**
     * getter for doctor
     * @return doctor
     */
    public Doctor getDoctor() {
        return doctor;
    }
    /**
     * getter for patient
     * @return patient
     */
    public Patient getPatient() {
        return patient;
    }
    /**
     * getter for treatment type
     * @return treatment type
     */
    public String getTreatmentType() {
        return treatmentType;
    }
    /**
     * getter for cost
     * @return cost
     */
    public double getCost() {
        return cost;
    }


    /**
     * The method set the cost of the treatment, with validation of input value
     * @param cost cost of the treatment
     */
    public void setCost(double cost) {
        if (cost < 0){
            throw new IllegalArgumentException("Cost must be a positive number");
        }
        this.cost = cost;
    }

    /**
     * This method prints the performed treatment for the specific object
     */
    @Override
    public void performTreatment() {
        String s1 = "Performing " + this.treatmentType + " treatment on " + this.patient.getName() + " by " + this.doctor.getName() + ". Treatment ID: "+ this.getTreatmentID() + "\n";
        System.out.println(s1.concat(this.toString()));
    }
    /**
     * to String method for treatment
     */
    @Override
    public String toString(){
        return "Treatment ID: " + treatmentID + "\n Date (DD MM YYYY): " + date + "\n Doctor: " + doctor + "\n Patient: " + patient
                + "\n Treatment Type: " + treatmentType + "\n Cost: $" + cost + "\n";
    }//end method
}
