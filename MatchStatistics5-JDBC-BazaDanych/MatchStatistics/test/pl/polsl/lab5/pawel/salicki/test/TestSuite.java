package pl.polsl.lab5.pawel.salicki.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Test suite indicting the test engine and classes containg unit tests.
 *
 * @author Paweł Salicki
 * @version 1.0
 */
@RunWith(Suite.class)
@SuiteClasses({TestDatabase.class,
    TestMatch.class,
    TestPlayer.class,
    TestSoccerTeam.class
})
public class TestSuite {
}
