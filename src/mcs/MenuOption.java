package mcs;
// REFERENCES FOR THE MENUOPTIONS IN THIS ENUM AND IN THE MEDICALCLINICSYSTEM:
// We implemented the in class notes: MenuOption.java and MenuOptionTester.java
/**
 * This is the menu option enum. 
 * 
 * This enum is used as the menu for navigating all the options of the main method
 * @see Date
 * @see Doctor
 * @see MedicalClinicSystem
 * @see Patient
 * @see Person
 * @see Receptionist
 * @see Schedulable
 * @see Treatable
 * @see Treatment
 */
public enum MenuOption {
    /// Each menu option has an associated integer value(value) and a string description (description)
    ADD_DOCTOR(1, "Add a new Doctor"),
    ADD_PATIENT(2, "Add a new Patient"),
    DISPLAY_DOCTOR_INFO(3, "Display Doctor Information"),
    UPDATE_DOCTOR_INFO(4, "Update Doctor Information"),
    DISPLAY_PATIENT_INFO(5, "Display Patient Information"),
    UPDATE_PATIENT_INFO(6, "Update Patient Information"),
    ADD_TREATMENT(7, "Add a Treatment"),
    VIEW_TREATMENT_DETAILS(8, "View Treatment DETAILS"),
    PERFORM_TREATMENT(9, "Perform Treatment"),
    SCHEDULE_APPOINTMENT(10, "Schedule Appointment"),
    EXIT(11, "Exit Medical Clinic System");

    // data members (fields)
    private final int value;
    private final String description;

    /**
     * Constructor for menu option
     * @param value menu option's value
     * @param description menu option's description
     */
    private MenuOption(int value, String description) {
        this.value = value;
        this.description = description;
    } // end constructor

    /**
     * get value method
     * @return value
     */
    public int getValue() {
        return this.value;
    }
    /**
     * get description
     * @return description
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Method to set up menu option with the right amount of options
     * @param i number of options
     * @return number of options
     */
    public static MenuOption fromInt(int i) {
        for (MenuOption option : MenuOption.values()) {
            if (option.getValue() == i) {
                return option;
            }
        }
        return null;
    }
} // end enum
