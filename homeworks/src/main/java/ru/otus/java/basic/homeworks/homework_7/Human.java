package ru.otus.java.basic.homeworks.homework_7;

import lombok.Getter;
import lombok.Setter;

public class Human {
    @Getter
    private String name;
    private Transport currentTransport = null;
    @Getter
    @Setter
    private int endurance;

    public Human(String name, int endurance) {
        this.name = name;
        this.endurance = endurance;
    }
    public void takeTransport(Transport transport) {
        currentTransport = transport;
        transport.setUser(this);
        System.out.printf("%s использует %s%n",name,transport.getIdentifier());
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
            endurance -= landscape.getWalkCost() * distance;
            System.out.println("Прошел");
            return true;
        }
    }
}
