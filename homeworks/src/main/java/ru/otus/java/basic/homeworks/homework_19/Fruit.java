package ru.otus.java.basic.homeworks.homework_19;

public class Fruit {
    private final double weight;
    public Fruit(double weight) {
        this.weight = weight;
    }
    public double getWeight() {
        return this.weight;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() +
                " - " + weight + " г.";
    }
}
