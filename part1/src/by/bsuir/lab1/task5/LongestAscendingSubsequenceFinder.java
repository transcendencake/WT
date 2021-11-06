package by.bsuir.lab1.task5;

import java.util.Arrays;

public class LongestAscendingSubsequenceFinder {
    public static int FindLongestSubsequenceLength(int[] sequence) {
        int srcLength = sequence.length;
        int[] d = new int[srcLength]; //element d[i] is length of longest ascending subsequence in {sequence[0]..sequence[i]}
        for (int i = 0; i < srcLength; i++) {
            d[i] = 1;
            for (int j = 0; j < i; j++) {
                if (sequence[j] < sequence[i]) {
                    d[i] = Math.max(d[i], d[j] + 1);
                }
            }
        }
        return Arrays.stream(d).max().getAsInt();
    }
}
