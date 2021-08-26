package geektrust.traffic.factors;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VehicleTest {

    @Test
    public void shouldCalculateTravelTime()
    {
        assertEquals(75, Vehicle.CAR.calculateTravelTime(20, 5, 20));
        assertEquals(135, Vehicle.CAR.calculateTravelTime(20, 5, 10));
        assertEquals(130, Vehicle.BIKE.calculateTravelTime(20, 5, 10));
        assertEquals(125, Vehicle.TUKTUK.calculateTravelTime(20, 5, 10));
    }

}