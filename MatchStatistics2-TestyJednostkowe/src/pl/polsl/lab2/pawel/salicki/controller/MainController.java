package pl.polsl.lab2.pawel.salicki.controller;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.IOException;

import pl.polsl.lab2.pawel.salicki.model.Database;
import pl.polsl.lab2.pawel.salicki.view.UserInterface;
import pl.polsl.lab2.pawel.salicki.view.MainMenuChoice;
import pl.polsl.lab2.pawel.salicki.model.Match;
import pl.polsl.lab2.pawel.salicki.model.Player;
import pl.polsl.lab2.pawel.salicki.model.SoccerTeam;
import pl.polsl.lab2.pawel.salicki.exceptions.WrongInputException;

/**
 * Main controller of program. his class mediates communication between the user
 * interface and the operation of the application.
 *
 * @author Paweł Salicki
 * @version 1.0
 */
public class MainController {

    /**
     * Database of matches.
     */
    private final Database matchesData;

    /**
     * User Interface.
     */
    private final UserInterface userInterface;

    /**
     * User input stream.
     */
    private final Scanner keyInput;

    /**
     * An auxiliary variable informing about the command to close the
     * application.
     */
    private boolean exitApp;

    /**
     * Auxiliary variable for the user input stream.
     */
    private int inputTmp;

    /**
     * A basic constructor of the MainController class that sets fields to basic
     * values.
     */
    public MainController() {
        this.matchesData = new Database();
        this.userInterface = new UserInterface();

        exitApp = false;
        inputTmp = 0;

        keyInput = new Scanner(System.in);
    }

    /**
     * The method is used to obtain information about subsequent players of the
     * team. It calls the appropriate user interface methods telling you what to
     * type at the moment.
     *
     * @param teamVersion string of characters informing about the type of team
     * about which the user provides information (Host / Guest)
     * @param matchLength length of the match needed for questions about how
     * long players play on the field
     * @return the method returns a list of players about which information was
     * obtained
     */
    private ArrayList<Player> addPlayers(String teamVersion, int matchLength) {
        ArrayList<Player> playersList = new ArrayList<>();

        // get from userinformation about amount of players
        int amountOfPlayers = 0;

        do {
            userInterface.askHowManyPeopleEnter("players (min 1) in the team " + teamVersion);
            amountOfPlayers = Integer.parseInt(keyInput.nextLine());
        } while (amountOfPlayers < 1);

        // get players information from user
        for (int i = 0; i < amountOfPlayers; i++) {

            // get player name from user
            String playerName = "Unknown";
            userInterface.askPlayerName(teamVersion, i + 1, amountOfPlayers);
            playerName = keyInput.nextLine();

            // get information from user about player's match
            int enteredMinute = 0, leftMinute = 0;
            boolean playedWholeMatch = false;
            String answerYN = "";

            // ask if player played whole match
            boolean goodAnswer;
            do {
                goodAnswer = false;
                userInterface.askPlayerPlayedWholeMatch(playerName);
                answerYN = keyInput.nextLine();

                if (!answerYN.equals("y") || !answerYN.equals("n")) {
                    goodAnswer = true;
                }

            } while (!goodAnswer);

            if (answerYN.equals("y")) {
                playedWholeMatch = true;
                enteredMinute = 0;
                leftMinute = matchLength;
            } else {
                playedWholeMatch = false;

                do {
                    userInterface.askPlayerEnteredTime(playerName, matchLength);
                    enteredMinute = Integer.parseInt(keyInput.nextLine());
                } while (enteredMinute > matchLength);

                do {
                    userInterface.askPlayerLeftTime(playerName, enteredMinute, matchLength);
                    leftMinute = Integer.parseInt(keyInput.nextLine());
                } while (leftMinute <= enteredMinute);

            }

            // points scored by player
            int amountOfGoals = 0;

            do {
                userInterface.askPlayerGoalsNr(playerName);
                amountOfGoals = Integer.parseInt(keyInput.nextLine());
            } while (amountOfGoals < 0);

            // player's fouls
            int amountOfFouls = 0;
            do {
                userInterface.askPlayerFoulsAmount(playerName);
                amountOfFouls = Integer.parseInt(keyInput.nextLine());
            } while (amountOfFouls < 0);

            // red and yellow cards collected by player
            int amountOfYellowCards = 0;
            boolean redCard = false;

            userInterface.askPlayerYellowCards(playerName);
            amountOfYellowCards = Integer.parseInt(keyInput.nextLine());

            if (amountOfYellowCards >= 2) {
                redCard = true;
            } else {

                do {
                    goodAnswer = false;
                    userInterface.askPlayerRedCard(playerName);
                    answerYN = keyInput.nextLine();

                    if (!answerYN.equals("y") || !answerYN.equals("n")) {
                        goodAnswer = true;
                    }

                } while (!goodAnswer);

                redCard = answerYN.equals("y");
            }
            Player player = new Player(playerName, amountOfGoals, playedWholeMatch,
                    enteredMinute, leftMinute, amountOfYellowCards, redCard,
                    amountOfFouls);

            // add player to arrayList
            playersList.add(player);
        }

        return playersList;
    }

