package by.bsuir.lab1.task3;

public class TgCounter {
    public static CountingResult[] countInRange (double start, double end, double step) {
        int arrSize = (int)Math.floor((end - start) / step) + 1;
        var result = new CountingResult[arrSize];

        int currArrIndex = 0;
        for (double i = start; i < end; i+= step) {
            result[currArrIndex] = new CountingResult(i, Math.tan(i));
            currArrIndex++;
        }

        return result;
    }
}
