package ru.otus.java.basic.homeworks.homework_7;

public class Car implements Transport{
    private int amountOfPetrol;
    private String identifier = "Автомобиль";
    private Human user = null;

    public Car(int amountOfPetrol) {
        this.amountOfPetrol = amountOfPetrol;
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
        if (landscape == Landscape.Swamp || landscape == Landscape.DenseForest) {
            System.out.println("На машине тут не проехать");
            return false;
        }
        if (amountOfPetrol < landscape.getCarCost() * distance) {
            System.out.println("Нельзя проехать, так как недостаточно бензина");
            return false;
        } else {
            amountOfPetrol -= landscape.getCarCost() * distance;
            System.out.println("Проехал");
            return true;
        }
    }
}
