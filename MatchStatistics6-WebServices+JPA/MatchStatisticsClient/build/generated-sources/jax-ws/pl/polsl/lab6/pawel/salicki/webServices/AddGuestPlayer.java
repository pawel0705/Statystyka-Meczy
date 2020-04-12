
package pl.polsl.lab6.pawel.salicki.webServices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for addGuestPlayer complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="addGuestPlayer"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="playerGuestName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="playerGuestGoals" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="playerGuestEnteredMinute" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="playerGuestLeftMinute" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="playerGuestYellowCards" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="playerGuestFouls" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="matchLength" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="playerGuestRedCards" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "addGuestPlayer", propOrder = {
    "playerGuestName",
    "playerGuestGoals",
    "playerGuestEnteredMinute",
    "playerGuestLeftMinute",
    "playerGuestYellowCards",
    "playerGuestFouls",
    "matchLength",
    "playerGuestRedCards"
})
public class AddGuestPlayer {

    protected String playerGuestName;
    protected int playerGuestGoals;
    protected int playerGuestEnteredMinute;
    protected int playerGuestLeftMinute;
    protected int playerGuestYellowCards;
    protected int playerGuestFouls;
    protected int matchLength;
    protected int playerGuestRedCards;

    /**
     * Gets the value of the playerGuestName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlayerGuestName() {
        return playerGuestName;
    }

    /**
     * Sets the value of the playerGuestName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlayerGuestName(String value) {
        this.playerGuestName = value;
    }

    /**
     * Gets the value of the playerGuestGoals property.
     * 
     */
    public int getPlayerGuestGoals() {
        return playerGuestGoals;
    }

    /**
     * Sets the value of the playerGuestGoals property.
     * 
     */
    public void setPlayerGuestGoals(int value) {
        this.playerGuestGoals = value;
    }

    /**
     * Gets the value of the playerGuestEnteredMinute property.
     * 
     */
    public int getPlayerGuestEnteredMinute() {
        return playerGuestEnteredMinute;
    }

    /**
     * Sets the value of the playerGuestEnteredMinute property.
     * 
     */
    public void setPlayerGuestEnteredMinute(int value) {
        this.playerGuestEnteredMinute = value;
    }

    /**
     * Gets the value of the playerGuestLeftMinute property.
     * 
     */
    public int getPlayerGuestLeftMinute() {
        return playerGuestLeftMinute;
    }

    /**
     * Sets the value of the playerGuestLeftMinute property.
     * 
     */
    public void setPlayerGuestLeftMinute(int value) {
        this.playerGuestLeftMinute = value;
    }

    /**
     * Gets the value of the playerGuestYellowCards property.
     * 
     */
    public int getPlayerGuestYellowCards() {
        return playerGuestYellowCards;
    }

    /**
     * Sets the value of the playerGuestYellowCards property.
     * 
     */
    public void setPlayerGuestYellowCards(int value) {
        this.playerGuestYellowCards = value;
    }

    /**
     * Gets the value of the playerGuestFouls property.
     * 
     */
    public int getPlayerGuestFouls() {
        return playerGuestFouls;
    }

    /**
     * Sets the value of the playerGuestFouls property.
     * 
     */
    public void setPlayerGuestFouls(int value) {
        this.playerGuestFouls = value;
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
     * Gets the value of the playerGuestRedCards property.
     * 
     */
    public int getPlayerGuestRedCards() {
        return playerGuestRedCards;
    }

    /**
     * Sets the value of the playerGuestRedCards property.
     * 
     */
    public void setPlayerGuestRedCards(int value) {
        this.playerGuestRedCards = value;
    }

}
