import java.util.Scanner;
import java.util.Arrays;

class Main {
    // implement me
    private static void rotate(int[] arr, int steps) {
        while (steps > arr.length) {
            steps -= arr.length;
        }
        int[] result = new int[arr.length];
        int index = 0;
        for (int i = arr.length - steps; i < arr.length; i++) {
            result[index] = arr[i];
            index++;
        }

        for (int i = 0; i < arr.length - steps; i++) {
            result[index] = arr[i];
            index++;
        }


        for (int i = 0; i < arr.length; i++) {
            arr[i] = result[i];
        }


    }

    // do not change code below
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int steps = Integer.parseInt(scanner.nextLine());

        rotate(arr, steps);

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}