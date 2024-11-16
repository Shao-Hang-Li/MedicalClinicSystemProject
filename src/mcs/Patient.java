package mcs;

public class Patient extends Person{

    String insuranceCompany;
    String medicalHistory;

    public Patient(String name, String dateOfBirth, String phoneNumber, String address, String insuranceCompany, String medicalHistory) {
        super(name, dateOfBirth, phoneNumber, address);
        this.insuranceCompany = insuranceCompany;
        this.medicalHistory = medicalHistory;
    }

}
