package pl.polsl.lab3.pawel.salicki.tcpNetwork;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import pl.polsl.lab3.pawel.salicki.exceptions.WrongInputException;
import pl.polsl.lab3.pawel.salicki.model.Database;
import pl.polsl.lab3.pawel.salicki.model.Match;
import pl.polsl.lab3.pawel.salicki.model.Player;
import pl.polsl.lab3.pawel.salicki.model.SoccerTeam;

/**
 * A single service class for server.
 *
 * @author Paweł Salicki
 * @version 1.0
 */
public class SingleService implements Runnable, Closeable {

    /**
     * Buffered input from client.
     */
    private final BufferedReader inputClient;

    /**
     * Formatted output for client.
     */
    private final PrintWriter outputClient;

    /**
     * Server database of matches statistics data.
     */
    private Database database;

    /**
     * Socket representing client connection.
     */
    private final Socket socket;

    /**
     * Multi-parameter constructor of the SingleService class.
     *
     * @param socket socket for client connection
     * @param database reference to database object
     * @throws IOException input output exception
     */
    public SingleService(Socket socket, Database database) throws IOException {
        this.socket = socket;
        this.database = database;
        outputClient = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
        inputClient = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    /**
     * Realizes the service. Reads commands and runs the appropriate methods.
     */
    @Override
    public void run() {

        if (database == null) {
            database = new Database();
        }

        try {
            System.out.println(new java.util.Date().toString());
            System.out.print("Client connected: ");
            System.out.println(Thread.currentThread().getName());
            boolean quit = false;

            while (!quit) {
                String str = inputClient.readLine();
                str = str.toUpperCase();

                System.out.print(Thread.currentThread().getName());
                System.out.println(" sent command " + str);

                switch (str) {
                    case "SHOW_MATCHES":
                        this.showMatchesHandling();
                        break;
                    case "SAVE_TO_FILE":
                        this.saveToFileHandling();
                        break;
                    case "READ_FROM_FILE":
                        this.readFromFileHandling();
                        break;
                    case "SHOW_ONE_MATCH":
                        this.showOneMatchHandling();
                        break;
                    case "ADD_MATCH":
                        this.newMatchHandling();
                        break;
                    case "DELETE_MATCH":
                        this.deleteMatchHandling();
                        break;
                    case "DELETE_DATABASE":
                        this.deleteDatabaseHandling();
                        break;
                    case "EXIT_APP":
                        quit = true;
                        outputClient.println("OK");
                        break;
                    case "HELP":
                        this.helpHandling();
                        break;
                    default:
                        System.err.println("Unknown command: " + str);
                        System.err.println("Try again!");
                        break;
                }
            }
        } catch (NullPointerException | IOException e) {
            System.err.println(e.getMessage());
        } finally {
            System.out.println("DISCONNECTED " + Thread.currentThread().getName());

            try {
                socket.close();
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    /**
     * A method that removes all information from the database.
     */
    private void deleteDatabaseHandling() {
        this.outputClient.println("OK");

        if (this.database != null) {
            if (this.database.hasData()) {
                this.database.deleteAllMatches();
            }
        }
        this.outputClient.println("DATABASE_DELETE_SUCCESS");
    }

    /**
     * A method that removes one match from the database.
     */
    private void deleteMatchHandling() {
        this.outputClient.println("OK");

        try {
            int matchId = Integer.parseInt(this.inputClient.readLine());
            if (this.database.hasMatchInData(matchId)) {
                this.database.deleteMatchById(matchId);
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        } finally {
            this.outputClient.println("MATCH_DELETE_SUCCESS");
        }
    }

    /**
     * Method displaying one match.
     */
    private void showOneMatchHandling() {
        this.outputClient.println("OK");

        String tmp = "";
        boolean finish = false;
        try {
            int matchId = Integer.parseInt(this.inputClient.readLine());

            if (this.database.hasMatchInData(matchId)) {
                int arbitratorsCounter = 0;
                int playersHostTeamCounter = 0;
                int playersGuestTeamCounter = 0;

                this.outputClient.println("MATCH_SHOW_OK");
                while (!finish) {
                    try {
                        String str = this.inputClient.readLine();
                        switch (str) {
                            case "OK_MATCH_ID":
                                this.outputClient.println(this.database.getMatchById(matchId).getMatchId());
                                break;
                            case "OK_MATCH_LENGTH":
                                this.outputClient.println(this.database.getMatchById(matchId).getMatchTime());
                                break;
                            case "OK_ARBITER_NAME":
                                this.outputClient.println(this.database.getMatchById(matchId).getArbiterName());
                                break;
                            case "OK_ARBITRATOR_ASSISTANTS_SIZE":
                                this.outputClient.println(this.database.getMatchById(matchId).getArbitratorAssistants().size());
                                break;
                            case "OK_ARBITRATOR_ASSISTANTS":
                                this.outputClient.println(this.database.getMatchById(matchId).getArbitratorAssistants().get(arbitratorsCounter++));
                                break;
                            case "OK_HOST_TEAM_NAME":
                                this.outputClient.println(this.database.getMatchById(matchId).getHostTeam().getTeamName());
                                break;
                            case "OK_HOST_TEAM_COACH":
                                this.outputClient.println(this.database.getMatchById(matchId).getHostTeam().getCoachName());
                                break;
                            case "OK_HOST_TEAM_COUNTRY":
                                this.outputClient.println(this.database.getMatchById(matchId).getHostTeam().getCoachName());
                                break;
                            case "OK_GUEST_TEAM_NAME":
                                this.outputClient.println(this.database.getMatchById(matchId).getGuestTeam().getTeamName());
                                break;
                            case "OK_GUEST_TEAM_COACH":
                                this.outputClient.println(this.database.getMatchById(matchId).getGuestTeam().getCoachName());
                                break;
                            case "OK_GUEST_TEAM_COUNTRY":
                                this.outputClient.println(this.database.getMatchById(matchId).getGuestTeam().getTeamCountryName());
                                break;
                            case "OK_HOST_PLAYER_SIZE":
                                this.outputClient.println(this.database.getMatchById(matchId).getHostTeam().getPlayers().size());
                                break;
                            case "OK_NEXT_HOST_PLAYER":
                                playersHostTeamCounter++;
                                break;
                            case "OK_HOST_PLAYER_NAME":
                                this.outputClient.println(this.database.getMatchById(matchId).getHostTeam().getPlayers().get(playersHostTeamCounter).getPlayerName());
                                break;
                            case "OK_HOST_PLAYER_SCORE":
                                this.outputClient.println(this.database.getMatchById(matchId).getHostTeam().getPlayers().get(playersHostTeamCounter).getScoredGoals());
                                break;
                            case "OK_HOST_PLAYER_ENTRY_TIME":
                                this.outputClient.println(this.database.getMatchById(matchId).getHostTeam().getPlayers().get(playersHostTeamCounter).getEntryTime());
                                break;
                            case "OK_HOST_PLAYER_LEFT_TIME":
                                this.outputClient.println(this.database.getMatchById(matchId).getHostTeam().getPlayers().get(playersHostTeamCounter).getLeftTime());
                                break;
                            case "OK_HOST_PLAYER_YELLOW_CARDS":
                                this.outputClient.println(this.database.getMatchById(matchId).getHostTeam().getPlayers().get(playersHostTeamCounter).getYellowCards());
                                break;
                            case "OK_HOST_PLAYER_ALL_TIME":
                                this.outputClient.println(this.database.getMatchById(matchId).getHostTeam().getPlayers().get(playersHostTeamCounter).calculatePlayerTimeInGame());
                                break;
                            case "OK_HOST_PLAYER_RED_CARD":
                                if (this.database.getMatchById(matchId).getHostTeam().getPlayers().get(playersHostTeamCounter).getRedCard()) {
                                    this.outputClient.println("Y");
                                } else {
                                    this.outputClient.println("N");
                                }
                                break;
                            case "OK_GUEST_PLAYER_SIZE":
                                this.outputClient.println(this.database.getMatchById(matchId).getGuestTeam().getPlayers().size());
                                break;
                            case "OK_NEXT_GUEST_PLAYER":
                                playersGuestTeamCounter++;
                                break;
                            case "OK_GUEST_PLAYER_NAME":
                                this.outputClient.println(this.database.getMatchById(matchId).getGuestTeam().getPlayers().get(playersGuestTeamCounter).getPlayerName());
                                break;
                            case "OK_GUEST_PLAYER_SCORE":
                                this.outputClient.println(this.database.getMatchById(matchId).getGuestTeam().getPlayers().get(playersGuestTeamCounter).getScoredGoals());
                                break;
                            case "OK_GUEST_PLAYER_ENTRY_TIME":
                                this.outputClient.println(this.database.getMatchById(matchId).getGuestTeam().getPlayers().get(playersGuestTeamCounter).getEntryTime());
                                break;
                            case "OK_GUEST_PLAYER_LEFT_TIME":
                                this.outputClient.println(this.database.getMatchById(matchId).getGuestTeam().getPlayers().get(playersGuestTeamCounter).getLeftTime());
                                break;
                            case "OK_GUEST_PLAYER_YELLOW_CARDS":
                                this.outputClient.println(this.database.getMatchById(matchId).getGuestTeam().getPlayers().get(playersGuestTeamCounter).getYellowCards());
                                break;
                            case "OK_GUEST_PLAYER_ALL_TIME":
                                this.outputClient.println(this.database.getMatchById(matchId).getGuestTeam().getPlayers().get(playersGuestTeamCounter).calculatePlayerTimeInGame());
                                break;
                            case "OK_GUEST_PLAYER_RED_CARD":
                                if (this.database.getMatchById(matchId).getGuestTeam().getPlayers().get(playersGuestTeamCounter).getRedCard()) {
                                    this.outputClient.println("Y");
                                } else {
                                    this.outputClient.println("N");
                                }
                                break;
                            case "SHOW_MATCH_SUCCESS":
                                finish = true;
                                System.out.print(Thread.currentThread().getName());
                                System.out.println(" succesfully sent players.");
                                break;
                        }

                    } catch (IOException e) {
                        System.err.println("An error uccurred while getting match from database");
                    }
                }

            } else {
                this.outputClient.println("MATCH_SHOW_FAILURE");
            }

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        this.outputClient.println("OK_SHOW_MATCH");
    }

    /**
     * A method that reads the database from a file.
     */
    private void readFromFileHandling() {
        this.outputClient.println("OK");
        try {
            String filePath = this.inputClient.readLine();
            this.database.readDataFromFile(filePath);
        } catch (IOException | WrongInputException e) {
            System.err.println(e.getMessage());
        } finally {
            this.outputClient.println("FILE_READ_SUCCESS");
        }

    }

    /**
     * The method of saving the database to a file.
     */
    private void saveToFileHandling() {
        this.outputClient.println("OK");
        if (database.hasData()) {
            try {
                String fileName = this.inputClient.readLine();
                this.database.writeDataToFile(fileName);
            } catch (IOException e) {
                System.err.println("An error occurred while saving database to file");
                System.err.println(e);
            } finally {
                this.outputClient.println("FILE_SAVE_SUCCESS");
            }
        }
    }

    /**
     * A method that transfers basic data from a database.
     */
    private void showMatchesHandling() {
        this.outputClient.println("OK");
        this.outputClient.println(this.database.getAllMatches().size());
        String tmp = "";

        if (this.database == null) {
            this.outputClient.println("DATABASE_EMPTY");
            return;
        }

        int i = 0;
        boolean finish = false;
        while (!finish) {
            try {
                String str = this.inputClient.readLine();
                switch (str) {
                    case "OK_MATCH_ID":
                        this.outputClient.println(this.database.getAllMatches().get(i).getMatchId());
                        break;
                    case "OK_ARBITER_NAME":
                        this.outputClient.println(this.database.getAllMatches().get(i).getArbiterName());
                        break;
                    case "OK_MATCH_LENGTH":
                        this.outputClient.println(this.database.getAllMatches().get(i).getMatchTime());
                        break;
                    case "OK_HOST_TEAM_NAME":
                        this.outputClient.println(this.database.getAllMatches().get(i).getHostTeam().getTeamName());
                        break;
                    case "OK_GUEST_TEAM_NAME":
                        this.outputClient.println(this.database.getAllMatches().get(i).getGuestTeam().getTeamName());
                        break;
                    case "OK_PLACE_MATCH":
                        this.outputClient.println(this.database.getAllMatches().get(i).getHostTeam().getTeamCountryName());
                        break;
                    case "OK_FOULS_AMOUNT":
                        this.outputClient.println(this.database.getAllMatches().get(i).calculateFouls());
                        break;
                    case "OK_HOST_SCORE":
                        this.outputClient.println(this.database.getAllMatches().get(i).getHostTeam().calculateGoals());
                        break;
                    case "OK_GUEST_SCORE":
                        this.outputClient.println(this.database.getAllMatches().get(i).getGuestTeam().calculateGoals());
                        break;
                    case "OK_GAME_STATUS":
                        this.outputClient.println(this.database.getAllMatches().get(i).chooseTheWinnerTeam());
                        break;
                    case "OK_GET_NEXT":
                        i++;
                        break;
                    case "SHOW_MATCHES_SUCCESS":
                        finish = true;
                        System.out.print(Thread.currentThread().getName());
                        System.out.println(" succesfully sent information.");
                        break;

                }
            } catch (IOException e) {
                System.err.println("An error occured while reading database");
            }
        }
    }

    /**
     * A method that supports adding a new match to the database.
     */
    private void newMatchHandling() {
        this.outputClient.println("OK");

        try {
            this.outputClient.println("OK_ARBITER_NAME");
            String arbiterName = this.inputClient.readLine();

            this.outputClient.println("OK_NR_ASSISTANTS");
            int nrAssistants = Integer.parseInt(this.inputClient.readLine());

            ArrayList<String> assistants = new ArrayList<>();
            for (int i = 0; i < nrAssistants; i++) {
                this.outputClient.println("OK_ASSISTANT_NAME");
                assistants.add(this.inputClient.readLine());
            }

            this.outputClient.println("OK_MATCH_LENGTH");
            int matchLength = Integer.parseInt(this.inputClient.readLine());

            this.outputClient.println("OK_HOST_TEAM_NAME");
            String hostTeamName = this.inputClient.readLine();

            this.outputClient.println("OK_GUEST_TEAM_NAME");
            String guestTeamName = this.inputClient.readLine();

            this.outputClient.println("OK_COACH_HOST_NAME");
            String coachHostName = this.inputClient.readLine();

            this.outputClient.println("OK_COACH_GUEST_NAME");
            String coachGuestName = this.inputClient.readLine();

            this.outputClient.println("OK_HOST_TEAM_COUNTRY");
            String hostTeamCountry = this.inputClient.readLine();

            this.outputClient.println("OK_GUEST_TEAM_COUNTRY");
            String guestTeamCountry = this.inputClient.readLine();

            ArrayList<Player> playersHostTeam = new ArrayList<>();
            ArrayList<Player> playersGuestTeam = new ArrayList<>();
            SoccerTeam hostTeam;
            SoccerTeam guestTeam;

            this.outputClient.println("OK_PLAYERS_NUMBER");
            int playersAmount = Integer.parseInt(this.inputClient.readLine());

            for (int i = 0; i < playersAmount; i++) {
                this.outputClient.println("OK_PLAYER_NAME");
                String playerName = this.inputClient.readLine();

                boolean playerPlayedWholeMatch = false;
                String answerYN = "";
                do {
                    this.outputClient.println("OK_PLAYED_WHOLE_MATCH_Y_N");
                    answerYN = this.inputClient.readLine();
                    answerYN = answerYN.toUpperCase();

                    if (answerYN.equals("Y")) {
                        playerPlayedWholeMatch = true;
                    }

                } while (!answerYN.equals("Y") && !answerYN.equals("N"));

                int playerEntryTime = 0;
                int playerLeftTime = 0;
                if (!playerPlayedWholeMatch) {
                    this.outputClient.println("OK_PLAYER_ENTER_TIME");
                    playerEntryTime = Integer.parseInt(this.inputClient.readLine());

                    this.outputClient.println("OK_PLAYER_LEFT_TIME");
                    playerLeftTime = Integer.parseInt(this.inputClient.readLine());
                }

                this.outputClient.println("OK_PLAYER_GOALS");
                int playerGoals = Integer.parseInt(this.inputClient.readLine());

                this.outputClient.println("OK_PLAYER_FOULS");
                int playerFouls = Integer.parseInt(this.inputClient.readLine());

                this.outputClient.println("OK_PLAYER_YELLOW_CARDS");
                int playerYellowCards = Integer.parseInt(this.inputClient.readLine());

                boolean redCard = false;
                if (playerYellowCards >= 2) {
                    redCard = true;
                } else {
                    do {
                        this.outputClient.println("OK_PLAYER_RED_CARD_Y_N");
                        answerYN = this.inputClient.readLine();
                        answerYN = answerYN.toUpperCase();

                        if (answerYN.equals("Y")) {
                            redCard = true;
                        }

                    } while (!answerYN.equals("Y") && !answerYN.equals("N"));
                }

                Player player = new Player(playerName, playerGoals, playerPlayedWholeMatch, playerEntryTime, playerLeftTime,
                        playerYellowCards, redCard, playerFouls);
                playersHostTeam.add(player);
            }
            hostTeam = new SoccerTeam(hostTeamName, hostTeamCountry, coachHostName, playersHostTeam);

            this.outputClient.println("OK_PLAYERS_NUMBER");
            playersAmount = Integer.parseInt(this.inputClient.readLine());

            for (int i = 0; i < playersAmount; i++) {
                this.outputClient.println("OK_PLAYER_NAME");
                String playerName = this.inputClient.readLine();

                boolean playerPlayedWholeMatch = false;
                String answerYN = "";
                do {
                    this.outputClient.println("OK_PLAYED_WHOLE_MATCH_Y_N");
                    answerYN = this.inputClient.readLine();
                    answerYN = answerYN.toUpperCase();

                    if (answerYN.equals("Y")) {
                        playerPlayedWholeMatch = true;
                    }

                } while (!answerYN.equals("Y") && !answerYN.equals("N"));

                int playerEntryTime = 0;
                int playerLeftTime = 0;
                if (!playerPlayedWholeMatch) {
                    this.outputClient.println("OK_PLAYER_ENTER_TIME");
                    playerEntryTime = Integer.parseInt(this.inputClient.readLine());

                    this.outputClient.println("OK_PLAYER_LEFT_TIME");
                    playerLeftTime = Integer.parseInt(this.inputClient.readLine());
                }

                this.outputClient.println("OK_PLAYER_GOALS");
                int playerGoals = Integer.parseInt(this.inputClient.readLine());

                this.outputClient.println("OK_PLAYER_FOULS");
                int playerFouls = Integer.parseInt(this.inputClient.readLine());

                this.outputClient.println("OK_PLAYER_YELLOW_CARDS");
                int playerYellowCards = Integer.parseInt(this.inputClient.readLine());

                boolean redCard = false;
                if (playerYellowCards >= 2) {
                    redCard = true;
                } else {
                    do {
                        this.outputClient.println("OK_PLAYER_RED_CARD_Y_N");
                        answerYN = this.inputClient.readLine();
                        answerYN = answerYN.toUpperCase();

                        if (answerYN.equals("Y")) {
                            redCard = true;
                        }

                    } while (!answerYN.equals("Y") && !answerYN.equals("N"));
                }

                Player player = new Player(playerName, playerGoals, false, playerEntryTime, playerLeftTime,
                        playerYellowCards, redCard, playerFouls);
                playersGuestTeam.add(player);
            }
            guestTeam = new SoccerTeam(guestTeamName, guestTeamCountry, coachGuestName, playersGuestTeam);

            SoccerTeam[] soccerTeams = {hostTeam, guestTeam};

            Match match = new Match(matchLength, arbiterName, assistants, soccerTeams);

            this.database.addMatchToDatabase(match);

        } catch (IOException | NumberFormatException e) {
            this.outputClient.println("ERROR");
            System.out.println(Thread.currentThread().getName());
            System.out.println(" get error when adding new match");
        }

        this.outputClient.println("ADD_NEW_MATCH_ENDED");
        System.out.print(Thread.currentThread().getName());
        System.out.println(" ended adding new match to database");

    }

    /**
     * List of commands to use.
     */
    private void helpHandling() {
        this.outputClient.print("Available commands: ");
        this.outputClient.print("SHOW_MATCHES, ");
        this.outputClient.print("SAVE_TO_FILE, ");
        this.outputClient.print("READ_FROM_FILE, ");
        this.outputClient.print("SHOW_ONE_MATCH, ");
        this.outputClient.print("ADD_MATCH, ");
        this.outputClient.print("DELETE_MATCH, ");
        this.outputClient.print("DELETE_DATABASE, ");
        this.outputClient.print("EXIT_APP, ");
        this.outputClient.print("HELP");
        this.outputClient.println();
    }

    /**
     * The socket closing method
     *
     * @throws IOException ioexception
     */
    @Override
    public void close() throws IOException {
        if (socket != null) {
            socket.close();
        }
    }
}
