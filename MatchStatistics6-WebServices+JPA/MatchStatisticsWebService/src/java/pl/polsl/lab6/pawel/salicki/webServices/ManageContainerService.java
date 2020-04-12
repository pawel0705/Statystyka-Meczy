package pl.polsl.lab6.pawel.salicki.webServices;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import pl.polsl.lab6.pawel.salicki.entities.Arbiters;
import pl.polsl.lab6.pawel.salicki.entities.Matches;
import pl.polsl.lab6.pawel.salicki.entities.Players;
import pl.polsl.lab6.pawel.salicki.entities.Team;
import pl.polsl.lab6.pawel.salicki.exceptions.WrongInputException;
import pl.polsl.lab6.pawel.salicki.model.Database;
import pl.polsl.lab6.pawel.salicki.model.Match;
import pl.polsl.lab6.pawel.salicki.model.Player;
import pl.polsl.lab6.pawel.salicki.model.SoccerTeam;

/**
 * WebService managing the database container and JPA database. Returns the
 * appropriate values to the client.
 *
 * @author Paweł Salicki
 * @version 1.0
 */
@WebService(serviceName = "ManageContainerService")
public class ManageContainerService {

    /**
     * Database container.
     */
    private Database databaseMatches = null;

    /**
     * ArrayList of Player instance. (host player list)
     */
    private ArrayList<Player> hostPlayers = new ArrayList<>();

    /**
     * Array list of Player instance. (guest player list)
     */
    private ArrayList<Player> guestPlayers = new ArrayList<>();

    /**
     * SoccerTeam instance, guest soccer team.
     */
    private SoccerTeam guestSoccerTeam;

    /**
     * SoccerTeam instance, host soccer team.
     */
    private SoccerTeam hostSoccerTeam;

    /**
     * Entity manager.
     */
    @PersistenceContext(unitName = "MatchStatisticsWebServicePU")
    private EntityManager em;

    /**
     * User transaction.
     */
    @Resource
    private javax.transaction.UserTransaction utx;

    /**
     * The method creates a database container.
     *
     * @return boolean whether a new container has been created
     */
    @WebMethod(operationName = "createDatabase")
    public boolean createDatabase() {

        if (databaseMatches == null) {
            databaseMatches = new Database();
            return true;
        }

        return false;
    }

    /**
     * The method adds a player to the host team (to the JPA database and
     * container)
     *
     * @param playerHostName name of player
     * @param playerHostGoals amout of goals
     * @param playerHostEnteredMinute minute entered on match
     * @param playerHostLeftMinute minute left from match
     * @param playerHostYellowCards amount of yellow cards
     * @param playerHostFouls amount of fouls
     * @param matchLength length of the game by the player
     * @param playerHostRedCards if the player got a red card
     */
    @WebMethod(operationName = "addHostPlayer")
    public void addHostPlayer(@WebParam(name = "playerHostName") String playerHostName,
            @WebParam(name = "playerHostGoals") int playerHostGoals,
            @WebParam(name = "playerHostEnteredMinute") int playerHostEnteredMinute,
            @WebParam(name = "playerHostLeftMinute") int playerHostLeftMinute,
            @WebParam(name = "playerHostYellowCards") int playerHostYellowCards,
            @WebParam(name = "playerHostFouls") int playerHostFouls,
            @WebParam(name = "matchLength") int matchLength,
            @WebParam(name = "playerHostRedCards") int playerHostRedCards) {

        boolean playedWholeMatch = false;
        boolean redCard = false;

        if (matchLength - playerHostLeftMinute + playerHostEnteredMinute == 0) {
            playedWholeMatch = true;
        }
        if (playerHostRedCards >= 1 || playerHostYellowCards >= 2) {
            redCard = true;
        }

        hostPlayers.add(new Player(playerHostName, playerHostGoals, playedWholeMatch, playerHostEnteredMinute,
                playerHostLeftMinute, playerHostYellowCards, redCard, playerHostFouls));
    }

    /**
     * The method adds a player to the guest team (to the JPA database and
     * container)
     *
     * @param playerGuestName name of player
     * @param playerGuestGoals amout of goals
     * @param playerGuestEnteredMinute minute entered on match
     * @param playerGuestLeftMinute minute left from match
     * @param playerGuestYellowCards amount of yellow cards
     * @param playerGuestFouls amount of fouls
     * @param matchLength length of the game by the player
     * @param playerGuestRedCards if the player got a red card
     */
    @WebMethod(operationName = "addGuestPlayer")
    public void addGuestPlayer(@WebParam(name = "playerGuestName") String playerGuestName,
            @WebParam(name = "playerGuestGoals") int playerGuestGoals,
            @WebParam(name = "playerGuestEnteredMinute") int playerGuestEnteredMinute,
            @WebParam(name = "playerGuestLeftMinute") int playerGuestLeftMinute,
            @WebParam(name = "playerGuestYellowCards") int playerGuestYellowCards,
            @WebParam(name = "playerGuestFouls") int playerGuestFouls,
            @WebParam(name = "matchLength") int matchLength,
            @WebParam(name = "playerGuestRedCards") int playerGuestRedCards) {

        boolean playedWholeMatch = false;
        boolean redCard = false;
        if (matchLength - playerGuestLeftMinute + playerGuestEnteredMinute == 0) {
            playedWholeMatch = true;
        }
        if (playerGuestRedCards >= 1 || playerGuestYellowCards >= 2) {
            redCard = true;
        }

        guestPlayers.add(new Player(playerGuestName, playerGuestGoals, playedWholeMatch, playerGuestEnteredMinute,
                playerGuestLeftMinute, playerGuestYellowCards, redCard, playerGuestFouls));
    }

