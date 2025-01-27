package ru.otus.java.basic.homeworks.homework_22;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] testArray = new int[] {1,2,3,4,5,1,2,2,3};
        int[] testArray2 = new int[] {1,2,2,1};
        System.out.println(Arrays.toString(arrayAfterLastOne(testArray)));
        System.out.println(checkArrayFilling(testArray2));
    }
    public static int[] arrayAfterLastOne(int[] inArray) {
        int oneIndex = -1;
        for (int i = 0; i < inArray.length; i++) {
            if (inArray[i] == 1) {
                oneIndex = i;
            }
        }
        if (oneIndex == -1) {
            throw new RuntimeException("Во входном массиве отсутствуют единицы");
        }
        int[] newArray = new int[inArray.length - oneIndex - 1];
        for (int i = oneIndex; i < inArray.length - 1; i++) {
            newArray[i - oneIndex] = inArray[i + 1];
        }
        return newArray;
    }
    public static boolean checkArrayFilling(int[] array) {
        int oneCount = 0;
        int twoCount = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 1) {
                oneCount += 1;
            } else if (array[i] == 2) {
                twoCount += 1;
            } else {
                return false;
            }
        }
        if (oneCount == 0 || twoCount == 0) {
            return false;
        }
        return true;
    }
}
