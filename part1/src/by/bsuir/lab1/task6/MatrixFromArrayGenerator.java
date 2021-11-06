package by.bsuir.lab1.task6;

public class MatrixFromArrayGenerator {
    public static int[][] generate(int[] src) {
        int n = src.length;
        int[][] result = new int[n][n];
        int index = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++, index = incrementWithOverflow(index, n)) {
                result[row][col] = src[index];
            }
            index = incrementWithOverflow(index, n);
        }
        return result;
    }

    private static int incrementWithOverflow(int src, int border) {
        int result = src + 1;
        result %= border;
        return result;
    }
}
