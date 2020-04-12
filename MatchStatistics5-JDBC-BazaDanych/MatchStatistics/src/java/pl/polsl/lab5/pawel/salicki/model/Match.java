package pl.polsl.lab5.pawel.salicki.model;

import java.util.ArrayList;

/**
 * A class that stores information about a match.
 *
 * @author Paweł Salicki
 * @version 2.0
 */
public class Match {

    /**
     * Static match ID.
     */
    static private int id;

    /**
     * matchId
     */
    private final int matchId;

    /**
     * The length of the match in minutes.
     */
    private final int matchLength;

    /**
     * The name of the main referee of the football match.
     */
    private final String arbiterName;

    /**
     * An array storing the names of the arbitrator's assistants.
     */
    private final ArrayList<String> arbitratorAssistants;

    /**
     * First team. Host of a football game.
     */
    private SoccerTeam hostTeam;

    /**
     * Second team. Guest team.
     */
    private SoccerTeam guestTeam;

    /**
     * A basic Match class constructor that sets fields to basic values.
     */
    public Match() {
        Match.id++;
        this.matchId = id;
        this.arbiterName = "Unknown arbiter";
        this.matchLength = 0;

        this.arbitratorAssistants = new ArrayList<>();
        this.hostTeam = new SoccerTeam();
        this.guestTeam = new SoccerTeam();
    }

    /**
     * A multi-parameter constructor of the Match class that sets fields to
     * passed values.
     *
     * @param matchLength length of the match in minutes
     * @param arbiterName name of the main referee of the match
     * @param arbitratorAssistants list of names of the match referee's helpers
     * @param soccerTeam an array storing team objects
     */
    public Match(int matchLength, String arbiterName,
            ArrayList<String> arbitratorAssistants, SoccerTeam[] soccerTeam) {
        Match.id++;
        this.matchId = id;
        this.arbiterName = arbiterName;
        this.matchLength = matchLength;

        this.arbitratorAssistants = new ArrayList<>();
        this.arbitratorAssistants.addAll(arbitratorAssistants);

        this.hostTeam = new SoccerTeam();
        this.guestTeam = new SoccerTeam();

        this.hostTeam = soccerTeam[0];
        this.guestTeam = soccerTeam[1];
    }

    /**
     * A method of counting the goals of each player from both teams and
     * returning the name of the winning team.
     *
     * @return name of the winning team or draw information
     */
    public String chooseTheWinnerTeam() {
        if (hostTeam.calculateGoals() > guestTeam.calculateGoals()) {
            return "Winner-" + hostTeam.getTeamName();
        } else if (hostTeam.calculateGoals() < guestTeam.calculateGoals()) {
            return "Winner-" + guestTeam.getTeamName();
        }

        return "There is no winner";
    }

    /**
     * A method of counting the number of fouls during a match.
     *
     * @return fouls by players amount
     */
    public int calculateFouls() {
        int foulsNr = 0;

        foulsNr = hostTeam.getPlayers().stream().map((player1)
                -> player1.getFouls()).reduce(foulsNr, Integer::sum);

        foulsNr = guestTeam.getPlayers().stream().map((player2)
                -> player2.getFouls()).reduce(foulsNr, Integer::sum);

        return foulsNr;
    }

    /**
     * A method that sets hostTeam's reference.
     * 
     * @param hostTeam instance of soccer team (host team)
     */
    public void setHostTeam(SoccerTeam hostTeam){
        this.hostTeam = hostTeam;
    }
    
    /**
     * A method that sets guestTeam's reference.
     * 
     * @param guestTeam instance of soccer team (guest team)
     */
    public void setGuestTeam(SoccerTeam guestTeam){
        this.guestTeam = guestTeam;
    }
    
    /**
     * A method that returns the name of the country where the match takes
     * place.
     *
     * @return name of the country in which the match took place
     */
    public String getPlaceOfTheMatch() {
        return hostTeam.getTeamCountryName();
    }

    /**
     * A method that returns a copy of the host team's object
     *
     * @return host team
     */
    public SoccerTeam getHostTeam() {
        return this.hostTeam;
    }

    /**
     * A method that returns a copy of the guest team's object
     *
     * @return guest team
     */
    public SoccerTeam getGuestTeam() {
        return this.guestTeam;
    }

    /**
     * A method that returns the list of midfielders' names.
     *
     * @return list of names of the match referee's helpers
     */
    public ArrayList<String> getArbitratorAssistants() {
        return this.arbitratorAssistants;
    }

    /**
     * A method that returns the length of the match in minutes
     *
     * @return matchLength length of the match in minutes
     */
    public int getMatchTime() {
        return this.matchLength;
    }

    /**
     * The method returns the name of the main referee of the match.
     *
     * @return the main referee name
     */
    public String getArbiterName() {
        return this.arbiterName;
    }

    /**
     * The method returning the match id.
     *
     * @return the match id
     */
    public int getMatchId() {
        return this.matchId;
    }
}
