package by.bsuir.lab1.task7;

public class Sorter {
    public static void sort(int[] src) {
        int length = src.length;
        int i = 0;
        while (i < length - 1) {
            if (src[i] > src[i + 1]){
                swap(src, i, i + 1);
                if (i > 0) i--;
            } else {
                i++;
            }
        }
    }

    private static void swap(int[] src, int i, int j) {
        int tmp = src[i];
        src[i] = src[j];
        src[j] = tmp;
    }
}
