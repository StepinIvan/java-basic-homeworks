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

        int minAge = 23;
        System.out.printf(String.format("Список сотрудников старше %d: %s\n", minAge,
                getEmployeesWithCertainAge(employees, minAge)));

        System.out.println(checkAverageEmployeeAge(employees, 22));

        System.out.printf(String.format("Самый молодой сотрудник: %s",findYoungerEmployee(employees)));
    }
    /**
     * @param min minimal value
     * @param max maximum value
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
     * @param list Integer ArrayList
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
     * @param value fill value
     * @param list  ArrayList link
     * @return ArrayList with value at each position
     */
    public static ArrayList<Integer> refillArrayList(int value, ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            list.set(i, value);
        }
        return list;
    }

    /**
     * @param number value by which each element must be increased
     * @param list   ArrayList link
     * @return ArrayList with increased values
     */
    public static ArrayList<Integer> increaseElements(int number, ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            list.set(i, list.get(i) + number);
        }
        return list;
    }

    /**
     * @param employees ArrayList of employees
     * @return ArrayList of employees names
     */
    public static ArrayList<String> getEmployeesNames(ArrayList<Employee> employees) {
        ArrayList<String> names = new ArrayList<>();
        for (Employee employee : employees) {
            names.add(employee.getName());
        }
        return names;
    }

    /**
     * @param employees ArrayList of employees
     * @param minAge minimal age of employee
     * @return ArrayList of employees with age greater or equal than minAge
     */
    public static ArrayList<String> getEmployeesWithCertainAge(ArrayList<Employee> employees, int minAge) {
        ArrayList<Employee> minAgeEmployees = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getAge() >= minAge) {
                minAgeEmployees.add(employee);
            }
        }
        return getEmployeesNames(minAgeEmployees);
    }

    /**
     * @param employees ArrayList of employees
     * @param minAverageAge minimal average age of employee
     * @return boolean value shows that the average age of employees exceed the specified value or not
     */
    public static boolean checkAverageEmployeeAge(ArrayList<Employee> employees, int minAverageAge) {
        ArrayList<Employee> minAgeEmployees = new ArrayList<>();
        int sum = 0;
        for (Employee employee : employees) {
            sum += employee.getAge();
        }
        return (double) sum / employees.size() > minAverageAge;
    }

    /**
     *
     * @param employees ArrayList of employees
     * @return youngest employee
     */
    public static Employee findYoungerEmployee(ArrayList<Employee> employees) {
        if (employees.isEmpty()) {
            System.out.println("Список сотрудников пуст");
            return null;
        }
        Employee youngestEmployee = employees.get(0);
        for (Employee employee : employees) {
            if (youngestEmployee.getAge() > employee.getAge()) {
                youngestEmployee = employee;
            }
        }
        return youngestEmployee;
    }
}
