package mcs;

import java.util.Scanner;

/**
 * This is the doctor class. It is a subclass of person refering to the doctors of the hospital
 * 
 * this class is used to add doctors and implement them into treatments
 * @see Date
 * @see MedicalClinicSystem
 * @see MenuOption
 * @see Patient
 * @see Person
 * @see Receptionist
 * @see Schedulable
 * @see Treatable
 * @see Treatment
 */
public class Doctor extends Person implements Treatable{
    // Data members (Fields)
    private String specialty;
    private int yearsOfExperience;
    Scanner input = new Scanner(System.in);
    // Constructor with parameters
    public Doctor(String name, Date dateOfBirth, String phoneNumber, String address, String specialty,
                  int yearsOfExperience) {
        // Super class Person
        super(name, dateOfBirth, phoneNumber, address);

        this.specialty = specialty;
        this.setYearsOfExperience(yearsOfExperience);    //setter with validation
    }

    // Mutators and accessors
    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        // Validation for yearsOfExperience (can't be negative)
        if (yearsOfExperience < 0) {
            throw new IllegalArgumentException("Years of experience must be a positive value");
        }
        this.yearsOfExperience = yearsOfExperience;
    }

    /**
     * The method Prints the Doctor's basic Info (Name, Specialty, Experience)
     */
    @Override
    public void displayInfo(){
        System.out.println(this);
    }

    /**
     * The method takes user input and update corresponding parameter of the Doctor object
     */
    @Override
    public void updateInfo(){
        int option = 0;
        try {
            while (option != 7){
                System.out.println("Please specify the info you wish to update");
                System.out.println("1. Name \n" +
                    "2. Birthday \n" +
                    "3. Phone Number \n" +
                    "4. Address \n" +
                    "5. Specialty \n" +
                    "6. Years of experience\n" +
                    "7. Back to menu");
                option = input.nextInt();
                input.nextLine();
                switch (option){
                    case 1:
                        System.out.println("Enter the name of the doctor");
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
                        System.out.println("Enter the phone number of the doctor");
                        String phoneNumber = input.nextLine();
                        this.setPhoneNumber(phoneNumber);
                        break;
                    case 4:
                        System.out.println("Enter the address of the doctor");
                        String address = input.nextLine();
                        this.setAddress(address);
                        break;
                    case 5:
                        System.out.println("Enter the specialty of the doctor");
                        String specialty = input.nextLine();
                        this.setSpecialty(specialty);
                        break;
                    case 6:
                        System.out.println("Enter the years of experience of the doctor");
                        int yearsOfExperience = input.nextInt();
                        input.nextLine();
                        this.setYearsOfExperience(yearsOfExperience);
                        break;
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * The method prints the performed treatment for the specific object
     */
    public void performTreatment(){
        System.out.println("Doctor" + this.getName() + "is performing treatment");
    }


    // Return String representation of the Doctor object
    @Override
    public String toString() {
        return String.format("%s %n Specialty: %s %n Years of Experience: %d %n", super.toString(), specialty,
                yearsOfExperience);
    }
}
