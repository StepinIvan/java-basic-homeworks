package ru.otus.java.basic.homeworks.homework_22;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Arrays;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);
    public static void main(String[] args) {
        int[] testArray = new int[] {1,2,3,4,5,1,2,2,3};
        int[] testArray2 = new int[] {1,2,2,1};
        LOGGER.info(String.format("Результат расчета метода arrayAfterLastOne с входным массивом: %s - %s",
                Arrays.toString(testArray),Arrays.toString(arrayAfterLastOne(testArray))));
        LOGGER.info(String.format("Результат расчета метода checkArrayFilling с входным массивом: %s - %s",
                Arrays.toString(testArray2),checkArrayFilling(testArray2)));
    }
    public static int[] arrayAfterLastOne(int[] inArray) {
        int oneIndex = -1;
        for (int i = 0; i < inArray.length; i++) {
            if (inArray[i] == 1) {
                oneIndex = i;
            }
        }
        if (oneIndex == -1) {
            LOGGER.error("Ошибка! Во входном массиве отсутствуют единицы");
            throw new RuntimeException();
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
