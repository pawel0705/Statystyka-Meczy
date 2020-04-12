package pl.polsl.lab1.pawel.salicki.view;

import pl.polsl.lab1.pawel.salicki.exceptions.WrongInputException;
import pl.polsl.lab1.pawel.salicki.model.Parsable;

/**
 * Mian Menu enum class. The class is responsible for selecting options in the
 * main menu.
 *
 * @author Paweł Salicki
 * @version 1.0
 */
public enum MainMenuChoice implements Parsable {

    /**
     * Choice of options displayed in the user's main menu.
     */
    VOID(0, "Unknown operation"),
    SHOW_MATCHES(1, "Show all basic matches statistics"),
    SAVE_TO_FILE(2, "Save statistics to file"),
    READ_FROM_FILE(3, "Read statistics from file"),
    SHOW_ONE_MATCH(4, "Show one match advanced statistics"),
    ADD_MATCH(5, "Add one new match"),
    DELETE_MATCH(6, "Delete one match"),
    DELETE_DATABASE(7, "Delete all matches"),
    EXIT_APP(8, "Exit application");

    /**
     * Option number from menu list.
     */
    private int choice;

    /**
     * Description of options from the main menu.
     */
    private String userMessage;

    /**
     * Setting starting parameters block.
     */
    {
        choice = 0;
        userMessage = "Unknown";
    }

    /**
     * Multi-parameter constructor of MainMenuChoice Enum class.
     *
     * @param choice selected option from the menu list by user
     * @param userMessage text informing the user what a given option does
     */
    MainMenuChoice(int choice, String userMessage) {
        this.userMessage = userMessage;
        this.choice = choice;
    }

    /**
     * A method that converts a received string to an integer.
     *
     * @param choice choosing an option from the menu
     * @return converted number
     */
    @Override
    public int tryParseToInt(String choice){
        try {
            return Integer.parseInt(choice);
        } catch (NumberFormatException e) {
            return VOID.choice;
        }
    }

    /**
     * A method that returns a selection code.
     *
     * @return selected key code
     */
    public int getChoice() {
        return this.choice;
    }

    /**
     * A method that returns selected message for user.
     *
     * @return message for user
     */
    public String getMessage() {
        return this.userMessage;
    }

    /**
     * A method that sets the user's choice.
     *
     * @param choice menu option from input
     * @return menuChoice selected option from the main menu
     * @throws WrongInputException exception caused due to incorrect option
     * selection
     */
    public MainMenuChoice getInputCode(String choice) throws WrongInputException {

        int choiceTmp = tryParseToInt(choice);

        for (MainMenuChoice menuChoice : MainMenuChoice.values()) {
            if (menuChoice.choice == choiceTmp) {
                return menuChoice;
            }
        }
        throw new WrongInputException("Wrong key code");
    }
}
