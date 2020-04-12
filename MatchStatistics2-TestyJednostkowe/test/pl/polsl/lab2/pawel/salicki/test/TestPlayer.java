package pl.polsl.lab2.pawel.salicki.test;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import pl.polsl.lab2.pawel.salicki.model.Player;

/**
 * Test case of class Player methods
 *
 * @author Paweł Salicki
 * @version 1.0
 */
public class TestPlayer {

    /**
     * Player instance
     */
    Player player;

    /**
     * Setup method for testing
     */
    @Before
    public void setup() {
        player = new Player();
    }

    /**
     * A method that checks the method responsible for calculating the player's
     * time spent in the game. (new method)
     */
    @Test
    public void testCalculatePlayerTimeInGame() {

        // entry in 0 min, left in 0 min 
        player.setEntryTime(0);
        player.setLeftTime(0);
        assertEquals("The game time should be 0 minutes.", player.calculatePlayerTimeInGame(), 0 - 0);

        // entry in -10 min, left in -10 min (negative values) 
        player.setEntryTime(-10);
        player.setLeftTime(-10);
        assertEquals("The game time should be 0 minutes.", player.calculatePlayerTimeInGame(), 0 - 0);

        // entry in 10 min, left in -10 min (positive and negative value)
        player.setEntryTime(10);
        player.setLeftTime(-10);
        assertEquals("The game time should be 0 minutes.", player.calculatePlayerTimeInGame(), 0 - 0);

        // entry in 10 min, left in 10 min (positive the same values)
        player.setEntryTime(10);
        player.setLeftTime(10);
        assertEquals("The game time should be 0 minutes.", player.calculatePlayerTimeInGame(), 10 - 10);

        // entry in 0 min, left in 90 min (0 value and positive value)
        player.setEntryTime(0);
        player.setLeftTime(90);
        assertEquals("The game time should be 10 minutes.", player.calculatePlayerTimeInGame(), 90 - 0);

        // entry in 10 min, left in 80 min (positive values)
        player.setEntryTime(10);
        player.setLeftTime(80);
        assertEquals("The game time should be 70 minutes.", player.calculatePlayerTimeInGame(), 80 - 10);

        // entry in 80 min, left in 10 min (posirive values)
        player.setEntryTime(80);
        player.setLeftTime(10);
        assertEquals("The game time should be 0 minutes.", player.calculatePlayerTimeInGame(), 80 - 80);

        // entry in 9 min, left in 10 min (positive values)
        player.setEntryTime(9);
        player.setLeftTime(10);
        assertEquals("The game time should be 1 minute.", player.calculatePlayerTimeInGame(), 10 - 9);
    }

    /**
     * A method that checks the method responsible for calculating the player's
     * time spent in the game. (old method)
     */
    @Test
    public void testCalculatePlayerPlayedTime() {

        // entry in 0 min, left in 0 min (0, the same vakues)
        player.setEntryTime(0);
        player.setLeftTime(0);
        assertEquals("The game time should be 0 minutes.", player.calculatePlayerPlayedTime(), 0 - 0);

        // entry in -10 min, left in -10 min (negative, the same values)
        player.setEntryTime(-10);
        player.setLeftTime(-10);
        assertEquals("The game time should be 0 minutes.", player.calculatePlayerPlayedTime(), (-10) - (-10));

        // entry in 10 min, left in -10 min (posirive and negative value)
        player.setEntryTime(10);
        player.setLeftTime(-10);
        assertEquals("The game time should be -20 minutes.", player.calculatePlayerPlayedTime(), (-10) - 10);

        // entry in 10 min, left in 10 min (positive, the same values)
        player.setEntryTime(10);
        player.setLeftTime(10);
        assertEquals("The game time should be 0 minutes.", player.calculatePlayerPlayedTime(), 10 - 10);

        // entry in 0 min, left in 90 min (0 and positive value)
        player.setEntryTime(0);
        player.setLeftTime(90);
        assertEquals("The game time should be 90 minutes.", player.calculatePlayerPlayedTime(), 90 - 0);

        // entry in 10 min, left in 80 min (positive values)
        player.setEntryTime(10);
        player.setLeftTime(80);
        assertEquals("The game time should be 70 minutes.", player.calculatePlayerPlayedTime(), 80 - 10);

        // entry in 80 min, left in 10 min (positive values)
        player.setEntryTime(80);
        player.setLeftTime(10);
        assertEquals("The game time should be -70 minutes.", player.calculatePlayerPlayedTime(), 10 - 80);

        // entry in 9 min, left in 10 min (positive values)
        player.setEntryTime(9);
        player.setLeftTime(10);
        assertEquals("The game time should be 1 minute.", player.calculatePlayerPlayedTime(), 10 - 9);
    }
}
