package pl.polsl.lab4.pawel.salicki.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pl.polsl.lab4.pawel.salicki.model.Database;
import pl.polsl.lab4.pawel.salicki.model.Match;
import pl.polsl.lab4.pawel.salicki.model.Player;
import pl.polsl.lab4.pawel.salicki.model.SoccerTeam;

/**
 * Servlet saves match information to the database. Servlet obtains information
 * with the help of the AddNewMatch servlet.
 *
 * @author Paweł Salicki
 * @version 1.0
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

        try {
            Database database = (Database) session.getAttribute("database");

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
