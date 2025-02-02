package ru.otus.java.basic.homeworks.homework_7;

public class Main {
    public static void main(String[] args) {
        Car car = new Car(150);
        Horse horse = new Horse(40);
        Bicycle bicycle = new Bicycle();
        OfRoadVehicle ofRoadVehicle = new OfRoadVehicle(250);

        Human John = new Human("John", 100);
        John.takeTransport(car);
        John.useTransport(Landscape.Plain, 50);
        John.useTransport(Landscape.Swamp, 50);
        John.useTransport(Landscape.DenseForest, 50);
        John.leaveTransport();
        John.takeTransport(horse);
        John.useTransport(Landscape.Plain, 2);
        John.useTransport(Landscape.Swamp, 2);
        John.useTransport(Landscape.DenseForest, 2);
        John.leaveTransport();
        John.takeTransport(bicycle);
        John.useTransport(Landscape.Plain, 30);
        John.useTransport(Landscape.Swamp, 30);
        John.useTransport(Landscape.DenseForest, 30);
        John.leaveTransport();
        John.takeTransport(ofRoadVehicle);
        John.useTransport(Landscape.Plain, 20);
        John.useTransport(Landscape.Swamp, 20);
        John.useTransport(Landscape.DenseForest, 20);
        John.leaveTransport();
        John.useTransport(Landscape.Plain, 1);
        John.useTransport(Landscape.Swamp, 1);
        John.useTransport(Landscape.DenseForest, 1);
    }
}
