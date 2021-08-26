package geektrust.traffic.processor;

import geektrust.traffic.factors.Weather;
import geektrust.traffic.routes.Route;
import geektrust.traffic.routes.TravelTimeResult;

import java.util.stream.Stream;

public class TravelTimeCalculator {

    public static String findShortestTime(Weather weather, double route1SpeedCap, double route2SpeedCap) {
        TravelTimeResult travelTimeResultInRoute1 =
                Route.Orbit1.calculateTravelTime(weather, route1SpeedCap);

        TravelTimeResult travelTimeResultInRoute2 =
                Route.Orbit2.calculateTravelTime(weather, route2SpeedCap);

        return Stream.of(travelTimeResultInRoute1, travelTimeResultInRoute2
                )
                .min(TravelTimeResult::compareTo)
                .map(TravelTimeResult::formatOutput)
                .orElse("");
    }

}
