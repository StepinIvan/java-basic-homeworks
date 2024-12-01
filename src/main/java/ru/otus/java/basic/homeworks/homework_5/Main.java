package ru.otus.java.basic.homeworks.homework_5;

import ru.otus.java.basic.homeworks.homework_5.animals.Cat;
import ru.otus.java.basic.homeworks.homework_5.animals.Dog;
import ru.otus.java.basic.homeworks.homework_5.animals.Horse;


public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat("Барсик", 3, 30);
        System.out.println("Время, которое " + cat.getName() + " затратил на плавание: " + cat.swim(10));
        System.out.println("Время, которое " + cat.getName() + " затратил на бег: " + cat.run(15));
        System.out.println("Время, которое " + cat.getName() + " затратил на бег: " + cat.run(20));
        cat.info();
        Dog dog = new Dog("Барбос", 5, 2, 80);
        System.out.println("Время, которое " + dog.getName() + " затратил на плавание: " + dog.swim(10));
        System.out.println("Время, которое " + dog.getName() + " затратил на бег: " + dog.run(15));
        System.out.println("Время, которое " + dog.getName() + " затратил на бег: " + dog.run(20));
        dog.info();
        Horse horse = new Horse("Серый", 15, 5, 200);
        System.out.println("Время, которое " + horse.getName() + " затратил на плавание: " + horse.swim(15));
        System.out.println("Время, которое " + horse.getName() + " затратил на бег: " + horse.run(105));
        System.out.println("Время, которое " + horse.getName() + " затратил на бег: " + horse.run(60));
        horse.info();
    }
}
