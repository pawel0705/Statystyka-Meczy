package pl.polsl.lab6.pawel.salicki.test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import pl.polsl.lab6.pawel.salicki.model.Match;
import pl.polsl.lab6.pawel.salicki.model.Player;
import pl.polsl.lab6.pawel.salicki.model.SoccerTeam;

/**
 * A class that performs unit tests for methods from the Match class.
 *
 * @author Paweł Salicki
 * @version 1.0
 */
public class TestMatch {

    /**
     * Player instance
     */
    Player player;

    /**
     * SoccerTeam instance
     */
    SoccerTeam soccerTeam;

    /**
     * Match instance
     */
    Match match;

    /**
     * A method that checks the correctness of the method responsible for
     * calculating all goals and selecting the winning team.
     */
    @Test
    public void testChooseTheWinnerTeam() {
        // 0 : 0 score
        match = new Match();
        soccerTeam = new SoccerTeam();
        soccerTeam.setTeamName("hostTeam");
        player = new Player();
        player.setScoredGoals(0);
        soccerTeam.setPlayer(player);
        match.setHostTeam(soccerTeam);
        soccerTeam = new SoccerTeam();
        soccerTeam.setTeamName("guestTeam");
        player = new Player();
        player.setScoredGoals(0);
        soccerTeam.setPlayer(player);
        match.setGuestTeam(soccerTeam);
        assertEquals("No team should win.", match.chooseTheWinnerTeam(), "There is no winner");

        // 2 : 2 score (positive score, tha same score)
        match = new Match();
        soccerTeam = new SoccerTeam();
        soccerTeam.setTeamName("hostTeam");
        player = new Player();
        player.setScoredGoals(2);
        soccerTeam.setPlayer(player);
        match.setHostTeam(soccerTeam);
        soccerTeam = new SoccerTeam();
        soccerTeam.setTeamName("guestTeam");
        player = new Player();
        player.setScoredGoals(2);
        soccerTeam.setPlayer(player);
        match.setGuestTeam(soccerTeam);
        assertEquals("No team should win.", match.chooseTheWinnerTeam(), "There is no winner");

        // -5 : -3 score (negative score)
        match = new Match();
        soccerTeam = new SoccerTeam();
        soccerTeam.setTeamName("hostTeam");
        player = new Player();
        player.setScoredGoals(-5);
        soccerTeam.setPlayer(player);
        match.setHostTeam(soccerTeam);
        soccerTeam = new SoccerTeam();
        soccerTeam.setTeamName("guestTeam");
        player = new Player();
        player.setScoredGoals(-3);
        soccerTeam.setPlayer(player);
        match.setGuestTeam(soccerTeam);
        assertEquals("No team should win.", match.chooseTheWinnerTeam(), "There is no winner");

        // -5 : 3 (negative and positive score)
        match = new Match();
        soccerTeam = new SoccerTeam();
        soccerTeam.setTeamName("hostTeam");
        player = new Player();
        player.setScoredGoals(-5);
        soccerTeam.setPlayer(player);
        match.setHostTeam(soccerTeam);
        soccerTeam = new SoccerTeam();
        soccerTeam.setTeamName("guestTeam");
        player = new Player();
        player.setScoredGoals(3);
        soccerTeam.setPlayer(player);
        match.setGuestTeam(soccerTeam);
        assertEquals("The guest team should win.", match.chooseTheWinnerTeam(), "Winner-guestTeam");

        // 3 : -1 (positive and negative score)
        match = new Match();
        soccerTeam = new SoccerTeam();
        soccerTeam.setTeamName("hostTeam");
        player = new Player();
        player.setScoredGoals(3);
        soccerTeam.setPlayer(player);
        match.setHostTeam(soccerTeam);
        soccerTeam = new SoccerTeam();
        soccerTeam.setTeamName("guestTeam");
        player = new Player();
        player.setScoredGoals(-1);
        soccerTeam.setPlayer(player);
        match.setGuestTeam(soccerTeam);
        assertEquals("The host team should win", match.chooseTheWinnerTeam(), "Winner-hostTeam");

        // 3 : 5 (positive score)
        match = new Match();
        soccerTeam = new SoccerTeam();
        soccerTeam.setTeamName("hostTeam");
        player = new Player();
        player.setScoredGoals(3);
        soccerTeam.setPlayer(player);
        match.setHostTeam(soccerTeam);
        soccerTeam = new SoccerTeam();
        soccerTeam.setTeamName("guestTeam");
        player = new Player();
        player.setScoredGoals(5);
        soccerTeam.setPlayer(player);
        match.setGuestTeam(soccerTeam);
        assertEquals("The guest team should win", match.chooseTheWinnerTeam(), "Winner-guestTeam");

        // 10 : 1 (positive score)
        match = new Match();
        soccerTeam = new SoccerTeam();
        soccerTeam.setTeamName("hostTeam");
        player = new Player();
        player.setScoredGoals(10);
        soccerTeam.setPlayer(player);
        match.setHostTeam(soccerTeam);
        soccerTeam = new SoccerTeam();
        soccerTeam.setTeamName("guestTeam");
        player = new Player();
        player.setScoredGoals(1);
        soccerTeam.setPlayer(player);
        match.setGuestTeam(soccerTeam);
        assertEquals("The host team should win", match.chooseTheWinnerTeam(), "Winner-hostTeam");
    }

