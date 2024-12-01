package ru.otus.java.basic.homeworks.homework_5.animals;

public class Cat extends Animal {
    public Cat(String name, int runVelocity, int endurance) {
        super(name, runVelocity, endurance);
        swimVelocity = 0;
    }

    @Override
    public int swim(int distance) {
        System.out.println(name + " не умеет плавать!");
        return -1;
    }
}
