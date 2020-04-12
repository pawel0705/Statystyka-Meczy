package pl.polsl.lab4.pawel.salicki.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThat;
import pl.polsl.lab4.pawel.salicki.exceptions.WrongInputException;
import pl.polsl.lab4.pawel.salicki.model.Database;
import pl.polsl.lab4.pawel.salicki.model.Match;

/**
 * Test case of Database methods
 *
 * @author Paweł Salicki
 * @version 1.0
 */
public class TestDatabase {

    /**
     * Instance of the database object for testing.
     */
    Database database;

    /**
     * Initializate database object.
     */
    @Before
    public void setup() {
        database = new Database();
    }

    /**
     * The method tests the correctness of matches added to the database.
     */
    @Test
    public void testAddMatchToDatabase() {

        // Check single matches
        // Given
        Match match1 = new Match();

        // When
        database.addMatchToDatabase(match1);

        // Then
        assertNotNull("Reference to null!", database.getAllMatches());
        assertSame("References do not indicate the same object!", database.getAllMatches().get(0), match1);

        // Given
        Match match2 = new Match();

        // When
        database.addMatchToDatabase(match2);

        // Then
        assertNotNull("Reference to null!", database.getAllMatches());
        assertSame("References do not indicate the same object!", database.getAllMatches().get(1), match2);

        // Check multiple matches
        // Given
        Match[] matches = new Match[2];

        // When
        matches[0] = match1;
        matches[1] = match2;

        // Then
        assertArrayEquals("Collections values ​​in both arrays are not identical!", matches,
                database.getAllMatches().toArray());
        
        // null reference
        // Given
        Match match3 = null;
        
        // When
        database.addMatchToDatabase(match3);
        
        // Then
        assertNull("Reference isn't null!", database.getAllMatches().get(2));
    }

    /**
     * A method that checks the correctness of a returned match by providing an
     * id.
     */
    @Test
    public void testGetMatchById() {
        int matchId;

        // Given
        Match match1 = new Match();

        // When
        matchId = match1.getMatchId();
        database.addMatchToDatabase(match1);

        // Then
        assertSame("References do not indicate the same object!", database.getMatchById(matchId), match1);

        // Given
        Match match2 = new Match();

        // When
        matchId = match2.getMatchId();

        // Then
        database.addMatchToDatabase(match2);
        assertSame("References do not indicate the same object!", database.getMatchById(matchId), match2);
    }

    /**
     * A method that checks the correctness of deleting a match from the
     * database by providing an id.
     */
    @Test
    public void testDeleteMatchById() {
        int matchId;

        // Given
        Match match1 = new Match();

        // When
        matchId = match1.getMatchId();
        database.addMatchToDatabase(match1);
        database.deleteMatchById(matchId);

        // Then
        assertNotSame("References point to the same object!", database.getMatchById(matchId), match1);

        // Given
        Match match2 = new Match();

        // When
        matchId = match2.getMatchId();
        database.addMatchToDatabase(match2);
        database.deleteMatchById(matchId);

        // Then
        assertNotSame("References point to the same object!", database.getMatchById(matchId), match2);
    }

    /**
     * The method checking the return of a result for the method checking
     * whether the database has data.
     */
    @Test
    public void testHasData() {
        // Given
        Match match = new Match();

        // When
        database.addMatchToDatabase(match);

        // Then
        assertFalse("Database shouldn't empty!", database.hasData());

        // New database
        Database database2 = new Database();
        assertTrue("Database should be empty!", database2.hasData());
    }

    /**
     * A method that checks if a match with the given id is in the database.
     */
    @Test
    public void testHasMatchInData() {
        // Given
        Match match = new Match();

        // When
        int matchId = match.getMatchId();
        database.addMatchToDatabase(match);

        // Then
        assertTrue("The database should have this data.", database.hasMatchInData(matchId));

        // Check wrong id
        matchId = -1;
        assertFalse("The database shouldn't have this data", database.hasMatchInData(matchId));
    }

    /**
     * A method that checks the method parsing a string for type int.
     */
    @Test
    public void testTryParseToInt() {

        // Try parse 0
        try {
            assertEquals("The function should return 0 as a number.", database.tryParseToInt("0"), 0);
        } catch (WrongInputException e) {
            fail("Parsing \"0\" fails");
        }

        // Try parse negative number
        try {
            assertEquals("The function should return 0 as a number.", database.tryParseToInt("-10"), -10);
        } catch (WrongInputException e) {
            fail("Parsing \"-10\" fails");
        }

        // Try parse positive number
        try {
            assertEquals("The function should return 0 as a number.", database.tryParseToInt("5"), 5);
        } catch (WrongInputException e) {
            fail("Parsing \"5\" fails");
        }

        // Try parse wrong string input
        try {
            database.tryParseToInt("wrong input");
            fail("An exception should be thrown when the string input is wrong (not number)");
        } catch (WrongInputException e) {
        }
    }

    /**
     * The method checks the correctness of the method responsible for cleaning
     * the database.
     */
    @Test
    public void testDeleteAllMatches() {

        // Delete all mathes from main database
        database.deleteAllMatches();
        assertEquals("Database should be empty!", database.getNumberOfMatches(), 0);

        // Create new database and delete matches
        Database database2 = new Database();
        database2.deleteAllMatches();
        assertEquals("Database should be empty!", database2.getNumberOfMatches(), 0);

        // Create new database, add new match and delete matches
        Match match = new Match();
        database2.addMatchToDatabase(match);
        database2.deleteAllMatches();
        assertEquals("Database should be empty!", database2.getNumberOfMatches(), 0);
        
        // create match with null reference
        Match match2 = null;
        database2.addMatchToDatabase(match2);
        database2.deleteAllMatches();
        assertEquals("Database should be empty!", database2.getNumberOfMatches(), 0);
    }

    /**
     * The method checks the correctness of writing to a file.
     */
    @Test
    public void testWriteDataToFile() {

        // Try write to file
        try {
            database.writeDataToFile("TestFileName.txt");
        } catch (IOException e) {
            fail("The file should be created for the database.");
        }
    }

    /**
     * The method that validates the method responsible for reading the database
     * from the file.
     */
    @Test
    public void testReadDataFromFile() {
        // Try open file than not exists
        try {
            database.readDataFromFile("fileThatNotExists.wrong");
            fail("The not exiting file should not be read!");
        } catch (WrongInputException | IOException e) {
        }

        // Try open file with wrong data input
        try {
            database.readDataFromFile("testFileWRONG.txt");
            fail("The file with wrong input data should not be read!");
        } catch (WrongInputException | IOException e) {
        }

        // Try open file that exists
        try {
            database.readDataFromFile("testFile.txt");
        } catch (WrongInputException e) {
            fail("Wrong file data!");
        } catch (IOException e) {
            fail("Wrong file path!");
        }
    }

    /**
     * The method checks the correctness of raising an exception in the method
     * responsible for reading the data file.
     */
    @Test
    public void testOfExceptionReadDataFromFile() {
        Exception exception = null;
        try {
            database.readDataFromFile("fileThatNotExists.wrong");
            database.readDataFromFile("testFileWRONG.txt");
        } catch (WrongInputException | IOException e) {
            exception = e;
        }

        assertThat("Wrong type of the exception!", exception,
                anyOf(is(instanceOf(WrongInputException.class)), is(instanceOf(IOException.class))));
    }

}
