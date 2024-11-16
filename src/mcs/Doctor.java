package mcs;

public class Doctor extends Person {
    // Data members (Fields)
    private String specialty;
    private int yearsOfExperience;

    // Constructor with parameters
    public Doctor(String name, Date dateOfBirth, String phoneNumber, String address, String specialty,
                  int yearsOfExperience) {
        // Super class Person
        super(name, dateOfBirth, phoneNumber, address);

        this.specialty = specialty;
        // Validation for yearsOfExperience (can't be negative)
        if (yearsOfExperience < 0) {
            throw new IllegalArgumentException("Years of experience must be a positive value");
        }
        this.yearsOfExperience = yearsOfExperience;
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

    // Return String representation of the Doctor object
    @Override

}
