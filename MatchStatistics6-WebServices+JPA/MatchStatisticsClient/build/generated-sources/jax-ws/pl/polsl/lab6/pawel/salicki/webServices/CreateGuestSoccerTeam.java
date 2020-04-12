
package pl.polsl.lab6.pawel.salicki.webServices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for createGuestSoccerTeam complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="createGuestSoccerTeam"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="guestTeamName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="guestTeamCountry" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="guestTeamCoachName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "createGuestSoccerTeam", propOrder = {
    "guestTeamName",
    "guestTeamCountry",
    "guestTeamCoachName"
})
public class CreateGuestSoccerTeam {

    protected String guestTeamName;
    protected String guestTeamCountry;
    protected String guestTeamCoachName;

    /**
     * Gets the value of the guestTeamName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGuestTeamName() {
        return guestTeamName;
    }

    /**
     * Sets the value of the guestTeamName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGuestTeamName(String value) {
        this.guestTeamName = value;
    }

    /**
     * Gets the value of the guestTeamCountry property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGuestTeamCountry() {
        return guestTeamCountry;
    }

    /**
     * Sets the value of the guestTeamCountry property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGuestTeamCountry(String value) {
        this.guestTeamCountry = value;
    }

    /**
     * Gets the value of the guestTeamCoachName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGuestTeamCoachName() {
        return guestTeamCoachName;
    }

    /**
     * Sets the value of the guestTeamCoachName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGuestTeamCoachName(String value) {
        this.guestTeamCoachName = value;
    }

}
