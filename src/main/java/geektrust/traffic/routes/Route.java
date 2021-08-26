package geektrust.traffic.routes;

import geektrust.traffic.factors.Weather;

public enum Route {

    Orbit1("ORBIT1", 18, 20),
    Orbit2("ORBIT2", 20, 10);


    private final String routeName;
    private final int distance;
    private final int craters;

    Route(String routeName, int distance, int craters) {
        this.routeName = routeName;
        this.distance = distance;
        this.craters = craters;
    }

    public TravelTimeResult calculateTravelTime(Weather weather, double speedCap)
    {
        return weather.getSuitableVehicles().stream()
                .map(vehicle -> {
                    double travelTime = vehicle.calculateTravelTime(distance, craters* weather.getCraterCoefficient(), speedCap);
                    return new TravelTimeResult(vehicle, travelTime, routeName);
                })
                .min(TravelTimeResult::compareTo)
                .orElse(null);

    }
}
