package mcs;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
// Modify as necessary
// References: MenuOptionTester.java, Java_II_HOLs_10
public class MedicalClinicSystem {
    static Scanner console = new Scanner(System.in);
    ArrayList<Doctor> doctors = new ArrayList<>();
    ArrayList<Patient> patients = new ArrayList<>();
    ArrayList<Treatment> treatments = new ArrayList<>();

    public static void main(String[] args) {
    
        while (true) {

            for (MenuOption menuOption : MenuOption.values()) {
                System.out.println(menuOption.getValue() + ". " + menuOption.getDescription());

            }

            System.out.println("\nEnter an option: ");
            int choice = console.nextInt();

            MenuOption selectedOption = MenuOption.fromInt(choice);

            if (selectedOption == null) {
                System.out.println("Invalid option. Please select another.");
                continue;  
            }

            switch (selectedOption) {
                case ADD_DOCTOR -> System.out.println("Add a new Doctor...");
                case ADD_PATIENT -> System.out.println("Add a new Patient...");
                case DISPLAY_DOCTOR_INFO -> System.out.println("Display Doctor Info...");
                case DISPLAY_PATIENT_INFO -> System.out.println("Display Patient Info...");
                case ADD_TREATMENT -> System.out.println("Add a new Treatment...");
                case VIEW_TREATMENT_DETAILS -> System.out.println("View Treatment Details...");
                case EXIT -> {
                    System.out.println("Exiting Medical Clinic System, Have a Nice Day.");
                    console.close();
                    return;
                }

            }

        }

    }

    /**
     * The method is a combination of three methods to increase readability and for easier apllication.
     * The method reads Doctor, Patient and Treatment from corresponding files
     */
    public void readAll(){
        readDoctorFromFile();
        readPatientFromFile();
        readTreatmentFromFile();
    }

    /**
     * The method is a combination of three methods to increase readability and for easier apllication.
     * The method writes Doctor, Patient and Treatment to corresponding files
     */
    public void saveAll(){
        writeDoctorToFile();
        writePatientToFile();
        writeTreatmentToFile();
    }
    
    /**
     * The method searches and returns a Doctor by the name
     * @param name name of the doctor
     * @return doctor object
     */
    public Doctor findDoctorByName(String name) {
        for (Doctor doctor : doctors) {
            if (doctor.getName().equals(name)) {
                return doctor;
            }
        }
        return null;
    }

    /**
     * The method searches and returns a patient by the name
     * @param name name of the patient
     * @return patient object
     */
    public Patient findPatientByName(String name) {
        for (Patient patient : patients) {
            if (patient.getName().equals(name)) {
                return patient;
            }
        }
        return null;
    }

