
package pl.polsl.lab6.pawel.salicki.webServices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getArbitratorAssistantName complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getArbitratorAssistantName"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="index" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="i" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getArbitratorAssistantName", propOrder = {
    "index",
    "i"
})
public class GetArbitratorAssistantName {

    protected int index;
    protected int i;

    /**
     * Gets the value of the index property.
     * 
     */
    public int getIndex() {
        return index;
    }

    /**
     * Sets the value of the index property.
     * 
     */
    public void setIndex(int value) {
        this.index = value;
    }

    /**
     * Gets the value of the i property.
     * 
     */
    public int getI() {
        return i;
    }

    /**
     * Sets the value of the i property.
     * 
     */
    public void setI(int value) {
        this.i = value;
    }

}
