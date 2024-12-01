package ru.otus.java.basic.homeworks.homework_6;

import lombok.Getter;

public class Plate {
    private int maxAmountOfFood;
    @Getter
    private int currentAmountOfFood;

    public Plate(int maxAmountOfFood) {
        this.maxAmountOfFood = maxAmountOfFood;
        currentAmountOfFood = maxAmountOfFood;
    }

    public void addFoodToPlate(int amountOfFood) {
        currentAmountOfFood = Math.min((currentAmountOfFood + amountOfFood), maxAmountOfFood);
    }

    public boolean takeFoodFromPlate(int amountOfFood) {
        if (currentAmountOfFood - amountOfFood < 0) {
            return false;
        } else {
            currentAmountOfFood -= amountOfFood;
            return true;
        }
    }

    public void info() {
        System.out.println("Количество еды в тарелке: " + currentAmountOfFood);
        System.out.println("--------------------------------------------------------");
    }
}
