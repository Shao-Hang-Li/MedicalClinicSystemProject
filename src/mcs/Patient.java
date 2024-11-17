package mcs;

import javax.management.InvalidAttributeValueException;
import java.util.Scanner;

public class Patient extends Person implements Treatable{

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

    /**
     * The method updates(append) new medical history to the existing history.
     * @param medicalHistory medical history of the patient
     */
    public void addHistory(String medicalHistory) {
        this.medicalHistory += ("\n" + medicalHistory);
    }

    /**
     * The method displays general info about the patient
     */
    @Override
    public void displayInfo(){
        System.out.println(this);
    }

    //called when user asks to update info, method will prompt user to enter corresponding info and update it
    @Override
    public void updateInfo(){
        int option = 0;
        Scanner input = new Scanner(System.in);
        try {
            while (option != 7){
                System.out.println("Please specify the info you wish to update");
                System.out.println("1. Name \n" +
                        "2. Birthday \n" +
                        "3. Phone Number \n" +
                        "4. Address \n" +
                        "5. Insurance Company \n" +
                        "6. Medical History\n" +
                        "7. back to menu");
                option = input.nextInt();
                input.nextLine();
                switch (option){
                    case 1:
                        System.out.println("Enter the name of the patient");
                        String name = input.nextLine();
                        this.setName(name);
                        break;
                    case 2:
                        System.out.println("Enter the date of birth (DD MM YYYY)");
                        int day = input.nextInt();
                        int month = input.nextInt();
                        int year = input.nextInt();
                        input.nextLine();
                        Date newBirthday = new Date(day, month, year);
                        this.setDateOfBirth(newBirthday);
                        break;
                    case 3:
                        System.out.println("Enter the phone number of the patient");
                        String phoneNumber = input.nextLine();
                        this.setPhoneNumber(phoneNumber);
                        break;
                    case 4:
                        System.out.println("Enter the address of the patient");
                        String address = input.nextLine();
                        this.setAddress(address);
                        break;
                    case 5:
                        System.out.println("Enter the insurance company of the patient");
                        String Insurance = input.nextLine();
                        this.setInsuranceCompany(Insurance);
                        break;
                    case 6:
                        System.out.println("Please choose and option: \n1. Add to existing medical history\n2. Rewrite medical history");
                        int option2 = input.nextInt();
                        input.nextLine();
                        if (option2 == 1){
                            System.out.println("Enter the medical history of the patient");
                            String medicalHistory = input.nextLine();
                            this.addHistory(medicalHistory);
                        }
                        else if (option2 == 2){
                            System.out.println("Enter the medical history of the patient");
                            String medicalHistory = input.nextLine();
                            this.setMedicalHistory(medicalHistory);
                        }
                        else{
                            throw new IllegalArgumentException();
                        }
                        break;
                }
            }
            input.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public String performTreatment(){
        return "Patient" + this.getName() + "is receiving treatment";
    }
    // Return String representation of the Patient object
    @Override
    public String toString() {
        return String.format("%s %nInsurance company: %s %nMedical history: %s", super.toString(), insuranceCompany, medicalHistory);
    }
}
