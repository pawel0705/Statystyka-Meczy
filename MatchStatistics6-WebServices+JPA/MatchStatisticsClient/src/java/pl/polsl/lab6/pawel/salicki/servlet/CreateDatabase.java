package pl.polsl.lab6.pawel.salicki.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.WebServiceRef;
import pl.polsl.lab6.pawel.salicki.webServices.ManageContainerService_Service;

/**
 * Servlet creates a database instance. Servlet also connects to the JPA
 * database.
 *
 * @author Paweł Salicki
 * @version 3.0
 */
//@WebServlet(urlPatterns = {"/CreateDatabase"})
public class CreateDatabase extends HttpServlet {
    /**
     * WebService manager.
     */
    @WebServiceRef(wsdlLocation = "http://localhost:8080/MatchStatisticsWebService/ManageContainerService?wsdl")
    private ManageContainerService_Service service;

    // private Database database;
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * The method creates a new database instance if it does not exist.
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

        Connection connection = null;

        try {
            Class.forName(this.getInitParameter("driver"));
            connection = DriverManager.getConnection(this.getInitParameter("url"), this.getInitParameter("user"), this.getInitParameter("password"));

        } catch (ClassNotFoundException | SQLException ex) {
            out.println("Unable to connect to JPA database! The database has not been created!");
        }

        boolean result = createDatabase();
        if (result == true) {
            out.println("Database created!");
        } else {
            out.println("Database is already created!");
        }

        session.setAttribute("connection", connection);
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
        return "Servlet creates a database instance.";
    }// </editor-fold>

    /**
     * The method connects to WebService to create a database.
     *
     * @return whether the database has already been created
     */
    private boolean createDatabase() {

        pl.polsl.lab6.pawel.salicki.webServices.ManageContainerService port = service.getManageContainerServicePort();
        return port.createDatabase();
    }

}
