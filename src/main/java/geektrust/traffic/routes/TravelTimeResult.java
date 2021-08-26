package geektrust.traffic.routes;

import geektrust.traffic.factors.Vehicle;

@SuppressWarnings("rawtypes")
public class TravelTimeResult implements Comparable {

    private final Vehicle vehicle;
    private final double timeToTravel;
    private final String route;

    public TravelTimeResult(Vehicle vehicle, double timeToTravel, String route) {
        this.vehicle = vehicle;
        this.timeToTravel = timeToTravel;
        this.route = route;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TravelTimeResult that = (TravelTimeResult) o;
        return Double.compare(that.timeToTravel, timeToTravel) == 0 && vehicle == that.vehicle && route.equals(that.route);
    }

    @Override
    public int compareTo(Object o) {
        if (!(o instanceof TravelTimeResult)) {
            return 1;
        }
        TravelTimeResult other = (TravelTimeResult) o;
        if (!(this.timeToTravel == other.timeToTravel)) {
            return Double.compare(this.timeToTravel, other.timeToTravel);
        }
        return Integer.compare(this.vehicle.getPriority(), other.vehicle.getPriority());
    }

    public String formatOutput() {
        return String.format("%s %s", this.vehicle.name(), this.route);
    }


}
