
package pl.polsl.lab6.pawel.salicki.webServices;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.11-b150120.1832
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "ManageContainerService", targetNamespace = "http://webServices.salicki.pawel.lab6.polsl.pl/", wsdlLocation = "http://localhost:8080/MatchStatisticsWebService/ManageContainerService?wsdl")
public class ManageContainerService_Service
    extends Service
{

    private final static URL MANAGECONTAINERSERVICE_WSDL_LOCATION;
    private final static WebServiceException MANAGECONTAINERSERVICE_EXCEPTION;
    private final static QName MANAGECONTAINERSERVICE_QNAME = new QName("http://webServices.salicki.pawel.lab6.polsl.pl/", "ManageContainerService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/MatchStatisticsWebService/ManageContainerService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        MANAGECONTAINERSERVICE_WSDL_LOCATION = url;
        MANAGECONTAINERSERVICE_EXCEPTION = e;
    }

    public ManageContainerService_Service() {
        super(__getWsdlLocation(), MANAGECONTAINERSERVICE_QNAME);
    }

    public ManageContainerService_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), MANAGECONTAINERSERVICE_QNAME, features);
    }

    public ManageContainerService_Service(URL wsdlLocation) {
        super(wsdlLocation, MANAGECONTAINERSERVICE_QNAME);
    }

    public ManageContainerService_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, MANAGECONTAINERSERVICE_QNAME, features);
    }

    public ManageContainerService_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ManageContainerService_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns ManageContainerService
     */
    @WebEndpoint(name = "ManageContainerServicePort")
    public ManageContainerService getManageContainerServicePort() {
        return super.getPort(new QName("http://webServices.salicki.pawel.lab6.polsl.pl/", "ManageContainerServicePort"), ManageContainerService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ManageContainerService
     */
    @WebEndpoint(name = "ManageContainerServicePort")
    public ManageContainerService getManageContainerServicePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://webServices.salicki.pawel.lab6.polsl.pl/", "ManageContainerServicePort"), ManageContainerService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (MANAGECONTAINERSERVICE_EXCEPTION!= null) {
            throw MANAGECONTAINERSERVICE_EXCEPTION;
        }
        return MANAGECONTAINERSERVICE_WSDL_LOCATION;
    }

}