    /**
     * The method reads from Treatment.txt file and stores all treatment objects in an ArrayList
     */
    public void readTreatmentFromFile() {
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
                Doctor theDoc = findDoctorByName(doctorName);
                String patientName = line[5];
                Patient thePatient = findPatientByName(patientName);
                String treatmentType = line[6];
                double cost = Double.valueOf(line[7]);
                //now create a patient object
                Treatment aTreatment = new Treatment(treatmentID, date, theDoc, thePatient, treatmentType, cost);
                treatments.add(aTreatment);     //store into the ArrayList
            }
            reader.close();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    /**
     * The method reads from Doctor.txt file and stores all doctor objects in an ArrayList
     */
    public void readDoctorFromFile() {
        try{
            Scanner reader = new Scanner("Doctor.txt");
            while (reader.hasNextLine()){
                String aLine = reader.nextLine();
                String [] line = aLine.split(",");      //Separate String by comma and store into a list
                //access each data from the list by index
                String name = line[0];
                //we can use Integer.parseInt for type conversion
                Date dateOfBirth = new Date(Integer.valueOf(line[1]), Integer.valueOf(line[2]), Integer.valueOf(line[3]));
                String phoneNumber = line[4];
                String address = line[5];
                String specialty = line[6];
                int yearsOfExperience = Integer.valueOf(line[7]);
                //now create a patient object
                Doctor aDoctor = new Doctor(name, dateOfBirth, phoneNumber, address, specialty, yearsOfExperience);
                doctors.add(aDoctor);     //store into the ArrayList
            }
            reader.close();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    /**
     * The method reads from Patient.txt file and stores all patient objects in an ArrayList
     */
    public void readPatientFromFile() {
        try{
            Scanner reader = new Scanner("Patient.txt");
            while (reader.hasNextLine()){
                String aLine = reader.nextLine();
                String [] line = aLine.split(",");      //Separate String by comma and store into a list
                //access each data from the list by index
                String name = line[0];
                //we can use Integer.parseInt for type conversion
                Date dateOfBirth = new Date(Integer.valueOf(line[1]), Integer.valueOf(line[2]), Integer.valueOf(line[3]));
                String phoneNumber = line[4];
                String address = line[5];
                String insuranceCompany = line[6];
                String medicalHistory = line[7];
                //now create a patient object
                Patient aPatient = new Patient(name, dateOfBirth, phoneNumber, address, insuranceCompany, medicalHistory);
                patients.add(aPatient);     //store into the ArrayList
            }
            reader.close();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    /**
     * the method takes a Patient ArrayList and write into a text file, with each piece of info seperated by comma
     */
    public void writePatientToFile() {
        try {
            PrintWriter writer = new PrintWriter("Patient.txt");
            for (Patient patient:patients){
                Date dateOfBirth = patient.getDateOfBirth();
                writer.printf("%s,%d,%d,%d,%s,%s,%s,%s%n", patient.getName(), dateOfBirth.getDay(), dateOfBirth.getMonth(), dateOfBirth.getYear()
                        , patient.getPhoneNumber(), patient.getAddress(), patient.getInsuranceCompany(), patient.getMedicalHistory());
            }
            writer.close();
        }catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }

    /**
     * the method takes a Doctor ArrayList and write into a text file, with each piece of info seperated by comma
     */
    public void writeDoctorToFile() {
        try {
            PrintWriter writer = new PrintWriter("Doctor.txt");
            for (Doctor doctor:doctors){
                Date dateOfBirth = doctor.getDateOfBirth();
                writer.printf("%s,%d,%d,%d,%s,%s,%s,%d%n", doctor.getName(), dateOfBirth.getDay(), dateOfBirth.getMonth(), dateOfBirth.getYear()
                        , doctor.getPhoneNumber(), doctor.getAddress(), doctor.getSpecialty(), doctor.getYearsOfExperience());
            }
            writer.close();
        }catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }

    /**
     * the method takes a treatment ArrayList and write into a text file, with each piece of info seperated by comma
     */
    public void writeTreatmentToFile() {
        try {
            PrintWriter writer = new PrintWriter("Treatment.txt");
            for (Treatment treat:treatments) {
                Date date = treat.getDate();
                //here we only write Doctor and Patient name in the file
                writer.printf("%s,%d,%d,%d,%s,%s,%s,%.2f%n", treat.getTreatmentID(), date.getDay(), date.getMonth(),
                        date.getYear(), treat.getDoctor().getName(), treat.getPatient().getName(), treat.getTreatmentType(), treat.getCost());
            }
            writer.close();
        }catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }

    public static void addDoctor() {
        System.out.println("Enter Doctor's name");
        String name = console.nextLine();
        System.out.println("Enter Doctor's date of birth starting from date to year");
        Date dateOfBirth = new Date(console.nextInt(), console.nextInt(), console.nextInt());
        System.out.println("Enter Doctor's phone number");
        String phoneNumber = console.nextLine();
        System.out.println("Enter");
        String address = console.nextLine();
        System.out.println();
        String specialty = console.nextLine();
        System.out.println();
        int yearsOfExperience = console.nextInt();
    
        doctors.add(new Doctor(name, dateOfBirth, phoneNumber, address, specialty, yearsOfExperience));
    }    

}
