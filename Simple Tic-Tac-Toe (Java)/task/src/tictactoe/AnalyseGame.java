package tictactoe;

public class AnalyseGame {

    /**
     * Analyses the state of the game and provides feedback for the user:
     *
     * - Impossible
     * - X wins
     * - O wins
     * - Draw
     * - Game not finished
     *
     * @param table The table to be analysed
     * @return A String with the state of the game.
     */
    public static GameState analyseGame(char[][] table) {
        if (impossible(table)) {
            return GameState.IMPOSSIBLE;
        } else if (xWins(table)) {
            return GameState.X_WINS;
        } else if (oWins(table)) {
            return GameState.O_WINS;
        } else if (Draw(table)) {
            return GameState.DRAW;
        } else {
            return GameState.GAME_NOT_FINISHED;
        }
    }

    /**
     * The current state of the table analysed by analyseGame(char[][] table) method. An enum of
     * the game state is return and compared to GameState.GAME_NOT_FINISHED. If it is true, then
     * the game should continue.
     *
     * @param table The table to be analysed
     * @return True if the game should continue; false otherwise.
     */
    public static boolean isGameContinuing(char[][] table) {
        return analyseGame(table) == GameState.GAME_NOT_FINISHED;
    }

    /**
     * Checks if the state of the game is braking the rules, such as two winners or one player
     * has many more entries than the other.
     *
     * @param table The table to be checked
     * @return True if it is impossible, false otherwise
     */
    private static boolean impossible(char[][] table) {
        // If both 'X' and 'O' have three in a row, that is not a possible outcome
        if (isWinner(table, 'X') && isWinner(table, 'O')) {
            return true;
        }

        int countX = 0;
        int countO = 0;

        // Iterate through the whole table
        for (int row = 0; row < table.length; row++) {
            for (int col = 0; col < table[row].length; col++) {
                if (table[row][col] == 'X') {
                    countX++;
                } else if (table[row][col] == 'O') {
                    countO++;
                }

            }
        }

        // If there are more than 1 symbols in the difference, then this is impossible
        if (Math.abs(countX - countO) > 1) {
            return true;
        }

        return false;
    }

    /**
     * Checks the state of the game to see if it is a draw. It does so my seeing if the table is
     * filled with 'X's and 'O's without a winner.
     *
     * @param table The table to be checked
     * @return True if it is a draw; false otherwise
     */
    private static boolean Draw(char[][] table) {
        boolean isFull = true;
        boolean hasWinner;
        for (int row = 0; row < table.length; row++) {
            for (int col = 0; col < table[row].length; col++) {
                if (table[row][col] == ' ' || table[row][col] == '_') {
                    isFull = false;
                }
            }
        }

        hasWinner = isWinner(table, 'X') || isWinner(table, 'O');

        return isFull && !hasWinner;
    }

    /**
     * Checks to see if player 'O' wins
     *
     * @param table The table to check
     * @return True if 'O' wins; false otherwise
     */
    private static boolean oWins(char[][] table) {
        return isWinner(table, 'O');
    }

    /**
     * Checks to see ig player 'X' wins
     *
     * @param table The table to check
     * @return True if 'X' wins; false otherwise
     */
    private static boolean xWins(char[][] table) {
        return isWinner(table, 'X');
    }

    /**
     * Using the helper methods for finding a winner, this method takes in a table and a symbol
     * to check if that symbol is a winner.
     *
     * @param table The table to be checked
     * @param symbol The symbol to check in each method
     * @return True if the symbol is found three time consecutively, false otherwise.
     */
    private static boolean isWinner(char[][] table, char symbol) {
        return threeInARow(table, symbol) ||
                threeInACol(table, symbol) ||
                threeDiagonalBottomLeft(table, symbol) ||
                threeDiagonalTopLeft(table, symbol);
    }

    /**
     *
     * @param table The table of 'X's and 'O's to be checked
     * @param symbol Represents the 'X' or the 'O' to be checked
     * @return True if there is three of the chosen symbol in a row, false otherwise
     */
    private static boolean threeInARow(char[][] table, char symbol) {
        int consecutive;

        for (int row = 0; row < table.length; row++) {
            // Each time a new row starts, start the consecutive count again.
            consecutive = 0;
            for (int col = 0; col < table[row].length; col++) {

                if (table[row][col] == symbol) {
                    consecutive++;
                } else {
                    // If the next symbol is not consecutive, set consecutive to O
                    consecutive = 0;
                }
                // If there is
                // three in a row, return true
                if (consecutive == 3) return true;
            }
        }
        return false;
    }

    /**
     * Checks for three in each column and returns true if found, false otherwise.
     *
     * @param table The table to be checked for the symbol 3 times consecutively.
     * @param symbol The symbol to be checked for
     * @return True if the symbol is found 3 times consecutively, false otherwise.
     */
    private static boolean threeInACol(char[][] table, char symbol) {
        int consecutive;
        for (int col = 0; col < table[0].length; col++) {
            // Rest consecutive if checking a new column
            consecutive = 0;
            // Check each column
            for (int row = 0; row < table.length; row++) {
                if (table[row][col] == symbol) {
                    consecutive++;
                } else {
                    // Reset consecutive if the symbol is not found
                    consecutive = 0;
                }
                // Return true if three in a row.
                if (consecutive ==3) return true;
            }
        }
        return false;
    }

    /**
     * Checks for three symbols in a row diagonally from top left to bottom right.
     *
     * @param table The table to check for the three symbols
     * @param symbol The symbol to be checked for
     * @return True if three consecutive symbols are found, false otherwise.
     */
    private static boolean threeDiagonalTopLeft(char[][] table, char symbol) {
        int consecutive = 0;

        // Index is the same for the row and column
        for (int i = 0; i < table.length; i++) {
            if (table[i][i] == symbol) {
                consecutive++;
            } else {
                // Reset consecutive if the symbol does not match
                consecutive = 0;
            }
        }

        return consecutive == 3;
    }

    /**
     * Iterates from top right to bottom left of the matrix to check for 3 consecutive symbols.
     *
     * @param table The table to be checked
     * @param symbol The symbol checked for
     * @return True if three consecutive symbols, false otherwise.
     */
    private static boolean threeDiagonalBottomLeft(char[][] table, char symbol) {
        int consecutive = 0;


        for (int i = 0; i < table.length; i++) {
            // length of the table - 1 (as we index from 0) then minus the i to move backwards.
            if (table[table.length - 1- i][i] == symbol) {
                consecutive++;
            } else {
                consecutive = 0;
            }
        }
        return consecutive == 3;
    }


}