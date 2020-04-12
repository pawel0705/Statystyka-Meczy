package pl.polsl.lab5.pawel.salicki.exceptions;

/**
 * Exception informing about choosing the wrong option.
 *
 * @author Paweł Salicki
 * @version 1.0
 */
public class WrongInputException extends Exception {

    /**
     * One parameter constructor with error message.
     *
     * @param message error display message
     */
    public WrongInputException(String message) {
        super(message);
    }

    /**
     * Method that gives information abour error.
     *
     * @return error message
     */
    @Override
    public String getMessage() {
        return "Error: Wrong input given";
    }
    
    /**
     * The method display the exception information in the user's console.
     */
    public void inputErrorMessage(){
        System.err.println("Wrong input!");
    }
}
