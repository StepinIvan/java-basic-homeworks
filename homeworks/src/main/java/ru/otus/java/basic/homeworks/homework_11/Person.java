package ru.otus.java.basic.homeworks.homework_11;

public class Person {
    String name;
    Position position;
    Long id;

    public Person(String name, Position position, Long id) {
        this.name = name;
        this.position = position;
        this.id = id;
    }

    @Override
    public String toString() {
        return String.format("Имя: %s, должность: %s, ID: %d", name, position, id);
    }
}
