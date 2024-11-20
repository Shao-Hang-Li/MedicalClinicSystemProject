package mcs;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * This is the main method. It is used as to run everything
 * 
 * To run everything it uses a menu, which is an enum.
 * @author Qi He, Shao Hang Li, John Nicholas Goettisheim.
 * @version 1.0
 * @since 15-11-2024
 * @see Date
 * @see Doctor
 * @see MenuOption
 * @see Patient
 * @see Person
 * @see Receptionist
 * @see Schedulable
 * @see Treatable
 * @see Treatment
 */
public class MedicalClinicSystem {

    Scanner scanner = new Scanner(System.in);

    ArrayList<Doctor> doctors = new ArrayList<>();
    ArrayList<Patient> patients = new ArrayList<>();
    ArrayList<Treatment> treatments = new ArrayList<>();
    private Receptionist receptionist;

    // References: MenuOptionTester.java
    // In class notes for the option part.
    public static void main(String[] args) {
        MedicalClinicSystem mcs = new MedicalClinicSystem();
        Scanner console = new Scanner(System.in);
        mcs.readAll();
        while (true) {

            for (MenuOption menuOption : MenuOption.values()) {
                System.out.println(menuOption.getValue() + ". " + menuOption.getDescription());

            }

            System.out.println("\nEnter an option: ");
            int choice = console.nextInt();
            console.nextLine();

            MenuOption selectedOption = MenuOption.fromInt(choice);

            if (selectedOption == null) {
                System.out.println("Invalid option. Please select another.");
                continue;  
            }

            switch (selectedOption) {
                case ADD_DOCTOR -> mcs.addDoctor();
                case ADD_PATIENT -> mcs.addPatient();
                case DISPLAY_DOCTOR_INFO -> mcs.doctorDisplay();
                case UPDATE_DOCTOR_INFO -> mcs.updateDoctor();
                case DISPLAY_PATIENT_INFO -> mcs.patientDisplay();
                case UPDATE_PATIENT_INFO -> mcs.updatePatient();
                case ADD_TREATMENT -> mcs.addTreatment();
                case VIEW_TREATMENT_DETAILS -> mcs.treatmentDisplay();
                case PERFORM_TREATMENT -> mcs.performTreatments();
                case SCHEDULE_APPOINTMENT -> mcs.scheduleAppointment();
                case EXIT -> {
                    mcs.saveAll();
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
        System.out.println("Accessing Data...");
        readDoctorFromFile();
        readPatientFromFile();
        readTreatmentFromFile();
        System.out.println("Access Complete.");
    }

    /**
     * The method is a combination of three methods to increase readability and for easier apllication.
     * The method writes Doctor, Patient and Treatment to corresponding files
     */
    public void saveAll(){
        System.out.println("Saving Data...");
        writeDoctorToFile();
        writePatientToFile();
        writeTreatmentToFile();
        System.out.println("All Data saved. See you next time.");
    }
    
    /**
     * The method searches and returns a Doctor by the name
     * @param name name of the doctor
     * @return doctor object
     */
    public Doctor findDoctorByName(String name) {
        for (Doctor doctor : doctors) {
            if ((doctor.getName()).equalsIgnoreCase(name)) {
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
            if ((patient.getName()).equalsIgnoreCase(name)) {
                return patient;
            }
        }
        return null;
    }

    /**
     * The method searches and returns a treatment by ID
     * @param id treatment ID
     * @return treatment object
     */
    public Treatment findTreatmentByID(String id) {
        for (Treatment treatment : treatments) {
            if ((treatment.getTreatmentID()).equalsIgnoreCase(id)) {
                return treatment;
            }
        }
        return null;
    }

    /**
     * The method reads from Treatment.txt file and stores all treatment objects in an ArrayList
     */
    public void readTreatmentFromFile() {
        try{
            File file = new File("Treatment.txt");
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()){
                String aLine = reader.nextLine();
                String [] line = aLine.split(",");      //Separate String by comma and store into a list
                //access each data from the list by index
                String treatmentID = line[0];
                Date date = new Date(Integer.parseInt(line[1]), Integer.parseInt(line[2]), Integer.parseInt(line[3]));
                String doctorName = line[4];
                Doctor theDoc = findDoctorByName(doctorName);
                String patientName = line[5];
                Patient thePatient = findPatientByName(patientName);
                String treatmentType = line[6];
                double cost = Double.parseDouble(line[7]);
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
            File file = new File("Doctor.txt");
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()){
                String aLine = reader.nextLine();
                String [] line = aLine.split(",");      //Separate String by comma and store into a list
                //access each data from the list by index
                String name = line[0];
                Date dateOfBirth = new Date(Integer.parseInt(line[1]), Integer.parseInt(line[2]), Integer.parseInt(line[3]));
                String phoneNumber = line[4];
                String address = line[5];
                String specialty = line[6];
                int yearsOfExperience = Integer.parseInt(line[7]);
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
            File file = new File("Patient.txt");
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()){
                String aLine = reader.nextLine();
                String [] line = aLine.split(",");      //Separate String by comma and store into a list
                //access each data from the list by index
                String name = line[0];
                Date dateOfBirth = new Date(Integer.parseInt(line[1]), Integer.parseInt(line[2]), Integer.parseInt(line[3]));
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
                writer.printf("%s,%d,%d,%d,%s,%s,%s,%s%n", patient.getName(), dateOfBirth.getDay(), dateOfBirth.getMonth(), dateOfBirth.getYear(),
                patient.getPhoneNumber(), patient.getAddress(), patient.getInsuranceCompany(), patient.getMedicalHistory());
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

    public void addDoctor() {
        System.out.println("Enter Doctor's name");
        String name = scanner.nextLine();
        System.out.println("Enter Doctor's date of birth starting from date to year (DD MM YYYY)");
        Date dateOfBirth = new Date(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
        scanner.nextLine();
        System.out.println("Enter Doctor's phone number");
        String phoneNumber = scanner.nextLine();
        System.out.println("Enter Doctor's Address");
        String address = scanner.nextLine();
        System.out.println("Enter Doctor's Specialty");
        String specialty = scanner.nextLine();
        System.out.println("Enter Doctor's years of experience");
        int yearsOfExperience = scanner.nextInt();
        scanner.nextLine();
        Doctor aDoctor = new Doctor(name, dateOfBirth, phoneNumber, address, specialty, yearsOfExperience);
        doctors.add(aDoctor);
    }    

    public void addPatient() {
        System.out.println("Enter Patient's name");
        String name = scanner.nextLine();
        System.out.println("Enter Patient's date of birth starting from date to year (DD MM YYYY)");
        Date dateOfBirth = new Date(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
        scanner.nextLine();
        System.out.println("Enter Patient's phone number");
        String phoneNumber = scanner.nextLine();
        System.out.println("Enter Patient's Address");
        String address = scanner.nextLine();
        System.out.println("Enter the insurance company");
        String insuranceCompany = scanner.nextLine();
        System.out.println("Enter the medical history");
        String medicalHistory = scanner.nextLine();
        Patient aPatient = new Patient(name, dateOfBirth, phoneNumber, address, insuranceCompany, medicalHistory);
        patients.add(aPatient);
    }
    
    public void addTreatment() {
        System.out.println("Enter the treatmentID");
        String treatmentID = scanner.nextLine();
        System.out.println("Enter the date of the treatment");
        Date date = new Date(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
        scanner.nextLine();
        System.out.println("Enter the doctor preforming the treatment");
        Doctor docName = findDoctorByName(scanner.nextLine());
        System.out.println("Enter patient receiving treatment");
        Patient patName = findPatientByName(scanner.nextLine());
        System.out.println("Enter the treatment type");
        String treatmentType = scanner.nextLine();
        System.out.println("Enter treatment cost");
        double cost = scanner.nextDouble();
        scanner.nextLine();
        Treatment aTreatment = new Treatment(treatmentID, date, docName, patName, treatmentType, cost);
        treatments.add(aTreatment);
    }

    public void doctorDisplay() {
        for(Doctor aDoctor : doctors) {

            System.out.printf("%n %s %n", aDoctor.toString());
            System.out.println();
            
        }
        System.out.println("Returning to menu");
    }

    public void patientDisplay() {
        for(Patient aPatient : patients) {

            System.out.printf("%n %s %n", aPatient.toString());
            System.out.println();
        }    
        System.out.println("Returning to menu");
        
    }

    public void treatmentDisplay() {
        for(Treatment aTreatment : treatments) {
            
            System.out.printf("%n %s %n %n", aTreatment.toString());

        }
    }
    /**
     * the method prompts the user to enter a name and calls update info for a patient class object, and modifies the object
     */
    public void updateDoctor(){
        System.out.println("Please enter doctor's name: ");
        String name = scanner.nextLine();
        Doctor aDoctor = findDoctorByName(name);
        if (aDoctor != null) {
            aDoctor.updateInfo();
        }
        else{
            System.out.println("Doctor not found.");
        }
    }

    /**
     * the method prompts t e user to enter a name and calls update info for a patient class object, and modifies the object
     */
    public void updatePatient(){
        System.out.println("Please enter patient's name: ");
        String name = scanner.nextLine();
        Patient aPatient = findPatientByName(name);
        if (aPatient != null) {
            aPatient.updateInfo();
        }
        else{
            System.out.println("Patient not found.");
        }
    }

    /**
     * the method shows the info of performing treatment. Uses polymorphism for each class
     */
    public void performTreatments(){
        System.out.println("Please enter treatment ID: ");
        String treatmentID = scanner.nextLine();
        Treatment aTreatment = findTreatmentByID(treatmentID);
        if (aTreatment != null) {
            aTreatment.performTreatment();
            System.out.println(aTreatment.toString());
            System.out.println("---- People Information -----");
            aTreatment.getDoctor().performTreatment();
            aTreatment.getPatient().performTreatment();
            System.out.println("-----------------------------");
        }
        else{
            System.out.println("Treatment not found.");
        }
    }

    /**
     *  This method helps the receptionist schedule an appointment for the patient by finding the patientName first
     */
    public void scheduleAppointment() {
        System.out.println("Please enter the receptionist name: ");
        String receptionistName = scanner.nextLine();
        this.receptionist = new Receptionist(receptionistName);
        System.out.println("Please enter the patient name: ");
        String patientName = scanner.nextLine();
        Patient aPatient = findPatientByName(patientName);

        if (aPatient != null) {
            receptionist.scheduleAppointment();
        }
        else {
            System.out.println("There are no patient with the above name");
        }
    }
}
