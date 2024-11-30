package ru.otus.java.basic.homeworks.homework_5.animals;

public abstract class Animal {
    String name;
    int runVelocity;
    int swimVelocity;
    int endurance;

    public Animal(String name, int runVelocity, int swimVelocity, int endurance) {
        this.name = name;
        this.runVelocity = runVelocity;
        this.swimVelocity = swimVelocity;
        this.endurance = endurance;
    }
    public abstract int run(int distance);
    public abstract int swim(int distance);
    public abstract void info();
}