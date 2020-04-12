package pl.polsl.lab2.pawel.salicki.controller;

import java.io.IOException;

/**
 * Entry point of application. The MatchStatistics class contains the main
 * method from which the program starts.
 *
 *
 * @author Paweł Salicki
 * @version 1.0
 */
public class MatchStatistics {

    /**
     * Starting main method.
     *
     * @param args file.txt path with database about matches
     */
    public static void main(String[] args) {

        MainController mainController = new MainController();

        try {
            if (args.length > 0 && args[0].equals("-f")) {
                mainController.openDataFile(args[1]);
            }
            mainController.startProgram();

        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Bad arguments! Please restart the application");
        } catch (IOException e) {
            e.getMessage();
            System.err.println("File not read! Please restart the application");
        }
    }
}
