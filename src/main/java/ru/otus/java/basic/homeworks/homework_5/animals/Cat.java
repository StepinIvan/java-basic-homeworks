package ru.otus.java.basic.homeworks.homework_5.animals;

public class Cat extends Animal {
    public Cat(String name, int runVelocity, int swimVelocity, int endurance) {
        super(name, runVelocity, swimVelocity, endurance);
    }

    @Override
    public int run(int distance) {
        if (distance > endurance) {
            System.out.println("Кот не может столько пробежать, единиц выносливости недостаточно");
            return -1;
        } else {
            endurance -= distance;
        }
        return distance / runVelocity;
    }

    @Override
    public int swim(int distance) {
        System.out.println("Кот не умеет плавать!");
        return -1;
    }

    @Override
    public void info() {
        System.out.println("Имя " + name + "\nСкорость бега: " + runVelocity + "\nСкорость плавания: " + swimVelocity
                + "\nВыносливость: " + endurance);
        System.out.println("----------------------------------------------------");
    }
}
