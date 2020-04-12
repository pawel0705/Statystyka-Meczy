
package pl.polsl.lab6.pawel.salicki.webServices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for team complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="team"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="coachnameteam" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="countrynameteam" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="nameteam" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "team", propOrder = {
    "coachnameteam",
    "countrynameteam",
    "id",
    "nameteam"
})
public class Team {

    protected String coachnameteam;
    protected String countrynameteam;
    protected Long id;
    protected String nameteam;

    /**
     * Gets the value of the coachnameteam property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCoachnameteam() {
        return coachnameteam;
    }

    /**
     * Sets the value of the coachnameteam property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCoachnameteam(String value) {
        this.coachnameteam = value;
    }

    /**
     * Gets the value of the countrynameteam property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCountrynameteam() {
        return countrynameteam;
    }

    /**
     * Sets the value of the countrynameteam property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCountrynameteam(String value) {
        this.countrynameteam = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setId(Long value) {
        this.id = value;
    }

    /**
     * Gets the value of the nameteam property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNameteam() {
        return nameteam;
    }

    /**
     * Sets the value of the nameteam property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNameteam(String value) {
        this.nameteam = value;
    }

}
