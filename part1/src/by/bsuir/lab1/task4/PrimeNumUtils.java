package by.bsuir.lab1.task4;

import java.util.ArrayList;
import java.util.List;

public class PrimeNumUtils {
    public static List<Integer> selectPrimeNumberIndexes(int[] numbers) {
        List<Integer> indexes = new ArrayList<Integer>();
        for (int i = 0; i < numbers.length; i++) {
            if (isPrime(numbers[i])) {
                indexes.add(i);
            }
        }
        return indexes;
    }

    public static boolean isPrime(int n){
        int half = n / 2;
        if (n == 0 || n == 1)
        {
           return false;
        }

        for (int i = 2; i <= half; i++){
            if (n % i == 0){
                return false;
            }
        }
        return true;
    }
}