    /**
     * The method creates a team instance. (host team)
     *
     * @param hostTeamName name of team
     * @param hostTeamCountry country of team
     * @param hostTeamCoachName name of main coach
     */
    @WebMethod(operationName = "createHostSoccerTeam")
    public void createHostSoccerName(@WebParam(name = "hostTeamName") String hostTeamName,
            @WebParam(name = "hostTeamCountry") String hostTeamCountry,
            @WebParam(name = "hostTeamCoachName") String hostTeamCoachName) {

        hostSoccerTeam = new SoccerTeam(hostTeamName, hostTeamCountry, hostTeamCoachName, hostPlayers);
    }

    /**
     * The method creates a team instance. (guest team)
     *
     * @param guestTeamName name of team
     * @param guestTeamCountry country of team
     * @param guestTeamCoachName name of main coach
     */
    @WebMethod(operationName = "createGuestSoccerTeam")
    public void createGuestSoccerName(@WebParam(name = "guestTeamName") String guestTeamName,
            @WebParam(name = "guestTeamCountry") String guestTeamCountry,
            @WebParam(name = "guestTeamCoachName") String guestTeamCoachName) {

        guestSoccerTeam = new SoccerTeam(guestTeamName, guestTeamCountry, guestTeamCoachName, guestPlayers);
    }

    /**
     * The method adds a new match to the database container.
     *
     * @param matchLength length of the new match
     * @param arbiterName name of the main arbiter
     * @param arbitratorAssistants names of arbitrator assistants
     */
    @WebMethod(operationName = "addNewMatch")
    public void addNewMatch(@WebParam(name = "matchLength") int matchLength,
            @WebParam(name = "arbiterName") String arbiterName,
            @WebParam(name = "arbitratorAssistants") ArrayList<String> arbitratorAssistants) {

        SoccerTeam[] soccerTeams = {hostSoccerTeam, guestSoccerTeam};
        databaseMatches.addMatchToDatabase(new Match(matchLength, arbiterName, arbitratorAssistants, soccerTeams));
        hostPlayers.clear();
        guestPlayers.clear();
    }

    /**
     * The method returns the number of matches in the database container.
     *
     * @return number of mayches from the databaseMAtches container
     */
    @WebMethod(operationName = "getNumberOfMatches")
    public int getNumberOfMatches() {
        return databaseMatches.getNumberOfMatches();
    }

    /**
     * The method calls the method that reads the text file from which the
     * database is being read.
     *
     * @param filePath path of the file
     * @throws WrongInputException
     * @throws IOException
     */
    @WebMethod(operationName = "readDatabaseFromFile")
    public void readDatabaseFromFile(@WebParam(name = "filePath") String filePath)
            throws WrongInputException, IOException {
        databaseMatches.readDataFromFile(filePath);
    }

    /**
     * The method calls the method and saves the database to a text file.
     *
     * @param filePath path of the file
     * @throws IOException
     */
    @WebMethod(operationName = "saveDatabaseToFile")
    public void saveDatabaseToFile(@WebParam(name = "filePath") String filePath)
            throws IOException {
        databaseMatches.writeDataToFile(filePath);
    }

    /**
     * The method returns information whether the database container contains a
     * match with a given ID.
     *
     * @param deleteMatchId id of match record
     * @return information about the content of the match in the database
     */
    @WebMethod(operationName = "hasMatchInData")
    public boolean hasMatchInData(@WebParam(name = "deleteMatchId") int deleteMatchId) {
        return databaseMatches.hasMatchInData(deleteMatchId);
    }

    /**
     * The method returns the match id.
     *
     * @param index index of matches record
     * @return id of match
     */
    @WebMethod(operationName = "getMatchId")
    public int getMatchId(@WebParam(name = "index") int index) {
        return databaseMatches.getAllMatches().get(index).getMatchId();
    }

    /**
     * The method calls the method removing the match from the container with
     * the given id.
     *
     * @param deleteMatchId id of the deleting match
     */
    @WebMethod(operationName = "deleteMatchById")
    public void deleteMatchById(@WebParam(name = "deleteMatchId") int deleteMatchId) {
        databaseMatches.deleteMatchById(deleteMatchId);
    }

