package pl.polsl.lab6.pawel.salicki.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.persistence.RollbackException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.WebServiceRef;
import pl.polsl.lab6.pawel.salicki.webServices.HeuristicMixedException_Exception;
import pl.polsl.lab6.pawel.salicki.webServices.HeuristicRollbackException_Exception;
import pl.polsl.lab6.pawel.salicki.webServices.ManageContainerService_Service;
import pl.polsl.lab6.pawel.salicki.webServices.NotSupportedException_Exception;
import pl.polsl.lab6.pawel.salicki.webServices.RollbackException_Exception;
import pl.polsl.lab6.pawel.salicki.webServices.SystemException_Exception;

/**
 * Servlet that deletes all match information contained in the database.
 *
 * @author Paweł Salicki
 * @version 3.0
 */
@WebServlet(urlPatterns = {"/DeleteAllMatches"})
public class DeleteAllMatches extends HttpServlet {
    /**
     * WebService manager.
     */
    @WebServiceRef(wsdlLocation = "http://localhost:8080/MatchStatisticsWebService/ManageContainerService?wsdl")
    private ManageContainerService_Service service;

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * A method that removes all information from the database.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(true);

        if (deleteAllMatches()) {
            out.println("Database content has been successfully deleted.<br>");
        } else {
            out.println("Database not created. There is nothing to remove from!<br>");
        }

        try {
            this.deleteAllMatchesDatabase();
        } catch (SecurityException | IllegalStateException | RollbackException e) {
        } catch (HeuristicMixedException_Exception | HeuristicRollbackException_Exception | NotSupportedException_Exception | SystemException_Exception | RollbackException_Exception ex) {
            out.println("An error occurred while cleaning the JPA database tables!");
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * A method that calls the toGet method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Servlet removes all information from the match database.";
    }// </editor-fold>

    /**
     * The method connects to the Web Service and cleans the container
     * containing match records.
     *
     * @return boolean if container was successfully cleaned
     */
    private boolean deleteAllMatches() {

        pl.polsl.lab6.pawel.salicki.webServices.ManageContainerService port = service.getManageContainerServicePort();
        return port.deleteAllMatches();
    }

    /**
     * The method connects to WebServices and removes records from JPA database
     * tables.
     *
     * @throws HeuristicMixedException_Exception
     * @throws HeuristicRollbackException_Exception
     * @throws NotSupportedException_Exception
     * @throws SystemException_Exception
     * @throws RollbackException_Exception
     */
    private void deleteAllMatchesDatabase() throws HeuristicMixedException_Exception, HeuristicRollbackException_Exception, NotSupportedException_Exception, SystemException_Exception, RollbackException_Exception {

        pl.polsl.lab6.pawel.salicki.webServices.ManageContainerService port = service.getManageContainerServicePort();
        port.deleteAllMatchesDatabase();
    }

}
