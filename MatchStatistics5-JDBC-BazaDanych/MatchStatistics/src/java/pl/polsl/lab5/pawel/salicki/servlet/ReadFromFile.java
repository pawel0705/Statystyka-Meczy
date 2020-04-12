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
import pl.polsl.lab5.pawel.salicki.exceptions.WrongInputException;
import pl.polsl.lab5.pawel.salicki.model.Database;

/**
 * Servlet reads the entered path to the file and calls the method from the
 * database, which reads it and adds new information to the database.
 *
 * @author Paweł Salicki
 * @version 2.0
 */
@WebServlet(urlPatterns = {"/ReadFromFile"})
public class ReadFromFile extends HttpServlet {

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

        Database database = (Database) session.getAttribute("database");

        try {
            database.readDataFromFile(request.getParameter(("readFilePath")));
            out.println("File read successfully.");

        } catch (WrongInputException | IOException e) {
            out.println("File cannot be open! Check the path or contents of the file are correct.");
        }

        Connection connection = null;
        try {
            connection = (Connection) session.getAttribute("connection");
            Statement statement = connection.createStatement();
            statement.executeUpdate("DELETE FROM TEAM");
            statement.executeUpdate("DELETE FROM MATCHES");
            statement.executeUpdate("DELETE FROM PLAYERS");
            statement.executeUpdate("DELETE FROM ARBITERS");

            int hostTeamId = 0;
            int guestTeamId = 1;

            int arbitratorId = 0;
            int playerId = 0;

            // add match to jdbc database
            for (int i = 0; i < database.getAllMatches().size(); i++) {
                statement.executeUpdate("INSERT INTO MATCHES (ID_MATCH, LENGTH_MATCH, ARBITER_NAME_MATCH, HOST_TEAM_ID, GUEST_TEAM_ID) VALUES ("
                        + database.getAllMatches().get(i).getMatchId() + ","
                        + database.getAllMatches().get(i).getMatchTime() + ",'"
                        + database.getAllMatches().get(i).getArbiterName() + "',"
                        + hostTeamId + ","
                        + guestTeamId + ")"
                );

                // add host team to jdbc database
                statement.executeUpdate("INSERT INTO TEAM (ID_TEAM, COUNTRY_NAME_TEAM, COACH_NAME_TEAM, NAME_TEAM) VALUES("
                        + hostTeamId + ",'"
                        + database.getAllMatches().get(i).getHostTeam().getTeamCountryName() + "','"
                        + database.getAllMatches().get(i).getHostTeam().getCoachName() + "','"
                        + database.getAllMatches().get(i).getHostTeam().getTeamName() + "')"
                );

                // add guest team to jdbc database
                statement.executeUpdate("INSERT INTO TEAM (ID_TEAM, COUNTRY_NAME_TEAM, COACH_NAME_TEAM, NAME_TEAM) VALUES("
                        + guestTeamId + ",'"
                        + database.getAllMatches().get(i).getGuestTeam().getTeamCountryName() + "','"
                        + database.getAllMatches().get(i).getGuestTeam().getCoachName() + "','"
                        + database.getAllMatches().get(i).getGuestTeam().getTeamName() + "')"
                );

                playerId += database.getAllMatches().get(i).getHostTeam().getPlayers().size()
                        + database.getAllMatches().get(i).getGuestTeam().getPlayers().size();

                int playerIdSave = playerId;
                // add HOST players to jdbc database
                for (int j = 0; j < database.getAllMatches().get(i).getHostTeam().getPlayers().size(); j++) {
                    statement.executeUpdate("INSERT INTO PLAYERS (ID_PLAYER, NAME, PLAYED_WHOLE_MATCH, MINUTE_ENTERED, MINUTE_LEFT, GOALS, FOULS, YELLOW_CARDS, RED_CARD, ID_TEAM) VALUES("
                            + (playerId--) + ",'"
                            + database.getAllMatches().get(i).getHostTeam().getPlayers().get(j).getPlayerName() + "',"
                            + database.getAllMatches().get(i).getHostTeam().getPlayers().get(j).getPlayedWholeTime() + ","
                            + database.getAllMatches().get(i).getHostTeam().getPlayers().get(j).getEntryTime() + ","
                            + database.getAllMatches().get(i).getHostTeam().getPlayers().get(j).getLeftTime() + ","
                            + database.getAllMatches().get(i).getHostTeam().getPlayers().get(j).getScoredGoals() + ","
                            + database.getAllMatches().get(i).getHostTeam().getPlayers().get(j).getFouls() + ","
                            + database.getAllMatches().get(i).getHostTeam().getPlayers().get(j).getYellowCards() + ","
                            + database.getAllMatches().get(i).getHostTeam().getPlayers().get(j).getRedCard() + ","
                            + hostTeamId + ")"
                    );
                }

                // add GUEST players to jdbc database
                for (int j = 0; j < database.getAllMatches().get(i).getGuestTeam().getPlayers().size(); j++) {
                    statement.executeUpdate("INSERT INTO PLAYERS (ID_PLAYER, NAME, PLAYED_WHOLE_MATCH, MINUTE_ENTERED, MINUTE_LEFT, GOALS, FOULS, YELLOW_CARDS, RED_CARD, ID_TEAM) VALUES("
                            + (playerId--) + ",'"
                            + database.getAllMatches().get(i).getGuestTeam().getPlayers().get(j).getPlayerName() + "',"
                            + database.getAllMatches().get(i).getGuestTeam().getPlayers().get(j).getPlayedWholeTime() + ","
                            + database.getAllMatches().get(i).getGuestTeam().getPlayers().get(j).getEntryTime() + ","
                            + database.getAllMatches().get(i).getGuestTeam().getPlayers().get(j).getLeftTime() + ","
                            + database.getAllMatches().get(i).getGuestTeam().getPlayers().get(j).getScoredGoals() + ","
                            + database.getAllMatches().get(i).getGuestTeam().getPlayers().get(j).getFouls() + ","
                            + database.getAllMatches().get(i).getGuestTeam().getPlayers().get(j).getYellowCards() + ","
                            + database.getAllMatches().get(i).getGuestTeam().getPlayers().get(j).getRedCard() + ","
                            + guestTeamId + ")"
                    );
                }
                playerId = playerIdSave;

                arbitratorId += database.getAllMatches().get(i).getArbitratorAssistants().size();
                int arbitratorIdSave = arbitratorId;
                // add arbitrator assistants to jdbc database
                for (int j = 0; j < database.getAllMatches().get(i).getArbitratorAssistants().size(); j++) {
                    statement.executeUpdate("INSERT INTO ARBITERS (ID_ARBITRATOR, ARBITRATOR_NAME, ARBITRATOR_MATCH_ID) VALUES("
                            + (arbitratorId--) + ",'"
                            + database.getAllMatches().get(i).getArbitratorAssistants().get(j) + "',"
                            + database.getAllMatches().get(i).getMatchId() + ")"
                    );
                }

                arbitratorId = arbitratorIdSave;
                
                hostTeamId += 2;
                guestTeamId += 2;
            }
            session.setAttribute("connection", connection);
        } catch (SQLException ex) {
            Logger.getLogger(DeleteAllMatches.class.getName()).log(Level.SEVERE, null, ex);
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

}
