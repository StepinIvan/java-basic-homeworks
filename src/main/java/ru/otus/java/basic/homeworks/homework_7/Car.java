package ru.otus.java.basic.homeworks.homework_7;

public class Car implements Transport{
    private int amountOfPetrol;

    public Car(int amountOfPetrol) {
        this.amountOfPetrol = amountOfPetrol;
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
            System.out.println("Проехали");
            return true;
        }
    }
}
