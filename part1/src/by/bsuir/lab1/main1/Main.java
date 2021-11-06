package by.bsuir.lab1.main1;

import by.bsuir.lab1.common.ArrayWithSequentNumbersGenerator;
import by.bsuir.lab1.task1.Calculator;
import by.bsuir.lab1.task2.GeometryShape;
import by.bsuir.lab1.task2.Point;
import by.bsuir.lab1.task3.CountingResult;
import by.bsuir.lab1.task3.TgCounter;
import by.bsuir.lab1.common.ArrayWithNumbersGenerator;
import by.bsuir.lab1.task4.PrimeNumUtils;
import by.bsuir.lab1.task5.LongestAscendingSubsequenceFinder;
import by.bsuir.lab1.task6.MatrixFromArrayGenerator;
import by.bsuir.lab1.task7.Sorter;
import by.bsuir.lab1.task8.InsertionPrinter;

import java.util.Scanner;

public class Main {

    private static Scanner in;

    public static void main(String[] args) {
        in = new Scanner(System.in);

        while (true) {
            System.out.println("Enter task number to run:");
            int chosenTask = in.nextInt();

            switch (chosenTask) {
                case 1:
                    proceedFirstTask();
                    break;
                case 2:
                    proceedSecondTask();
                    break;
                case 3:
                    proceedThirdTask();
                    break;
                case 4:
                    proceedFourhtTask();
                    break;
                case 5:
                    proceedFifthTask();
                    break;
                case 6:
                    proceedSixthTask();
                    break;
                case 7:
                    proceedSeventhTask();
                    break;
                case 8:
                    proceedEighthTask();
                    break;
            }
        }
    }

    private static void proceedFirstTask() {
        System.out.println("Enter x:");
        double x = in.nextDouble();
        System.out.println("Enter y:");
        double y = in.nextDouble();
        System.out.println("Result: " + Calculator.Calculate(x, y));
    }

    private static void proceedSecondTask() {
        System.out.println("Enter x:");
        double x = in.nextDouble();
        System.out.println("Enter y:");
        double y = in.nextDouble();
        System.out.println("Result: " + new GeometryShape().isInsideTheShape(new Point(x, y)));
    }

    private static void proceedThirdTask() {
        System.out.println("Enter a:");
        double a = in.nextDouble();
        System.out.println("Enter b:");
        double b = in.nextDouble();
        System.out.println("Enter h:");
        double h = in.nextDouble();
        CountingResult[] result = TgCounter.countInRange(a, b, h);

        for (int i = 0; i < result.length; i++) {
            System.out.printf("%.2f  %.2f \n", result[i].argument, result[i].value);
        }
    }

    private static void proceedFourhtTask() {
        System.out.println("Enter N:");
        int n = in.nextInt();
        var numbers = ArrayWithNumbersGenerator.generate(n);
        var indexes = PrimeNumUtils.selectPrimeNumberIndexes(numbers);

        System.out.println("Primes:");
        for (Integer index:
             indexes) {
            System.out.println(index);
        }
    }

    private static void proceedFifthTask() {
        System.out.println("Enter N:");
        int n = in.nextInt();
        var numbers = ArrayWithNumbersGenerator.generate(n);
        var canDelete = n - LongestAscendingSubsequenceFinder.FindLongestSubsequenceLength(numbers);

        System.out.println("Can delete: " + canDelete + " numbers");
    }

    private static void proceedSixthTask() {
        System.out.println("Enter N:");
        int n = in.nextInt();
        var numbers = ArrayWithSequentNumbersGenerator.generate(n);
        var matrix = MatrixFromArrayGenerator.generate(numbers);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void proceedSeventhTask() {
        System.out.println("Enter N:");
        int n = in.nextInt();
        var numbers = ArrayWithNumbersGenerator.generate(n);

        System.out.println("Was:");
        for (int i = 0; i < n; i++) {
            System.out.print(numbers[i] + " ");
        }

        Sorter.sort(numbers);
        System.out.println("Become:");
        for (int i = 0; i < n; i++) {
            System.out.print(numbers[i] + " ");
        }
    }

    private static void proceedEighthTask() {
        var sequenceA = new int[] {1, 2, 3, 4, 5, 6, 7, 11};
        var sequenceB = new int[] {-1, 3, 4, 4, 5, 5, 5, 6, 7, 7, 9, 9, 9};

        System.out.println("sequenceA:");
        for (int i = 0; i < sequenceA.length; i++) {
            System.out.print(sequenceA[i] + " ");
        }
        System.out.println();

        System.out.println("sequenceB:");
        for (int i = 0; i < sequenceB.length; i++) {
            System.out.print(sequenceB[i] + " ");
        }
        System.out.println();

        InsertionPrinter.printInsertions(sequenceA, sequenceB);
    }
}
