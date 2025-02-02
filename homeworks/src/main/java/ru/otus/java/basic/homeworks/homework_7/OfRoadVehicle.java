package ru.otus.java.basic.homeworks.homework_7;

public class OfRoadVehicle implements Transport{
    private int amountOfPetrol;
    private String identifier = "Вездеход";
    private Human user = null;

    public OfRoadVehicle(int amountOfPetrol) {
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
        if (amountOfPetrol < landscape.getOfRoadVehicleCost() * distance) {
            System.out.println("Нельзя проехать, так как недостаточно бензина");
            return false;
        } else {
            amountOfPetrol -= landscape.getOfRoadVehicleCost() * distance;
            System.out.println("Проехал");
            return true;
        }
    }
}
