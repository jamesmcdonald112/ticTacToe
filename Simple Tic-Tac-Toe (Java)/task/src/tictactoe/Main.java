package tictactoe;

public class Main {
    public static void main(String[] args) {
        // Get user input
        String userInput = UserInput.getUserInput();

        // Break input into three lines
        String firstLine = userInput.substring(0, 3);
        String secondLine = userInput.substring(3, 6);
        String thirdLine = userInput.substring(6);

        // Format the lines
        String tableWithDash = CreateTable.createFormattedTable(firstLine, secondLine, thirdLine);
        // Table with just X and O, no dashes
        System.out.println(tableWithDash);

        // Create matrix of table
        char[][] tableMatrix = MatrixCreator.createMatrix(userInput);

        System.out.println(AnalyseGame.analyseGame(tableMatrix));
    }


}

