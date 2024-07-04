package tictactoe;

public class Main {
    public static void main(String[] args) {
        // Get user input
        String userInput = UserInput.getUserInput();

        // Create matrix of table
        char[][] tableMatrix = MatrixCreator.createMatrix(userInput);

        // set the table
        PlayGame.setTable(tableMatrix);

        // Format the lines
        String tableWithDash = CreateTable.createFormattedTable(tableMatrix);
        // Table with just X and O, no dashes
        System.out.println(tableWithDash);

        // Analyse the game
        System.out.println(AnalyseGame.analyseGame(tableMatrix));

        // Get user move
        PlayGame.updateUserMove();


    }


}

