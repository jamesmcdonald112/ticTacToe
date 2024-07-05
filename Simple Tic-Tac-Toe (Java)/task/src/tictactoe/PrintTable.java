package tictactoe;

public class PrintTable {

    /**
     * Prints a formatted table to the console.
     */
    public static void printFormattedTable() {
        System.out.println(CreateTable.createFormattedTable(PlayGame.getTable()));
    }
}
