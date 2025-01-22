//Boo!!

import java.util.Arrays;

public class Data {
    //Global settings:
    private static boolean admin;

    //Global mode variables:
    private static String[] modeSelection;
    private static boolean[] modeAvailability;

    public static void configMode(){
        Data.modeSelection = new String[2];
        Data.modeAvailability = new boolean[Data.modeSelection.length];
        Arrays.fill(modeAvailability, true);

        //Mode options:
        Data.modeSelection[0] = "Admin Mode";
        Data.modeSelection[1] = "Maximum Binary Output";
    }

    public static boolean isAdmin() {
        return admin;
    }

    public static void setAdmin(boolean admin) {
        Data.admin = admin;
    }

    public static String[] getModeSelection() {
        return Data.modeSelection;
    }

    public static boolean[] getModeAvailability() {
        return Data.modeAvailability;
    }
}