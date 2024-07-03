package tictactoe;

import java.util.Scanner;


public class UserInput {
    // INSTANCE VARIABLES
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Gets the input from the user using scanner.
     *
     * @return The user input as a String
     */
    public static String getUserInput() {
        return scanner.nextLine();
    }



}
