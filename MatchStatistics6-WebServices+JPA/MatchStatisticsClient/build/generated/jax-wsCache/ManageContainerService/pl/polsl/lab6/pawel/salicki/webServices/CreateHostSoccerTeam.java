
package pl.polsl.lab6.pawel.salicki.webServices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for createHostSoccerTeam complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="createHostSoccerTeam"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="hostTeamName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="hostTeamCountry" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="hostTeamCoachName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "createHostSoccerTeam", propOrder = {
    "hostTeamName",
    "hostTeamCountry",
    "hostTeamCoachName"
})
public class CreateHostSoccerTeam {

    protected String hostTeamName;
    protected String hostTeamCountry;
    protected String hostTeamCoachName;

    /**
     * Gets the value of the hostTeamName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHostTeamName() {
        return hostTeamName;
    }

    /**
     * Sets the value of the hostTeamName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHostTeamName(String value) {
        this.hostTeamName = value;
    }

    /**
     * Gets the value of the hostTeamCountry property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHostTeamCountry() {
        return hostTeamCountry;
    }

    /**
     * Sets the value of the hostTeamCountry property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHostTeamCountry(String value) {
        this.hostTeamCountry = value;
    }

    /**
     * Gets the value of the hostTeamCoachName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHostTeamCoachName() {
        return hostTeamCoachName;
    }

    /**
     * Sets the value of the hostTeamCoachName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHostTeamCoachName(String value) {
        this.hostTeamCoachName = value;
    }

}
