package ru.otus.java.basic.homeworks.homework_10;

public class Main {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Иванов Иван Иванович", "8-964-333-44-55");
        phoneBook.add("Иванов Иван Иванович", "8-965-222-11-77");
        phoneBook.add("Иванов Иван Иванович", "8-965-222-11-77");
        phoneBook.add("Сергеев Сергей Сергеевич", "8-923-444-11-22");
        phoneBook.add("Андреев Андрей Андреевич", "8-976-555-88-99");

        System.out.println((phoneBook.containsPhoneNumber("8-964-333-44-55")) ? "Телефон есть в справочнике" : "Телефон не найден");
        System.out.println((phoneBook.containsPhoneNumber("8-964-333-44-11")) ? "Телефон есть в справочнике" : "Телефон не найден");
        System.out.println(phoneBook.find("Иванов Иван Иванович"));
        System.out.println(phoneBook.find("Иванов Иван Андреевич"));
    }
}
