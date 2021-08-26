package geektrust.traffic.routes;

import geektrust.traffic.factors.Vehicle;
import geektrust.traffic.factors.Weather;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RouteTest {

    @Test
    public void shouldCalculateTravelTime()
    {
        assertEquals(new TravelTimeResult(Vehicle.TUKTUK, 114, "ORBIT1"), Route.Orbit1.calculateTravelTime(Weather.RAINY, 40d));
        assertEquals(new TravelTimeResult(Vehicle.CAR, 90, "ORBIT2"), Route.Orbit2.calculateTravelTime(Weather.WINDY, 40d));
    }


}