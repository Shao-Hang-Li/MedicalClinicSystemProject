package mcs;

// Modify as necessary
// References MenuOption.java, Java_II_HOLs_10

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
    EXIT(11, "Exit THE Medical Clinic System");

    // data members (fields)
    private final int value;
    private final String description;

    // constructor initializes the value and description
    private MenuOption(int value, String description) {
        this.value = value;
        this.description = description;
    } // end constructor

    // get value method
    public int getValue() {
        return this.value;
    }
    // det description
    public String getDescription() {
        return this.description;
    }

    // method to get the MenuOption by its value
    // fromInt(int i) method maps an integer to a MenuOption constant.
    // if the input doesn't match any option, it returns null
    public static MenuOption fromInt(int i) {
        for (MenuOption option : MenuOption.values()) {
            if (option.getValue() == i) {
                return option;
            }
        }
        return null;
    }
} // end enum