    /**
     * The method calls the method that deletes the contents of the database
     * container.
     *
     * @return boolean if container is empty
     */
    @WebMethod(operationName = "deleteAllMatches")
    public boolean deleteAllMatches() {
        if (databaseMatches == null) {
            return false;
        }

        databaseMatches.deleteAllMatches();
        return true;
    }

    /**
     * The method returns basic information about each match contained in the
     * database container.
     *
     * @return basic matches data as array list of string
     */
    @WebMethod(operationName = "getBasicMatchesInfo")
    public ArrayList<String> getBasicMatchesInfo() {
        ArrayList<String> matchesInfo = new ArrayList<>();

        matchesInfo.add(Integer.toString(databaseMatches.getAllMatches().size()));
        for (Match match : databaseMatches.getAllMatches()) {
            matchesInfo.add(Integer.toString(match.getMatchId()));
            matchesInfo.add(match.getArbiterName());

            int arbitratorAssistantsAmount = match.getArbitratorAssistants().size();
            matchesInfo.add(Integer.toString(arbitratorAssistantsAmount));
            for (int i = 0; i < arbitratorAssistantsAmount; i++) {
                matchesInfo.add(match.getArbitratorAssistants().get(i));
            }

            matchesInfo.add(Integer.toString(match.getMatchTime()));
            matchesInfo.add(match.getHostTeam().getTeamName());
            matchesInfo.add(match.getGuestTeam().getTeamName());
            matchesInfo.add(match.getPlaceOfTheMatch());
            matchesInfo.add(Integer.toString(match.calculateFouls()));
            matchesInfo.add(Integer.toString(match.getHostTeam().calculateGoals()));
            matchesInfo.add(Integer.toString(match.getGuestTeam().calculateGoals()));
            matchesInfo.add(match.chooseTheWinnerTeam());
        }

        return matchesInfo;
    }

    /**
     * The method returns the player's name.
     *
     * @param index index of match
     * @param lastMatch index of match
     * @return name of player
     */
    @WebMethod(operationName = "getHostPlayerName")
    public String getHostPlayerName(@WebParam(name = "index") int index, @WebParam(name = "lastMatch") int lastMatch) {
        return databaseMatches.getAllMatches().get(lastMatch).getHostTeam().getPlayers().get(index).getPlayerName();
    }

    /**
     * The method returns information whether the player has played throughout
     * the match.
     *
     * @param index index of match
     * @param lastMatch index of match
     * @return information whether the player has played throughout the match
     */
    @WebMethod(operationName = "getHostPlayerPlayedWholeTime")
    public boolean getHostPlayerPlayedWholeTime(@WebParam(name = "index") int index, @WebParam(name = "lastMatch") int lastMatch) {
        return databaseMatches.getAllMatches().get(lastMatch).getHostTeam().getPlayers().get(index).getPlayedWholeTime();
    }

    /**
     * The method returns information about the time the player enters the
     * field.
     *
     * @param index idex of match
     * @param lastMatch index of match
     * @return minute of entering the field
     */
    @WebMethod(operationName = "getHostPlayerEntryTime")
    public int getHostPlayerEntryTime(@WebParam(name = "index") int index, @WebParam(name = "lastMatch") int lastMatch) {
        return databaseMatches.getAllMatches().get(lastMatch).getHostTeam().getPlayers().get(index).getEntryTime();
    }

    /**
     * The method returns information about the time the player left from the
     * field.
     *
     * @param index index of match
     * @param lastMatch index of match
     * @return minute left from filed
     */
    @WebMethod(operationName = "getHostPlayerLeftTime")
    public int getHostPlayerLeftTime(@WebParam(name = "index") int index, @WebParam(name = "lastMatch") int lastMatch) {
        return databaseMatches.getAllMatches().get(lastMatch).getHostTeam().getPlayers().get(index).getLeftTime();
    }

    /**
     * The method returns the number of goals scored by the player.
     *
     * @param index index of match
     * @param lastMatch index of match
     * @return amount of goals
     */
    @WebMethod(operationName = "getHostPlayerScoredGoals")
    public int getHostPlayerScoredGoals(@WebParam(name = "index") int index, @WebParam(name = "lastMatch") int lastMatch) {
        return databaseMatches.getAllMatches().get(lastMatch).getHostTeam().getPlayers().get(index).getScoredGoals();
    }

    /**
     * The method returns the amount of fouls.
     *
     * @param index index of match
     * @param lastMatch index of match
     * @return amount of fouls
     */
    @WebMethod(operationName = "getHostPlayerFouls")
    public int getHostPlayerFouls(@WebParam(name = "index") int index, @WebParam(name = "lastMatch") int lastMatch) {
        return databaseMatches.getAllMatches().get(lastMatch).getHostTeam().getPlayers().get(index).getFouls();
    }

    /**
     * The methid returns the amount of yellow cards.
     *
     * @param index index of match
     * @param lastMatch index of match
     * @return amount of yellow match
     */
    @WebMethod(operationName = "getHostPlayerYellowCards")
    public int getHostPlayerYellowCards(@WebParam(name = "index") int index, @WebParam(name = "lastMatch") int lastMatch) {
        return databaseMatches.getAllMatches().get(lastMatch).getHostTeam().getPlayers().get(index).getYellowCards();
    }

