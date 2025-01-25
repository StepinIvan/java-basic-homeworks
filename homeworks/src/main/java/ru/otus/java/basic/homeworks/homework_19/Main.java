package ru.otus.java.basic.homeworks.homework_19;


public class Main {
    public static void main(String[] args) {
        Box<Fruit> fruits = new Box<>();
        Box<Apple> apples = new Box<>();
        Box<Orange> oranges = new Box<>();

        Apple apple_1 = new Apple(170);
        Apple apple_2 = new Apple(156);

        Orange orange_1 = new Orange(200);
        Orange orange_2 = new Orange(180);

        apples.addFruitTo(apple_1);
        apples.addFruitTo(apple_2);

        oranges.addFruitTo(orange_1);
        oranges.addFruitTo(orange_2);

        fruits.addFruitTo(apple_1);
        fruits.addFruitTo(orange_1);

        System.out.println("Вес коробки с яблоками: " + apples.weight());
        System.out.println("Вес коробки с апельсинами: " + oranges.weight());
        System.out.println("Вес коробки с фруктами: " + fruits.weight());
        System.out.println("Равны ли веса коробок?  - " + apples.compare(oranges));

        System.out.println(fruits);
        System.out.println(apples);
        System.out.println(oranges);

        System.out.println("Пересыпаем коробку с яблоками в коробку с фруктами");
        apples.transferFruitsTo(fruits);

        System.out.println(fruits);
        System.out.println(apples);
        System.out.println(oranges);

        System.out.println("Пересыпаем коробку с апельсинами в коробку с фруктами");
        oranges.transferFruitsTo(fruits);

        System.out.println(fruits);
        System.out.println(apples);
        System.out.println(oranges);

    }
}
