package pl.polsl.lab5.pawel.salicki.model;

import pl.polsl.lab5.pawel.salicki.exceptions.WrongInputException;

import java.util.ArrayList;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Database class, contains aray of matches.
 *
 * @author Paweł Salicki
 * @version 2.0
 */
public class Database implements Parsable {

    /**
     * Dynamic arrayList of matches.
     */
    private final ArrayList<Match> matches;

    /**
     * Constructor of database.
     */
    public Database() {
        matches = new ArrayList<>();
    }

    /**
     * Method that adds match to database.
     *
     * @param match Match to databse.
     */
    public void addMatchToDatabase(Match match) {
        this.matches.add(match);
    }

    /**
     * A method that returns a match with the given id.
     *
     * @param matchId id of the match to be returned
     * @return match
     */
    public Match getMatchById(int matchId) {

        for (Match match : matches) {
            if (match.getMatchId() == matchId) {
                return match;
            }
        }
        return new Match();
    }

    /**
     * Method removing a match with given id.
     *
     * @param matchId match id to be deleted
     */
    public void deleteMatchById(int matchId) {

        int position = 0;
        for (Match match : matches) {

            if (match.getMatchId() != matchId) {
                position++;
            } else {
                break;
            }
        }
        matches.remove(position);
    }

    /**
     * A method that checks if the database is empty.
     *
     * @return boolean if dtabase is empty
     */
    public boolean hasData() {
        return matches.isEmpty();
    }

    /**
     * A method that returns information whether a match with the given id
     * exists in the database.
     *
     * @param matchId id of the match to be checked
     * @return boolean match found or not
     */
    public boolean hasMatchInData(int matchId) {
        for (Match match : matches) {
            if (match.getMatchId() == matchId) {
                return true;
            }
        }
        return false;
    }

