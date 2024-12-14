package ru.otus.java.basic.homeworks.homework_7;

public class Bicycle implements Transport{
    private String identifier = "Велосипед";
    private Human user = null;
    @Override
    public String getIdentifier() {
        return identifier;
    }

    @Override
    public void setUser(Human user) {
        this.user = user;
    }

    @Override
    public boolean useTransport(Landscape landscape, int distance) {
        if (landscape == Landscape.Swamp) {
            System.out.println("На велосипеде тут не проехать");
            return false;
        }
        user.setEndurance(user.getEndurance() - landscape.getBicycleCost() * distance);
        System.out.println("Проехал на велосипеде");
        return true;
    }
}
