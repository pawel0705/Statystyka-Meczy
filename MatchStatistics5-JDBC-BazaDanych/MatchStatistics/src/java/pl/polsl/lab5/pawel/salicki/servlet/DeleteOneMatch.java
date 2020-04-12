package pl.polsl.lab5.pawel.salicki.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
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
 * Servlet removes one match from the database with the given id. Servlet also
 * deletes the corresponding records from the JDBC database tables.
 *
 * @author Paweł Salicki
 * @version 2.0
 */
@WebServlet(urlPatterns = {"/DeleteOneMatch"})
public class DeleteOneMatch extends HttpServlet {

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
        Database database = (Database) session.getAttribute("database");

        try {
            deleteMatchId = Integer.parseInt(request.getParameter("deleteMatchId"));
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Wrong match id!");
        }

        if (database == null) {
            out.println("First add match to database!<br>");
        } else {
            if (!database.hasMatchInData(deleteMatchId)) {
                out.println("This match does not exist in the database!<br>");
            } else {
                database.deleteMatchById(deleteMatchId);
                out.println("The match has been successfully deleted.<br>");

                Connection connection = null;
                try {
                    connection = (Connection) session.getAttribute("connection");
                    Statement statement = connection.createStatement();

                    ResultSet rs = null;

                    rs = statement.executeQuery("SELECT * FROM MATCHES WHERE ID_MATCH=" + deleteMatchId);
                    String hostTeamId = "";
                    while (rs.next()) {
                        hostTeamId = Integer.toString(rs.getInt("HOST_TEAM_ID"));
                    }
                    rs.close();

                    rs = statement.executeQuery("SELECT * FROM MATCHES WHERE ID_MATCH=" + deleteMatchId);
                    String guestTeamId = "";
                    while (rs.next()) {
                        guestTeamId = Integer.toString(rs.getInt("GUEST_TEAM_ID"));
                    }
                    rs.close();

                    // delete teams
                    statement.executeUpdate("DELETE FROM TEAM WHERE ID_TEAM=" + hostTeamId);
                    statement.executeUpdate("DELETE FROM TEAM WHERE ID_TEAM=" + guestTeamId);

                    //delete match
                    statement.executeUpdate("DELETE FROM MATCHES WHERE ID_MATCH=" + deleteMatchId);

                    // delete players
                    statement.executeUpdate("DELETE FROM PLAYERS WHERE ID_TEAM=" + hostTeamId);
                    statement.executeUpdate("DELETE FROM PLAYERS WHERE ID_TEAM=" + guestTeamId);

                    // delete arbitrator assistants
                    statement.executeUpdate("DELETE FROM ARBITERS WHERE ARBITRATOR_MATCH_ID=" + deleteMatchId);
                    session.setAttribute("connection", connection);

                } catch (SQLException e) {
                    out.println("An error occurred while deleting data from tables from the JDBC database.");
                }
            }
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
}
