package by.bsuir.lab1.common;

public class ArrayWithSequentNumbersGenerator {
    public static int[] generate(int size) {
        var result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = i + 1;
        }
        return result;
    }
}
