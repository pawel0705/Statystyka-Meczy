
package pl.polsl.lab6.pawel.salicki.webServices;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for addNewMatch complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="addNewMatch"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="matchLength" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="arbiterName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="arbitratorAssistants" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "addNewMatch", propOrder = {
    "matchLength",
    "arbiterName",
    "arbitratorAssistants"
})
public class AddNewMatch {

    protected int matchLength;
    protected String arbiterName;
    protected List<String> arbitratorAssistants;

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
     * Gets the value of the arbiterName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArbiterName() {
        return arbiterName;
    }

    /**
     * Sets the value of the arbiterName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArbiterName(String value) {
        this.arbiterName = value;
    }

    /**
     * Gets the value of the arbitratorAssistants property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the arbitratorAssistants property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getArbitratorAssistants().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getArbitratorAssistants() {
        if (arbitratorAssistants == null) {
            arbitratorAssistants = new ArrayList<String>();
        }
        return this.arbitratorAssistants;
    }

}
