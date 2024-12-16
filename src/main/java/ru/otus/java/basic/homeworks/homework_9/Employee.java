package ru.otus.java.basic.homeworks.homework_9;

import lombok.Getter;

public class Employee {
    @Getter
    private String name;
    @Getter
    private int age;
    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