    /**
     * A method that checks the correctness of the foul counting method.
     */
    @Test
    public void testCalculateFouls() {
        // O fouls in host team, 0 fouls in guest team
        match = new Match();
        player = new Player();
        soccerTeam = new SoccerTeam();
        player.setFouls(0);
        soccerTeam.setPlayer(player);
        match.setHostTeam(soccerTeam);
        player = new Player();
        soccerTeam = new SoccerTeam();
        player.setFouls(0);
        soccerTeam.setPlayer(player);
        match.setGuestTeam(soccerTeam);
        assertEquals("There should be 0 fouls.", match.calculateFouls(), 0 + 0);

        // -1 fouls in host team, -2 fouls in guest team (negative values)
        match = new Match();
        player = new Player();
        soccerTeam = new SoccerTeam();
        player.setFouls(-1);
        soccerTeam.setPlayer(player);
        match.setHostTeam(soccerTeam);
        player = new Player();
        soccerTeam = new SoccerTeam();
        player.setFouls(-2);
        soccerTeam.setPlayer(player);
        match.setGuestTeam(soccerTeam);
        assertEquals("There should be 0 fouls.", match.calculateFouls(), 0 + 0);

        // 1 foul in host team, 5 fouls in guest team (positive values) 
        match = new Match();
        player = new Player();
        soccerTeam = new SoccerTeam();
        player.setFouls(1);
        soccerTeam.setPlayer(player);
        match.setHostTeam(soccerTeam);
        player = new Player();
        soccerTeam = new SoccerTeam();
        player.setFouls(5);
        soccerTeam.setPlayer(player);
        match.setGuestTeam(soccerTeam);
        assertEquals("There should be 6 fouls.", match.calculateFouls(), 1 + 5);

        // -2 fouls in host team, -4 fouls in guest team (negative values)
        match = new Match();
        player = new Player();
        soccerTeam = new SoccerTeam();
        player.setFouls(-2);
        soccerTeam.setPlayer(player);
        match.setHostTeam(soccerTeam);
        player = new Player();
        soccerTeam = new SoccerTeam();
        player.setFouls(-4);
        soccerTeam.setPlayer(player);
        match.setGuestTeam(soccerTeam);
        assertEquals("There should be 0 fouls.", match.calculateFouls(), 0 + 0);

        // -1 foul in host team, 2 fouls in guest team (negative and positive value)
        match = new Match();
        player = new Player();
        soccerTeam = new SoccerTeam();
        player.setFouls(-1);
        soccerTeam.setPlayer(player);
        match.setHostTeam(soccerTeam);
        player = new Player();
        soccerTeam = new SoccerTeam();
        player.setFouls(2);
        soccerTeam.setPlayer(player);
        match.setGuestTeam(soccerTeam);
        assertEquals("There should be 2 fouls.", match.calculateFouls(), 0 + 2);
    }
}
