package geektrust.traffic.factors;

public enum Vehicle {


    BIKE(10d, 2, 1),
    TUKTUK(12d, 1, 2),
    CAR(20d, 3, 3);

    private final double speedPerMmPerHour;
    private final double minutesToCrossSingleCrater;
    private final int priority;

    Vehicle(double speedPerMmPerHour, double minutesToCrossSingleCrater, int priority) {
        this.speedPerMmPerHour = speedPerMmPerHour;
        this.minutesToCrossSingleCrater = minutesToCrossSingleCrater;
        this.priority = priority;
    }

    public double calculateTravelTime(double distance, double craters, double speedCap)
    {
        return (distance/Math.min(this.speedPerMmPerHour, speedCap))*60 + (craters*minutesToCrossSingleCrater);
    }

    public int getPriority() {
        return priority;
    }
}
