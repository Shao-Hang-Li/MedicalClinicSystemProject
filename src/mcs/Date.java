package mcs;

// I took the Date.java class that I made in the previous homework.
// I added the verification part after the class yesterday by following the reference of BasePlusCommissionEmployee.java
// Java_II_HOLs_06
public class Date {
    // declare data members (field)
    private int day;
    private int month;
    private int year;

    // default constructor
    public Date() {
        day = 0;
        month = 0;
        year = 0;
    }

    // constructor with parameters
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

    // mutators and accessors
    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        // validate day (day can be 28, 30 or 31, for this example I will put 31 to be simple)
        if (day > 0 && day <= 31) {
            this.day = day;
        }
        else {
            throw new IllegalArgumentException("The day has to be chosen from 1 to 31.");
        }
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        if (month > 0 && month <= 12) {
            this.month = month;
        }
        else {
            throw new IllegalArgumentException("The month has to be chosen from 1 to 12.");
        }
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return day + "/" + month + "/" + year;
    }
}
