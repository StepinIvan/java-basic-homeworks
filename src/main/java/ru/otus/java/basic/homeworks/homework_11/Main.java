package ru.otus.java.basic.homeworks.homework_11;

import java.util.Arrays;

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
    }
}
