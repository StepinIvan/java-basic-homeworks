package ru.otus.java.basic.homeworks.homework_6;

public class Cat {
    private String name;
    private int appetite;
    private boolean full;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        full = false;
    }

    public void eat(Plate plate) {
        if (plate.takeFoodFromPlate(appetite)) {
            full = true;
        } else {
            System.out.println(name + " не стал есть, так как еды слишком мало");
        }
    }

    public void info() {
        System.out.println("Имя: " + name + "\nАппетит: " + appetite + "\nСтатус сытости: " + (full ? "сыт" : "голоден"));
        System.out.println("--------------------------------------------------------");
    }
}
