package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("0 - Чтение из файла\n1 - Чтение из  коносли");
        int type = scanner.nextInt();
        if (type == 0 ){
            String [] list = new String[1];
            list[0] = "/Users/artemsolopov/Учеба/2_курс/ВычМат/laba_1_java/src/main/resources/input.txt";
            GaussSeidelSolver.main(list);
        }
        if (type == 1){
            String [] list = new String[0];
            GaussSeidelSolver.main(list);
        }

    }
}