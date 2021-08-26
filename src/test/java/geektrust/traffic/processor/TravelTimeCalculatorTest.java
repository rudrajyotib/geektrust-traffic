package geektrust.traffic.processor;

import geektrust.traffic.factors.Weather;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TravelTimeCalculatorTest {

    @Test
    public void shouldCalculateShortestTime()
    {
        assertEquals("TUKTUK ORBIT1", TravelTimeCalculator.findShortestTime(Weather.RAINY, 12, 10));
        assertEquals("CAR ORBIT2", TravelTimeCalculator.findShortestTime(Weather.WINDY, 14, 20));
    }


}