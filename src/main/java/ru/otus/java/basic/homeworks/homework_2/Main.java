package ru.otus.java.basic.homeworks.homework_2;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Массивы для проверки работы методов
        int[] array_1 = {6, 7, 8, 9, 10, 1, 2, 3, 4, 5};
        int[] array_2 = new int[10];
        int[][] array_3 = {{2, 4, 1}, {6, 9}, {11, 4, 32, 8, 0}};
        int[] array_4 = {5, 3, 4, -2};
        int[] array_5 = {4, 3, 2, 1};
        //Задача 1
        printStrings(3, "Just simple string");
        //Задача 2
        arraySum(array_1);
        //Задача 3
        fillArray(7, array_2);
        for (int j : array_2) {
            System.out.print(j + ", ");
        }
        System.out.println();
        //Задача 4
        increaseArrayElements(2, array_1);
        for (int j : array_1) {
            System.out.print(j + ", ");
        }
        System.out.println();
        //Задача 5
        checkHalfArraySums(array_1);
        //Задача 1*
        int[] arraysSum = arraysSum(array_3);
        for (int i : arraysSum) {
            System.out.print(i + ", ");
        }
        System.out.println();
        //Задача 2*
        checkBalancePoint(array_4);
        //Задача 3*
        checkOrder(array_5);
        System.out.println();
        //Задача 4*
        for (int i : reverseArray(array_4)) {
            System.out.print(i + ", ");
        }
    }

    public static void printStrings(int numberOfStrings, String string) {
        for (int i = 0; i < numberOfStrings; i++) {
            System.out.println(string);
        }
    }

    public static void arraySum(int[] array) {
        int sum = 0;
        for (int j : array) {
            if (j > 5) {
                sum += j;
            }
        }
        System.out.println("Сумма элементов > 5 = " + sum);
    }

    public static int[] fillArray(int digit, int[] array) {
        Arrays.fill(array, digit);
        return array;
    }

    public static int[] increaseArrayElements(int digit, int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] += digit;
        }
        return array;
    }

    public static void checkHalfArraySums(int[] array) {
        int firstHalfSum = 0;
        int secondHalfSum = 0;
        for (int i = 0; i < array.length / 2; i++) {
            firstHalfSum += array[i];
        }
        for (int i = array.length / 2; i < array.length; i++) {
            secondHalfSum += array[i];
        }
        if (firstHalfSum > secondHalfSum) {
            System.out.println("Сумма первой половины элементов массива больше");
        } else {
            System.out.println("Сумма второй половины элементов массива больше");
        }
    }

    public static int[] arraysSum(int[][] arrays) {
        int maxLength = 0;
        for (int[] array : arrays) {
            if (array.length > maxLength) {
                maxLength = array.length;
            }
        }
        int[] resultArray = new int[maxLength];
        for (int[] array : arrays) {
            int count = 0;
            for (int a : array) {
                resultArray[count] += a;
                count++;
            }
        }
        return resultArray;
    }

    public static void checkBalancePoint(int[] array) {
        boolean result = false;
        for (int i = 1; i < array.length; i++) {
            int fistHalfSum = 0;
            int secondHalfSum = 0;
            for (int j = 0; j < i; j++) {
                fistHalfSum += array[j];
            }
            for (int j = i; j < array.length; j++) {
                secondHalfSum += array[j];
            }
            if (fistHalfSum == secondHalfSum) {
                result = true;
                System.out.println("В массиве есть точка, в которой сумма левой и правой части равны. Данная точка " +
                        "находится между " + (i - 1) + " и " + i + " элементом массива");
                break;
            }
        }
        if (!result) {
            System.out.println("В массиве нет точки, в которой сумма левой и правой части равны.");
        }
    }

    public static void checkOrder(int[] array) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите >, если необходимо проверить, что все элементы идут в порядке возрастания и <," +
                " если порядок убывания");
        char task = scanner.next().charAt(0);
        while (task != '<' && task != '>') {
            System.out.println("Вы ввели неверный знак, попробуйте еще раз");
            task = scanner.next().charAt(0);
        }
        boolean flag = true;
        if (task == '<') {
            for (int i = 0; i < array.length - 1; i++) {
                int temp = array[i];
                if (temp <= array[i + 1]) {
                    System.out.println("В массиве нарушается порядок убывания");
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.println("Элементы массива расположены в поряке убывания");
            }
        } else {
            for (int i = 0; i < array.length - 1; i++) {
                int temp = array[i];
                if (temp >= array[i + 1]) {
                    System.out.println("В массиве нарушается порядок возрастания");
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.println("Элементы массива расположены в поряке возрастания");
            }
        }
    }

    public static int[] reverseArray(int[] array) {
        int[] reverseArray = new int[array.length];
        int count = array.length - 1;
        for (int j : array) {
            reverseArray[count] = j;
            count--;
        }
        return reverseArray;
    }


}
