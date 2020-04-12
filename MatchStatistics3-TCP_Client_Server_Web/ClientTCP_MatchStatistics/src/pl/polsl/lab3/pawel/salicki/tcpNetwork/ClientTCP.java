package pl.polsl.lab3.pawel.salicki.tcpNetwork;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
import pl.polsl.lab3.pawel.salicki.view.UserInterface;

/**
 * A class that supports communication with the client's protocol.
 *
 * @author Paweł Salicki
 * @version 1.0
 */
public class ClientTCP {

    /**
     * Buffered input to server.
     */
    private final BufferedReader inputServer;

    /**
     * Formatted output from server.
     */
    private final PrintWriter outputServer;

    /**
     * Client socket for server connection.
     */
    private final Socket socket;

    /**
     * A constructor of ClientTCP class creating a socket for the client.
     *
     * @param serverIP address of the server to which the connection is to be
     * established
     * @param PORT the PORT of the server for connection
     * @throws IOException exception when port is already bind
     */
    public ClientTCP(String serverIP, int PORT) throws IOException {
        socket = new Socket(serverIP, PORT);
        outputServer = new PrintWriter(
                new BufferedWriter(
                        new OutputStreamWriter(
                                socket.getOutputStream())), true);
        inputServer = new BufferedReader(
                new InputStreamReader(
                        socket.getInputStream()));
    }

    /**
     * The method attempts to send commands from the client to the server.
     *
     * @param serverCommand command from client
     * @return true when command is successful readed or else when something
     * fail
     */
    private boolean executeServerCommandHandling(String serverCommand) {
        serverCommand = serverCommand.toUpperCase();
        outputServer.println(serverCommand);

        try {
            return (inputServer.readLine().equals("OK"));
        } catch (IOException e) {
            System.err.println("Cannot execute server command!");
            System.err.println(e.getMessage());
        }
        return false;
    }