    /**
     * The method returns information whether the player got a red card.
     *
     * @param index index of match
     * @param lastMatch index of match
     * @return boolean if player got a red card
     */
    @WebMethod(operationName = "getHostPlayerRedCard")
    public boolean getHostPlayerRedCard(@WebParam(name = "index") int index, @WebParam(name = "lastMatch") int lastMatch) {
        return databaseMatches.getAllMatches().get(lastMatch).getHostTeam().getPlayers().get(index).getRedCard();
    }

    /**
     * The method returns the player's name.
     *
     * @param index index of match
     * @param lastMatch index of match
     * @return name of player
     */
    @WebMethod(operationName = "getGuestPlayerName")
    public String getGuestPlayerName(@WebParam(name = "index") int index, @WebParam(name = "lastMatch") int lastMatch) {
        return databaseMatches.getAllMatches().get(lastMatch).getGuestTeam().getPlayers().get(index).getPlayerName();
    }

    /**
     * The method returns information whether the player has played throughout
     * the match.
     *
     * @param index index of match
     * @param lastMatch index of match
     * @return information whether the player has played throughout the match
     */
    @WebMethod(operationName = "getGuestPlayerPlayedWholeTime")
    public boolean getGuestPlayerPlayedWholeTime(@WebParam(name = "index") int index, @WebParam(name = "lastMatch") int lastMatch) {
        return databaseMatches.getAllMatches().get(lastMatch).getGuestTeam().getPlayers().get(index).getPlayedWholeTime();
    }

    /**
     * The method returns information about the time the player enters the
     * field.
     *
     * @param index idex of match
     * @param lastMatch index of match
     * @return minute of entering the field
     */
    @WebMethod(operationName = "getGuestPlayerEntryTime")
    public int getGuestPlayerEntryTime(@WebParam(name = "index") int index, @WebParam(name = "lastMatch") int lastMatch) {
        return databaseMatches.getAllMatches().get(lastMatch).getGuestTeam().getPlayers().get(index).getEntryTime();
    }

    /**
     * The method returns information about the time the player left from the
     * field.
     *
     * @param index index of match
     * @param lastMatch index of match
     * @return minute left from filed
     */
    @WebMethod(operationName = "getGuestPlayerLeftTime")
    public int getGuestPlayerLeftTime(@WebParam(name = "index") int index, @WebParam(name = "lastMatch") int lastMatch) {
        return databaseMatches.getAllMatches().get(lastMatch).getGuestTeam().getPlayers().get(index).getLeftTime();
    }

    /**
     * The method returns the number of goals scored by the player.
     *
     * @param index index of match
     * @param lastMatch index of match
     * @return amount of goals
     */
    @WebMethod(operationName = "getGuestPlayerScoredGoals")
    public int getGuestPlayerScoredGoals(@WebParam(name = "index") int index, @WebParam(name = "lastMatch") int lastMatch) {
        return databaseMatches.getAllMatches().get(lastMatch).getGuestTeam().getPlayers().get(index).getScoredGoals();
    }

    /**
     * The method returns the amount of fouls.
     *
     * @param index index of match
     * @param lastMatch index of match
     * @return amount of fouls
     */
    @WebMethod(operationName = "getGuestPlayerFouls")
    public int getGuestPlayerFouls(@WebParam(name = "index") int index, @WebParam(name = "lastMatch") int lastMatch) {
        return databaseMatches.getAllMatches().get(lastMatch).getGuestTeam().getPlayers().get(index).getFouls();
    }

    /**
     * The methid returns the amount of yellow cards.
     *
     * @param index index of match
     * @param lastMatch index of match
     * @return amount of yellow match
     */
    @WebMethod(operationName = "getGuestPlayerYellowCards")
    public int getGuestPlayerYellowCards(@WebParam(name = "index") int index, @WebParam(name = "lastMatch") int lastMatch) {
        return databaseMatches.getAllMatches().get(lastMatch).getGuestTeam().getPlayers().get(index).getYellowCards();
    }

    /**
     * The method returns information whether the player got a red card.
     *
     * @param index index of match
     * @param lastMatch index of match
     * @return boolean if player got a red card
     */
    @WebMethod(operationName = "getGuestPlayerRedCard")
    public boolean getGuestPlayerRedCard(@WebParam(name = "index") int index, @WebParam(name = "lastMatch") int lastMatch) {
        return databaseMatches.getAllMatches().get(lastMatch).getGuestTeam().getPlayers().get(index).getRedCard();
    }

    /**
     * The method returns the number of players in the host team.
     *
     * @param index index of match
     * @return amount of players in host team
     */
    @WebMethod(operationName = "getHostTeamPlayersSize")
    public int getHostTeamPlayersSize(@WebParam(name = "index") int index) {
        return databaseMatches.getAllMatches().get(index).getHostTeam().getPlayers().size();
    }

