package pl.polsl.lab5.pawel.salicki.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pl.polsl.lab5.pawel.salicki.model.Database;

/**
 * Servlet displays to the user the all records of all tables from the JDBC
 * database.
 *
 * @author Paweł Salicki
 * @version 1.0
 */
@WebServlet(name = "ShowDatabase", urlPatterns = {"/ShowDatabase"})
public class ShowDatabase extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
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
        if (database == null) {
            out.println("First create database!");
        } else {
            out.println("<h3>MATCHES table:</h3>");
            Connection connection = (Connection) session.getAttribute("connection");
            try {
                Statement statement = connection.createStatement();
                ResultSet rs = null;
                rs = statement.executeQuery("SELECT * FROM MATCHES");

                out.println("<TABLE BORDER>");
                out.println("<TR><TD>ID</TD><TD>LENGTH</TD><TD>ARBITER NAME</TD><TD>HOST TEAM ID</TD><TD>GUEST TEAM ID</TD></TR>");
                while (rs.next()) {
                    out.println("<TR>" + "<TD>" + rs.getInt("ID_MATCH") + "</TD>");
                    out.println("<TD>" + rs.getInt("LENGTH_MATCH") + "</TD>");
                    out.println("<TD>" + rs.getString("ARBITER_NAME_MATCH") + "</TD>");
                    out.println("<TD>" + rs.getInt("HOST_TEAM_ID") + "</TD>");
                    out.println("<TD>" + rs.getInt("GUEST_TEAM_ID") + "</TD>" + "</TR>");
                }
                out.println("</TABLE>");
                rs.close();

                out.println("<h3>ARBITERS table:</h3>");
                rs = statement.executeQuery("SELECT * FROM ARBITERS");

                out.println("<TABLE BORDER>");
                out.println("<TR><TD>ID</TD><TD>ARBITRATOR NAME</TD><TD>ARBITRATOR MATCH ID</TD><TR>");
                while (rs.next()) {
                    out.println("<TR>" + "<TD>" + rs.getInt("ID_ARBITRATOR") + "</TD>");
                    out.println("<TD>" + rs.getString("ARBITRATOR_NAME") + "</TD>");
                    out.println("<TD>" + rs.getInt("ARBITRATOR_MATCH_ID") + "</TD>" + "</TR>");
                }
                out.println("</TABLE>");
                rs.close();

                out.println("<h3>TEAM table:</h3>");
                rs = statement.executeQuery("SELECT * FROM TEAM");

                out.println("<TABLE BORDER>");
                out.println("<TR><TD>ID</TD><TD>COUNTRY NAME</TD><TD>COACH NAME</TD><TD>TEAM NAME</TD></TR>");
                while (rs.next()) {
                    out.println("<TR>" + "<TD>" + rs.getInt("ID_TEAM") + "</TD>");
                    out.println("<TD>" + rs.getString("COUNTRY_NAME_TEAM") + "</TD>");
                    out.println("<TD>" + rs.getString("COACH_NAME_TEAM") + "</TD>");
                    out.println("<TD>" + rs.getString("NAME_TEAM") + "</TD>" + "</TR>");
                }
                out.println("</TABLE>");
                rs.close();

                out.println("<h3>PLAYERS table:</h3>");
                rs = statement.executeQuery("SELECT * FROM PLAYERS");

                out.println("<TABLE BORDER>");
                out.println("<TR><TD>ID</TD><TD>NAME</TD><TD>PLAYED WHOLE MATCH</TD><TD>MINUTE ENTERED</TD>"
                        + "<TD>MINUTE LEFT</TD><TD>GOALS</TD><TD>FOULS</TD>"
                        + "<TD>YELLOW CARDS</TD><TD>RED CARD</TD><TD>ID TEAM</TD></TR>");
                while (rs.next()) {
                    out.println("<TR>" + "<TD>" + rs.getInt("ID_PLAYER") + "</TD>");
                    out.println("<TD>" + rs.getString("NAME") + "</TD>");
                    out.println("<TD>" + rs.getBoolean("PLAYED_WHOLE_MATCH") + "</TD>");
                    out.println("<TD>" + rs.getInt("MINUTE_ENTERED") + "</TD>");
                    out.println("<TD>" + rs.getInt("MINUTE_LEFT") + "</TD>");
                    out.println("<TD>" + rs.getInt("GOALS") + "</TD>");
                    out.println("<TD>" + rs.getInt("FOULS") + "</TD>");
                    out.println("<TD>" + rs.getInt("YELLOW_CARDS") + "</TD>");
                    out.println("<TD>" + rs.getBoolean("RED_CARD") + "</TD>");
                    out.println("<TD>" + rs.getInt("ID_TEAM") + "</TD>" + "</TR>");
                }
                out.println("</TABLE>");
                rs.close();

            } catch (SQLException sqle) {
                out.println("An error occurred while displaying table contents.<br>");
                out.println("SQL exception: " + sqle.getMessage());
            }
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
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
        return "Servlet prints the entire contents of the JDBC database tables.";
    }// </editor-fold>

}
