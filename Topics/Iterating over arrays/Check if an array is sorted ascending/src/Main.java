import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner s = new Scanner(System.in);

        // Array Size
        int n = s.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = s.nextInt();
        }

        boolean isSorted = true;
        for (int i = 0; i < arr.length - 1; i++) {
            if(arr[i] > arr[i + 1]) {
                isSorted = false;
                break;
            }
        }

        System.out.println(isSorted);

    }
}