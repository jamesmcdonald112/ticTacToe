package tictactoe;

import java.util.Arrays;

public class MatrixCreator {

    /**
     * Takes in a String input and returns a char[3][3] matrix of the user input.
     *
     * @param input The String to be converted to a char[][] matrix
     * @return The char[][] matrix
     */
    public static char[][] createMatrix(String input) {
        // Create a matrix of size 3 * 3
        char[][] matrix = new char[3][3];
        // Track the string index
        int stringIndex = 0;
        // Iterate over each row
        for (int row = 0; row < matrix.length; row++) {
            // Iterate over each column
            for (int col = 0; col < matrix[row].length; col++) {
                // Add the user input one at a time
                matrix[row][col] = input.charAt(stringIndex);
                stringIndex++;
            }
        }
        return matrix;
    }

}
