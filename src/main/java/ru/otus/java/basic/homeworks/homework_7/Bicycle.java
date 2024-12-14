package ru.otus.java.basic.homeworks.homework_7;

public class Bicycle implements Transport{
    @Override
    public boolean useTransport(Landscape landscape, int distance) {
        if (landscape == Landscape.Swamp) {
            System.out.println("На велосипеде тут не проехать");
            return false;
        }
        System.out.println("Проехали на велосипеде");
        return true;
    }
}
