package pl.polsl.lab6.pawel.salicki.model;

import pl.polsl.lab6.pawel.salicki.exceptions.WrongInputException;

/**
 * Changes the string to a number.
 *
 * @author Paweł Salicki
 * @version 1.0
 */
public interface Parsable {

    /**
     * The method converts the received string into a number. Returns an
     * exception if it fails.
     *
     * @param text string to be converted to a number
     * @return the converted number
     * @throws WrongInputException throws an exception when the number is not
     * converted
     */
    public int tryParseToInt(String text) throws WrongInputException, NumberFormatException;
}
