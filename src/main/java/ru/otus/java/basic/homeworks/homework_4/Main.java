package ru.otus.java.basic.homeworks.homework_4;

import java.time.Year;

public class Main {
    public static void main(String[] args) {
        int currentYear = Year.now().getValue();
        User[] listOfUsers = {
                new User("Иванов", "Никита", "Петрович", 1992, "petrovich@mail.ru"),
                new User("Петров", "Денис", "Альбертович", 1984, "deniska@mail.ru"),
                new User("Сидорова", "Светлана", "Ивановна", 1998, "sidSvet@mail.ru"),
                new User("Малюта", "Иван", "Рудольфович", 1995, "MalJohn@mail.ru"),
                new User("Юдин", "Василий", "Петрович", 2002, "proger2000@mail.ru"),
                new User("Непейвода", "Арина", "Эдуардовна", 2005, "engineer5@mail.ru"),
                new User("Макаренко", "Елизавета", "Андреевна", 2001, "makElisaveta@mail.ru"),
                new User("Федькин", "Никита", "Сергеевич", 1978, "NikFed@mail.ru"),
                new User("Васильева", "Елена", "Олеговна", 1988, "atom235@mail.ru"),
                new User("Крутов", "Михаил", "Алексеевич", 1981, "physics@mail.ru"),
        };
        for (User user : listOfUsers) {
            if (currentYear - user.getBirthYear() > 40) {
                user.info();
                System.out.println("------------------------------");
            }
        }

        Box myBox = new Box(3, "Black", true);
        myBox.open();
        myBox.close();
        myBox.changeColor("синий");
        myBox.info();
        myBox.putItem("Телефон");
        myBox.open();
        myBox.putItem("Телефон");
        myBox.throwAwayItem();
        myBox.throwAwayItem();
    }
}
