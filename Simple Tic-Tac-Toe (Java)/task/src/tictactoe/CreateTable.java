package tictactoe;

public class CreateTable {

    /**
     * Takes first, second, and third row of the current game can creates a formatted table.
     * Dashes are added above and below, pipes are added on either side on the table and the
     * characters a spaced out from each other.
     *
     * @param firstLine The first line of the table to be formatted
     * @param secondLine The first line of the table to be formatted
     * @param thirdLine The first line of the table to be formatted
     * @return The formatted table
     */
    public static String createFormattedTable(String firstLine, String secondLine, String thirdLine) {
        // Create table variable
        StringBuilder table = new StringBuilder();

        // Format lines
        String formattedFirstLine = formatLineWithPipes(firstLine);
        String formattedSecondLine = formatLineWithPipes(secondLine);
        String formattedThirdLine = formatLineWithPipes(thirdLine);

        // Add to StringBuilder
        table.append(dashes());
        table.append(formattedFirstLine);
        table.append(formattedSecondLine);
        table.append(formattedThirdLine);
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

    /**
     * Takes in a line of characters and returns a String or formatted characters between two pipes
     *
     * @param lineInput The line to be formatted
     * @return The formatted line
     */
    private static String formatLineWithPipes(String lineInput) {
        // Characters to be formatted
        char first = lineInput.charAt(0);
        char second = lineInput.charAt(1);
        char third = lineInput.charAt(2);

        return String.format("| %c %c %c |\n", first, second, third);
    }


}