    /**
     * The method returns the number of players in the guest team.
     *
     * @param index index of match
     * @return amount of players in guest team
     */
    @WebMethod(operationName = "getGuestTeamPlayersSize")
    public int getGuestTeamPlayersSize(@WebParam(name = "index") int index) {
        return databaseMatches.getAllMatches().get(index).getGuestTeam().getPlayers().size();
    }

    /**
     * The method returns the name of the host team.
     *
     * @param index index of match
     * @return name of the host team
     */
    @WebMethod(operationName = "getHostTeamName")
    public String getHostTeamName(@WebParam(name = "index") int index) {
        return databaseMatches.getAllMatches().get(index).getHostTeam().getTeamCountryName();
    }

    /**
     * The method returns the name coach in host team.
     *
     * @param index index of match
     * @return name of coach
     */
    @WebMethod(operationName = "getHostTeamCoachName")
    public String getHostTeamCoachName(@WebParam(name = "index") int index) {
        return databaseMatches.getAllMatches().get(index).getHostTeam().getCoachName();
    }

    /**
     * The method returns the country name of host team.
     *
     * @param index index of match
     * @return country name
     */
    @WebMethod(operationName = "getHostTeamCountryName")
    public String getHostTeamCountryName(@WebParam(name = "index") int index) {
        return databaseMatches.getAllMatches().get(index).getHostTeam().getTeamCountryName();
    }

    /**
     * The method returns the name of the guest team.
     *
     * @param index index of match
     * @return name of the guest team
     */
    @WebMethod(operationName = "getGuestTeamName")
    public String getGuestTeamName(@WebParam(name = "index") int index) {
        return databaseMatches.getAllMatches().get(index).getGuestTeam().getTeamCountryName();
    }

    /**
     * The method returns the name coach in guest team.
     *
     * @param index index of match
     * @return name of coach
     */
    @WebMethod(operationName = "getGuestTeamCoachName")
    public String getGuestTeamCoachName(@WebParam(name = "index") int index) {
        return databaseMatches.getAllMatches().get(index).getGuestTeam().getCoachName();
    }

    /**
     * The method returns the country name of guest team.
     *
     * @param index index of match
     * @return country name
     */
    @WebMethod(operationName = "getGuestTeamCountryName")
    public String getGuestTeamCountryName(@WebParam(name = "index") int index) {
        return databaseMatches.getAllMatches().get(index).getGuestTeam().getTeamCountryName();
    }

    /**
     * The method returns the number of match referee's assistants.
     *
     * @param index index of match
     * @return amount of arbitrator assistants
     */
    @WebMethod(operationName = "getArbitratorAssistantsSize")
    public int getArbitratorAssistantsSize(@WebParam(name = "index") int index) {
        return databaseMatches.getAllMatches().get(index).getArbitratorAssistants().size();
    }

    /**
     * The method returns the name of the assistant referee of the match.
     *
     * @param index index of match
     * @param i index of match
     * @return name of arbitrator assistant
     */
    @WebMethod(operationName = "getArbitratorAssistantName")
    public String getArbitratorAssistantName(@WebParam(name = "index") int index, @WebParam(name = "i") int i) {
        return databaseMatches.getAllMatches().get(index).getArbitratorAssistants().get(i);
    }

    /**
     * The method returns the duration of the match.
     *
     * @param index index of match
     * @return length of match in munutes
     */
    @WebMethod(operationName = "getMatchTime")
    public int getMatchTime(@WebParam(name = "index") int index) {
        return databaseMatches.getAllMatches().get(index).getMatchTime();
    }

