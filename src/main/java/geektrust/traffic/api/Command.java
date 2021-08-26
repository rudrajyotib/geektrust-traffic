package geektrust.traffic.api;

import geektrust.traffic.factors.Weather;
import geektrust.traffic.processor.TravelTimeCalculator;

public class Command {

    public static String calculateShortestPath(String argument)
    {
        String[] split = argument.split(" ");
        if (split.length != 3)
        {
            throw  new IllegalArgumentException("Invalid command line passed");
        }
        Weather weather = Weather.valueOf(split[0]);
        double speedCapRoute1 = Double.parseDouble(split[1]);
        double speedCapRoute2 = Double.parseDouble(split[2]);
        return TravelTimeCalculator.findShortestTime(weather, speedCapRoute1, speedCapRoute2);
    }

}