    /**
     * The method prompts the user for the match referee's name and retrieved
     * information.
     *
     * @return match referee name
     */
    private String getArbiterName() {
        userInterface.askArbiterName();
        return keyInput.nextLine();
    }

    /**
     * The method calls the user interface methods to get information about the
     * names of the match referee's assistants.
     *
     * @return list of match referee's midfielder names
     */
    private ArrayList<String> getArbitratorAssistants() {
        int amountOfArbitrators = 0;
        ArrayList<String> arbitratorAssistants = new ArrayList<>();

        //get arbitrator assistants names
        do {
            userInterface.askHowManyPeopleEnter("arbitrator assistants");
            amountOfArbitrators = Integer.parseInt(keyInput.nextLine());
        } while (amountOfArbitrators <= 0);

        if (amountOfArbitrators > 0) {
            userInterface.askPeopleEnter();
            for (int i = 0; i < amountOfArbitrators; i++) {
                userInterface.printNumberList(i + 1, amountOfArbitrators);
                arbitratorAssistants.add(keyInput.nextLine());
            }
        }
        return arbitratorAssistants;
    }

    /**
     * The method calls the method from the user interface class to get
     * information about the length of the match.
     *
     * @return matchLength length of the match in minutes
     */
    private int getMatchLength() {
        int matchLength = -1;

        do {
            userInterface.askTimeMatch();
            matchLength = Integer.parseInt(keyInput.nextLine());
        } while (matchLength < 0);

        return matchLength;
    }

    /**
     * The method calls the method from the user interface to get information
     * about the name of the team.
     *
     * @param teamVersion name of the team
     * @return user imput entry (team name)
     */
    private String getTeamName(String teamVersion) {
        userInterface.askTeamName(teamVersion);
        return keyInput.nextLine();
    }

    /**
     * The method calls the method from the user interface to get information
     * about the coach name.
     *
     * @param teamName name of the team
     * @return user imput entry (coach name)
     */
    private String getNameCoach(String teamName) {
        userInterface.askCoachNameOfTeam(teamName);
        return keyInput.nextLine();
    }

    /**
     * The method calls the method from the user interface to get information
     * about the country name.
     *
     * @param teamName name of the team
     * @return user imput entry (country name)
     */
    private String getCountryName(String teamName) {
        userInterface.askTeamCountry(teamName);
        return keyInput.nextLine();
    }

    /**
     * A method that calls the user interface for a file path.
     *
     * @return user input (file path)
     */
    private String getFilePath() {
        userInterface.askFilePath();
        return keyInput.nextLine();
    }

