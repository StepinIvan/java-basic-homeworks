package ru.otus.java.basic.homeworks.homework_5.animals;

public class Dog extends Animal {
    public Dog(String name, int runVelocity, int swimVelocity, int endurance) {
        super(name, runVelocity, swimVelocity, endurance);
    }

    @Override
    public int swim(int distance) {
        if (distance * 2 > endurance) {
            System.out.println(name + " не может столько проплыть, единиц выносливости недостаточно");
            return -1;
        } else {
            endurance -= distance * 2;
        }
        return distance / swimVelocity;
    }
}
