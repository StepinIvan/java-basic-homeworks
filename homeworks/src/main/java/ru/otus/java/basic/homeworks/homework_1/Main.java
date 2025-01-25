package ru.otus.java.basic.homeworks.homework_1;

import java.util.Random;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число от 1 до 5");
        int userNumber = scanner.nextInt();
        switch (userNumber) {
            case 1 -> greetings();
            case 2 -> checkSign((int) ((Math.random() * (100 + Math.abs(-100))) - 100),
                    (int) ((Math.random() * (100 + Math.abs(-100))) - 100),
                    (int) ((Math.random() * (100 + Math.abs(-100))) - 100));
            case 3 -> selectColor();
            case 4 -> compareNumbers();
            case 5 -> addOrSubtractAndPrint((int)(Math.random() * 100), (int)(Math.random() * 100), new Random().nextBoolean());
        }
    }

    public static void greetings() {
        System.out.println("Hello\nWorld\nfrom\nJava");
    }

    public static void checkSign(int a, int b, int c) {
        int sum = a + b + c;
        if (sum > 0) {
            System.out.println("a = " + a + ", " + "b = " + b + ", " + "c = "+ c + " - Сумма положительная");
        } else {
            System.out.println("a = " + a + ", " + "b = " + b + ", " + "c = "+ c + " - Сумма отрицательная");
        }
    }

    public static void selectColor() {
        int data = 21;
        if (data <= 10) {
            System.out.println("Красный");
        } else if (data <= 20) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }

    public static void compareNumbers() {
        int a = 1;
        int b = 54;
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }

    public static void addOrSubtractAndPrint(int initValue, int delta, boolean increment) {
        if (increment) {
            System.out.println("initValue = " + initValue + ", " + "delta = " + delta + ", " + "increment = "
                    + increment +  "\nРезультат = " + (initValue + delta));
        } else {
            System.out.println("initValue = " + initValue + ", " + "delta = " + delta + ", " + "increment = "
                    + increment + "\nРезультат = " + (initValue - delta));
        }
    }
}
