package by.bsuir.lab1.task8;

public class InsertionPrinter {
    public static void printInsertions(int[] to, int[] from) {
        int insertedElem = 0;
        boolean wasInserted = false;

        int toLength = to.length;
        int fromLength = from.length;
        int fromIndex = 0;
        for (int i = 0; i < toLength; i++) {
            if (fromIndex >= fromLength) return;

            int currElem = wasInserted ? insertedElem : to[i];
            int nextElem = (i + 1) == toLength ? Integer.MAX_VALUE : to[i + 1];

            for (int j = fromIndex; j < fromLength; j++) {
                int fromElem = from[j];
                if (currElem <= fromElem) {
                    if (nextElem >= fromElem) {
                        System.out.println("Insert elem from sequence B with index = " + j + " after elem of sequence A with index = " + i);
                        insertedElem = fromElem;
                        wasInserted = true;
                        fromIndex = j + 1;
                        i--;
                    } else {
                        wasInserted = false;
                    }
                    break;
                }
            }
        }
    }
}
