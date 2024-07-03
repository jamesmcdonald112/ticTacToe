import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner s = new Scanner(System.in);

        // Rows and Seats
        String[] parts = s.nextLine().split(" ");
        int rows = Integer.parseInt(parts[0]);
        int seats = Integer.parseInt(parts[1]);

        // Cinema size
        int[][] cinema = new int[rows][seats];
        for (int i = 0; i < cinema.length; i++) {
            for (int j = 0; j < cinema[i].length; j++) {
                cinema[i][j] = s.nextInt();
            }
        }

       // Number of tickets to buy
        int tickets = s.nextInt();

        int result = findRowWithSeats(tickets, cinema);
        System.out.println(result);

        s.close();

    }

    private static int findRowWithSeats(int tickets, int[][] cinema) {
        for (int row = 0; row < cinema.length; row++) {
            int consecutive = 0;
            for (int seat = 0; seat < cinema[row].length; seat++) {
                if (cinema[row][seat] == 0) {
                    consecutive++;
                    if (consecutive == tickets) {
                        return row + 1;
                    }
                } else {
                    consecutive = 0;
                }
            }

        }

        return 0;
    }
}

