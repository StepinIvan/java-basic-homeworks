package ru.otus.java.basic.homeworks.homework_4;

public class Box {
    private double width;
    private double height;
    private double length;
    private String color;
    private boolean isOpened;
    private boolean isFilled;

    public Box(double width, double height, double length, String color, boolean isOpened) {
        this.width = width;
        this.height = height;
        this.length = length;
        this.color = color;
        this.isOpened = isOpened;
        this.isFilled = false;
    }

    public void open() {
        isOpened = true;
        System.out.println("Коробка открыта");
    }

    public void close() {
        isOpened = false;
        System.out.println("Коробка закрыта");
    }

    public void changeColor(String color) {
        this.color = color;
        System.out.println("Коробка перекрашена в " + color + " цвет");
    }

    public void info() {
        System.out.println("Размеры коробки (ширина, высота, длина): " + width + " м, " + height + " м, " + length + " м");
        if (isOpened) {
            System.out.println("Статус коробки: открыта");
        } else {
            System.out.println("Статус коробки: закрыта");
        }
    }

    public void putItem(String item) {
        if (isOpened) {
            if (isFilled) {
                System.out.println("В коробке уже есть предмет");
            } else {
                isFilled = true;
                System.out.println("Вы положили " + item + " в коробку");
            }
        } else {
            System.out.println("Откройте коробку для взаимодействия с ее предметами");
        }
    }

    public void throwAwayItem() {
        if (isOpened) {
            if (isFilled) {
                System.out.println("Вы выбросили предмет из коробки");
                isFilled = false;
            } else {
                System.out.println("Вы не можете ничего выбросить, так как в коробке ничего нет");
            }
        } else {
            System.out.println("Откройте коробку для взаимодействия с ее предметами");
        }
    }
}
