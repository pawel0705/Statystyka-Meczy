package pl.polsl.lab6.pawel.salicki.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.WebServiceRef;
import pl.polsl.lab6.pawel.salicki.webServices.Arbiters;
import pl.polsl.lab6.pawel.salicki.webServices.ManageContainerService_Service;
import pl.polsl.lab6.pawel.salicki.webServices.Matches;

/**
 * Servlet listing detailed information about one particular match.
 *
 * @author Paweł Salicki
 * @version 3.0
 */
@WebServlet(urlPatterns = {"/ShowOneMatch"})
public class ShowOneMatch extends HttpServlet {

    /**
     * WebService manager.
     */
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/MatchStatisticsWebService/ManageContainerService.wsdl")
    private ManageContainerService_Service service;

    /**
     * Match id from database.
     */
    private int matchId;

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

        try {
            matchId = Integer.parseInt(request.getParameter("matchId"));
        } catch (NumberFormatException e) {
            out.println("Wrong match id!<br>");
        }

        List<Matches> matchesList = this.matchesCreateQuery("SELECT m FROM Matches m WHERE m.id=" + matchId);

        for (Matches matches : matchesList) {
            out.format("#Match ID: %s<br>", matchId);
            out.format("#The length of the match: %smin<br>", matches.getLengthmatch());
            out.format("#Arbiter name: %s<br>", matches.getArbiternamematch());
            out.println("#Arbitrator assistants:<br>");
        }

        int hostTeamId = matchesList.get(0).getHostteamid();
        int guestTeamId = matchesList.get(0).getGuestteamid();

        List<Arbiters> arbitersList = this.arbitersCreateQuery("SELECT a FROM Arbiters a WHERE a.arbitratormatchid=" + matchId);

        for (Arbiters arbiters : arbitersList) {
            out.format("-%s<br>", arbiters.getArbitratorname());
        }

        List<pl.polsl.lab6.pawel.salicki.webServices.Players> playerHostList = this.playerCreateQuery("SELECT p FROM Players p WHERE p.idteam=" + hostTeamId);

        List<pl.polsl.lab6.pawel.salicki.webServices.Players> playerGuestList = this.playerCreateQuery("SELECT p FROM Players p WHERE p.idteam=" + guestTeamId);

        List<pl.polsl.lab6.pawel.salicki.webServices.Team> teamHostList = this.teamCreateQuery("SELECT t FROM Team t WHERE t.id=" + hostTeamId);

        List<pl.polsl.lab6.pawel.salicki.webServices.Team> teamGuestList = this.teamCreateQuery("SELECT t FROM Team t WHERE t.id=" + guestTeamId);

        out.format("Hosting event team: %s<br>", teamHostList.get(0).getNameteam());
        out.format("Coach of team %s: %s<br>", teamHostList.get(0).getNameteam(), teamHostList.get(0).getCoachnameteam());
        out.format("Team's country: %s<br>", teamHostList.get(0).getCountrynameteam());

        int playerCounter = 0;
        for (pl.polsl.lab6.pawel.salicki.webServices.Players playerHost : playerHostList) {
            playerCounter++;
            out.format("%s. Player name: %s<br>", playerCounter, playerHost.getName());
            out.format("%s. Goals scored: %s<br>", playerCounter, playerHost.getGoals());
            out.format("%s. Entered the game on %s min<br>", playerCounter, playerHost.getMinuteentered());
            out.format("%s. Left the game on %s min<br>", playerCounter, playerHost.getMinuteleft());
            out.format("%s. Amount of yellow cards: %s<br>", playerCounter, playerHost.getYellowcards());
        }

        out.format("Guest team: %s<br>", teamGuestList.get(0).getNameteam());
        out.format("Coach of team %s: %s<br>", teamGuestList.get(0).getNameteam(), teamGuestList.get(0).getCoachnameteam());
        out.format("Team's country: %s<br>", teamGuestList.get(0).getCountrynameteam());

        playerCounter = 0;
        for (pl.polsl.lab6.pawel.salicki.webServices.Players playerGuest : playerGuestList) {
            playerCounter++;
            out.format("%s. Player name: %s<br>", playerCounter, playerGuest.getName());
            out.format("%s. Goals scored: %s<br>", playerCounter, playerGuest.getGoals());
            out.format("%s. Entered the game on %s min<br>", playerCounter, playerGuest.getMinuteentered());
            out.format("%s. Left the game on %s min<br>", playerCounter, playerGuest.getMinuteleft());
            out.format("%s. Amount of yellow cards: %s<br>", playerCounter, playerGuest.getYellowcards());
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

    /**
     * The method connects to WebServices and returns the result of the database query.
     * @param query query
     * @return list of teams
     */
    private java.util.List<pl.polsl.lab6.pawel.salicki.webServices.Team> teamCreateQuery(java.lang.String query) {

        pl.polsl.lab6.pawel.salicki.webServices.ManageContainerService port = service.getManageContainerServicePort();
        return port.teamCreateQuery(query);
    }

    /**
     * The method connects to WebServices and returns the result of the database query.
     * @param query query
     * @return list of players
     */
    private java.util.List<pl.polsl.lab6.pawel.salicki.webServices.Players> playerCreateQuery(java.lang.String query) {

        pl.polsl.lab6.pawel.salicki.webServices.ManageContainerService port = service.getManageContainerServicePort();
        return port.playerCreateQuery(query);
    }

    /**
     * The method connects to WebServices and returns the result of the database query.
     * @param query query
     * @return list of arbiters
     */
    private java.util.List<pl.polsl.lab6.pawel.salicki.webServices.Arbiters> arbitersCreateQuery(java.lang.String query) {

        pl.polsl.lab6.pawel.salicki.webServices.ManageContainerService port = service.getManageContainerServicePort();
        return port.arbitersCreateQuery(query);
    }

    /**
     * The method connects to WebServices and returns the result of the database query.
     * @param query query
     * @return list of matches
     */
    private java.util.List<pl.polsl.lab6.pawel.salicki.webServices.Matches> matchesCreateQuery(java.lang.String query) {

        pl.polsl.lab6.pawel.salicki.webServices.ManageContainerService port = service.getManageContainerServicePort();
        return port.matchesCreateQuery(query);
    }

}
