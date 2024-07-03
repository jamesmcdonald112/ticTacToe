import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner s = new Scanner(System.in);
        int size = s.nextInt();
        int sum = 0;
        int[]  arr = new int[size];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = s.nextInt();
            sum += arr[i];
        }

        System.out.println(sum);

    }
}