package pl.polsl.lab6.pawel.salicki.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Players table JPA.
 * 
 * @author Paweł Salicki
 * @version 1.0
 */
@Entity
public class Players implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private String name;

    private boolean playedWholeMatch;

    private int minuteEntered;

    private int minuteLeft;

    private int goals;

    private int fouls;

    private int yellowCards;

    private boolean redCard;

    private int idTeam;

    /**
     * Get the value of idTeam
     *
     * @return the value of idTeam
     */
    public int getIdTeam() {
        return idTeam;
    }

    /**
     * Set the value of idTeam
     *
     * @param idTeam new value of idTeam
     */
    public void setIdTeam(int idTeam) {
        this.idTeam = idTeam;
    }

    /**
     * Get the value of redCard
     *
     * @return the value of redCard
     */
    public boolean getRedCard() {
        return redCard;
    }

    /**
     * Set the value of redCard
     *
     * @param redCard new value of redCard
     */
    public void setRedCard(boolean redCard) {
        this.redCard = redCard;
    }

    /**
     * Get the value of yellowCards
     *
     * @return the value of yellowCards
     */
    public int getYellowCards() {
        return yellowCards;
    }

    /**
     * Set the value of yellowCards
     *
     * @param yellowCards new value of yellowCards
     */
    public void setYellowCards(int yellowCards) {
        this.yellowCards = yellowCards;
    }

    /**
     * Get the value of fouls
     *
     * @return the value of fouls
     */
    public int getFouls() {
        return fouls;
    }

    /**
     * Set the value of fouls
     *
     * @param fouls new value of fouls
     */
    public void setFouls(int fouls) {
        this.fouls = fouls;
    }

    /**
     * Get the value of goals
     *
     * @return the value of goals
     */
    public int getGoals() {
        return goals;
    }

    /**
     * Set the value of goals
     *
     * @param goals new value of goals
     */
    public void setGoals(int goals) {
        this.goals = goals;
    }

    /**
     * Get the value of minuteLeft
     *
     * @return the value of minuteLeft
     */
    public int getMinuteLeft() {
        return minuteLeft;
    }

    /**
     * Set the value of minuteLeft
     *
     * @param minuteLeft new value of minuteLeft
     */
    public void setMinuteLeft(int minuteLeft) {
        this.minuteLeft = minuteLeft;
    }

    /**
     * Get the value of minuteEntered
     *
     * @return the value of minuteEntered
     */
    public int getMinuteEntered() {
        return minuteEntered;
    }

    /**
     * Set the value of minuteEntered
     *
     * @param minuteEntered new value of minuteEntered
     */
    public void setMinuteEntered(int minuteEntered) {
        this.minuteEntered = minuteEntered;
    }

    /**
     * Get the value of playedWholeMatch
     *
     * @return the value of playedWholeMatch
     */
    public boolean isPlayedWholeMatch() {
        return playedWholeMatch;
    }

    /**
     * Set the value of playedWholeMatch
     *
     * @param playedWholeMatch new value of playedWholeMatch
     */
    public void setPlayedWholeMatch(boolean playedWholeMatch) {
        this.playedWholeMatch = playedWholeMatch;
    }

    /**
     * Get the value of name
     *
     * @return the value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the value of name
     *
     * @param name new value of name
     */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Players)) {
            return false;
        }
        Players other = (Players) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pl.polsl.lab6.pawel.salicki.entity.Players[ id=" + id + " ]";
    }
    
}
