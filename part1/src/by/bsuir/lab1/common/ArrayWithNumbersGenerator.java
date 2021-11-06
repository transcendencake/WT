package by.bsuir.lab1.common;

import java.util.Random;

public class ArrayWithNumbersGenerator {
    public static int[] generate(int size) {
        var result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = new Random().nextInt();
        }
        return result;
    }
}
