class ArrayOperations {
    public static int[][][] createCube() {
        // write your code here

        int n = 3;
        int[] values = {0, 1, 2, 3, 4, 5, 6, 7, 8};
        int[][][] array = new int[n][n][n];
        
        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array[row].length; col++) {
                for (int third = 0; third < array[row][col].length; third++) {
                    array[row][col][third] = values[col * 3 + third];
                }
            }
        }
        return array;
    }
}