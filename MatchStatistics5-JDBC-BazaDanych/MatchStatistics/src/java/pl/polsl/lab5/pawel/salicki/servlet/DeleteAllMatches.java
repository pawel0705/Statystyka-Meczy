package pl.polsl.lab5.pawel.salicki.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pl.polsl.lab5.pawel.salicki.model.Database;

/**
 * Servlet that deletes all match information contained in the database.
 *
 * @author Paweł Salicki
 * @version 2.0
 */
@WebServlet(urlPatterns = {"/DeleteAllMatches"})
public class DeleteAllMatches extends HttpServlet {

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

        Database database = (Database) session.getAttribute("database");
        if (database != null) {
            database.deleteAllMatches();
            out.println("Database content has been successfully deleted.<br>");
        } else {
            out.println("Database not created. There is nothing to remove from!<br>");
        }

        Connection connection = null;
        try {
            connection = (Connection) session.getAttribute("connection");

            Statement statement = connection.createStatement();
            statement.executeUpdate("DELETE FROM TEAM");
            statement.executeUpdate("DELETE FROM MATCHES");
            statement.executeUpdate("DELETE FROM PLAYERS");
            statement.executeUpdate("DELETE FROM ARBITERS");
            session.setAttribute("connection", connection);
            out.println("All tables from the JDBC database have been successfully deleted.<br>");
            session.setAttribute("connection", connection);
        } catch (SQLException e) {
            out.println("An error occurred while deleting data from database JDBC tables!");
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

}
