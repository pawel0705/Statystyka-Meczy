
package pl.polsl.lab6.pawel.salicki.webServices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for matches complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="matches"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="arbiternamematch" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="guestteamid" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="hostteamid" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="lengthmatch" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "matches", propOrder = {
    "arbiternamematch",
    "guestteamid",
    "hostteamid",
    "id",
    "lengthmatch"
})
public class Matches {

    protected String arbiternamematch;
    protected Integer guestteamid;
    protected Integer hostteamid;
    protected Long id;
    protected Integer lengthmatch;

    /**
     * Gets the value of the arbiternamematch property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArbiternamematch() {
        return arbiternamematch;
    }

    /**
     * Sets the value of the arbiternamematch property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArbiternamematch(String value) {
        this.arbiternamematch = value;
    }

    /**
     * Gets the value of the guestteamid property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getGuestteamid() {
        return guestteamid;
    }

    /**
     * Sets the value of the guestteamid property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setGuestteamid(Integer value) {
        this.guestteamid = value;
    }

    /**
     * Gets the value of the hostteamid property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getHostteamid() {
        return hostteamid;
    }

    /**
     * Sets the value of the hostteamid property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setHostteamid(Integer value) {
        this.hostteamid = value;
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
     * Gets the value of the lengthmatch property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getLengthmatch() {
        return lengthmatch;
    }

    /**
     * Sets the value of the lengthmatch property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setLengthmatch(Integer value) {
        this.lengthmatch = value;
    }

}
