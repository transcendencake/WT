package by.bsuir.lab1.task1;

public class Calculator {
    public static double Calculate (double x, double y) {
        double result =
            (1 + Math.pow(Math.sin(x + y), 2))
            / (2 + Math.abs(x - (2 * x / (1 + Math.pow(x * y, 2)))))
            + x;
        return result;
    }
}
