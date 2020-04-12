package pl.polsl.lab5.pawel.salicki.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pl.polsl.lab5.pawel.salicki.model.Database;

/**
 * Servlet creates a database instance. Servlet also connects to the JDBC
 * database.
 *
 * @author Paweł Salicki
 * @version 2.0
 */
//@WebServlet(urlPatterns = {"/CreateDatabase"})
public class CreateDatabase extends HttpServlet {

    /**
     * Database instance.
     */
    private Database database;

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

        if (session.getAttribute("database") == null) {
            database = new Database();
            session.setAttribute("database", database);
            out.println("Database created");
        } else {
            out.println("Database is already created!");
        }

        Connection connection = null;

        try {
            Class.forName(this.getInitParameter("driver"));
            connection = DriverManager.getConnection(this.getInitParameter("url"), this.getInitParameter("user"), this.getInitParameter("password"));

            // clear old data
            Statement statement = connection.createStatement();
            statement.executeUpdate("DELETE FROM TEAM");
            statement.executeUpdate("DELETE FROM MATCHES");
            statement.executeUpdate("DELETE FROM PLAYERS");
            statement.executeUpdate("DELETE FROM ARBITERS");
            session.setAttribute("connection", connection);
        } catch (SQLException e) {
            out.println("SQL exception: " + e.getMessage());
            out.println("Can't connect to JDBC database.");
        } catch (ClassNotFoundException e) {
            out.println("ClassNotFound exception: " + e.getMessage());
            out.println("Can't connect to JDBC database.");
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
        return "Servlet creates a database instance.";
    }// </editor-fold>

}
