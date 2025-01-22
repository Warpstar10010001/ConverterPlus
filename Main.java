//Boo!!

import java.util.Scanner;

public class Main {
    //Global objects:
    static Scanner scanner = new Scanner(System.in);
    static Fork fork = new Fork();

    //Global variables:
    static final String LASTUPDATE = "22.01.25";
    static final String VERSION = "1.0";
    static final String DIVIDER = "\n--------------------------------------------\n";

    public static void main(String[] args) {
        System.out.println("++++ ConverterPlus ++++");
        System.out.println("Version: " + VERSION + " / Last Updated: " + LASTUPDATE);
        System.out.println(DIVIDER);

        Data.configMode();
        selection(true);
    }

    public static void selection(boolean isFirstRun){
        System.out.println("Select one of the modes listed below:");

        int modeIndex = 0;
        boolean unlockAdmin = true;
        int nonAdminModeCount = 0;

        for(int i = 0; i < Data.getModeSelection().length; i++){
            if(Data.getModeAvailability()[i] == true){
                nonAdminModeCount++;
            }
        }

        if(Data.getModeSelection().length == nonAdminModeCount){
            unlockAdmin = false;
        }

        if(!isFirstRun || !unlockAdmin){
            modeIndex++;
        }
        
        for(int i = modeIndex; i < Data.getModeSelection().length; i++){
            if(!(Data.isAdmin())){
                if(Data.getModeAvailability()[i] == true){
                    if(unlockAdmin){
                        System.out.println("[" + i + "]: " + Data.getModeSelection()[i]);
                    } else {
                        if(i != 0){
                            System.out.println("[" + i + "]: " + Data.getModeSelection()[i]);
                        }
                    }
                }
            } else {
                if(Data.getModeAvailability()[i] == true){
                    System.out.println("[" + i + "]: " + Data.getModeSelection()[i]);
                } else {
                    System.out.println("[" + i + "]: " + Data.getModeSelection()[i] + " [Admin Mode]"); 
                }
            }
        }

        if(Data.isAdmin()){
            System.out.print("\nSelection [1-" + (Data.getModeSelection().length - 1) + "]: ");
        } else {
            System.out.print("\nSelection [" + modeIndex + "-" + (nonAdminModeCount - 1) + "]: ");
        }
        int selection = scanner.nextInt();

        if(selection >= modeIndex && selection < Data.getModeSelection().length){
            System.out.println(DIVIDER);
        }

        switch (selection){
            case 0 -> {
                if(isFirstRun && unlockAdmin){
                    Data.setAdmin(true);
                    System.out.println("Admin Mode: " + Data.isAdmin());
                    System.out.println(DIVIDER);
                    selection(false);
                } else {
                    exit(true, 1);
                }
            }
            default -> fork.exec(selection);
        }
    }

    public static void restart(){
        scanner.nextLine();

        System.out.println(DIVIDER);
        System.out.print("Calculate another value? [Y/N]: ");
        char restart = Character.toUpperCase(scanner.nextLine().charAt(0));
        switch (restart) {
            case 'N' -> exit(false, 0);
            case 'Y' -> {
                System.out.println(DIVIDER);
                selection(false);
            }
            default -> exit(true, 1);
        }
    }

    public static void RTM(){
        System.out.println(DIVIDER);
        System.out.println("Returning to Mode Selection.");
        System.out.println(DIVIDER);
        selection(false);
    }

    public static void exit(boolean isError, int exitCode){
        if(isError){
            String errorMessage = "\nError: ";
            switch (exitCode){
                case 1 -> errorMessage += "Invalid input.";
                case 2 -> errorMessage += "Mode Unavailable.";
                //Implement other error messages if needed
                default -> errorMessage += "Internal system failure.";
            }
            System.out.print(errorMessage);
        } else {
            System.out.print("\nSession terminated.");
        }

        System.exit(0);
    }
}