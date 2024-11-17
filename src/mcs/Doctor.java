package mcs;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
public class Doctor extends Person implements Treatable{
    // Data members (Fields)
    private String specialty;
    private int yearsOfExperience;

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
        Scanner input = new Scanner(System.in);
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
            input.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void performTreatment(){
        System.out.println("Doctor" + this.getName() + "is performing treatment");
    }


    /**
     * the method takes a Doctor ArrayList and write into a text file, with each peach of info seperated by comma
     * @param doctors An ArrayList consisting all doctor objects
     */
    public void writeToFile(ArrayList<Doctor> doctors) {
        try {
            PrintWriter writer = new PrintWriter("Doctor.txt");
            for (Doctor doctor:doctors){
                Date dateOfBirth = doctor.getDateOfBirth();
                writer.printf("%s,%d,%d,%d,%s,%s,%s,%d%n", this.getName(), dateOfBirth.getDay(), dateOfBirth.getMonth(), dateOfBirth.getYear()
                        , this.getPhoneNumber(), this.getAddress(), this.getSpecialty(), this.getYearsOfExperience());
            }
            writer.close();
        }catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }

    /**
     * The method reads from Doctor.txt file and returns all doctor objects in an ArrayList
     * @return a doctor ArrayList
     */
    public ArrayList<Doctor> readFromFile() {
        ArrayList<Doctor> doctors = new ArrayList<Doctor>();
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
            return doctors;
        }
        catch (Exception e){
            System.out.println(e);
        }
        return doctors;
    }

    // Return String representation of the Doctor object
    @Override
    public String toString() {
        return String.format("Name: %s %nSpecialty: %s %nYears of Experience: %d", getName(), specialty,
                yearsOfExperience);
    }
}
