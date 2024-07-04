package tictactoe;

public class CreateTable {

    /**
     * Takes first, second, and third row of the current game can creates a formatted table.
     * Dashes are added above and below, pipes are added on either side on the table and the
     * characters a spaced out from each other.
     *
     * @param tableMatrix the table to be formatted
     * @return The formatted table
     */
    public static String createFormattedTable(char[][] tableMatrix) {
        // Create table variable
        StringBuilder table = new StringBuilder();
        // Add to StringBuilder
        table.append(dashes());

        // Add the elements of the matrix to the String builder
        for (int row = 0; row < tableMatrix.length; row++) {
            table.append("| ");
            for (int col = 0; col < tableMatrix[row].length; col++) {
                table.append(tableMatrix[row][col]).append(" ");
            }
            // After a row is filled, it goes to a new line
            table.append("|\n");
        }

       // Dashes appended to the bottom line
        table.append(dashes());
        return table.toString();

    }


    /**
     * Creates and returns a String of dashed lines
     *
     * @return A string of dashes
     */
    private static String dashes() {
        return "---------\n";
    }

}
