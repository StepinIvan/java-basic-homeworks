package ru.otus.java.basic.homeworks.homework_9;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println(sequentialFilling(20, 30));

        System.out.printf(String.format("Сумма элементов, которые больше 5 для ArrayList:%s: %d \n", sequentialFilling(1, 10), sumArrayList(sequentialFilling(1, 10))));

        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        System.out.printf(String.format("Начальный ArrayList:%s\n", list));
        System.out.printf(String.format("Перезаполненный ArrayList: %s\n", refillArrayList(34, list)));

        ArrayList<Integer> list_2 = new ArrayList<>();
        list_2.add(0);
        list_2.add(1);
        list_2.add(2);
        System.out.printf(String.format("Начальный ArrayList:%s\n", list_2));
        System.out.printf(String.format("ArrayList с увеличенными значениями ArrayList: %s\n", increaseElements(2, list_2)));

        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Иван", 25));
        employees.add(new Employee("Борис", 24));
        employees.add(new Employee("Диана", 22));
        System.out.printf(String.format("Имена всех сотрудников: %s\n", getEmployeesNames(employees)));

    }

    /**
     * @param min - minimal value
     * @param max - maximum value
     * @return ArrayList with a consistent set of values from min to max inclusive
     */

    public static ArrayList<Integer> sequentialFilling(int min, int max) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            list.add(i);
        }
        return list;
    }

    /**
     * @param list - Integer ArrayList
     * @return sum of all the ArrayList elements that are greater than 5
     */
    public static int sumArrayList(ArrayList<Integer> list) {
        int sum = 0;
        for (Integer integer : list) {
            if (integer > 5) {
                sum += integer;
            }
        }
        return sum;
    }

    /**
     * @param value - fill value
     * @param list  - ArrayList link
     * @return - ArrayList with value at each position
     */
    public static ArrayList<Integer> refillArrayList(int value, ArrayList<Integer> list) {
        for (Integer integer : list) {
            list.set(integer, value);
        }
        return list;
    }

    /**
     * @param number - value by which each element must be increased
     * @param list   - ArrayList link
     * @return - ArrayList with increased values
     */
    public static ArrayList<Integer> increaseElements(int number, ArrayList<Integer> list) {
        for (Integer integer : list) {
            list.set(integer, list.get(integer) + number);
        }
        return list;
    }

    /**
     *
     * @param employees - ArrayList of employees
     * @return ArrayList employees names
     */
    public static ArrayList<String> getEmployeesNames(ArrayList<Employee> employees) {
        ArrayList<String> names = new ArrayList<>();
        for (Employee employee : employees) {
            names.add(employee.getName());
        }
        return names;
    }
}
