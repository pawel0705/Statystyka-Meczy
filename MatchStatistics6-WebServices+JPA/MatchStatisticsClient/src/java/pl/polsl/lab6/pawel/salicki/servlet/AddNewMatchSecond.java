package pl.polsl.lab6.pawel.salicki.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.WebServiceRef;
import pl.polsl.lab6.pawel.salicki.webServices.ManageContainerService_Service;

/**
 * Servlet saves match information to the database. Servlet obtains information
 * with the help of the AddNewMatch servlet. Servlet adds a new match to the JPA
 * database.
 *
 * @author Paweł Salicki
 * @version 3.0
 */
@WebServlet(urlPatterns = {"/AddNewMatchSecond"})
public class AddNewMatchSecond extends HttpServlet {
    /**
     * WebService manager.
     */
    @WebServiceRef(wsdlLocation = "http://localhost:8080/MatchStatisticsWebService/ManageContainerService?wsdl")
    private ManageContainerService_Service service;

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
            // get information from user
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

            for (int i = 0; i < (int) session.getAttribute("numberOfHostTeamPlayers"); i++) {
                String playerHostName = request.getParameter("playerHostName" + i);
                int playerHostEnteredMinute = Integer.parseInt(request.getParameter("playerHostEnteredMinute" + i));
                int playerHostLeftMinute = Integer.parseInt(request.getParameter("playerHostLeftMinute" + i));
                int playerHostGoals = Integer.parseInt(request.getParameter("playerHostGoals" + i));
                int playerHostFouls = Integer.parseInt(request.getParameter("playerHostFouls" + i));
                int playerHostYellowCards = Integer.parseInt(request.getParameter("playerHostYellowCards" + i));
                int playerHostRedCards = Integer.parseInt(request.getParameter("playerHostRedCards" + i));

                addHostPlayer(playerHostName, playerHostGoals, playerHostEnteredMinute,
                        playerHostLeftMinute, playerHostYellowCards, playerHostFouls,
                        matchLength, playerHostRedCards);

            }
            createHostSoccerTeam(hostTeamName, hostTeamCountry, hostTeamCoachName);

            for (int i = 0; i < (int) session.getAttribute("numberOfGuestTeamPlayers"); i++) {
                String playerGuestName = request.getParameter("playerGuestName" + i);
                int playerGuestEnteredMinute = Integer.parseInt(request.getParameter("playerGuestEnteredMinute" + i));
                int playerGuestLeftMinute = Integer.parseInt(request.getParameter("playerGuestLeftMinute" + i));
                int playerGuestGoals = Integer.parseInt(request.getParameter("playerGuestGoals" + i));
                int playerGuestFouls = Integer.parseInt(request.getParameter("playerGuestFouls" + i));
                int playerGuestYellowCards = Integer.parseInt(request.getParameter("playerGuestYellowCards" + i));
                int playerGuestRedCards = Integer.parseInt(request.getParameter("playerGuestRedCards" + i));

                addGuestPlayer(playerGuestName, playerGuestGoals, playerGuestEnteredMinute,
                        playerGuestLeftMinute, playerGuestYellowCards, playerGuestFouls,
                        matchLength, playerGuestRedCards);
            }
            createGuestSoccerTeam(guestTeamName, guestTeamCountry, guestTeamCoachName);

            addNewMatch(matchLength, arbiterName, arbitratorAssistants);

