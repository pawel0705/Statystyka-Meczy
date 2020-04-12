package pl.polsl.lab4.pawel.salicki.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet responsible for adding a new match to the database. Creates fields
 * for entering information that the user must complete.
 *
 * @author Paweł Salicki
 * @version 1.0
 */
@WebServlet(urlPatterns = {"/AddNewMatch"})
public class AddNewMatch extends HttpServlet {

    /**
     * Number of hosting team players.
     */
    private int nrPlayersHostTeam;
    /**
     * Number of guest team players.
     */
    private int nrPlayersGuestTeam;
    /**
     * Number of arbitrator assistants.
     */
    private int nrArbitratorAssistants;

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * Method that prints out fields in the browser to enter information.
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
            out.println("Create a database first!<br>");
        } else {
            try {
                nrPlayersHostTeam = Integer.parseInt(request.getParameter("numberOfHostTeamPlayers"));
                nrPlayersGuestTeam = Integer.parseInt(request.getParameter("numberOfGuestTeamPlayers"));
                nrArbitratorAssistants = Integer.parseInt(request.getParameter("numberOfArbitratorAssistants"));
            } catch (NumberFormatException e) {
                out.println("You must complete all fields in the form of numbers!<br>");
            }

            if (nrPlayersHostTeam < 1 || nrPlayersGuestTeam < 1 || nrArbitratorAssistants < 0) {
                out.println("There must be at least 1 player each team!<br>");
                out.println("Number of arbitrator assistants must be 0 or positive value!<br>");
            } else {
                session.setAttribute("numberOfHostTeamPlayers", nrPlayersHostTeam);
                session.setAttribute("numberOfGuestTeamPlayers", nrPlayersGuestTeam);
                session.setAttribute("numberOfArbitratorAssistants", nrArbitratorAssistants);
                out.println("<form action=\"AddNewMatchSecond\">\n");

                out.println("Arbiter name:&emsp;<input type=text size=10 name=arbiterName> <br>");
                out.println("Match length in minutes:&emsp;<input type=text size=10 name=matchLength> <br>");
                out.println("Host team name:&emsp;<input type=text size=10 name=hostTeamName> <br>");
                out.println("Guest team name:&emsp;<input type=text size=10 name=guestTeamName> <br>");
                out.println("Host's team coach name:&emsp;<input type=text size=10 name=hostTeamCoachName> <br>");
                out.println("Guest's team coach name:&emsp;<input type=text size=10 name=guestTeamCoachName> <br>");
                out.println("Country of host team:&emsp;<input type=text size=10 name=hostTeamCountry> <br>");
                out.println("Country of guest team:&emsp;<input type=text size=10 name=guestTeamCountry> <br>");

                out.println("ARBITRATOR ASSISTANTS <br>");
                out.println("NR &emsp; Arbitrator name<br>");
                for (int i = 0; i < nrArbitratorAssistants; i++) {
                    out.println(i + 1);
                    out.println("&emsp;<input type=text size=10 name=arbitratorAssistantName" + i + ">");

                    out.println("<br>");
                }

                out.println("<br>");

                out.println("HOST TEAM PLAYERS <br>");
                out.println("NR&emsp;Player name&emsp;Entered minute&emsp;Left minute&emsp;Goals amount&emsp;Fouls amount&emsp;Yellow cards&emsp;Red cards&emsp;<br>");

                for (int i = 0; i < nrPlayersHostTeam; i++) {
                    out.println(i + 1);
                    out.println("&emsp;<input type=text size=8 name=playerHostName" + i + ">");
                    out.println("&emsp;<input type=text size=8 name=playerHostEnteredMinute" + i + ">");
                    out.println("&emsp;<input type=text size=8 name=playerHostLeftMinute" + i + ">");
                    out.println("&emsp;<input type=text size=8 name=playerHostGoals" + i + ">");
                    out.println("&emsp;<input type=text size=8 name=playerHostFouls" + i + ">");
                    out.println("&emsp;<input type=text size=8 name=playerHostYellowCards" + i + ">");
                    out.println("&emsp;<input type=text size=8 name=playerHostRedCards" + i + ">");

                    out.println("<br>");
                }

                out.println("<br>");

                out.println("GUEST TEAM PLAYERS <br>");
                out.println("NR&emsp;Player name&emsp;Entered minute&emsp;Left minute&emsp;Goals amount&emsp;Fouls amount&emsp;Yellow cards&emsp;Red cards&emsp;<br>");

                for (int i = 0; i < nrPlayersGuestTeam; i++) {
                    out.println(i + 1);
                    out.println("&emsp;<input type=text size=8 name=playerGuestName" + i + ">");
                    out.println("&emsp;<input type=text size=8 name=playerGuestEnteredMinute" + i + ">");
                    out.println("&emsp;<input type=text size=8 name=playerGuestLeftMinute" + i + ">");
                    out.println("&emsp;<input type=text size=8 name=playerGuestGoals" + i + ">");
                    out.println("&emsp;<input type=text size=8 name=playerGuestFouls" + i + ">");
                    out.println("&emsp;<input type=text size=8 name=playerGuestYellowCards" + i + ">");
                    out.println("&emsp;<input type=text size=8 name=playerGuestRedCards" + i + ">");

                    out.println("<br>");
                }
                out.println("ALL fields must be filled with valid values. <br>Where the number is expected in the form of goals, time etc ... the number should be entered. <br>If these conditions are not met, the match will not be added to the database!<br>");
                out.println("<input type=\"submit\" value=\"AddNewMatch\" />");
                out.println("</form>");
            }
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * Calls the doGet method.
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
        return "Servlet that prints fields for user to enter information about the match.";
    }// </editor-fold>
}
