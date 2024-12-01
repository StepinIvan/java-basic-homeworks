package ru.otus.java.basic.homeworks.homework_5.animals;

public class Horse extends Animal {
    public Horse(String name, int runVelocity, int swimVelocity, int endurance) {
        super(name, runVelocity, swimVelocity, endurance);
    }
    @Override
    public int swim(int distance) {
        if (distance * 4 > endurance) {
            System.out.println(name + " не может столько пробежать, единиц выносливости недостаточно");
            return -1;
        } else {
            endurance -= distance * 4;
        }
        return distance / swimVelocity;
    }
}
