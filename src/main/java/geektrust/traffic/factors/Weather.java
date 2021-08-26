package geektrust.traffic.factors;

import java.util.Arrays;
import java.util.List;

public enum Weather {

    RAINY(1.2d, Arrays.asList(Vehicle.CAR, Vehicle.TUKTUK)),
    SUNNY(0.9d, Arrays.asList(Vehicle.CAR, Vehicle.TUKTUK, Vehicle.BIKE)),
    WINDY(1d, Arrays.asList(Vehicle.CAR, Vehicle.BIKE));

    private final double craterCoefficient;
    private final List<Vehicle> suitableVehicles;

    Weather(double craterCoefficient, List<Vehicle> suitableVehicles) {
        this.craterCoefficient = craterCoefficient;
        this.suitableVehicles = suitableVehicles;
    }

    public double getCraterCoefficient() {
        return craterCoefficient;
    }

    public List<Vehicle> getSuitableVehicles() {
        return suitableVehicles;
    }
}
