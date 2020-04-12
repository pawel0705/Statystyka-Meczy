package pl.polsl.lab6.pawel.salicki.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
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
 * Servlet removes one match from the database with the given id. Servlet also
 * deletes the corresponding records from the JDBC database tables.
 *
 * @author Paweł Salicki
 * @version 3.0
 */
@WebServlet(urlPatterns = {"/DeleteOneMatch"})
public class DeleteOneMatch extends HttpServlet {
    /**
     * WebService manager.
     */
    @WebServiceRef(wsdlLocation = "http://localhost:8080/MatchStatisticsWebService/ManageContainerService?wsdl")
    private ManageContainerService_Service service;

    /**
     * Match id to delete.
     */
    private int deleteMatchId;

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * The method acquires the match id address to be deleted from the database
     * and then deletes it.
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

        try {
            deleteMatchId = Integer.parseInt(request.getParameter("deleteMatchId"));
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Wrong match id!");
        }

        if (!hasMatchInData(deleteMatchId)) {
            out.println("This match does not exist in the database!<br>");
        } else {
            deleteMatchById(deleteMatchId);
            out.println("The match has been successfully deleted.<br>");
        }

        try {
            this.deleteOneMatchDatabase(deleteMatchId);
        } catch (SystemException_Exception | RollbackException_Exception | HeuristicRollbackException_Exception | NotSupportedException_Exception | HeuristicMixedException_Exception ex) {
            Logger.getLogger(DeleteOneMatch.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * The method calls the doGet method.
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
        return "Servlet removes the match with the given id from the database.";
    }// </editor-fold>

    /**
     * The method connects to WebServices and returns the result of a query
     * whether there are any records in the database.
     *
     * @param deleteMatchId id of match that will be removed from database
     * @return if the match with the given id exist in the database
     */
    private boolean hasMatchInData(int deleteMatchId) {

        pl.polsl.lab6.pawel.salicki.webServices.ManageContainerService port = service.getManageContainerServicePort();
        return port.hasMatchInData(deleteMatchId);
    }

    /**
     * The method connects to WebServices and removes the match from the
     * container.
     *
     * @param deleteMatchId id of match that will be removed from database
     */
    private void deleteMatchById(int deleteMatchId) {

        pl.polsl.lab6.pawel.salicki.webServices.ManageContainerService port = service.getManageContainerServicePort();
        port.deleteMatchById(deleteMatchId);
    }

    /**
     * The method connects to WebServices and removes the match from the JPA
     * database.
     *
     * @param deleteMatchId id of match that will be removed from database
     * @throws SystemException_Exception
     * @throws RollbackException_Exception
     * @throws HeuristicRollbackException_Exception
     * @throws NotSupportedException_Exception
     * @throws HeuristicMixedException_Exception
     */
    private void deleteOneMatchDatabase(int deleteMatchId) throws SystemException_Exception, RollbackException_Exception, HeuristicRollbackException_Exception, NotSupportedException_Exception, HeuristicMixedException_Exception {

        pl.polsl.lab6.pawel.salicki.webServices.ManageContainerService port = service.getManageContainerServicePort();
        port.deleteOneMatchDatabase(deleteMatchId);
    }
}
