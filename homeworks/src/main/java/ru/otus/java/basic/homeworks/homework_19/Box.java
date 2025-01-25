package ru.otus.java.basic.homeworks.homework_19;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {
    private final List<T> fruits = new ArrayList<>();

    public Box() {
    }
    public void addFruitTo(T fruit) {
        fruits.add(fruit);
    }
    public double weight() {
        double weight = 0;
        for (T fruit : fruits) {
            weight += fruit.getWeight();
        }
        return weight;
    }
    public boolean compare(Box<?> anotherBox) {
        return Math.abs(this.weight() - anotherBox.weight()) < 0.000001;
    }

    @Override
    public String toString() {
        return "Box{" + fruits +
                '}';
    }

    public void transferFruitsTo(Box<? super T> otherBox) {
        for (T fruit : fruits) {
            otherBox.addFruitTo(fruit);
        }
        fruits.clear();
    }
}
