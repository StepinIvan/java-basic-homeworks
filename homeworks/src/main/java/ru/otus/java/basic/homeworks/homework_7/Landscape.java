package ru.otus.java.basic.homeworks.homework_7;

import lombok.Getter;

public enum Landscape {
    Plain(1,2,1,1,2), DenseForest(3,2,2,4), Swamp(5,9);
    @Getter
    private int carCost;
    @Getter
    private int horseCost;
    @Getter
    private int ofRoadVehicleCost;
    @Getter
    private int bicycleCost;
    @Getter
    private int walkCost;

    Landscape(int carCost, int horseCost, int ofRoadVehicleCost, int bicycleCost, int walkCost) {
        this.carCost = carCost;
        this.horseCost = horseCost;
        this.ofRoadVehicleCost = ofRoadVehicleCost;
        this.bicycleCost = bicycleCost;
        this.walkCost = walkCost;
    }
    Landscape(int horseCost, int ofRoadVehicleCost, int bicycleCost, int walkCost) {
        this.horseCost = horseCost;
        this.ofRoadVehicleCost = ofRoadVehicleCost;
        this.bicycleCost = bicycleCost;
        this.walkCost = walkCost;
    }
    Landscape(int ofRoadVehicleCost, int walkCost) {
        this.ofRoadVehicleCost = ofRoadVehicleCost;
        this.walkCost = walkCost;
    }
}
