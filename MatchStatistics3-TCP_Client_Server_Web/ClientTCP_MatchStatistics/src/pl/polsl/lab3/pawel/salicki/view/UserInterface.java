package pl.polsl.lab3.pawel.salicki.view;

/**
 * UserInterface Class. The class used to display relevant messages to the user.
 *
 * @author Paweł Salicki
 * @version 2.0
 */
public class UserInterface {

    /**
     * Show application's author name.
     */
    public void showAuthorName() {
        System.out.println("Match Statistics application by Paweł Salicki");
    }

    /**
     * The method displays the main menu to the user.
     */
    public void showMainMenu() {
        System.out.println("*--MAIN MENU--*");
        for (MainMenuChoice menuChoice : MainMenuChoice.values()) {
            if (menuChoice == MainMenuChoice.VOID) {
                continue;
            }

            System.out.format("%s. %s.\n", menuChoice.getChoice(),
                    menuChoice.getMessage());
        }
        System.out.println("*-------------*");
        System.out.print("Enter option: ");
    }

    /**
     * A method that displays a message asking the arbitrator's name for a user.
     */
    public void askArbiterName() {
        System.out.print("Name of arbiter: ");
    }

    /**
     * Method that displays a message asking for the destination path to the
     * file.
     */
    public void askFilePath() {
        System.out.print("Enter file path: ");
    }

    /**
     * Method that displays a message asking to enter the player's name.
     *
     * @param teamName name of the team the player belongs to
     * @param actualNr current number of the player whose name is being entered
     * @param maxPlayers number of players to enter
     */
    public void askPlayerName(String teamName, int actualNr, int maxPlayers) {
        System.out.format("%s of %s: Player name of team %s: ", actualNr,
                maxPlayers, teamName);
    }

    /**
     * Method asking the user about the number of goals scored by a given
     * player.
     *
     * @param playerName name of the player to whom the request relates
     */
    public void askPlayerGoalsNr(String playerName) {
        System.out.format("How many goals did %s score?: ", playerName);
    }

    /**
     * Method asking the user to enter the duration of the match.
     */
    public void askTimeMatch() {
        System.out.print("How many minutes did the whole match last?: ");
    }

    /**
     * A method that asks the user to enter a team name.
     *
     * @param teamVersion determines whether the team is the host or the guest
     */
    public void askTeamName(String teamVersion) {
        System.out.format("%s team name: ", teamVersion);
    }

    /**
     * A method that asks the user to enter the name of the team coach.
     *
     * @param teamName name of the team the trainer belongs to
     */
    public void askCoachNameOfTeam(String teamName) {
        System.out.format("%s's team coach name: ", teamName);
    }

    /**
     * A method that asks the user about the country of origin of the introduced
     * team.
     *
     * @param teamName name of the team to which the request belongs
     */
    public void askTeamCountry(String teamName) {
        System.out.format("Country of team %s: ", teamName);
    }

    /**
     * A method that asks the user how much yellow player has received during
     * the match.
     *
     * @param playerName the name of the player to whom the question applies
     */
    public void askPlayerYellowCards(String playerName) {
        System.out.format("How much did %s get yellow cards?: ", playerName);
    }

    /**
     * The method asks the user if the given player got a red card.
     *
     * @param playerName the name of the player to whom the question applies
     */
    public void askPlayerRedCard(String playerName) {
        System.out.format("Did the player - %s get a red card? (y/n): ",
                playerName);
    }

    /**
     * The method asks the user to type amount of player's fouls.
     *
     * @param playerName the name of the player to whom the question applies
     */
    public void askPlayerFoulsAmount(String playerName) {
        System.out.format("How many fouls a player - %s has made?: ",
                playerName);
    }

    /**
     * A method that asks the user if a player has participated in the entire
     * match.
     *
     * @param playerName the name of the player to whom the question applies
     */
    public void askPlayerPlayedWholeMatch(String playerName) {
        System.out.format("Has the player - (%s) played all the time? (y/n): ",
                playerName);
    }

    /**
     * A method that asks the user what minute the player entered the field.
     *
     * @param playerName the name of the player to whom the question applies
     * @param maxMinute allowable time period in which the competitor could
     * participate
     */
    public void askPlayerEnteredTime(String playerName, int maxMinute) {
        System.out.format("In what minute did %s enter the match? (Max %smin): ",
                playerName, maxMinute);
    }

    /**
     * A method that displays to the user a message about writing to a file.
     */
    public void printFileSaved() {
        System.out.println("File saved...");
    }

    /**
     * Method that sends a message to the system stream with an error received.
     *
     * @param errMessage error message
     */
    public void printErrorMessage(String errMessage) {
        System.err.println(errMessage);
    }

    /**
     * A method that displays to the user a message about opened file.
     */
    public void printFileOpened() {
        System.out.println("File ready...");
    }

    /**
     * A method that displays text to the user with a message asking them to
     * press the Enter key.
     */
    public void askUserForEnterKey() {
        System.out.println("Press Enter to continue...");
    }

    /**
     * A method that asks the user what minute the player left the field.
     *
     * @param playerName the name of the player to whom the question applies
     * @param minMinute minimum option time period
     * @param maxMinute maximum time period of the option
     */
    public void askPlayerLeftTime(String playerName, int minMinute, int maxMinute) {
        System.out.format("In what minute did %s left the match? (Min %smin, Max %smin): ",
                playerName, minMinute, maxMinute);
    }

    /**
     * A method that asks the user how many people are going to enter.
     *
     * @param person the type of person whose number is to be entered
     */
    public void askHowManyPeopleEnter(String person) {
        System.out.format("How many %s?: ", person);
    }

    /**
     * Method asking the user to enter the match id.
     */
    public void askMatchId() {
        System.out.print("Enter match ID: ");
    }

