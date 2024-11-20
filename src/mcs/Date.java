package mcs;

// References: I took this date class that I created from the past few homeworks.
/**
 * This is the date class. It is used to make dates in most of the other java classes.
 * @see Doctor
 * @see MedicalClinicSystem
 * @see MenuOption
 * @see Patient
 * @see Person
 * @see Receptionist
 * @see Schedulable
 * @see Treatable
 * @see Treatment
 */
public class Date {
    // declare data members (field)
    private int day;
    private int month;
    private int year;

    /**
     * Default constructor for date
     */
    public Date() {
        day = 0;
        month = 0;
        year = 0;
    }

    /**
     * Constructor with parameters for date
     * @param day day of specified date
     * @param month month of specified date
     * @param year year of specified date
     */
    public Date(int day, int month, int year) {
        // validate day (day can be 28, 30 or 31, for this example I will put 31 to be simple)
        if (day > 0 && day <= 31) {
            this.day = day;
        }
        else {
            throw new IllegalArgumentException("The day has to be chosen from 1 to 31.");
        }

        // validate month
        if (month > 0 && month <= 12) {
            this.month = month;
        }
        else {
            throw new IllegalArgumentException("The month has to be chosen from 1 to 12.");
        }

        // Year
        this.year = year;
    }

    /**
     * getter for day
     * @return day
     */
    public int getDay() {
        return day;
    }
    /**
     * getter for month
     * @return month
     */
    public int getMonth() {
        return month;
    }
    /**
     * getter for year
     * @return year
     */
    public int getYear() {
        return year;
    }
    /**
     * setter for year
     * @param year year
     */
    public void setYear(int year) {
        this.year = year;
    }
    /**
     * String to set display for dates
     */
    @Override
    public String toString() {
        return day + "/" + month + "/" + year;
    }
}
