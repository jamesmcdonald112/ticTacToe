package tictactoe;

public class PlayGame {
    // INSTANCE VARIABLES
    private static char[][] table;
    private static char currentPlayer = 'X';

    // GETTER AND SETTERS
    public static char[][] getTable() {
        return table;
    }

    public static void setTable(char[][] table) {
        PlayGame.table = table;
    }

    public static char getCurrentPlayer() {
        return currentPlayer;
    }

    public static void setCurrentPlayer(char currentPlayer) {
        PlayGame.currentPlayer = currentPlayer;
    }

    // PUBLIC METHODS

    /**
     * Contains all the main functionality to run the game. An empty table is created, set for
     * the game and printed to the screen. The main game loop is running where users are ased for
     * the choice. The game ends when there is a winner or a draw.
     */
    public static void playGame() {
        // Create Empty table
        table = CreateTable.createEmptyTable();

        // Set the table for the game
        PlayGame.setTable(table);

        // Print formatted table for the user to see
        PrintTable.printFormattedTable();

        boolean gameRunning = true;
        // Main game loop
        while (gameRunning) {
            // Get user move
            updateUserMove();

            // Print the updated table
            PrintTable.printFormattedTable();

            // Analyse the game state
            GameState gameState = AnalyseGame.analyseGame(table);

            // If the game state should end
            switch (gameState) {
                case IMPOSSIBLE -> {
                    System.out.println("Impossible");
                    gameRunning = false;
                }
                case DRAW -> {
                    System.out.println("Draw");
                    gameRunning = false;
                }
                case X_WINS -> {
                    System.out.println("X wins!");
                    gameRunning =false;
                }
                case O_WINS -> {
                    System.out.println("O wins!");
                    gameRunning =false;
                }
                case GAME_NOT_FINISHED -> {
                    System.out.println("Player " + currentPlayer + "'s turn");
                }
            }
            // Switch player
            if (AnalyseGame.isGameContinuing(table)) {
                switchPlayer();
            }
        }
    }


    /**
     * Asks the user for their coordinates and makes sure they are valid. If they are not, the
     * user will be given feedback and prompted again for the coordinates. The table will then be
     * updated with a valid move.
     */
    private static void updateUserMove() {
        System.out.println("Please enter coordinates for your move. Choose between 1-3 for the " +
                "row and 1-3 for the column seperated by a space. Example 1 2 (1 is row, 2 in " +
                "column)");


        boolean isValidMove = false; // Flag to keep the loop running
        // Loop to get the coordinates from the user.
        while (!isValidMove) {
            String userInput = UserInput.getUserInput().trim();
            int[] coordinates = parseInput(userInput);
            if (coordinates != null) {
                int row = coordinates[0];
                int col = coordinates[1];

                // If the move is valid, stop the loop, update the table and print the table
                if (validateMove(row, col)) {
                    isValidMove = true;
                    makeMove(row, col);
                }
            }
        }
    }

    /**
     * Parses the users input and returns the coordinates.
     *
     * @param move The move to be parsed
     * @return Coordinates as a int[]
     */
    private static int[] parseInput(String move) {
        // Parse down to two numbers for the move
        String[] parts = move.split(" ");

        // If parts is greater than two, then it is incorrect
        if (parts.length != 2) {
            System.err.println("You should enter exactly two numbers separated by a space!");
            return null;
        }

        // If the parts cannot be converted to numbers, then it is incorrect
        try {
            int row = Integer.parseInt(parts[0]);
            int col = Integer.parseInt(parts[1]);
            return new int[]{row, col};
        } catch (NumberFormatException e) {
            System.err.println("You should enter numbers!");
            return null;
        }
    }

    /**
     * Takes the coordinates as row and col, checks they are in the range of the grid and checks if
     * the desired cell is occupied
     *
     * @param row The number of the chosen row
     * @param col The number of the chosen column
     * @return True if valid move, false otherwise.
     */
    private static boolean validateMove(int row, int col) {
        // If the coordinates are outside the grid, then it is incorrect
        if ((row < 1 || row > 3) || (col < 1 || col > 3)) {
            System.err.println("Coordinates should be from 1 to 3!");
            return false;
        }

        // Adjust the indexes of row and col for the 0 index
        row -= 1;
        col -= 1;
        if (table[row][col] != '_' && table[row][col] != ' ') {
            System.err.println("This cell is occupied! Choose another one! ");
            return false;
        }
        return true;
    }

    /**
     * Updates the table with the current player's move
     * @param row The number of the chosen row
     * @param col The number of the chosen column
     */
    private static void makeMove(int row, int col) {
        // Update move as current player symbol'. The rows and columns are zero based indexes
        table[row -1][col - 1] = getCurrentPlayer();

    }


    /**
     * Switch the symbol of the current player from 'X' to 'O' or from 'O' to 'X'
     */
    private static void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }


}