    /**
     * The method invokes queries from the user interface forcing it to fill
     * information with relevant data. In addition, the method creates a new
     * match for the database.
     */
    private void addNewMatch() throws NumberFormatException {

        try {
            // get arbiter's name from user
            String arbiterName = getArbiterName();

            // get arbitrator assistants from user
            ArrayList<String> arbitratorAssistants = new ArrayList<>();
            arbitratorAssistants.addAll(getArbitratorAssistants());

            // get length of the match        
            int matchLength = getMatchLength();

            //get team names from user
            String hostTeamName = getTeamName("Host");
            String guestTeamName = getTeamName("Guest");

            // get coach names from user
            String hostCoachName = getNameCoach(hostTeamName);
            String guestCoachName = getNameCoach(guestTeamName);

            //get team countries from user        
            String countryHostTeam = getCountryName(hostTeamName);
            String countryGuestTeam = getCountryName(guestTeamName);

            // add players to database
            ArrayList<Player> hostTeamPlayers = new ArrayList<>();
            ArrayList<Player> guestTeamPlayers = new ArrayList<>();

            hostTeamPlayers = addPlayers(hostTeamName, matchLength);
            guestTeamPlayers = addPlayers(guestTeamName, matchLength);

            SoccerTeam[] soccerTeams = new SoccerTeam[2];
            soccerTeams[0] = new SoccerTeam(hostTeamName, countryHostTeam, hostCoachName, hostTeamPlayers);
            soccerTeams[1] = new SoccerTeam(guestTeamName, countryGuestTeam, guestCoachName, guestTeamPlayers);

            // create match
            Match match = new Match(matchLength, arbiterName, arbitratorAssistants, soccerTeams);

            // add match to database
            matchesData.addMatchToDatabase(match);
        } catch (NumberFormatException e) {
            userInterface.printErrorMessage("Wrong data format. Try again.");
        }
    }

    /**
     * A method that calls the method from the user interface to get information
     * about the match id.
     *
     * @return user input (match id)
     */
    private boolean searchMatchByID() {
        try {
            userInterface.askMatchId();
            inputTmp = Integer.parseInt(keyInput.nextLine());
            return matchesData.hasMatchInData(inputTmp);
        } catch(NumberFormatException e){
            userInterface.printErrorMessage("Bad input");
            return false;
        }
    }

    /**
     * The method calls the method from the user interface with information
     * about pressing Enter to continue the application. Waiting for input from
     * the user.
     */
    private void stopConsole() {
        userInterface.askUserForEnterKey();
        keyInput.nextLine();
    }

    /**
     * The method passes the file path to the database to open and read it.
     *
     * @param filePath path to the text file with the database
     * @throws IOException exception about bad file reading
     */
    public void openDataFile(String filePath) throws IOException {
        try {
            matchesData.readDataFromFile(filePath);
            userInterface.printFileOpened();
        } catch (WrongInputException e) {
            userInterface.printErrorMessage(e.getMessage());
        } catch (IOException e) {
            userInterface.printErrorMessage(e.getMessage());
        }
    }

    /**
     * The method that calls the program. It is also the main loop of the
     * program.
     *
     * @throws IOException
     */
    public void startProgram() throws IOException {
        userInterface.showAuthorName();
        MainMenuChoice userChoice = MainMenuChoice.VOID;

        do {
            userInterface.showMainMenu();

            boolean option = false;
            try {
                while (!option) {
                    userChoice = userChoice.getInputCode(keyInput.nextLine());
                    option = true;
                }
            } catch (WrongInputException e) {
                userInterface.printErrorMessage(e.getMessage());
            }

            switch (userChoice) {
                case SHOW_MATCHES:
                    if (matchesData.hasData()) {
                        userInterface.printNoDataStatement();
                    } else {
                        userInterface.showAllMatches(matchesData.getAllMatches());
                    }
                    break;
                case SAVE_TO_FILE:
                    matchesData.writeDataToFile(this.getFilePath());
                    userInterface.printFileSaved();
                    break;
                case READ_FROM_FILE:
                    this.openDataFile(this.getFilePath());
                    break;
                case SHOW_ONE_MATCH:
                    if (!this.searchMatchByID()) {
                        userInterface.matchSearchFailure();
                    } else {
                        userInterface.showOneMatch(matchesData.getMatchById(inputTmp));
                    }
                    break;
                case ADD_MATCH:
                    this.addNewMatch();
                    break;
                case DELETE_MATCH:
                    if (!this.searchMatchByID()) {
                        userInterface.printNoDataStatement();
                    } else {
                        matchesData.deleteMatchById(inputTmp);
                    }
                    break;
                case DELETE_DATABASE:
                    matchesData.deleteAllMatches();
                    break;
                case EXIT_APP:
                    exitApp = true;
                    break;

            }
            this.stopConsole();
        } while (!exitApp);
    }
}
