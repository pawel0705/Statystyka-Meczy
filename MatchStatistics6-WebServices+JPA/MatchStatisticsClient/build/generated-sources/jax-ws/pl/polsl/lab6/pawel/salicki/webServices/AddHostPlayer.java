
package pl.polsl.lab6.pawel.salicki.webServices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for addHostPlayer complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="addHostPlayer"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="playerHostName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="playerHostGoals" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="playerHostEnteredMinute" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="playerHostLeftMinute" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="playerHostYellowCards" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="playerHostFouls" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="matchLength" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="playerHostRedCards" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "addHostPlayer", propOrder = {
    "playerHostName",
    "playerHostGoals",
    "playerHostEnteredMinute",
    "playerHostLeftMinute",
    "playerHostYellowCards",
    "playerHostFouls",
    "matchLength",
    "playerHostRedCards"
})
public class AddHostPlayer {

    protected String playerHostName;
    protected int playerHostGoals;
    protected int playerHostEnteredMinute;
    protected int playerHostLeftMinute;
    protected int playerHostYellowCards;
    protected int playerHostFouls;
    protected int matchLength;
    protected int playerHostRedCards;

    /**
     * Gets the value of the playerHostName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlayerHostName() {
        return playerHostName;
    }

    /**
     * Sets the value of the playerHostName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlayerHostName(String value) {
        this.playerHostName = value;
    }

    /**
     * Gets the value of the playerHostGoals property.
     * 
     */
    public int getPlayerHostGoals() {
        return playerHostGoals;
    }

    /**
     * Sets the value of the playerHostGoals property.
     * 
     */
    public void setPlayerHostGoals(int value) {
        this.playerHostGoals = value;
    }

    /**
     * Gets the value of the playerHostEnteredMinute property.
     * 
     */
    public int getPlayerHostEnteredMinute() {
        return playerHostEnteredMinute;
    }

    /**
     * Sets the value of the playerHostEnteredMinute property.
     * 
     */
    public void setPlayerHostEnteredMinute(int value) {
        this.playerHostEnteredMinute = value;
    }

    /**
     * Gets the value of the playerHostLeftMinute property.
     * 
     */
    public int getPlayerHostLeftMinute() {
        return playerHostLeftMinute;
    }

    /**
     * Sets the value of the playerHostLeftMinute property.
     * 
     */
    public void setPlayerHostLeftMinute(int value) {
        this.playerHostLeftMinute = value;
    }

    /**
     * Gets the value of the playerHostYellowCards property.
     * 
     */
    public int getPlayerHostYellowCards() {
        return playerHostYellowCards;
    }

    /**
     * Sets the value of the playerHostYellowCards property.
     * 
     */
    public void setPlayerHostYellowCards(int value) {
        this.playerHostYellowCards = value;
    }

    /**
     * Gets the value of the playerHostFouls property.
     * 
     */
    public int getPlayerHostFouls() {
        return playerHostFouls;
    }

    /**
     * Sets the value of the playerHostFouls property.
     * 
     */
    public void setPlayerHostFouls(int value) {
        this.playerHostFouls = value;
    }

    /**
     * Gets the value of the matchLength property.
     * 
     */
    public int getMatchLength() {
        return matchLength;
    }

    /**
     * Sets the value of the matchLength property.
     * 
     */
    public void setMatchLength(int value) {
        this.matchLength = value;
    }

    /**
     * Gets the value of the playerHostRedCards property.
     * 
     */
    public int getPlayerHostRedCards() {
        return playerHostRedCards;
    }

    /**
     * Sets the value of the playerHostRedCards property.
     * 
     */
    public void setPlayerHostRedCards(int value) {
        this.playerHostRedCards = value;
    }

}
