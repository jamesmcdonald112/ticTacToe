package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();

        // Break input into three lines
        String firstLine = userInput.substring(0, 3);
        String secondLine = userInput.substring(3, 6);
        String thirdLine = userInput.substring(6);

        // Format the lines
        String formattedFirstLine = formatLine(firstLine);
        String formattedSecondLine = formatLine(secondLine);
        String formattedThirdLine = formatLine(thirdLine);

        System.out.println(createTable(formattedFirstLine, formattedSecondLine, formattedThirdLine));

    }

    private static String dashes() {
        return "---------\n";
    }

    private static String formatLine(String lineInput) {
        char first = lineInput.charAt(0);
        char second = lineInput.charAt(1);
        char third = lineInput.charAt(2);

        return String.format("| %c %c %c |\n", first, second, third);
    }

    private static String createTable(String firstLine,String secondLine, String thirdLine) {
        StringBuilder table = new StringBuilder();
        table.append(dashes());
        table.append(firstLine);
        table.append(secondLine);
        table.append(thirdLine);
        table.append(dashes());
        return table.toString();

    }
}

