package pl.polsl.lab1.pawel.salicki.model;

import java.util.ArrayList;

/**
 * A class that stores information about a soccer team.
 *
 * @author Paweł Salicki
 * @version 1.0
 */
public class SoccerTeam {

    /**
     * The name of the football team.
     */
    private final String teamName;

    /**
     * Country of origin of the football team.
     */
    private final String countryName;

    /**
     * Name of soccer team coach.
     */
    private final String coachName;

    /**
     * A container that holds all players.
     */
    private final ArrayList<Player> players;

    /**
     * Default constructor. The method sets fields to basic values.
     */
    public SoccerTeam() {
        this.teamName = "missing team name";
        this.coachName = "missing coach name";
        this.countryName = "missing country name";

        players = new ArrayList<>();
    }

    /**
     * Multi-parameter constructor that sets team information.
     * 
     * @param teamName name of the team
     * @param countryName origin team's country
     * @param coachName name of the coach
     * @param players players in team
     */
    public SoccerTeam(String teamName, String countryName, String coachName,
            ArrayList<Player> players) {
        this.teamName = teamName;
        this.countryName = countryName;
        this.coachName = coachName;

        this.players = new ArrayList<>();
        this.players.addAll(players);
    }

    /**
     * The method of counting all goals of players.
     *
     * @return goalCounter he number of goals scored by the team
     */
    public int calculateGoals() {
        int goalCounter = 0;
        goalCounter = this.players.stream().map((player) -> 
                player.getScoredGoals()).reduce(goalCounter, Integer::sum);
        return goalCounter;
    }

    /**
     * A method of counting all yellow cards received by team players.
     *
     * @return yellowCardCounter number of yellow cards
     */
    public int calculateYellowCards() {
        int yellowCardCounter = 0;
        yellowCardCounter = this.players.stream().map((player) -> 
                player.getYellowCards()).reduce(yellowCardCounter, Integer::sum);
        return yellowCardCounter;
    }

    /**
     * A method of counting all red cards received by team players.
     *
     * @return redCardCounter number of red cards
     */
    public int calculateRedCards() {
        int redCardCounter = 0;
        redCardCounter = this.players.stream().filter((player) -> 
                (player.getRedCard())).map((_item) -> 1).reduce(redCardCounter, Integer::sum);
        return redCardCounter;
    }

    /**
     * A method that returns a list of team players.
     *
     * @return players list of team players
     */
    public ArrayList<Player> getPlayers() {
        return this.players;
    }

    /**
     * A method that returns the number of team players.
     *
     * @return players.size() number of team players
     */
    public int getPlayersPlayedAmount() {
        return this.players.size();
    }

    /**
     * A method that returns the name of a team coach.
     *
     * @return coachName name of a team coach
     */
    public String getCoachName() {
        return this.coachName;
    }

    /**
     * A method that returns the name of the country of origin.
     *
     * @return countryName name of country
     */
    public String getTeamCountryName() {
        return this.countryName;
    }

    /**
     * A method that returns the team name.
     *
     * @return teamName the name of the team
     */
    public String getTeamName() {
        return this.teamName;
    }
}
