package pl.polsl.lab3.pawel.salicki.controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;
import java.io.IOException;
import java.util.Properties;

import pl.polsl.lab3.pawel.salicki.view.UserInterface;
import pl.polsl.lab3.pawel.salicki.view.MainMenuChoice;
import pl.polsl.lab3.pawel.salicki.tcpNetwork.ClientTCP;

/**
 * Main controller of program. This class mediates communication between the
 * user interface and the operation of the application.
 *
 * @author Paweł Salicki
 * @version 2.0
 */
public class MainController {

    /**
     * Network connection to client.
     */
    private ClientTCP cientConntection;

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
     * Port for connecting to server.
     */
    private String PORT;

    /**
     * Server Address for connecting to server;
     */
    private String serverAddress;

    /**
     * A basic constructor of the MainController class that sets fields to basic
     * values.
     */
    public MainController() {
        this.cientConntection = null;
        this.userInterface = new UserInterface();

        this.exitApp = false;

        this.keyInput = new Scanner(System.in);
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
     * The method passes the file path to the database on the server to open and
     * save to it data.
     *
     * @param filePath path to the text file where database will be save
     * @throws IOException exception when something will go wrong when save data
     * to file
     */
    private void saveDataToFile(String filePath) throws IOException {
        cientConntection.saveToFile(filePath);
        userInterface.printFileSaved();
    }

    /**
     * The method passes the file path to the database on the server to open and
     * read from it data.
     *
     * @param filePath path to the text file with the database
     * @throws IOException exception when something will go wrong wiile reading
     * from file
     */
    public void openDataFile(String filePath) throws IOException {
        cientConntection.readFromFile(filePath);
        userInterface.printFileOpened();
    }

    /**
     * A method that connects to the server.*
     */
    private void tryConnectToServer() {
        boolean connectedToServer = false;

        while (!connectedToServer) {
            try {
                this.preparePortAndAddress();
                String serverAddress = this.serverAddress + ":" + this.PORT;
                userInterface.connectingToServerInfo(serverAddress);
                cientConntection = new ClientTCP(this.serverAddress, Integer.parseInt(this.PORT));
                connectedToServer = true;
                userInterface.serverConnectSuccess();
            } catch (IOException e) {
                userInterface.errorConnectToServer();
                connectedToServer = false;
            }
        }
    }

    /**
     * The method asks the user about the path to the file.
     *
     * @return file path that user entered
     */
    private String getFilePath() {
        userInterface.askFilePath();
        return keyInput.nextLine();
    }

    /**
     * The task of this method is to handle the file which contains the server
     * address and the port to which the client will connect.
     */
    private void preparePortAndAddress() {
        Properties serverConfiguration = new Properties();

        String answerYN = "";
        do {
            this.userInterface.askCreateNewServerConfiguration();
            answerYN = this.keyInput.nextLine();
            answerYN = answerYN.toUpperCase();
        } while (!answerYN.equals("Y") && !answerYN.equals("N"));

        if (answerYN.equals("Y")) {
            this.userInterface.askServerIp();
            this.serverAddress = this.keyInput.nextLine();

            this.userInterface.askPort();
            this.PORT = this.keyInput.nextLine();

            serverConfiguration.setProperty("serverAddress", this.serverAddress);
            serverConfiguration.setProperty("PORT", this.PORT);

            try (FileOutputStream out = new FileOutputStream(".properties")) {
                serverConfiguration.store(out, "--Configuration--");
            } catch (IOException e) {
                System.err.println("Error occurred while creating new address and port");
                this.PORT = "0000";
                this.serverAddress = "0.0.0.0";
            }
        } else {
            try (FileInputStream in = new FileInputStream(".properties")) {
                serverConfiguration.load(in);
                this.PORT = serverConfiguration.getProperty("PORT");
                this.serverAddress = serverConfiguration.getProperty("serverAddress");
            } catch (IOException e) {
                System.err.println("Error occurred while creating new address and port. Firstly try to create new server configuration");
                this.PORT = "0000";
                this.serverAddress = "0.0.0.0";
            }
        }
    }

    /**
     * The method that calls the program. It is also the main loop of the
     * program.
     *
     * @throws IOException The method throws an exception about bad input
     * parameters.
     */
    public void startProgram() throws IOException {
        userInterface.showAuthorName();
        MainMenuChoice userChoice = MainMenuChoice.VOID;

        this.tryConnectToServer();

        do {
            userInterface.showMainMenu();

            boolean option = false;
            try {
                while (!option) {
                    userChoice = userChoice.getInputCode(keyInput.nextLine());
                    option = true;
                }
            } catch (NumberFormatException e) {
                userInterface.printErrorMessage(e.getMessage());
            }

            if (this.cientConntection != null) {

                switch (userChoice) {
                    case SHOW_MATCHES:
                        cientConntection.showMatches(this.userInterface);
                        break;
                    case SAVE_TO_FILE:
                        this.saveDataToFile(this.getFilePath());
                        userInterface.printFileSaved();
                        break;
                    case READ_FROM_FILE:
                        this.openDataFile(this.getFilePath());
                        break;
                    case ADD_MATCH:
                        cientConntection.addMatch(this.userInterface, this.keyInput);
                        break;
                    case DELETE_MATCH:
                        this.userInterface.askMatchId();
                        cientConntection.deleteMatch(keyInput.nextLine());
                        break;
                    case DELETE_DATABASE:
                        cientConntection.deleteDatabase();
                        break;
                    case SHOW_ONE_MATCH:
                        this.userInterface.askMatchId();
                        cientConntection.showOneMatch(this.userInterface, this.keyInput);
                        break;
                    case EXIT_APP:
                        exitApp = true;
                        break;
                }
            }
            this.stopConsole();
        } while (!exitApp);
    }
}
