package ru.otus.java.basic.homeworks.homework_6;

public class Main {
    public static void main(String[] args) {
        Cat[] cats = {
                new Cat("Том", 5),
                new Cat("Василий", 12),
                new Cat("Дымок", 2)
        };
        Plate commonPlate = new Plate(18);
        for (Cat cat : cats) {
            cat.info();
        }

        commonPlate.info();
        cats[0].eat(commonPlate);
        cats[1].eat(commonPlate);
        cats[2].eat(commonPlate);

        for (Cat cat : cats) {
            cat.info();
        }
        commonPlate.info();
        commonPlate.addFoodToPlate(20);
        cats[2].eat(commonPlate);

        for (Cat cat : cats) {
            cat.info();
        }

        commonPlate.info();
    }
}
