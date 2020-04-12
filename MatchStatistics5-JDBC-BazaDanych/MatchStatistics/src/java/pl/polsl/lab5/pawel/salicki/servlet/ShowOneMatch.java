package pl.polsl.lab5.pawel.salicki.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pl.polsl.lab5.pawel.salicki.model.Database;
import pl.polsl.lab5.pawel.salicki.model.Match;
import pl.polsl.lab5.pawel.salicki.model.Player;
import pl.polsl.lab5.pawel.salicki.model.SoccerTeam;

/**
 * Servlet listing detailed information about one particular match.
 *
 * @author Paweł Salicki
 * @version 1.0
 */
@WebServlet(urlPatterns = {"/ShowOneMatch"})
public class ShowOneMatch extends HttpServlet {

    /**
     * Match id from database.
     */
    private int matchId;

    /**
     * A method that prints information about a team.
     *
     * @param soccerTeam soccer team instance (soccer team informations)
     * @param out output to user
     */
    private void printTeamInfo(SoccerTeam soccerTeam, PrintWriter out) {
        out.format("Hosting event team: %s<br>", soccerTeam.getTeamName());
        out.format("Coach of team %s: %s<br>", soccerTeam.getTeamName(),
                soccerTeam.getCoachName());
        out.format("Team's country: %s<br>", soccerTeam.getTeamCountryName());
    }

    /**
     * A method that prints information about players.
     *
     * @param players list of player instance (player informations)
     * @param out output to user
     */
    private void printPlayerInfo(ArrayList<Player> players, PrintWriter out) {
        int playerCounter = 0;
        for (Player player : players) {
            playerCounter++;
            out.format("%s. Player name: %s<br>", playerCounter, player.getPlayerName());
            out.format("%s. Goals scored: %s<br>", playerCounter, player.getScoredGoals());
            out.format("%s. Entered the game on %s min<br>", playerCounter, player.getEntryTime());
            out.format("%s. Left the game on %s min<br>", playerCounter, player.getLeftTime());
            out.format("%s. Amount of yellow cards: %s<br>", playerCounter, player.getYellowCards());
            out.format("%s. Player time on the field: %smin<br>", playerCounter, player.calculatePlayerTimeInGame());

            if (player.getRedCard()) {
                out.format("%s. This player got a red card<br>", playerCounter);
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * A method that prints detailed information about a given match from the
     * database. Calls auxiliary methods to print information.
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
            matchId = Integer.parseInt(request.getParameter("matchId"));
        } catch (NumberFormatException e) {
            out.println("Wrong match id!<br>");
        }

        if (database == null) {
            out.println("First add match to database!<br>");
        } else {
            if (!database.hasMatchInData(matchId)) {
                out.println("This match does not exist in the database!<br>");
            } else {
                Connection connection = (Connection) session.getAttribute("connection");

                try {
                    Statement statement = connection.createStatement();
                    ResultSet rs = null;
                    rs = statement.executeQuery("SELECT * FROM MATCHES WHERE ID_MATCH=" + matchId);

                    while (rs.next()) {
                        out.format("#Match ID: %s<br>", matchId);
                        out.format("#The length of the match: %smin<br>", Integer.toString(rs.getInt("LENGTH_MATCH")));
                        out.format("#Arbiter name: %s<br>", rs.getString("ARBITER_NAME_MATCH"));
                        out.println("#Arbitrator assistants:<br>");
                    }

                    rs.close();

                    rs = statement.executeQuery("SELECT * FROM ARBITERS WHERE ARBITRATOR_MATCH_ID=" + matchId);
                    while (rs.next()) {
                        out.format("-%s<br>", rs.getString("ARBITRATOR_NAME"));
                    }

                    rs.close();
                    
                    Match match = database.getMatchById(matchId);
                    this.printTeamInfo(match.getHostTeam(), out);
                    this.printPlayerInfo(match.getHostTeam().getPlayers(), out);
                    this.printTeamInfo(match.getGuestTeam(), out);
                    this.printPlayerInfo(match.getGuestTeam().getPlayers(), out);
                } catch (SQLException e) {
                    out.println("An error occurred while displaying table contents.<br>");
                    out.println("SQLException: " + e);
                }
            }
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * A method that calls the doGet method.
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
        return "Servlet listing detailed information about a given match.";
    }// </editor-fold>

}
