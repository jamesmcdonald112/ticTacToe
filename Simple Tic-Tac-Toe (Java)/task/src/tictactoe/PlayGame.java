package tictactoe;

public class PlayGame {
    private static char[][] table;

    public static char[][] getTable() {
        return table;
    }

    public static void setTable(char[][] table) {
        PlayGame.table = table;
    }

    public static void updateUserMove() {
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
                    printTable();
                }
            }
        }
    }

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

    private static void makeMove(int row, int col) {
        // Update move as player 'X'. The rows and columns are zero based indexes
        table[row -1][col - 1] = 'X';

    }

    private static void printTable() {
        System.out.println(CreateTable.createFormattedTable(table));
    }



}
