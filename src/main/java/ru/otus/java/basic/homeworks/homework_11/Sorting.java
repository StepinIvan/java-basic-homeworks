package ru.otus.java.basic.homeworks.homework_11;

public class Sorting {
    public int[] bubbleSort(int[] array) {
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
        return array;
    }
}
