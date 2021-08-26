package geektrust.traffic.factors;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WeatherTest {

    @Test
    public void shouldDeriveSuitableVehiclesAndAdjustCraters()
    {
        assertEquals(3, Weather.SUNNY.getSuitableVehicles().size());
        assertEquals(0.9, Weather.SUNNY.getCraterCoefficient());

        assertEquals(2, Weather.RAINY.getSuitableVehicles().size());
        assertEquals(1.2, Weather.RAINY.getCraterCoefficient());

        assertEquals(2, Weather.WINDY.getSuitableVehicles().size());
        assertEquals(1, Weather.WINDY.getCraterCoefficient());
    }

}