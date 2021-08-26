package geektrust.traffic.api;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CommandTest {

    @Test
    public void shouldCalculateShortestPathInCommand() {
        assertEquals("TUKTUK ORBIT1", Command.calculateShortestPath("SUNNY 12 10"));
    }

    @Test
    public void shouldThrowExceptionIfCommandNotProper() {
        assertThrows(IllegalArgumentException.class, () -> Command.calculateShortestPath("XXXXXX"));
    }

}