    /**
     * The method converts the read string into a number. Throws an exception if
     * it cannot be converted.
     *
     * @param text the text to be converted
     * @return converted number
     * @throws WrongInputException throws wrong data input exception
     */
    @Override
    public int tryParseToInt(String text) throws WrongInputException {
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException e) {
            throw new WrongInputException("Wrong file format!");
        }
    }

    /**
     * Method that deletes whole data.
     */
    public void deleteAllMatches() {
        this.matches.clear();
    }

    /**
     * A method that returns a list of all matches from the database.
     *
     * @return matches list of all matches
     */
    public ArrayList<Match> getAllMatches() {
        return this.matches;
    }

    /**
     * The method of loading information into the database from a text file.
     *
     * @param filePath location of the text file
     * @throws IOException exception of misread file
     * @throws WrongInputException exception of bad data reading from file
     */
    public void readDataFromFile(String filePath) throws WrongInputException, IOException {
        BufferedReader fileReader;

        fileReader = new BufferedReader(new FileReader(filePath));

        int amountOfMatches;
        amountOfMatches = this.tryParseToInt(fileReader.readLine());

        SoccerTeam[] soccerTeam = new SoccerTeam[2];

        for (int i = 0; i < amountOfMatches; i++) {

            int peopleAmount;

            int matchId = this.tryParseToInt(fileReader.readLine());
            int matchTime = this.tryParseToInt(fileReader.readLine());
            String arbiterName = fileReader.readLine();
            peopleAmount = this.tryParseToInt(fileReader.readLine());

            ArrayList<String> arbitratorAssistants = new ArrayList<>();
            for (int j = 0; j < peopleAmount; j++) {
                arbitratorAssistants.add(fileReader.readLine());
            }
            peopleAmount = 0;

            String hostTeamName = fileReader.readLine();
            String hostTeamCountryName = fileReader.readLine();
            String hostTeamCoachName = fileReader.readLine();

            peopleAmount = this.tryParseToInt(fileReader.readLine());

            ArrayList<Player> hostTeamPlayers = new ArrayList<>();

            for (int j = 0; j < peopleAmount; j++) {
                String playerName = fileReader.readLine();
                int fouls = this.tryParseToInt(fileReader.readLine());
                int scoredGoals = this.tryParseToInt(fileReader.readLine());
                int enteredTime = this.tryParseToInt(fileReader.readLine());
                int leftTime = this.tryParseToInt(fileReader.readLine());
                int yellowCards = this.tryParseToInt(fileReader.readLine());

                boolean hasRedCard = false;
                if (fileReader.readLine().equals("YesRed")) {
                    hasRedCard = true;
                }

                boolean playedWholeMatch = false;
                if (enteredTime == 0 && leftTime == matchTime) {
                    playedWholeMatch = true;
                }

                hostTeamPlayers.add(new Player(playerName, scoredGoals, playedWholeMatch,
                        enteredTime, leftTime, yellowCards, hasRedCard, fouls));
            }
            soccerTeam[0] = new SoccerTeam(hostTeamName, hostTeamCountryName,
                    hostTeamCoachName, hostTeamPlayers);

            peopleAmount = 0;

            String guestTeamName = fileReader.readLine();
            String guestTeamCountryName = fileReader.readLine();
            String guestTeamCoachName = fileReader.readLine();

            peopleAmount = this.tryParseToInt(fileReader.readLine());

            ArrayList<Player> guestTeamPlayers = new ArrayList<>();

            for (int j = 0; j < peopleAmount; j++) {
                String playerName = fileReader.readLine();
                int fouls = this.tryParseToInt(fileReader.readLine());
                int scoredGoals = this.tryParseToInt(fileReader.readLine());
                int enteredTime = this.tryParseToInt(fileReader.readLine());
                int leftTime = this.tryParseToInt(fileReader.readLine());
                int yellowCards = this.tryParseToInt(fileReader.readLine());

                boolean hasRedCard = false;
                if (fileReader.readLine().equals("YesRed")) {
                    hasRedCard = true;
                }

                boolean playedWholeMatch = false;
                if (enteredTime == 0 && leftTime == matchTime) {
                    playedWholeMatch = true;
                }

                guestTeamPlayers.add(new Player(playerName, scoredGoals,
                        playedWholeMatch, enteredTime, leftTime, yellowCards,
                        hasRedCard, fouls));
            }
            soccerTeam[1] = new SoccerTeam(guestTeamName, guestTeamCountryName,
                    guestTeamCoachName, guestTeamPlayers);

            matches.add(new Match(matchTime, arbiterName, arbitratorAssistants,
                    soccerTeam));
        }

        fileReader.close();
    }

    /**
     * The method of saving the database with matches to a text file.
     *
     * @param filePath path to the target file
     * @throws IOException
     */
    public void writeDataToFile(String filePath) throws IOException {
        File fout = new File(filePath);
        FileOutputStream fileOutStr = new FileOutputStream(fout);

        try (BufferedWriter bufWr = new BufferedWriter(new OutputStreamWriter(fileOutStr))) {
            bufWr.write(Integer.toString(matches.size()));
            bufWr.newLine();
            
            for (Match match : matches) {
                //save match id name
                bufWr.write(Long.toString(match.getMatchId()));
                bufWr.newLine();
                
                //save match time
                bufWr.write(Integer.toString(match.getMatchTime()));
                bufWr.newLine();
                
                //save arbiter name
                bufWr.write(match.getArbiterName());
                bufWr.newLine();
                
                //save assisntants amount
                bufWr.write(Integer.toString(match.getArbitratorAssistants().size()));
                bufWr.newLine();
                
                //save assistant's names
                for (String assistantsNames : match.getArbitratorAssistants()) {
                    bufWr.write(assistantsNames);
                    bufWr.newLine();
                }
                
                bufWr.write(match.getHostTeam().getTeamName());
                bufWr.newLine();
                
                bufWr.write(match.getHostTeam().getTeamCountryName());
                bufWr.newLine();
                
                bufWr.write(match.getHostTeam().getCoachName());
                bufWr.newLine();
                
                // save HOST players amount
                bufWr.write(Integer.toString(match.getHostTeam().getPlayersPlayedAmount()));
                bufWr.newLine();
                
                for (Player player : match.getHostTeam().getPlayers()) {
                    bufWr.write(player.getPlayerName());
                    bufWr.newLine();
                    
                    bufWr.write(Integer.toString(player.getFouls()));
                    bufWr.newLine();
                    
                    bufWr.write(Integer.toString(player.getScoredGoals()));
                    bufWr.newLine();
                    
                    bufWr.write(Integer.toString(player.getEntryTime()));
                    bufWr.newLine();
                    
                    bufWr.write(Integer.toString(player.getLeftTime()));
                    bufWr.newLine();
                    
                    bufWr.write(Integer.toString(player.getYellowCards()));
                    bufWr.newLine();
                    
                    if (player.getRedCard()) {
                        bufWr.write("YesRed");
                    } else {
                        bufWr.write("NoRed");
                    }
                    bufWr.newLine();
                }
                
                bufWr.write(match.getGuestTeam().getTeamName());
                bufWr.newLine();
                
                bufWr.write(match.getGuestTeam().getTeamCountryName());
                bufWr.newLine();
                
                bufWr.write(match.getGuestTeam().getCoachName());
                bufWr.newLine();
                
                // save HOST players amount
                bufWr.write(Integer.toString(match.getGuestTeam().getPlayersPlayedAmount()));
                bufWr.newLine();
                
                for (Player player : match.getGuestTeam().getPlayers()) {
                    bufWr.write(player.getPlayerName());
                    bufWr.newLine();
                    
                    bufWr.write(Integer.toString(player.getFouls()));
                    bufWr.newLine();
                    
                    bufWr.write(Integer.toString(player.getScoredGoals()));
                    bufWr.newLine();
                    
                    bufWr.write(Integer.toString(player.getEntryTime()));
                    bufWr.newLine();
                    
                    bufWr.write(Integer.toString(player.getLeftTime()));
                    bufWr.newLine();
                    
                    bufWr.write(Integer.toString(player.getYellowCards()));
                    bufWr.newLine();
                    
                    if (player.getRedCard()) {
                        bufWr.write("YesRed");
                    } else {
                        bufWr.write("NoRed");
                    }
                    bufWr.newLine();
                }
                
            }
        }
    }

    /**
     * Method to get amount of matches in database .
     *
     * @return database size
     */
    public int getNumberOfMatches() {
        return this.matches.size();
    }
}
