package mcs;

import java.util.Scanner;
// Modify as necessary
// References: MenuOptionTester.java, Java_II_HOLs_10
public class MedicalClinicSystem {
    static Scanner console = new Scanner(System.in);

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

}
