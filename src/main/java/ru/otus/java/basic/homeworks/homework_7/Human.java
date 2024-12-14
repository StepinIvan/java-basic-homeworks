package ru.otus.java.basic.homeworks.homework_7;

import lombok.Getter;

import java.lang.invoke.LambdaConversionException;


public class Human {
    @Getter
    private String name;
    private Transport currentTransport = null;
    private int endurance;

    public Human(String name, int endurance) {
        this.name = name;
        this.endurance = endurance;
    }
    public void takeTransport(Transport transport) {
        currentTransport = transport;
        System.out.println(name + " использует " + transport);
        //TODO Исправить вывод текущего транспорта
    }
    void leaveTransport() {
        currentTransport = null;
    }
    public boolean useTransport(Landscape landscape, int distance) {
        if (currentTransport == null) {
            return walk(landscape, distance);
        } else {
            return currentTransport.useTransport(landscape,distance);
        }
    }
    public boolean walk (Landscape landscape, int distance) {
        if (endurance < landscape.getWalkCost() * distance) {
            System.out.println("Не смогу столько пройти, недостаточно сил");
            return false;
        } else {
            System.out.println("Прошел");
            return true;
        }
    }
    public void info () {

    }
}