    /**
     * The method reads records from a text file. Assigns read records to JPA
     * database tables.
     *
     * @throws NotSupportedException
     * @throws SystemException
     * @throws RollbackException
     * @throws HeuristicMixedException
     * @throws HeuristicRollbackException
     */
    @WebMethod(operationName = "readMatchFromFileDatabase")
    public void readMatchFromFileDatabase() throws NotSupportedException, SystemException, RollbackException, HeuristicMixedException, HeuristicRollbackException {

        utx.begin();

        Query q1 = em.createQuery("DELETE FROM Matches");
        Query q2 = em.createQuery("DELETE FROM Arbiters");
        Query q3 = em.createQuery("DELETE FROM Players");
        Query q4 = em.createQuery("DELETE FROM Team");

        q1.executeUpdate();
        q2.executeUpdate();
        q3.executeUpdate();
        q4.executeUpdate();

        utx.commit();

        int hostTeamId = 0;
        int guestTeamId = 1;

        int arbitratorId = 0;
        int playerId = 0;

        // add match to jpa database
        for (int i = 0; i < this.getNumberOfMatches(); i++) {
            Matches matches = new Matches();
            matches.setId((long) this.getMatchId(i));
            matches.setLengthmatch(this.getMatchTime(i));
            matches.setArbiternamematch(this.getArbiterName(i));
            matches.setHostteamid(hostTeamId);
            matches.setGuestteamid(guestTeamId);
            this.persist(matches);

            // add host team to jpa database
            Team hostTeam = new Team();
            hostTeam.setId((long) hostTeamId);
            hostTeam.setCountrynameteam(this.getHostTeamCountryName(i));
            hostTeam.setCoachnameteam(this.getHostTeamCoachName(i));
            hostTeam.setNameteam(this.getHostTeamName(i));
            this.persist(hostTeam);

            // add guest team to jpa database
            Team guestTeam = new Team();
            guestTeam.setId((long) guestTeamId);
            guestTeam.setCountrynameteam(this.getGuestTeamCountryName(i));
            guestTeam.setCoachnameteam(this.getGuestTeamCoachName(i));
            guestTeam.setNameteam(this.getGuestTeamName(i));
            this.persist(guestTeam);

            playerId += this.getHostTeamPlayersSize(i) + this.getGuestTeamPlayersSize(i);

            int playerIdSave = playerId;

            //add HOST players to jpa database
            for (int j = 0; j < this.getHostTeamPlayersSize(i); j++) {
                Players hostPlayer = new Players();
                hostPlayer.setId((long) playerId--);
                hostPlayer.setName(this.getHostPlayerName(j, i));
                hostPlayer.setPlayedwholematch(this.getHostPlayerPlayedWholeTime(j, i));
                hostPlayer.setMinuteentered(this.getHostPlayerEntryTime(j, i));
                hostPlayer.setMinuteleft(this.getHostPlayerLeftTime(j, i));
                hostPlayer.setGoals(this.getHostPlayerScoredGoals(j, i));
                hostPlayer.setFouls(this.getHostPlayerFouls(j, i));
                hostPlayer.setYellowcards(this.getHostPlayerFouls(j, i));
                hostPlayer.setRedcard(this.getHostPlayerRedCard(j, i));
                hostPlayer.setIdteam(hostTeamId);
                this.persist(hostPlayer);
            }

            //add GUEST players to jpa database
            for (int j = 0; j < this.getGuestTeamPlayersSize(i); j++) {
                Players guestPlayer = new Players();
                guestPlayer.setId((long) playerId--);
                guestPlayer.setName(this.getGuestPlayerName(j, i));
                guestPlayer.setPlayedwholematch(this.getGuestPlayerPlayedWholeTime(j, i));
                guestPlayer.setMinuteentered(this.getGuestPlayerEntryTime(j, i));
                guestPlayer.setMinuteleft(this.getGuestPlayerLeftTime(j, i));
                guestPlayer.setGoals(this.getGuestPlayerScoredGoals(j, i));
                guestPlayer.setFouls(this.getGuestPlayerFouls(j, i));
                guestPlayer.setYellowcards(this.getGuestPlayerFouls(j, i));
                guestPlayer.setRedcard(this.getGuestPlayerRedCard(j, i));
                guestPlayer.setIdteam(guestTeamId);
                this.persist(guestPlayer);
            }
            playerId = playerIdSave;

            arbitratorId += this.getArbitratorAssistantsSize(i);
            int arbitratorIdSave = arbitratorId;

            // add arbitrator assistants to jpa database
            for (int j = 0; j < this.getArbitratorAssistantsSize(i); j++) {
                Arbiters arbiters = new Arbiters();
                arbiters.setId((long) arbitratorId--);
                arbiters.setArbitratorname(this.getArbitratorAssistantName(i, j));
                arbiters.setArbitratormatchid(this.getMatchId(i));
                this.persist(arbiters);
            }
            arbitratorId = arbitratorIdSave;

            hostTeamId += 2;
            guestTeamId += 2;
        }

    }

    /**
     * The method removes the match with the given ID from the JPA database.
     *
     * @param deleteMatchId id of the match that will be remove
     * @throws NotSupportedException
     * @throws SystemException
     * @throws RollbackException
     * @throws HeuristicMixedException
     * @throws HeuristicRollbackException
     */
    @WebMethod(operationName = "deleteOneMatchDatabase")
    public void deleteOneMatchDatabase(@WebParam(name = "deleteMatchId") int deleteMatchId) throws NotSupportedException, SystemException, RollbackException, HeuristicMixedException, HeuristicRollbackException {
        Query matchesQuery = em.createQuery("SELECT m FROM Matches m WHERE m.id=" + deleteMatchId);
        List<Matches> matchesList = matchesQuery.getResultList();

        int hostTeamId = 0;
        int guestTeamId = 0;
        for (Matches matches : matchesList) {
            hostTeamId = matches.getHostteamid();
            guestTeamId = matches.getGuestteamid();
        }

        utx.begin();

        Query deleteMatchQuery = em.createNativeQuery("DELETE FROM Matches WHERE id=" + deleteMatchId);
        Query deleteHostTeamQuery = em.createNativeQuery("DELETE FROM Team WHERE id=" + hostTeamId);
        Query deleteGuestTeamQuery = em.createNativeQuery("DELETE FROM Team WHERE id=" + guestTeamId);
        Query deleteHostPlayerQuery = em.createNativeQuery("DELETE FROM Players WHERE idteam=" + hostTeamId);
        Query deleteGuestPlayerQuery = em.createNativeQuery("DELETE FROM Players WHERE idteam=" + guestTeamId);
        Query deleteArbitersQuery = em.createNativeQuery("DELETE FROM Arbiters WHERE arbitratormatchid=" + deleteMatchId);

        deleteMatchQuery.executeUpdate();
        deleteHostTeamQuery.executeUpdate();
        deleteGuestTeamQuery.executeUpdate();
        deleteHostPlayerQuery.executeUpdate();
        deleteGuestPlayerQuery.executeUpdate();
        deleteArbitersQuery.executeUpdate();

        utx.commit();

    }

