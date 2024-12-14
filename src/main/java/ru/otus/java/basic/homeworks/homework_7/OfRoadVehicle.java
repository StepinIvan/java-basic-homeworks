package ru.otus.java.basic.homeworks.homework_7;

public class OfRoadVehicle implements Transport{
    private int amountOfPetrol;

    public OfRoadVehicle(int amountOfPetrol) {
        this.amountOfPetrol = amountOfPetrol;
    }

    @Override
    public boolean useTransport(Landscape landscape, int distance) {
        if (amountOfPetrol < landscape.getOfRoadVehicleCost() * distance) {
            System.out.println("Нельзя проехать, так как недостаточно бензина");
            return false;
        } else {
            amountOfPetrol -= landscape.getOfRoadVehicleCost() * distance;
            System.out.println("Проехали");
            return true;
        }
    }
}
