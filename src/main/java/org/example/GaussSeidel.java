package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GaussSeidel {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("0-Файл\n1-Консоль");
        int type = scanner.nextInt();
        Scanner input;
        if (type ==0){
            input = new Scanner(new File("/Users/artemsolopov/Учеба/2_курс/ВычМат/test_laba1/src/main/resources/input.txt"));
        }
        else {
            input = new Scanner(System.in);
        }
        System.out.print("Введите размерность матрицы: ");
        int n = input.nextInt();
        double[][] A = new double[n][n];
        double[] b = new double[n];
        double[] x = new double[n];
        double[] y = new double[n];
        double eps = 0.0001;
        int maxIterations = 1000;

        // Ввод данных о матрице
        System.out.println("Введите коэффициенты матрицы A: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                A[i][j] = input.nextDouble();
            }
        }

        System.out.println("Введите коэффициенты матрицы B: ");
        for (int i = 0; i < n; i++) {
            b[i] = input.nextDouble();
        }

        // Проверка условий сходимости
        boolean converge = true;
        for (int i = 0; i < n; i++) {
            double sum = 0;
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    sum += Math.abs(A[i][j]);
                }
            }
            if (Math.abs(A[i][i]) <= sum) {
                converge = false;
                break;
            }
        }

        if (converge) {
            // Итерационный процесс
            int iterations = 0;
            while (iterations < maxIterations) {
                for (int i = 0; i < n; i++) {
                    y[i] = x[i];
                    x[i] = b[i];
                    for (int j = 0; j < n; j++) {
                        if (i != j) {
                            x[i] -= A[i][j] * x[j];
                        }
                    }
                    x[i] /= A[i][i];
                }
                iterations++;
                double error = 0;
                for (int i = 0; i < n; i++) {
                    error += Math.abs(x[i] - y[i]);
                }
                if (error < eps) {
                    break;
                }
            }

            // Вывод результата
            System.out.println("Решение системы:");
            for (int i = 0; i < n; i++) {
                System.out.printf("x%d = %.4f\n", i + 1, x[i]);
            }
        } else {
            System.out.println("Метод Гаусса-Зейделя не применим к данной матрице");
        }
    }
}
