package pl.polsl.lab5.pawel.salicki.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
 * Servlet saves match information to the database. Servlet obtains information
 * with the help of the AddNewMatch servlet. Servlet adds a new match to the
 * JDBC database.
 *
 * @author Paweł Salicki
 * @version 3.0
 */
@WebServlet(urlPatterns = {"/AddNewMatchSecond"})
public class AddNewMatchSecond extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * A method of saving match information obtained from the appropriate fields
     * into the database.
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

        Database database = null;

        try {
            database = (Database) session.getAttribute("database");

            String arbiterName = request.getParameter("arbiterName");
            int matchLength = Integer.parseInt(request.getParameter("matchLength"));
            String hostTeamName = request.getParameter("hostTeamName");
            String guestTeamName = request.getParameter("guestTeamName");
            String hostTeamCoachName = request.getParameter("hostTeamCoachName");
            String guestTeamCoachName = request.getParameter("guestTeamCoachName");
            String hostTeamCountry = request.getParameter("hostTeamCountry");
            String guestTeamCountry = request.getParameter("guestTeamCountry");

            ArrayList<String> arbitratorAssistants = new ArrayList<>();
            for (int i = 0; i < (int) session.getAttribute("numberOfArbitratorAssistants"); i++) {
                arbitratorAssistants.add(request.getParameter("arbitratorAssistantName" + i));
            }

            ArrayList<Player> hostPlayers = new ArrayList<>();
            for (int i = 0; i < (int) session.getAttribute("numberOfHostTeamPlayers"); i++) {
                String playerHostName = request.getParameter("playerHostName" + i);
                int playerHostEnteredMinute = Integer.parseInt(request.getParameter("playerHostEnteredMinute" + i));
                int playerHostLeftMinute = Integer.parseInt(request.getParameter("playerHostLeftMinute" + i));
                int playerHostGoals = Integer.parseInt(request.getParameter("playerHostGoals" + i));
                int playerHostFouls = Integer.parseInt(request.getParameter("playerHostFouls" + i));
                int playerHostYellowCards = Integer.parseInt(request.getParameter("playerHostYellowCards" + i));
                int playerHostRedCards = Integer.parseInt(request.getParameter("playerHostRedCards" + i));

                boolean playedWholeMatch = false;
                boolean redCard = false;
                if (matchLength - playerHostLeftMinute + playerHostEnteredMinute == 0) {
                    playedWholeMatch = true;
                }
                if (playerHostRedCards >= 1 || playerHostYellowCards >= 2) {
                    redCard = true;
                }

                Player hostPlayer = new Player(playerHostName, playerHostGoals, playedWholeMatch,
                        playerHostEnteredMinute, playerHostLeftMinute, playerHostYellowCards, redCard, playerHostFouls);

                hostPlayers.add(hostPlayer);
            }
            SoccerTeam hostSoccerTeam = new SoccerTeam(hostTeamName, hostTeamCountry, hostTeamCoachName, hostPlayers);

            ArrayList<Player> guestPlayers = new ArrayList<>();
            for (int i = 0; i < (int) session.getAttribute("numberOfGuestTeamPlayers"); i++) {
                String playerGuestName = request.getParameter("playerGuestName" + i);
                int playerGuestEnteredMinute = Integer.parseInt(request.getParameter("playerGuestEnteredMinute" + i));
                int playerGuestLeftMinute = Integer.parseInt(request.getParameter("playerGuestLeftMinute" + i));
                int playerGuestGoals = Integer.parseInt(request.getParameter("playerGuestGoals" + i));
                int playerGuestFouls = Integer.parseInt(request.getParameter("playerGuestFouls" + i));
                int playerGuestYellowCards = Integer.parseInt(request.getParameter("playerGuestYellowCards" + i));
                int playerGuestRedCards = Integer.parseInt(request.getParameter("playerGuestRedCards" + i));

                boolean playedWholeMatch = false;
                boolean redCard = false;
                if (matchLength - playerGuestLeftMinute + playerGuestEnteredMinute == 0) {
                    playedWholeMatch = true;
                }
                if (playerGuestRedCards >= 1 || playerGuestYellowCards >= 2) {
                    redCard = true;
                }

                Player guestPlayer = new Player(playerGuestName, playerGuestGoals, playedWholeMatch,
                        playerGuestEnteredMinute, playerGuestLeftMinute, playerGuestYellowCards, redCard, playerGuestFouls);

                guestPlayers.add(guestPlayer);
            }
            SoccerTeam guestSoccerTeam = new SoccerTeam(guestTeamName, guestTeamCountry, guestTeamCoachName, guestPlayers);

            SoccerTeam[] soccerTeams = {hostSoccerTeam, guestSoccerTeam};

            database.addMatchToDatabase(new Match(matchLength, arbiterName, arbitratorAssistants, soccerTeams));
        } catch (NumberFormatException e) {
            out.println("Fill ALL fields with the correct values.");
        }

        Connection connection = null;
        try {

            connection = (Connection) session.getAttribute("connection");

            Statement statement = connection.createStatement();
            int lastMatch = database.getNumberOfMatches() - 1;
            int amountOfTeams = database.getNumberOfMatches() * 2;

            String hostTeamId = Integer.toString(amountOfTeams - 1);
            String guestTeamId = Integer.toString(amountOfTeams);

            int playerId = 0;
            for (int i = 0; i < database.getAllMatches().size(); i++) {
                playerId += database.getAllMatches().get(i).getHostTeam().getPlayers().size()
                        + database.getAllMatches().get(i).getGuestTeam().getPlayers().size();
            }

            // add HOST players to jdbc database
            for (int i = 0; i < database.getAllMatches().get(lastMatch).getHostTeam().getPlayers().size(); i++) {
                statement.executeUpdate("INSERT INTO PLAYERS (ID_PLAYER, NAME, PLAYED_WHOLE_MATCH, MINUTE_ENTERED, MINUTE_LEFT, GOALS, FOULS, YELLOW_CARDS, RED_CARD, ID_TEAM) VALUES("
                        + (playerId--) + ",'"
                        + database.getAllMatches().get(lastMatch).getHostTeam().getPlayers().get(i).getPlayerName() + "',"
                        + database.getAllMatches().get(lastMatch).getHostTeam().getPlayers().get(i).getPlayedWholeTime() + ","
                        + database.getAllMatches().get(lastMatch).getHostTeam().getPlayers().get(i).getEntryTime() + ","
                        + database.getAllMatches().get(lastMatch).getHostTeam().getPlayers().get(i).getLeftTime() + ","
                        + database.getAllMatches().get(lastMatch).getHostTeam().getPlayers().get(i).getScoredGoals() + ","
                        + database.getAllMatches().get(lastMatch).getHostTeam().getPlayers().get(i).getFouls() + ","
                        + database.getAllMatches().get(lastMatch).getHostTeam().getPlayers().get(i).getYellowCards() + ","
                        + database.getAllMatches().get(lastMatch).getHostTeam().getPlayers().get(i).getRedCard() + ","
                        + hostTeamId + ")"
                );
            }

            // add GUEST players to jdbc database
            for (int i = 0; i < database.getAllMatches().get(lastMatch).getGuestTeam().getPlayers().size(); i++) {
                statement.executeUpdate("INSERT INTO PLAYERS (ID_PLAYER, NAME, PLAYED_WHOLE_MATCH, MINUTE_ENTERED, MINUTE_LEFT, GOALS, FOULS, YELLOW_CARDS, RED_CARD, ID_TEAM) VALUES("
                        + (playerId--) + ",'"
                        + database.getAllMatches().get(lastMatch).getGuestTeam().getPlayers().get(i).getPlayerName() + "',"
                        + database.getAllMatches().get(lastMatch).getGuestTeam().getPlayers().get(i).getPlayedWholeTime() + ","
                        + database.getAllMatches().get(lastMatch).getGuestTeam().getPlayers().get(i).getEntryTime() + ","
                        + database.getAllMatches().get(lastMatch).getGuestTeam().getPlayers().get(i).getLeftTime() + ","
                        + database.getAllMatches().get(lastMatch).getGuestTeam().getPlayers().get(i).getScoredGoals() + ","
                        + database.getAllMatches().get(lastMatch).getGuestTeam().getPlayers().get(i).getFouls() + ","
                        + database.getAllMatches().get(lastMatch).getGuestTeam().getPlayers().get(i).getYellowCards() + ","
                        + database.getAllMatches().get(lastMatch).getGuestTeam().getPlayers().get(i).getRedCard() + ","
                        + guestTeamId + ")"
                );
            }

            // add host team to jdbc database
            statement.executeUpdate("INSERT INTO TEAM (ID_TEAM, COUNTRY_NAME_TEAM, COACH_NAME_TEAM, NAME_TEAM) VALUES("
                    + hostTeamId + ",'"
                    + database.getAllMatches().get(lastMatch).getHostTeam().getTeamCountryName() + "','"
                    + database.getAllMatches().get(lastMatch).getHostTeam().getCoachName() + "','"
                    + database.getAllMatches().get(lastMatch).getHostTeam().getTeamName() + "')"
            );

            // add guest team to jdbc database
            statement.executeUpdate("INSERT INTO TEAM (ID_TEAM, COUNTRY_NAME_TEAM, COACH_NAME_TEAM, NAME_TEAM) VALUES("
                    + guestTeamId + ",'"
                    + database.getAllMatches().get(lastMatch).getGuestTeam().getTeamCountryName() + "','"
                    + database.getAllMatches().get(lastMatch).getGuestTeam().getCoachName() + "','"
                    + database.getAllMatches().get(lastMatch).getGuestTeam().getTeamName() + "')"
            );

            String matchId = Integer.toString(lastMatch + 1);

            int arbitratorId = 0;
            for (int i = 0; i < database.getAllMatches().size(); i++) {
                arbitratorId += database.getAllMatches().get(i).getArbitratorAssistants().size();
            }

            // add arbitrator assistants to jdbc database
            for (int i = 0; i < database.getAllMatches().get(lastMatch).getArbitratorAssistants().size(); i++) {
                statement.executeUpdate("INSERT INTO ARBITERS (ID_ARBITRATOR, ARBITRATOR_NAME, ARBITRATOR_MATCH_ID) VALUES("
                        + (arbitratorId--) + ",'"
                        + database.getAllMatches().get(lastMatch).getArbitratorAssistants().get(i) + "',"
                        + (matchId) + ")"
                );
            }

            // add match to jdbc database
            statement.executeUpdate("INSERT INTO MATCHES (ID_MATCH, LENGTH_MATCH, ARBITER_NAME_MATCH, HOST_TEAM_ID, GUEST_TEAM_ID) VALUES ("
                    + (matchId) + ","
                    + database.getAllMatches().get(lastMatch).getMatchTime() + ",'"
                    + database.getAllMatches().get(lastMatch).getArbiterName() + "',"
                    + hostTeamId + ","
                    + guestTeamId + ")"
            );

        } catch (SQLException e) {
            out.println("Error while adding new records to JDBC database!<br>");
            out.println("SQL exception: " + e.getMessage());
        }
        session.setAttribute("connection", connection);
        response.sendRedirect("/MatchStatistics");
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
        return "Servlet saves match information to the database.";
    }// </editor-fold>
}
