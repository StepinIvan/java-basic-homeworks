package ru.otus.java.basic.homeworks.homework_7;

public class Horse implements Transport{
    private int amountOfForces;
    private String identifier = "Лошадь";
    private Human user = null;

    public Horse(int amountOfForces) {
        this.amountOfForces = amountOfForces;
    }

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
            System.out.println("На лошади тут не проехать");
            return false;
        }
        if (amountOfForces < landscape.getHorseCost() * distance) {
            System.out.println("Нельзя проскакать, так как недостаточно сил");
            return false;
        } else {
            amountOfForces -= landscape.getHorseCost() * distance;
            System.out.println("Проскакали на лошади");
            return true;
        }
    }
}