    /**
     * The method deletes all records from JPA database tables.
     *
     * @throws NotSupportedException
     * @throws SystemException
     * @throws RollbackException
     * @throws HeuristicMixedException
     * @throws HeuristicRollbackException
     */
    @WebMethod(operationName = "deleteAllMatchesDatabase")
    public void deleteAllMatchesDatabase() throws NotSupportedException, SystemException, RollbackException, HeuristicMixedException, HeuristicRollbackException {
        utx.begin();

        Query q1 = em.createQuery("DELETE FROM Matches");
        Query q2 = em.createQuery("DELETE FROM Arbiters");
        Query q3 = em.createQuery("DELETE FROM Players");
        Query q4 = em.createQuery("DELETE FROM Team");

        q1.executeUpdate();
        q2.executeUpdate();
        q3.executeUpdate();
        q4.executeUpdate();

        utx.commit();
    }

    /**
     * The method returns the name of the main referee of the match.
     *
     * @param index index of match
     * @return name of main arbiter
     */
    @WebMethod(operationName = "getArbiterName")
    public String getArbiterName(@WebParam(name = "index") int index) {
        return databaseMatches.getAllMatches().get(index).getArbiterName();
    }

    /**
     * The method returns a list of objects obtained by querying the database.
     *
     * @param queryName query
     * @return list of matches
     */
    @WebMethod(operationName = "showDatabaseMatchesList")
    public List<Matches> showDatabaseMatchesList(@WebParam(name = "queryName") String queryName) {

        Query matchesQuery = em.createNamedQuery(queryName);
        List<Matches> matchesList = matchesQuery.getResultList();

        return matchesList;
    }

    /**
     * The method returns a list of objects obtained by querying the database.
     *
     * @param queryName query
     * @return list of arbiters
     */
    @WebMethod(operationName = "showDatabaseArbitersList")
    public List<Arbiters> showDatabaseArbitersList(@WebParam(name = "queryName") String queryName) {

        Query arbitersQuery = em.createNamedQuery("Arbiters.findAll");
        List<Arbiters> arbitersList = arbitersQuery.getResultList();

        return arbitersList;
    }

    /**
     * The method returns a list of objects obtained by querying the database.
     *
     * @param queryName query
     * @return list of team
     */
    @WebMethod(operationName = "showDatabaseTeamList")
    public List<Team> showDatabaseTeamList(@WebParam(name = "queryName") String queryName) {

        Query teamQuery = em.createNamedQuery("Team.findAll");
        List<Team> teamList = teamQuery.getResultList();

        return teamList;
    }

    /**
     * The method returns a list of objects obtained by querying the database.
     *
     * @param queryName query
     * @return list of players
     */
    @WebMethod(operationName = "showDatabasePlayersList")
    public List<Players> showDatabasePlayersList(@WebParam(name = "queryName") String queryName) {

        Query playersQuery = em.createNamedQuery("Players.findAll");
        List<Players> playersList = playersQuery.getResultList();

        return playersList;
    }

    /**
     * The method returns a list of objects obtained by querying the database.
     *
     * @param query query
     * @return list of Players
     */
    @WebMethod(operationName = "playerCreateQuery")
    public List<Players> playerCreateQuery(@WebParam(name = "query") String query) {

        Query playerQuery = em.createQuery(query);
        List<Players> playerList = playerQuery.getResultList();

        return playerList;
    }

    /**
     * The method returns a list of objects obtained by querying the database.
     *
     * @param query query
     * @return list of Team
     */
    @WebMethod(operationName = "teamCreateQuery")
    public List<Team> teamCreateQuery(@WebParam(name = "query") String query) {

        Query hostQuery = em.createQuery(query);
        List<Team> teamList = hostQuery.getResultList();

        return teamList;
    }

    /**
     * The method returns a list of objects obtained by querying the database.
     *
     * @param query query
     * @return list of Matches
     */
    @WebMethod(operationName = "matchesCreateQuery")
    public List<Matches> matchesCreateQuery(@WebParam(name = "query") String query) {

        Query matchesQuery = em.createQuery(query);
        List<Matches> matchesList = matchesQuery.getResultList();

        return matchesList;
    }

