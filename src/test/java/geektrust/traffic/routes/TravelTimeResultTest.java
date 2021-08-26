package geektrust.traffic.routes;

import geektrust.traffic.factors.Vehicle;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TravelTimeResultTest {

    @Test
    public void shouldCompareByTravelTime() {
        TravelTimeResult travelTimeResult1 = new TravelTimeResult(Vehicle.CAR, 20d, "R1");
        TravelTimeResult travelTimeResult2 = new TravelTimeResult(Vehicle.CAR, 19d, "R2");

        assertEquals("CAR R2", Stream.of(travelTimeResult1, travelTimeResult2).min(TravelTimeResult::compareTo).get().formatOutput());

    }


    @Test
    public void shouldCompareByTravelTimeAndPriority() {
        TravelTimeResult travelTimeResult1 = new TravelTimeResult(Vehicle.CAR, 20d, "R1");
        TravelTimeResult travelTimeResult2 = new TravelTimeResult(Vehicle.BIKE, 20d, "R2");

        assertEquals("BIKE R2", Stream.of(travelTimeResult1, travelTimeResult2).min(TravelTimeResult::compareTo).get().formatOutput());

    }

    @Test
    public void shouldPrioritiseTimeOverPriority() {
        TravelTimeResult travelTimeResult1 = new TravelTimeResult(Vehicle.CAR, 19d, "R1");
        TravelTimeResult travelTimeResult2 = new TravelTimeResult(Vehicle.BIKE, 20d, "R2");

        assertEquals("CAR R1", Stream.of(travelTimeResult1, travelTimeResult2).min(TravelTimeResult::compareTo).get().formatOutput());

    }

    @Test
    public void shouldDeprioritiseNonCompatibleObjects() {
        TravelTimeResult travelTimeResult1 = new TravelTimeResult(Vehicle.CAR, 19d, "R1");
        assertEquals(1, travelTimeResult1.compareTo("Some text"));
    }

    @Test
    public void shouldCheckEqual() {
        assertEquals(new TravelTimeResult(Vehicle.CAR, 19d, "R1"), new TravelTimeResult(Vehicle.CAR, 19d, "R1"));
        TravelTimeResult travelTimeResult = new TravelTimeResult(Vehicle.CAR, 19d, "R1");
        assertEquals(travelTimeResult, travelTimeResult);
    }


}
