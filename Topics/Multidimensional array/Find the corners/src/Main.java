class ArrayOperations {
    public static void printCorners(int[][] twoDimArray) {
        // write your code here

        int rows = twoDimArray.length;
        int col = twoDimArray[0].length;

        System.out.print(twoDimArray[0][0] + " ");
        System.out.println(twoDimArray[0][col - 1]);
        System.out.print(twoDimArray[rows - 1][0] + " ");
        System.out.println(twoDimArray[rows - 1][col - 1]);


    }
}