    /**
     * The method obtains detailed data from the server about one match.
     *
     * @param userInterface user interface for writing commands what the user
     * should enter at the moment
     * @param keyInput scanner for data entered by the user
     */
    public void showOneMatch(UserInterface userInterface, Scanner keyInput) {
        if (executeServerCommandHandling("SHOW_ONE_MATCH")) {

            ArrayList<String> matchData = new ArrayList<>();
            ArrayList<String> assistantsData = new ArrayList<>();
            ArrayList<String> hostTeamData = new ArrayList<>();
            ArrayList<String> guestTeamData = new ArrayList<>();
            ArrayList<String> hostPlayersData = new ArrayList<>();
            ArrayList<String> guestPlayersData = new ArrayList<>();

            this.outputServer.println(keyInput.nextLine());

            try {
                if (this.inputServer.readLine().equals("MATCH_SHOW_FAILURE")) {
                    userInterface.matchSearchFailure();
                    return;
                }
                this.outputServer.println("OK_MATCH_ID");
                matchData.add(this.inputServer.readLine());
                this.outputServer.println("OK_MATCH_LENGTH");
                matchData.add(this.inputServer.readLine());
                this.outputServer.println("OK_ARBITER_NAME");
                matchData.add(this.inputServer.readLine());

                this.outputServer.println("OK_ARBITRATOR_ASSISTANTS_SIZE");
                int arbitrators = Integer.parseInt(this.inputServer.readLine());
                for (int i = 0; i < arbitrators; i++) {
                    this.outputServer.println("OK_ARBITRATOR_ASSISTANTS");
                    assistantsData.add(this.inputServer.readLine());
                }

                this.outputServer.println("OK_HOST_TEAM_NAME");
                hostTeamData.add(this.inputServer.readLine());
                this.outputServer.println("OK_HOST_TEAM_COACH");
                hostTeamData.add(this.inputServer.readLine());
                this.outputServer.println("OK_HOST_TEAM_COUNTRY");
                hostTeamData.add(this.inputServer.readLine());

                this.outputServer.println("OK_GUEST_TEAM_NAME");
                guestTeamData.add(this.inputServer.readLine());
                this.outputServer.println("OK_GUEST_TEAM_COACH");
                guestTeamData.add(this.inputServer.readLine());
                this.outputServer.println("OK_GUEST_TEAM_COUNTRY");
                guestTeamData.add(this.inputServer.readLine());

                this.outputServer.println("OK_HOST_PLAYER_SIZE");
                int hostPlayers = Integer.parseInt(this.inputServer.readLine());

                for (int i = 0; i < hostPlayers; i++) {

                    this.outputServer.println("OK_HOST_PLAYER_NAME");
                    hostPlayersData.add(this.inputServer.readLine());
                    this.outputServer.println("OK_HOST_PLAYER_SCORE");
                    hostPlayersData.add(this.inputServer.readLine());
                    this.outputServer.println("OK_HOST_PLAYER_ENTRY_TIME");
                    hostPlayersData.add(this.inputServer.readLine());
                    this.outputServer.println("OK_HOST_PLAYER_LEFT_TIME");
                    hostPlayersData.add(this.inputServer.readLine());
                    this.outputServer.println("OK_HOST_PLAYER_YELLOW_CARDS");
                    hostPlayersData.add(this.inputServer.readLine());
                    this.outputServer.println("OK_HOST_PLAYER_ALL_TIME");
                    hostPlayersData.add(this.inputServer.readLine());
                    this.outputServer.println("OK_HOST_PLAYER_RED_CARD");
                    hostPlayersData.add(this.inputServer.readLine());

                    this.outputServer.println("OK_NEXT_HOST_PLAYER");
                }

                this.outputServer.println("OK_GUEST_PLAYER_SIZE");
                int guestPlayers = Integer.parseInt(this.inputServer.readLine());

                for (int i = 0; i < guestPlayers; i++) {

                    this.outputServer.println("OK_GUEST_PLAYER_NAME");
                    guestPlayersData.add(this.inputServer.readLine());
                    this.outputServer.println("OK_GUEST_PLAYER_SCORE");
                    guestPlayersData.add(this.inputServer.readLine());
                    this.outputServer.println("OK_GUEST_PLAYER_ENTRY_TIME");
                    guestPlayersData.add(this.inputServer.readLine());
                    this.outputServer.println("OK_GUEST_PLAYER_LEFT_TIME");
                    guestPlayersData.add(this.inputServer.readLine());
                    this.outputServer.println("OK_GUEST_PLAYER_YELLOW_CARDS");
                    guestPlayersData.add(this.inputServer.readLine());
                    this.outputServer.println("OK_GUEST_PLAYER_ALL_TIME");
                    guestPlayersData.add(this.inputServer.readLine());
                    this.outputServer.println("OK_GUEST_PLAYER_RED_CARD");
                    guestPlayersData.add(this.inputServer.readLine());

                    this.outputServer.println("OK_NEXT_GUEST_PLAYER");
                }

                this.outputServer.println("SHOW_MATCH_SUCCESS");

                String[] matchDataArray = new String[matchData.size()];
                String[] assistantsDataArray = new String[assistantsData.size()];
                String[] hostTeamDataArray = new String[hostTeamData.size()];
                String[] guestTeamDataArray = new String[guestTeamData.size()];
                String[] hostPlayersDataArray = new String[hostPlayersData.size()];
                String[] guestPlayersDataArray = new String[guestPlayersData.size()];

                for (int i = 0; i < matchData.size(); i++) {
                    matchDataArray[i] = matchData.get(i);
                }
                for (int i = 0; i < assistantsData.size(); i++) {
                    assistantsDataArray[i] = assistantsData.get(i);
                }
                for (int i = 0; i < hostTeamData.size(); i++) {
                    hostTeamDataArray[i] = hostTeamData.get(i);
                }
                for (int i = 0; i < guestTeamData.size(); i++) {
                    guestTeamDataArray[i] = guestTeamData.get(i);
                }
                for (int i = 0; i < hostPlayersData.size(); i++) {
                    hostPlayersDataArray[i] = hostPlayersData.get(i);
                }
                for (int i = 0; i < guestPlayersData.size(); i++) {
                    guestPlayersDataArray[i] = guestPlayersData.get(i);
                }

                userInterface.showOneMatch(matchDataArray, hostPlayersDataArray, hostTeamDataArray, guestPlayersDataArray, guestTeamDataArray, assistantsDataArray);

            } catch (IOException | NumberFormatException e) {
                this.outputServer.println("SHOW_MATCH_SUCCESS");
                System.err.println("An error occurred while getting informations about match from database form server.");
                System.err.println(e.getMessage());
            }
        }
    }

    /**
     * A method that sends a request to the server to clean up the database.
     */
    public void deleteDatabase() {
        if (executeServerCommandHandling("DELETE_DATABASE")) {
            boolean finish = false;
            try {
                while (!finish) {
                    if (this.inputServer.readLine().equals("DATABASE_DELETE_SUCCESS")) {
                        finish = true;
                    }
                }
            } catch (IOException e) {
                System.err.println("An error occurred while deleting database.");
                System.err.println(e.getMessage());
            }
        }
    }