    /**
     * The method informs the user about a failed database search.
     */
    public void matchSearchFailure() {
        System.out.println("No match found with given id.");
    }

    /**
     * A method that asks you to enter the names of people in the correct order.
     */
    public void askPeopleEnter() {
        System.out.println("Write one name and surname then press Enter key:");
    }

    /**
     * A method that displays information to the user on how many things are
     * left to enter.
     *
     * @param number current number of the option being entered
     * @param max range of options remaining to be entered
     */
    public void printNumberList(int number, int max) {
        System.out.format("%s from %s: ", number, max);
    }

    /**
     * Method informing the user about an empty database.
     */
    public void printNoDataStatement() {
        System.out.println("!NO MATCHES IN THE DATABASE!");
        System.out.println("Add a new match first!");
    }

    /**
     * The method displays the exact statistics of one selected match.
     *
     *
     * @param match informations about match
     * @param hostPlayers informations about host team players
     * @param hostTeam informations about host team
     * @param guestPlayers informations about guest team players
     * @param guestTeam informations about guest team
     * @param assistants informations about arbitrator assistants
     */
    public void showOneMatch(String[] match, String[] hostPlayers, String[] hostTeam,
            String[] guestPlayers, String[] guestTeam, String[] assistants) {
        System.out.format("#Match ID: %s\n", match[0]);
        System.out.format("#The length of the match: %smin\n", match[1]);
        System.out.format("#Arbiter name: %s\n", match[2]);
        System.out.println("#Arbitrator assistants:");

        for (String assistant : assistants) {
            System.out.format("-%s\n", assistant);
        }

        this.printTeamInfo(hostTeam);
        this.printPlayerInfo(hostPlayers);
        this.printTeamInfo(guestTeam);
        this.printPlayerInfo(guestPlayers);
    }

    /**
     * Method that displays information about teams on the screen.
     *
     * @param team array of strings with information about team
     */
    private void printTeamInfo(String[] team) {
        System.out.format("Team name: %s\n", team[0]);
        System.out.format("Coach of team %s: %s\n", team[0],
                team[1]);
        System.out.format("Team's country: %s\n", team[2]);
    }

    /**
     * Method that displays information about players on the screen.
     *
     * @param players arraty of informations about players
     */
    private void printPlayerInfo(String[] players) {
        int playerCounter = 0;
        for (int i = 0; i < players.length; i++) {
            playerCounter++;
            System.out.format("%s. Player name: %s\n", playerCounter, players[i]);
            System.out.format("%s. Goals scored: %s\n", playerCounter, players[++i]);
            System.out.format("%s. Entered the game on %s min\n", playerCounter, players[++i]);
            System.out.format("%s. Left the game on %s min\n", playerCounter, players[++i]);
            System.out.format("%s. Amount of yellow cards: %s\n", playerCounter, players[++i]);
            System.out.format("%s. Player time on the field: %smin\n", playerCounter, players[++i]);

            if (players[++i].equals("Y")) {
                System.out.format("%s. This player got a red card\n", playerCounter);
            }
        }
    }

    /**
     * The method displays all basic match statistics from the database.
     *
     * @param matches array of matches from the database to display
     */
    public void showAllMatches(String... matches) {
        System.out.println("*--ALL MATCHES STATISTICS IN DATABASE--*");
        int matchNr = 0;
        for (int i = 0; i < matches.length; i++) {

            matchNr++;
            System.out.format("*--MATCH NR:. %s: --*\n", matchNr);
            System.out.format("#Match ID: %s\n", matches[i]);
            System.out.format("#Arbiter name: %s\n", matches[++i]);
            System.out.format("#The length of the match: %smin\n", matches[++i]);
            System.out.println("HOST TEAM \t GUEST TEAM");
            System.out.format("%s  vs  %s\n", matches[++i],
                    matches[++i]);
            System.out.format("Place of the match: %s\n", matches[++i]);
            System.out.format("Fouls in match: %s\n", matches[++i]);
            System.out.format("Match result: %s-%s\n", matches[++i],
                    matches[++i]);
            System.out.format("Game status: %s\n", matches[++i]);
        }
    }

    /**
     * A method asking the user to enter an ip address.
     */
    public void askServerIp() {
        System.out.print("Please enter server adress (WITHOUT port): ");
    }

    /**
     * A method asking the user to enter a port.
     */
    public void askPort() {
        System.out.print("Please enter server PORT: ");
    }

    /**
     * The method that displays a message to the user that the connection to the
     * server has failed.
     */
    public void errorConnectToServer() {
        System.err.println("Connecting to server impossible! Try again!");
    }

    /**
     * The method that displays a message to the user about successful
     * connection to the server.
     */
    public void serverConnectSuccess() {
        System.out.println("Succesfully connected to the server.");
    }

    /**
     * A method that displays a message to the user which server is attempting
     * to connect.
     *
     * @param serverAdress server address
     */
    public void connectingToServerInfo(String serverAdress) {
        System.out.format("Connecting to server %s... Please wait.\n", serverAdress);
    }

    /**
     * The method displays a message to the user which port has been read.
     *
     * @param PORT server port
     */
    public void printPORT(String PORT) {
        System.out.format("Entered port: %s", PORT);
    }

    /**
     * The method displays a message to the user which server address has been
     * read.
     *
     * @param serverAddress server address
     */
    public void printServerAddress(String serverAddress) {
        System.out.format("Entered server address: %s", serverAddress);
    }

    /**
     * A method asking the user if he wants to configure a new server
     * connection.
     */
    public void askCreateNewServerConfiguration() {
        System.out.print("Configure new server adress with port (create new .properties file)? (y/n): ");
    }
}
