package mcs;

import java.util.Scanner;

// Modify as necessary
// References: MenuOptionTester.java, Java_II_HOLs_10
public class MedicalClinicSystem {
    Scanner scanner = new Scanner(System.in);

    while (true)

    {// print menu options
        for (MenuOption option : MenuOption.values()) {
            System.out.println(option.getValue() + ". " + option.getDescription());

        }// get user input
        System.out.println("\nEnter an option: ");
        int choice = scanner.nextInt();

        // handle the choice using enhanced switch
        MenuOption selectedOption = MenuOption.fromInt(choice);

        if (selectedOption == null) {
            System.out.println("Invalid option. Please try again");
            continue;   // Invalid input, loop again
        }

        // use enhanced switch
        switch (selectedOption) {
            case ADD_DOCTOR -> System.out.println("Add a new Doctor...");
            case ADD_PATIENT -> System.out.println("Add a new Patient...");
            case DISPLAY_DOCTOR_INFO -> System.out.println("Display Doctor Info...");
            case DISPLAY_PATIENT_INFO -> System.out.println("Display Patient Info...");
            case ADD_TREATMENT -> System.out.println("Add a new Treatment...");
            case VIEW_TREATMENT_DETAILS -> System.out.println("View Treatment Details...");
            case EXIT -> {
                System.out.println("Exiting Medical Clinic System...");
                scanner.close();
                return;
            }
        }
    }
}
