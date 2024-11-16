package mcs;

public class Patient extends Person {

    // Data members (fields)
    private String insuranceCompany;
    private String medicalHistory;

    // Constructor with parameters
    public Patient (String name, Date dateOfBirth, String phoneNumber, String address, String insuranceCompany,
                    String medicalHistory) {
        // super class Person
        super(name, dateOfBirth, phoneNumber, address);

        this.insuranceCompany = insuranceCompany;
        this.medicalHistory = medicalHistory;
    }
    // Mutators and accessors
    public String getInsuranceCompany() {
        return insuranceCompany;
    }

    public void setInsuranceCompany(String insuranceCompany) {
        this.insuranceCompany = insuranceCompany;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    // Return String representation of the Patient object
    @Override

}
