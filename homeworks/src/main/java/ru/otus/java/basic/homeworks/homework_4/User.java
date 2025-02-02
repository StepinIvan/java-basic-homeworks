package ru.otus.java.basic.homeworks.homework_4;

import lombok.Getter;

public class User {
    private String surname;
    private String name;
    private String patronymic;
    @Getter
    private int birthYear;
    private String email;

    public User(String surname, String name, String patronymic, int birthYear, String email) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.birthYear = birthYear;
        this.email = email;
    }

    public void info() {
        System.out.println("ФИО: " + surname + " " + name + " " + patronymic +
                "\nГод рождения: " + birthYear + "\nEmail: " + email);
    }
}
