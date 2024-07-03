import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        String[][] arr = new String[n][n];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = ".";
            }
        }

        addStar(arr);

        print2DArray(arr);
    }

    private static void addStar(String[][] arr) {
        // Top left to bottom right
        for (int i = 0; i < arr.length; i++) {
            arr[i][i] = "*";
        }


        // Top right to bottom left
        for (int i = 0; i < arr.length; i++) {
            arr[i][arr.length -1 - i] = "*";
        }

        // Across the middle
        for (int col = 0; col < arr.length; col++) {
            arr[arr.length / 2][col] = "*";
        }

        // Down the middle
        for (int row = 0; row < arr.length; row++) {
            arr[row][arr.length / 2] = "*";
        }
    }

    private static void print2DArray(String[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println(" ");
        }
    }
}