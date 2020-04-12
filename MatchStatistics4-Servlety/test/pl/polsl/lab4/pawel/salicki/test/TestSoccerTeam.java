package pl.polsl.lab4.pawel.salicki.test;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import pl.polsl.lab4.pawel.salicki.model.Player;
import pl.polsl.lab4.pawel.salicki.model.SoccerTeam;

/**
 * Test case of SoccerTeam methods
 *
 * @author Paweł Salicki
 * @version 1.0
 */
public class TestSoccerTeam {

    /**
     * Player instance
     */
    Player player;

    /**
     * SoccerTeam instance
     */
    SoccerTeam soccerTeam;

    /**
     * Setup method for testing
     */
    @Before
    public void setup() {
        soccerTeam = new SoccerTeam();
    }

    /**
     * A method that checks the correctness of the method responsible for
     * calculating player goals.
     */
    @Test
    public void testCalculateGoals() {

        // one player
        // 0 goals
        // Given
        player = new Player();

        // When
        player.setScoredGoals(0);
        soccerTeam.setPlayer(player);

        // Then
        assertEquals("Scored goals should be 0", soccerTeam.calculateGoals(), 0);

        // -2 goals (negative value) 
        // Given
        player = new Player();

        // When
        player.setScoredGoals(-2);
        soccerTeam.setPlayer(player);

        // Then
        assertEquals("Scored goals should be 0", soccerTeam.calculateGoals(), 0);

        // 5 goals (positive value)
        // Given
        player = new Player();

        // When
        player.setScoredGoals(5);
        soccerTeam.setPlayer(player);

        // Then
        assertEquals("Scored goals should be 5", soccerTeam.calculateGoals(), 5);

        // two players
        // another positive value (2)
        // Given
        player = new Player();

        // When
        player.setScoredGoals(2);
        soccerTeam.setPlayer(player);

        // Then
        assertEquals("Scored goals should be 7", soccerTeam.calculateGoals(), 5 + 2);

        // another negative value (-1)
        // Given
        player = new Player();

        // When
        player.setScoredGoals(-1);
        soccerTeam.setPlayer(player);

        // Then
        assertEquals("Scored goals should be 7", soccerTeam.calculateGoals(), 5 + 2);
    }

    /**
     * A method that checks the correctness of the method responsible for
     * calculating the number of yellow cards.
     */
    @Test
    public void testCalculateYellowCards() {

        // one player in team
        // 0 cards
        // Given
        player = new Player();

        // When
        player.setYellowCards(0);
        soccerTeam.setPlayer(player);

        // Then
        assertEquals("Amount of yellow cards should be 0", soccerTeam.calculateYellowCards(), 0);

        // -2 cards (negative value)
        // Given
        player = new Player();

        // When
        player.setYellowCards(-2);
        soccerTeam.setPlayer(player);

        // Then
        assertEquals("Amount of yellow cards should be 0", soccerTeam.calculateYellowCards(), 0);

        // 5 cards (positive value)
        // Given
        player = new Player();

        // When
        player.setYellowCards(5);
        soccerTeam.setPlayer(player);

        // Then
        assertEquals("Amount of yellow cards should be 5", soccerTeam.calculateYellowCards(), 5);

        // two players
        // another 2 cards (positive value)
        // Given
        player = new Player();

        // When
        player.setYellowCards(2);
        soccerTeam.setPlayer(player);

        // Then
        assertEquals("Amount of yellow cards should be 7", soccerTeam.calculateYellowCards(), 5 + 2);

        // another -1 card (negative value)
        // Given
        player = new Player();

        // When
        player.setYellowCards(-1);
        soccerTeam.setPlayer(player);

        // Then
        assertEquals("Amount of yellow cards should be 7", soccerTeam.calculateYellowCards(), 5 + 2);
    }

    /**
     * A method that checks the correctness of the method responsible for
     * calculating the number of red cards.
     */
    @Test
    public void testCalculateRedCards() {

        // one player int team
        // Given
        player = new Player();

        // When
        player.setRedCard(false);
        soccerTeam.setPlayer(player);

        // Then
        assertEquals("Amount of red cards should be 0", soccerTeam.calculateRedCards(), 0);

        // Given
        player = new Player();

        // When
        player.setRedCard(true);
        soccerTeam.setPlayer(player);

        // Then
        assertEquals("Amount of red cards should be 1", soccerTeam.calculateRedCards(), 1);

        // two players in team
        // Given
        player = new Player();

        // When
        player.setRedCard(true);
        soccerTeam.setPlayer(player);

        // Then
        assertEquals("Amount of red cards should be 2", soccerTeam.calculateRedCards(), 1 + 1);

        // Given
        player = new Player();

        // When
        player.setRedCard(false);
        soccerTeam.setPlayer(player);

        // Then
        assertEquals("Amount of red cards should be 2", soccerTeam.calculateRedCards(), 1 + 1);
    }
}
