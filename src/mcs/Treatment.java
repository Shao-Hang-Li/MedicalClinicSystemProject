package mcs;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

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

    //accessor methods
    public String getTreatmentID() {
        return treatmentID;
    }
    public Date getDate() {
        return date;
    }
    public Doctor getDoctor() {
        return doctor;
    }
    public Patient getPatient() {
        return patient;
    }
    public String getTreatmentType() {
        return treatmentType;
    }
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

    //String treatmentID, Date date, Doctor doctor, Patient patient, String treatmentType,double cost
    public void writeToFile(ArrayList<Treatment> treatments) {
        try {
            PrintWriter writer = new PrintWriter("Treatment.txt");
            for (Treatment treat:treatments) {
                Date date = treat.getDate();
                //here we only write Doctor and Patient name in the file
                writer.printf("%s,%d,%d,%d,%s,%s,%s,%.2f%n", this.getTreatmentID(), date.getDay(), date.getMonth(),
                        date.getYear(), this.getDoctor().getName(), this.getPatient().getName(), this.getTreatmentType(), this.getCost());
            }
            writer.close();
        }catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }

    public ArrayList<Treatment> readFromFile() {
        ArrayList<Treatment> treatments = new ArrayList<Treatment>();
        try{
            Scanner reader = new Scanner("Treatment.txt");
            while (reader.hasNextLine()){
                String aLine = reader.nextLine();
                String [] line = aLine.split(",");      //Separate String by comma and store into a list
                //access each data from the list by index
                String treatmentID = line[0];
                //we can use Integer.parseInt for type conversion
                Date date = new Date(Integer.valueOf(line[1]), Integer.valueOf(line[2]), Integer.valueOf(line[3]));
                String doctorName = line[4];
                String patientName = line[5];
                String treatmentType = line[6];
                double cost = Double.valueOf(line[7]);
                //now create a patient object
                Treatment aTreatment = new Treatment();
                treatments.add(aTreatment);     //store into the ArrayList
            }
            reader.close();
            return treatments;
        }
        catch (Exception e){
            System.out.println(e);
        }
        return treatments;
    }

    /**
     * This method prints the performed treatment for the specific object
     */
    @Override
    public void performTreatment() {
        String s1 = "Performing " + this.treatmentType + " treatment on " + this.patient.getName() + " by " + this.doctor.getName() + ". Treatment ID: "+ this.getTreatmentID() + "\n";
        System.out.println(s1.concat(this.toString()));
    }
    //to String method
    @Override
    public String toString(){
        return "Treatment ID: " + treatmentID + "\n Date: " + date + "\n Doctor: " + doctor + "\n Patient: " + patient
                + "\n Treatment Type: " + treatmentType + "\n Cost: $" + cost;
    }//end method
}
