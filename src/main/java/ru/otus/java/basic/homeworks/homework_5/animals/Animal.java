package ru.otus.java.basic.homeworks.homework_5.animals;

import lombok.Getter;

public abstract class Animal {
    @Getter
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
    public Animal(String name, int runVelocity, int endurance) {
        this.name = name;
        this.runVelocity = runVelocity;
        this.endurance = endurance;
    }
    public int run(int distance) {
        if (distance > endurance) {
            System.out.println(name + " не может столько пробежать, единиц выносливости недостаточно");
            return -1;
        } else {
            endurance -= distance;
        }
        return distance / runVelocity;
    }
    public abstract int swim(int distance);
    public void info() {
        System.out.println("Имя: " + name + "\nСкорость бега: " + runVelocity + "\nСкорость плавания: " + swimVelocity
                + "\nВыносливость: " + endurance);
        System.out.println("----------------------------------------------------");
    };
}
