package pl.polsl.lab6.pawel.salicki.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.WebServiceRef;
import pl.polsl.lab6.pawel.salicki.webServices.HeuristicMixedException_Exception;
import pl.polsl.lab6.pawel.salicki.webServices.HeuristicRollbackException_Exception;
import pl.polsl.lab6.pawel.salicki.webServices.IOException_Exception;
import pl.polsl.lab6.pawel.salicki.webServices.ManageContainerService_Service;
import pl.polsl.lab6.pawel.salicki.webServices.NotSupportedException_Exception;
import pl.polsl.lab6.pawel.salicki.webServices.RollbackException_Exception;
import pl.polsl.lab6.pawel.salicki.webServices.SystemException_Exception;
import pl.polsl.lab6.pawel.salicki.webServices.WrongInputException_Exception;

/**
 * Servlet reads the entered path to the file and calls the method from the
 * database, which reads it and adds new information to the database.
 *
 * @author Paweł Salicki
 * @version 3.0
 */
@WebServlet(urlPatterns = {"/ReadFromFile"})
public class ReadFromFile extends HttpServlet {
    /**
     * WebService manager.
     */
    @WebServiceRef(wsdlLocation = "http://localhost:8080/MatchStatisticsWebService/ManageContainerService?wsdl")
    private ManageContainerService_Service service;

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * The method reads the path to the file and writes information to the
     * database.
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
            readDatabaseFromFile(request.getParameter(("readFilePath")));
            out.println("File read successfully.");
        } catch (WrongInputException_Exception | IOException_Exception ex) {
            out.println("File cannot be open! Check the path or contents of the file are correct.");
        }

        try {
            this.readMatchFromFileDatabase();
        } catch (NotSupportedException_Exception | SystemException_Exception | RollbackException_Exception | HeuristicRollbackException_Exception | HeuristicMixedException_Exception ex) {
            out.println("Unable to load the given file into JPA database tables!");
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
        return "Servlet reads the file and writes information to the database.";
    }// </editor-fold>

    /**
     * The method connects to WebServices and reads the database from a text
     * file.
     *
     * @param filePath path to the file with database
     * @throws WrongInputException_Exception
     * @throws IOException_Exception
     */
    private void readDatabaseFromFile(java.lang.String filePath) throws WrongInputException_Exception, IOException_Exception {

        pl.polsl.lab6.pawel.salicki.webServices.ManageContainerService port = service.getManageContainerServicePort();
        port.readDatabaseFromFile(filePath);
    }

    /**
     * The method connects to WebServices and reads the JPA database from a text
     * file.
     *
     * @throws NotSupportedException_Exception
     * @throws SystemException_Exception
     * @throws RollbackException_Exception
     * @throws HeuristicRollbackException_Exception
     * @throws HeuristicMixedException_Exception
     */
    private void readMatchFromFileDatabase() throws NotSupportedException_Exception, SystemException_Exception, RollbackException_Exception, HeuristicRollbackException_Exception, HeuristicMixedException_Exception {

        pl.polsl.lab6.pawel.salicki.webServices.ManageContainerService port = service.getManageContainerServicePort();
        port.readMatchFromFileDatabase();
    }

}