            this.addNewMatchToJPA();
        } catch (NumberFormatException e) {
            out.println("Fill ALL fields with the correct values!");
        }

        request.getRequestDispatcher("mainPage.html").include(request, response);
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

    /**
     * The method connects to WebService and adds the player to the database.
     *
     * @param playerGuestName name of guest player
     * @param playerGuestGoals amount of scored goals by guest player
     * @param playerGuestEnteredMinute minute that guest player entered on the
     * field
     * @param playerGuestLeftMinute minute that guest player left from the field
     * @param playerGuestYellowCards amount of yellow cards collected by guest
     * player
     * @param playerGuestFouls amount of fouls
     * @param matchLength length of player on the field
     * @param playerGuestRedCards did the player get a red card
     */
    private void addGuestPlayer(java.lang.String playerGuestName, int playerGuestGoals, int playerGuestEnteredMinute, int playerGuestLeftMinute, int playerGuestYellowCards, int playerGuestFouls, int matchLength, int playerGuestRedCards) {

        pl.polsl.lab6.pawel.salicki.webServices.ManageContainerService port = service.getManageContainerServicePort();
        port.addGuestPlayer(playerGuestName, playerGuestGoals, playerGuestEnteredMinute, playerGuestLeftMinute, playerGuestYellowCards, playerGuestFouls, matchLength, playerGuestRedCards);
    }

    /**
     * The method connects to WebService and adds the player to the database.
     *
     * @param playerHostName name of guest player
     * @param playerHostGoals amount of scored goals by guest player
     * @param playerHostEnteredMinute minute that guest player entered on the
     * field
     * @param playerHostLeftMinute minute that guest player left from the field
     * @param playerHostYellowCards amount of yellow cards collected by guest
     * player
     * @param playerHostFouls amount of fouls
     * @param matchLength length of player on the field
     * @param playerHostRedCards did the player get a red card
     */
    private void addHostPlayer(java.lang.String playerHostName, int playerHostGoals, int playerHostEnteredMinute, int playerHostLeftMinute, int playerHostYellowCards, int playerHostFouls, int matchLength, int playerHostRedCards) {

        pl.polsl.lab6.pawel.salicki.webServices.ManageContainerService port = service.getManageContainerServicePort();
        port.addHostPlayer(playerHostName, playerHostGoals, playerHostEnteredMinute, playerHostLeftMinute, playerHostYellowCards, playerHostFouls, matchLength, playerHostRedCards);
    }

    /**
     * The method connects to WebService and adds a new match to the database.
     *
     * @param matchLength match length in minutes
     * @param arbiterName name of the main arbiter
     * @param arbitratorAssistants names of arbitrator assistants
     */
    private void addNewMatch(int matchLength, java.lang.String arbiterName, java.util.List<java.lang.String> arbitratorAssistants) {

        pl.polsl.lab6.pawel.salicki.webServices.ManageContainerService port = service.getManageContainerServicePort();
        port.addNewMatch(matchLength, arbiterName, arbitratorAssistants);
    }

    /**
     * The method connects to WebService and adds a new guest team to the
     * database.
     *
     * @param guestTeamName name of guest team
     * @param guestTeamCountry country of guest team
     * @param guestTeamCoachName main coach of guest team
     */
    private void createGuestSoccerTeam(java.lang.String guestTeamName, java.lang.String guestTeamCountry, java.lang.String guestTeamCoachName) {

        pl.polsl.lab6.pawel.salicki.webServices.ManageContainerService port = service.getManageContainerServicePort();
        port.createGuestSoccerTeam(guestTeamName, guestTeamCountry, guestTeamCoachName);
    }

    /**
     * The method connects to WebService and adds a new host team to the
     * database.
     *
     * @param hostTeamName name of host team
     * @param hostTeamCountry country of host team
     * @param hostTeamCoachName main coach of host team
     */
    private void createHostSoccerTeam(java.lang.String hostTeamName, java.lang.String hostTeamCountry, java.lang.String hostTeamCoachName) {

        pl.polsl.lab6.pawel.salicki.webServices.ManageContainerService port = service.getManageContainerServicePort();
        port.createHostSoccerTeam(hostTeamName, hostTeamCountry, hostTeamCoachName);
    }

    /**
     * The method connects to WebService and adds a new match to JPA entity.
     */
    private void addNewMatchToJPA() {

        pl.polsl.lab6.pawel.salicki.webServices.ManageContainerService port = service.getManageContainerServicePort();
        port.addNewMatchToJPA();
    }

}
