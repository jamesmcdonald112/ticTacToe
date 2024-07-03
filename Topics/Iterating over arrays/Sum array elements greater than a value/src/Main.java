import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        s.nextLine();

        String line = s.nextLine();
        String[] parts = line.split(" ");

        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(parts[i]);
        }

        int num = s.nextInt();
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            if(numbers[i] > num) {
                sum += numbers[i];
            }
        }

        System.out.println(sum);
    }
}