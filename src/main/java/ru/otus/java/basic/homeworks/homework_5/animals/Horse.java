package ru.otus.java.basic.homeworks.homework_5.animals;

public class Horse extends Animal {
    public Horse(String name, int runVelocity, int swimVelocity, int endurance) {
        super(name, runVelocity, swimVelocity, endurance);
    }
    @Override
    public int swim(int distance) {
        if (distance > endurance) {
            System.out.println(name + " не может столько пробежать, единиц выносливости недостаточно");
            return -1;
        } else {
            endurance -= distance * 4;
        }
        return distance / runVelocity;
    }

    @Override
    public void info() {
        System.out.println("Имя " + name + "\nСкорость бега: " + runVelocity + "\nСкорость плавания: " + swimVelocity
                + "\nВыносливость: " + endurance);
        System.out.println("----------------------------------------------------");
    }
}
