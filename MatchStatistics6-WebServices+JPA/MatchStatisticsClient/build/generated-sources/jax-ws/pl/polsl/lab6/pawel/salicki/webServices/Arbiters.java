
package pl.polsl.lab6.pawel.salicki.webServices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for arbiters complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="arbiters"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="arbitratormatchid" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="arbitratorname" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "arbiters", propOrder = {
    "arbitratormatchid",
    "arbitratorname",
    "id"
})
public class Arbiters {

    protected Integer arbitratormatchid;
    protected String arbitratorname;
    protected Long id;

    /**
     * Gets the value of the arbitratormatchid property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getArbitratormatchid() {
        return arbitratormatchid;
    }

    /**
     * Sets the value of the arbitratormatchid property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setArbitratormatchid(Integer value) {
        this.arbitratormatchid = value;
    }

    /**
     * Gets the value of the arbitratorname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArbitratorname() {
        return arbitratorname;
    }

    /**
     * Sets the value of the arbitratorname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArbitratorname(String value) {
        this.arbitratorname = value;
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

}
