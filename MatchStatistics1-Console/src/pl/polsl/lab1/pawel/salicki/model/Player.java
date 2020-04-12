package pl.polsl.lab1.pawel.salicki.model;

/**
 * A class that stores information about a single player.
 *
 * @author Paweł Salicki
 * @version 1.0
 */
public class Player {

    /**
     * Player's name.
     */
    private final String playerName;

    /**
     * Number of goals scored.
     */
    private final int scoredGoals;

    /**
     * Number of fouls.
     */
    private final int fouls;
    
    /**
     * The minute of the match in which the player entered the field.
     */
    private final int entryTime;

    /**
     * The minute of the match in which the player left the field.
     */
    private final int leftTime;

    /**
     * Number of collected yellow cards.
     */
    private final int yellowCards;

    /**
     * Did the player get a red card.
     */
    private final boolean redCard;

    /**
     * Information whether the player participated in the entire match.
     */
    private final boolean playedWholeMatch;

    /**
     * Basic constructor initiating variables with basic values.
     */
    public Player() {
        this.playerName = "Unknown name";
        this.scoredGoals = 0;
        this.entryTime = 0;
        this.leftTime = 0;
        this.yellowCards = 0;
        this.fouls = 0;
        this.redCard = false;
        this.playedWholeMatch = false;
    }

    
    /**
     * Multi-parameter constructor initiating fields with appropriate values.
     * 
     * @param playerName name of the player
     * @param scoredGoals number of goals scored
     * @param playedWholeMatch boolean if player played on whole match
     * @param entryTime player's entry time on the field
     * @param leftTime player's left time from the field
     * @param yellowCards amount of yellow cards
     * @param redCard boolean if player got a red card
     * @param fouls amoutn of fouls
     */
    public Player(String playerName, int scoredGoals, boolean playedWholeMatch,
            int entryTime, int leftTime, int yellowCards, boolean redCard,
            int fouls) {
        this.playerName = playerName;
        this.scoredGoals = scoredGoals;
        this.playedWholeMatch = playedWholeMatch;
        this.fouls = fouls;
        
        if (playedWholeMatch) {
            this.entryTime = 0;
        } else {
            this.entryTime = entryTime;
        }
        this.leftTime = leftTime;

        this.yellowCards = yellowCards;
        this.redCard = redCard;
    }

    /**
     * A method of calculating the time a player spent while playing.
     *
     * @return player time on the field
     */
    public int calculatePlayerPlayedTime() {
        return this.leftTime - this.entryTime;
    }

    /**
     * A method that returns the number of yellow cards received by the player.
     *
     * @return yellowCards amount of yellow cards
     */
    public int getYellowCards() {
        return this.yellowCards;
    }

    /**
     * Method that returns the answer whether the player got a red card.
     *
     * @return redCard
     */
    public boolean getRedCard() {
        return this.redCard;
    }

    /**
     * The method returns the answer whether the player played throughout the
     * match.
     *
     * @return playedWholeMatch boolean if player played on the whole match
     */
    public boolean getPlayedWholeTime() {
        return this.playedWholeMatch;
    }

    /**
     * A method that returns the number of goals scored by a player.
     *
     * @return scoredGoals number of goals scored by the player
     */
    public int getScoredGoals() {
        return this.scoredGoals;
    }

    /**
     * A method that returns the entry time of a player.
     *
     * @return entryTime time the player enters the match
     */
    public int getEntryTime() {
        return this.entryTime;
    }

    /**
     * A method that returns the player's fouls number.
     *
     * @return amount of fouls
     */
    public int getFouls(){
        return this.fouls;
    }
    
    /**
     * A method that returns the time the player left the field.
     *
     * @return leftTime time when the player left the field
     */
    public int getLeftTime() {
        return this.leftTime;
    }

    /**
     * A method that returns the player's name.
     *
     * @return playerName player's name
     */
    public String getPlayerName() {
        return this.playerName;
    }
}
