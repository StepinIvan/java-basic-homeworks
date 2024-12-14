package ru.otus.java.basic.homeworks.homework_7;

public class Horse implements Transport{
    private int amountOfForces;

    public Horse(int amountOfForces) {
        this.amountOfForces = amountOfForces;
    }

    @Override
    public boolean useTransport(Landscape landscape, int distance) {
        if (landscape == Landscape.Swamp) {
            System.out.println("На лошади тут не проехать");
            return false;
        }
        if (amountOfForces < landscape.getHorseCost() * distance) {
            System.out.println("Нельзя проскакать, так как недостаточно бензина");
            return false;
        } else {
            amountOfForces -= landscape.getHorseCost() * distance;
            System.out.println("Проскакали на лошади");
            return true;
        }
    }
}
