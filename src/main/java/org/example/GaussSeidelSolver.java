package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GaussSeidelSolver {

    public static void main(String[] args) {
        Scanner scanner = null;

        try {
            if (args.length > 0) {
                scanner = new Scanner(new File(args[0]));
            } else {
                scanner = new Scanner(System.in);
            }

            int n = scanner.nextInt();
            double epsilon = scanner.nextDouble();
            int maxIterations = scanner.nextInt();

            double[][] coefficientMatrix = new double[n][n];
            double[] freeVector = new double[n];
            double[] initialApproximation = new double[n];
            double[] roots = new double[n];

            // Заполнение матрицы коэфициентами СЛАУ
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    coefficientMatrix[i][j] = scanner.nextDouble();
                }
            }
            // Заполнение вектора свободных членов
            for (int i = 0; i < n; i++) {
                freeVector[i] = scanner.nextDouble();
            }
            // Начальное приблежение
            for (int i = 0; i < n; i++) {
                initialApproximation[i] = scanner.nextDouble();
            }

            int counter = 0;
            double norm = Double.MAX_VALUE;

            while (norm > epsilon && counter < maxIterations) {
                norm = 0;
                for (int i = 0; i < n; i++) {
                    roots[i] = freeVector[i];
                    for (int j = 0; j < n; j++) {
                        if (j != i) {
                            roots[i] -= coefficientMatrix[i][j] * roots[j];
                        }
                    }
                    roots[i] /= coefficientMatrix[i][i];
                    norm += Math.pow(roots[i] - initialApproximation[i], 2);
                }
                norm = Math.sqrt(norm);
                counter++;
                System.arraycopy(roots, 0, initialApproximation, 0, n);
            }

            if (norm <= epsilon) {
                System.out.println("Решение найдено за " + counter + " итераций:");
                for (int i = 0; i < n; i++) {
                    System.out.println("roots[" + i + "] = " + roots[i]);
                }
            } else {
                System.out.println("Решение не найдено за " + maxIterations + " итераций.");
            }
        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден: " + args[0]);
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }
}