    /**
     * A method that sends a request to the server to remove a match with the
     * given ID from the database.
     *
     * @param matchId id of the match to delete
     */
    public void deleteMatch(String matchId) {
        if (executeServerCommandHandling("DELETE_MATCH")) {
            boolean finish = false;
            try {
                while (!finish) {
                    this.outputServer.println(matchId);

                    if (this.inputServer.readLine().equals("MATCH_DELETE_SUCCESS")) {
                        finish = true;
                    }
                }
            } catch (IOException e) {
                System.err.println("An error occurred while deleting match from database.");
                System.err.println(e.getMessage());
            }
        }
    }

    /**
     * A method that sends a request to the server to provide basic information
     * about all matches from the database to be printed out to the user.
     *
     * @param userInterface user interface to print information about matches
     */
    public void showMatches(UserInterface userInterface) {
        if (executeServerCommandHandling("SHOW_MATCHES")) {

            ArrayList<String> data = new ArrayList<>();

            int numberOfMatches;
            try {
                numberOfMatches = Integer.parseInt(this.inputServer.readLine());
                for (int i = 0; i < numberOfMatches; i++) {
                    this.outputServer.println("OK_MATCH_ID");
                    data.add(this.inputServer.readLine());
                    this.outputServer.println("OK_ARBITER_NAME");
                    data.add(this.inputServer.readLine());
                    this.outputServer.println("OK_MATCH_LENGTH");
                    data.add(this.inputServer.readLine());
                    this.outputServer.println("OK_HOST_TEAM_NAME");
                    data.add(this.inputServer.readLine());
                    this.outputServer.println("OK_GUEST_TEAM_NAME");
                    data.add(this.inputServer.readLine());
                    this.outputServer.println("OK_PLACE_MATCH");
                    data.add(this.inputServer.readLine());
                    this.outputServer.println("OK_FOULS_AMOUNT");
                    data.add(this.inputServer.readLine());
                    this.outputServer.println("OK_HOST_SCORE");
                    data.add(this.inputServer.readLine());
                    this.outputServer.println("OK_GUEST_SCORE");
                    data.add(this.inputServer.readLine());
                    this.outputServer.println("OK_GAME_STATUS");
                    data.add(this.inputServer.readLine());

                    this.outputServer.println("OK_GET_NEXT");
                }
                this.outputServer.println("SHOW_MATCHES_SUCCESS");

                String[] stringDataArray = new String[data.size()];

                for (int j = 0; j < data.size(); j++) {
                    stringDataArray[j] = data.get(j);
                }

                userInterface.showAllMatches(stringDataArray);
            } catch (NumberFormatException | IOException e) {
                this.outputServer.println("SHOW_MATCHES_SUCCESS");
                System.err.println("An error occurred while reading matches informations from database.");
                System.err.println(e.getMessage());
            }
        }
    }

