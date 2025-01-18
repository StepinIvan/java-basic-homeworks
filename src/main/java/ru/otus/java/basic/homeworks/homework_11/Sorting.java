package ru.otus.java.basic.homeworks.homework_11;

public class Sorting {
    public static void bubbleSort(int[] array) {
        boolean changed;
        do {
            changed = false;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    changed = true;
                }
            }

        } while (changed);
    }

    public static void quickSort(int[] array, int lowIndex, int highIndex) {
        if (array.length < 2) {//проверяем, необходима ли сортировка
            return;
        }
        if (lowIndex >= highIndex) {//если нет возможности делить
            return;
        }
        int middleElement = lowIndex + (highIndex - lowIndex) / 2;
        int pivot = array[middleElement];
        int i = lowIndex;
        int j = highIndex;
        while (i <= j) {
            while (array[i] < pivot) {
                i++;
            }

            while (array[j] > pivot) {
                j--;
            }

            if (i <= j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }
        if (lowIndex < j)
            quickSort(array, lowIndex, j);

        if (highIndex > i)
            quickSort(array, i, highIndex);
    }
}
