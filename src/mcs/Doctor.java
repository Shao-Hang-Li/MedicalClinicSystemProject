package mcs;

public class Doctor extends Person{

    private String specialty;
    private int yearsExp;

    public Doctor(String name, String dateOfBirth, String phoneNumber, String address, String specialty, int yearsExp) {
        super(name, dateOfBirth, phoneNumber, address);
        this.specialty = specialty;

        setYearsExp(yearsExp);
    }

    public void setYearsExp(int yearsExp) {
        if (yearsExp < 0) {
            throw new IllegalArgumentException("Years of experience must be greater then 0");
        }
    }

}
