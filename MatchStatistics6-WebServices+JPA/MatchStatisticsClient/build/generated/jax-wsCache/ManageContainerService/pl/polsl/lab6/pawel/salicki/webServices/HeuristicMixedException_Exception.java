
package pl.polsl.lab6.pawel.salicki.webServices;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.11-b150120.1832
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "HeuristicMixedException", targetNamespace = "http://webServices.salicki.pawel.lab6.polsl.pl/")
public class HeuristicMixedException_Exception
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private HeuristicMixedException faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public HeuristicMixedException_Exception(String message, HeuristicMixedException faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param faultInfo
     * @param cause
     * @param message
     */
    public HeuristicMixedException_Exception(String message, HeuristicMixedException faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: pl.polsl.lab6.pawel.salicki.webServices.HeuristicMixedException
     */
    public HeuristicMixedException getFaultInfo() {
        return faultInfo;
    }

}
