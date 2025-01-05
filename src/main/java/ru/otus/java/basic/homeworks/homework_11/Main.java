package ru.otus.java.basic.homeworks.homework_11;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        PersonDataBase dataBase = new PersonDataBase();
        Person Boris = new Person("Boris", Position.DEVELOPER, 0L);
        Person Ivan = new Person("Ivan", Position.DIRECTOR, 1L);
        Person Nikita = new Person("Nikita", Position.ENGINEER, 2L);
        dataBase.add(Boris);
        dataBase.add(Ivan);
        dataBase.add(Nikita);
        System.out.println(dataBase.findById(1L));
        System.out.println(dataBase.isManager(Ivan));
        System.out.println(dataBase.isEmployee(Nikita.id));

        int[] array =  {3,2,5,7,1,23,7,9,67,2,3};
        Sorting.bubbleSort(array);
        System.out.println(Arrays.toString(array));

        int[] array_2 =  {3,2,5,7,1,23,7,9,67,2,3};
        Sorting.quickSort(array_2, 0, array_2.length - 1);
        System.out.println(Arrays.toString(array_2));

        List<Integer> sortedList = List.of(1, 2, 3, 4, 5, 6, 7);
        BinarySearchTree bst = new BinarySearchTree(sortedList);
        System.out.printf(String.format("Поиск элемента 6: %d", bst.find(6)));
        System.out.println();
        System.out.printf(String.format("Поиск элемента 143: %d", bst.find(143)));
        System.out.println();
        System.out.printf(String.format("Отсортированный список, собранный из обхода бинарного дерева поиска: %s", bst.getSortedList()));
    }
}
