//Boo!!

public class Fork {
    public void exec(int selection){
        if(!Data.isAdmin()){
            if(selection <= (Data.getModeAvailability().length - 1)){
                if(Data.getModeAvailability()[selection] == false){
                    Main.exit(true, 2);
                }
            } else {
                Main.exit(true, 1);
            }
        }
        switch (selection){
            case 1 -> MaxBinOut.convert();
            default -> Main.exit(true, 1);
        }
    }
}