    /**
     * A method that sends a request to the server to add a new match from the
     * user to the database.
     *
     * @param userInterface The user interface that will guide the user through
     * the subsequent stages of entering information into the database.
     * @param keyInput scanner - user input
     */
    public void addMatch(UserInterface userInterface, Scanner keyInput) {
        if (this.executeServerCommandHandling("ADD_MATCH")) {
            try {
                boolean finish = false;

                String tmpTeamName = "Host";
                String tmpPlayerName = "";
                int playersNumber = 0;
                int maxPlayersNumber = 0;
                int maxMinuteMatch = 0;
                int minMinuteMatch = 0;

                while (!finish) {
                    String str = this.inputServer.readLine();
                    switch (str) {
                        case "OK_ARBITER_NAME":
                            userInterface.askArbiterName();
                            this.outputServer.println(keyInput.nextLine());
                            break;
                        case "OK_NR_ASSISTANTS":
                            userInterface.askHowManyPeopleEnter("arbiter assistants");
                            this.outputServer.println(keyInput.nextLine());
                            break;
                        case "OK_ASSISTANT_NAME":
                            userInterface.askPeopleEnter();
                            this.outputServer.println(keyInput.nextLine());
                            break;
                        case "OK_MATCH_LENGTH":
                            userInterface.askTimeMatch();
                            maxMinuteMatch = Integer.parseInt(keyInput.nextLine());
                            this.outputServer.println(maxMinuteMatch);
                            break;
                        case "OK_HOST_TEAM_NAME":
                            userInterface.askTeamName("Host");
                            this.outputServer.println(keyInput.nextLine());
                            break;
                        case "OK_GUEST_TEAM_NAME":
                            userInterface.askTeamName("Guest");
                            this.outputServer.println(keyInput.nextLine());
                            break;
                        case "OK_COACH_HOST_NAME":
                            userInterface.askCoachNameOfTeam("Host");
                            this.outputServer.println(keyInput.nextLine());
                            break;
                        case "OK_COACH_GUEST_NAME":
                            userInterface.askCoachNameOfTeam("Guest");
                            this.outputServer.println(keyInput.nextLine());
                            break;
                        case "OK_HOST_TEAM_COUNTRY":
                            userInterface.askTeamCountry("Host");
                            this.outputServer.println(keyInput.nextLine());
                            break;
                        case "OK_GUEST_TEAM_COUNTRY":
                            userInterface.askTeamCountry("Guest");
                            this.outputServer.println(keyInput.nextLine());
                            break;
                        case "OK_PLAYERS_NUMBER":
                            userInterface.askHowManyPeopleEnter("players");
                            maxPlayersNumber = Integer.parseInt(keyInput.nextLine());
                            this.outputServer.println(maxPlayersNumber);
                            break;
                        case "OK_PLAYER_NAME":
                            if (tmpTeamName.equals("Host") && playersNumber > maxPlayersNumber) {
                                tmpTeamName = "Guest";
                            }
                            userInterface.askPlayerName(tmpTeamName, ++playersNumber, maxPlayersNumber);
                            tmpPlayerName = keyInput.nextLine();
                            this.outputServer.println(tmpPlayerName);
                            break;
                        case "OK_PLAYED_WHOLE_MATCH_Y_N":
                            userInterface.askPlayerPlayedWholeMatch(tmpPlayerName);
                            this.outputServer.println(keyInput.nextLine());
                            break;
                        case "OK_PLAYER_ENTER_TIME":
                            userInterface.askPlayerEnteredTime(tmpPlayerName, maxMinuteMatch);
                            this.outputServer.println(keyInput.nextLine());
                            break;
                        case "OK_PLAYER_LEFT_TIME":
                            minMinuteMatch = maxMinuteMatch;
                            userInterface.askPlayerLeftTime(tmpPlayerName, minMinuteMatch, maxMinuteMatch);
                            this.outputServer.println(keyInput.nextLine());
                            break;
                        case "OK_PLAYER_GOALS":
                            userInterface.askPlayerGoalsNr(tmpPlayerName);
                            this.outputServer.println(keyInput.nextLine());
                            break;
                        case "OK_PLAYER_FOULS":
                            userInterface.askPlayerFoulsAmount(tmpPlayerName);
                            this.outputServer.println(keyInput.nextLine());
                            break;
                        case "OK_PLAYER_YELLOW_CARDS":
                            userInterface.askPlayerYellowCards(tmpPlayerName);
                            this.outputServer.println(keyInput.nextLine());
                            break;
                        case "OK_PLAYER_RED_CARD_Y_N":
                            userInterface.askPlayerRedCard(tmpPlayerName);
                            this.outputServer.println(keyInput.nextLine());
                            break;
                        case "ERROR":
                            userInterface.printErrorMessage("Error while adding players");
                            break;
                        case "ADD_NEW_MATCH_ENDED":
                            finish = true;
                            break;
                        default:
                            userInterface.printErrorMessage("Wrong command");
                            break;
                    }
                }
            } catch (NumberFormatException | IOException e) {
                userInterface.printErrorMessage(e.getMessage());
            }
        }
    }

    /**
     * A method that sends a request to a server to save the current database to
     * a file on the server.
     *
     * @param filePath file path
     */
    public void saveToFile(String filePath) {
        if (executeServerCommandHandling("SAVE_TO_FILE")) {
            boolean finish = false;
            try {
                while (!finish) {
                    this.outputServer.println(filePath);

                    if (this.inputServer.readLine().equals("FILE_SAVE_SUCCESS")) {
                        finish = true;
                    }
                }
            } catch (IOException e) {
                System.err.println("An error occurred while saving database to file.");
                System.err.println(e.getMessage());
            }
        }
    }

    /**
     * A method that sends a request to a server to read database from file.
     *
     * @param filePath file path
     */
    public void readFromFile(String filePath) {
        if (executeServerCommandHandling("READ_FROM_FILE")) {
            boolean finish = false;
            try {
                while (!finish) {
                    this.outputServer.println(filePath);

                    if (this.inputServer.readLine().equals("FILE_READ_SUCCESS")) {

                        finish = true;
                    }
                }
            } catch (IOException e) {
                System.err.println("An error occurred while reading database from file.");
                System.err.println(e.getMessage());
            }
        }
    }
}
