
package pl.polsl.lab6.pawel.salicki.webServices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for hasMatchInData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="hasMatchInData"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="deleteMatchId" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "hasMatchInData", propOrder = {
    "deleteMatchId"
})
public class HasMatchInData {

    protected int deleteMatchId;

    /**
     * Gets the value of the deleteMatchId property.
     * 
     */
    public int getDeleteMatchId() {
        return deleteMatchId;
    }

    /**
     * Sets the value of the deleteMatchId property.
     * 
     */
    public void setDeleteMatchId(int value) {
        this.deleteMatchId = value;
    }

}
