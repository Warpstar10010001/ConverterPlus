//Boo!!

import java.util.Scanner;

public class MaxBinOut {
    static Scanner scanner = new Scanner(System.in);
    public static void convert(){
        System.out.println("++ Maximum Binary Output Calculator ++\n");

        System.out.print("Enter length of binary string: ");
        int n = scanner.nextInt();

        int result = (int) (Math.pow(2, n) - 1);

        System.out.println("Result: " + result);

        Main.restart();
    }    
}