    /**
     * The method returns a list of objects obtained by querying the database.
     *
     * @param query query
     * @return list of Arbiters
     */
    @WebMethod(operationName = "arbitersCreateQuery")
    public List<Arbiters> arbitersCreateQuery(@WebParam(name = "query") String query) {

        Query arbitersQuery = em.createQuery(query);
        List<Arbiters> arbitersList = arbitersQuery.getResultList();

        return arbitersList;
    }

    /**
     * The method adds a new match to the JPA database tables.
     */
    @WebMethod(operationName = "addNewMatchToJPA")
    public void addNewMatchToJPA() {
        int lastMatch = this.getNumberOfMatches() - 1;
        int amountOfTeams = this.getNumberOfMatches() * 2;

        long hostTeamId = amountOfTeams - 1;
        long guestTeamId = amountOfTeams;

        int playerId = 0;
        for (int i = 0; i < this.getNumberOfMatches(); i++) {
            playerId += this.getHostTeamPlayersSize(i)
                    + this.getGuestTeamPlayersSize(i);
        }

        for (int i = 0; i < this.getHostTeamPlayersSize(lastMatch); i++) {
            Players hostPlayer = new Players();
            hostPlayer.setId((long) playerId--);
            hostPlayer.setName(this.getHostPlayerName(i, lastMatch));
            hostPlayer.setPlayedwholematch(this.getHostPlayerPlayedWholeTime(i, lastMatch));
            hostPlayer.setMinuteentered(this.getHostPlayerEntryTime(i, lastMatch));
            hostPlayer.setMinuteleft(this.getHostPlayerLeftTime(i, lastMatch));
            hostPlayer.setGoals(this.getHostPlayerScoredGoals(i, lastMatch));
            hostPlayer.setFouls(this.getHostPlayerFouls(i, lastMatch));
            hostPlayer.setYellowcards(this.getHostPlayerYellowCards(i, lastMatch));
            hostPlayer.setRedcard(this.getHostPlayerRedCard(i, lastMatch));
            hostPlayer.setIdteam((int) hostTeamId);

            this.persist(hostPlayer);
        }

        for (int i = 0; i < this.getGuestTeamPlayersSize(lastMatch); i++) {
            Players guestPlayer = new Players();
            guestPlayer.setId((long) playerId--);
            guestPlayer.setName(this.getGuestPlayerName(i, lastMatch));
            guestPlayer.setPlayedwholematch(this.getGuestPlayerPlayedWholeTime(i, lastMatch));
            guestPlayer.setMinuteentered(this.getGuestPlayerEntryTime(i, lastMatch));
            guestPlayer.setMinuteleft(this.getGuestPlayerLeftTime(i, lastMatch));
            guestPlayer.setGoals(this.getGuestPlayerScoredGoals(i, lastMatch));
            guestPlayer.setFouls(this.getGuestPlayerFouls(i, lastMatch));
            guestPlayer.setYellowcards(this.getGuestPlayerYellowCards(i, lastMatch));
            guestPlayer.setRedcard(this.getGuestPlayerRedCard(i, lastMatch));
            guestPlayer.setIdteam((int) guestTeamId);

            this.persist(guestPlayer);
        }

        Team hostTeam = new Team();
        hostTeam.setId(hostTeamId);
        hostTeam.setCountrynameteam(this.getHostTeamName(lastMatch));
        hostTeam.setCoachnameteam(this.getHostTeamCoachName(lastMatch));
        hostTeam.setNameteam(this.getHostTeamName(lastMatch));
        this.persist(hostTeam);

        Team guestTeam = new Team();
        guestTeam.setId(guestTeamId);
        guestTeam.setCountrynameteam(this.getGuestTeamName(lastMatch));
        guestTeam.setCoachnameteam(this.getGuestTeamCoachName(lastMatch));
        guestTeam.setNameteam(this.getGuestTeamName(lastMatch));
        this.persist(guestTeam);

        long matchId = lastMatch + 1;

        long arbitratorId = 0;

        for (int i = 0; i < this.getNumberOfMatches(); i++) {

            arbitratorId += this.getArbitratorAssistantsSize(i);
        }

        for (int i = 0; i < this.getArbitratorAssistantsSize(lastMatch); i++) {
            Arbiters arbiter = new Arbiters();
            arbiter.setId(arbitratorId--);
            arbiter.setArbitratormatchid((int) matchId);
            arbiter.setArbitratorname(this.getArbitratorAssistantName(lastMatch, i));
            this.persist(arbiter);
        }

        Matches match = new Matches();
        match.setId(matchId);
        match.setLengthmatch(this.getMatchTime(lastMatch));
        match.setArbiternamematch(this.getArbiterName(lastMatch));
        match.setHostteamid((int) hostTeamId);
        match.setGuestteamid((int) guestTeamId);
        this.persist(match);
    }

    /**
     * The method introduces a new object to the JPA database.
     *
     * @param object new object to database
     */
    public void persist(Object object) {
        try {
            utx.begin();
            em.persist(object);
            utx.commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
        }
    }
}
