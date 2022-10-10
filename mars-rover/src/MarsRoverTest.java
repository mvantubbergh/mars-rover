import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MarsRoverTest {

    private Assertions Assert;

    @Test
    public void executeInstructionsMMRMMRMRRM() {
        int maxX = 5;
        int maxY = 5;
        int curX = 3;
        int curY = 3;
        Plateau plateau = new Plateau(maxX, maxY);
        MarsRover marsRover = new MarsRover(plateau, "MMRMMRMRRM", curX, curY);
        marsRover.setCurDirection("E");
        marsRover.executeInstructions("MMRMMRMRRM");
        assertEquals(5, marsRover.getCurrX());
        assertEquals(1, marsRover.getCurY());
        assertEquals("E", marsRover.getCurDirection());
    }

    @Test
    public void executeInstructionsLMLMLMLMM() {
        int maxX = 5;
        int maxY = 5;
        int curX = 1;
        int curY = 2;
        Plateau plateau = new Plateau(maxX, maxY);
        MarsRover marsRover = new MarsRover(plateau, "LMLMLMLMM", curX, curY);
        marsRover.setCurDirection("N");
        marsRover.executeInstructions("LMLMLMLMM");
        assertEquals(1, marsRover.getCurrX());
        assertEquals(3, marsRover.getCurY());
        assertEquals("N", marsRover.getCurDirection());
    }
}