package ru.otus.java.basic.homeworks.homework_5.animals;

public class Horse extends Animal {
    public Horse(String name, int runVelocity, int swimVelocity, int endurance) {
        super(name, runVelocity, swimVelocity, endurance);
    }

    @Override
    public int run(int distance) {
        return 0;
    }

    @Override
    public int swim(int distance) {
        return 0;
    }

    @Override
    public void info() {

    }
}
