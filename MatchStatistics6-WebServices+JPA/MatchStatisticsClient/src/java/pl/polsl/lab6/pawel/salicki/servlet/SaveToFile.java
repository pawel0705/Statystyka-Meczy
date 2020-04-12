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
import pl.polsl.lab6.pawel.salicki.webServices.IOException_Exception;
import pl.polsl.lab6.pawel.salicki.webServices.ManageContainerService_Service;

/**
 * Servlet reads the path to the file. Writes the database to the path provided
 * as a txt file.
 *
 * @author Paweł Salicki
 * @version 2.0
 */
@WebServlet(urlPatterns = {"/SaveToFile"})
public class SaveToFile extends HttpServlet {
    /**
     * WebService manager.
     */
    @WebServiceRef(wsdlLocation = "http://localhost:8080/MatchStatisticsWebService/ManageContainerService?wsdl")
    private ManageContainerService_Service service;

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * The method saves the database to a txt file.
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
            saveDatabaseToFile(request.getParameter(("saveFilePath")));
             out.println("Database content successfully saved to file.");
        } catch (IOException_Exception ex) {
            out.println("There was a problem while trying to write database records to the text file!");
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
        return "Servlet saves the database to a txt file.";
    }// </editor-fold>

    /**
     * The method connects to WebService and writes records from the database to
     * a text file.
     *
     * @param filePath path to the file that records of database will be save
     * @throws IOException_Exception
     */
    private void saveDatabaseToFile(java.lang.String filePath) throws IOException_Exception {

        pl.polsl.lab6.pawel.salicki.webServices.ManageContainerService port = service.getManageContainerServicePort();
        port.saveDatabaseToFile(filePath);
    }

}
