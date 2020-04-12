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
import pl.polsl.lab6.pawel.salicki.webServices.ManageContainerService_Service;

/**
 * Servlet displays to the user the all records of all tables from the JDBC
 * database.
 *
 * @author Paweł Salicki
 * @version 2.0
 */
@WebServlet(name = "ShowDatabase", urlPatterns = {"/ShowDatabase"})
public class ShowDatabase extends HttpServlet {
    /**
     * WebService manager.
     */
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/MatchStatisticsWebService/ManageContainerService.wsdl")
    private ManageContainerService_Service service;

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

        List<pl.polsl.lab6.pawel.salicki.webServices.Matches> matchesList = this.showDatabaseMatchesList("Matches.findAll");
        List<pl.polsl.lab6.pawel.salicki.webServices.Arbiters> arbitersList = this.showDatabaseArbitersList("Arbiters.findAll");
        List<pl.polsl.lab6.pawel.salicki.webServices.Team> teamList = this.showDatabaseTeamList("Team.findAll");
        List<pl.polsl.lab6.pawel.salicki.webServices.Players> playersList = this.showDatabasePlayersList("Players.findAll");

        out.println("<h3>MATCHES table:</h3>");

        out.println("<TABLE BORDER>");
        out.println("<TR><TD>ID</TD><TD>LENGTH</TD><TD>ARBITER NAME</TD><TD>HOST TEAM ID</TD><TD>GUEST TEAM ID</TD></TR>");
        for (pl.polsl.lab6.pawel.salicki.webServices.Matches matches : matchesList) {
            out.println("<TR>" + "<TD>" + matches.getId() + "</TD>");
            out.println("<TD>" + matches.getLengthmatch() + "</TD>");
            out.println("<TD>" + matches.getArbiternamematch() + "</TD>");
            out.println("<TD>" + matches.getHostteamid() + "</TD>");
            out.println("<TD>" + matches.getGuestteamid() + "</TD>" + "</TR>");
        }
        out.println("</TABLE>");

        out.println("<h3>ARBITERS table:</h3>");
        out.println("<TABLE BORDER>");
        out.println("<TR><TD>ID</TD><TD>ARBITRATOR NAME</TD><TD>ARBITRATOR MATCH ID</TD><TR>");
        for (pl.polsl.lab6.pawel.salicki.webServices.Arbiters arbiters : arbitersList) {
            out.println("<TR>" + "<TD>" + arbiters.getId() + "</TD>");
            out.println("<TD>" + arbiters.getArbitratorname() + "</TD>");
            out.println("<TD>" + arbiters.getArbitratormatchid() + "</TD>" + "</TR>");
        }
        out.println("</TABLE>");

        out.println("<h3>TEAM table:</h3>");
        out.println("<TABLE BORDER>");
        out.println("<TR><TD>ID</TD><TD>COUNTRY NAME</TD><TD>COACH NAME</TD><TD>TEAM NAME</TD></TR>");
        for (pl.polsl.lab6.pawel.salicki.webServices.Team team : teamList) {
            out.println("<TR>" + "<TD>" + team.getId() + "</TD>");
            out.println("<TD>" + team.getCountrynameteam() + "</TD>");
            out.println("<TD>" + team.getCoachnameteam() + "</TD>");
            out.println("<TD>" + team.getNameteam() + "</TD>" + "</TR>");
        }
        out.println("</TABLE>");

        out.println("<h3>PLAYERS table:</h3>");

        out.println("<TABLE BORDER>");
        out.println("<TR><TD>ID</TD><TD>NAME</TD><TD>MINUTE ENTERED</TD>"
                + "<TD>MINUTE LEFT</TD><TD>GOALS</TD><TD>FOULS</TD>"
                + "<TD>YELLOW CARDS</TD><TD>ID TEAM</TD></TR>");
        for (pl.polsl.lab6.pawel.salicki.webServices.Players players : playersList) {
            out.println("<TR>" + "<TD>" + players.getId() + "</TD>");
            out.println("<TD>" + players.getName() + "</TD>");
            out.println("<TD>" + players.getMinuteentered() + "</TD>");
            out.println("<TD>" + players.getMinuteleft() + "</TD>");
            out.println("<TD>" + players.getGoals() + "</TD>");
            out.println("<TD>" + players.getFouls() + "</TD>");
            out.println("<TD>" + players.getYellowcards() + "</TD>");
            out.println("<TD>" + players.getIdteam() + "</TD>" + "</TR>");
        }
        out.println("</TABLE>");
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

    /**
     * The method connects to WebServices and returns the result of the database
     * query.
     *
     * @param queryName query
     * @return list of arbiters
     */
    private java.util.List<pl.polsl.lab6.pawel.salicki.webServices.Arbiters> showDatabaseArbitersList(java.lang.String queryName) {

        pl.polsl.lab6.pawel.salicki.webServices.ManageContainerService port = service.getManageContainerServicePort();
        return port.showDatabaseArbitersList(queryName);
    }

    /**
     * The method connects to WebServices and returns the result of the database
     * query.
     *
     * @param queryName query
     * @return list of maches
     */
    private java.util.List<pl.polsl.lab6.pawel.salicki.webServices.Matches> showDatabaseMatchesList(java.lang.String queryName) {

        pl.polsl.lab6.pawel.salicki.webServices.ManageContainerService port = service.getManageContainerServicePort();
        return port.showDatabaseMatchesList(queryName);
    }

    /**
     * The method connects to WebServices and returns the result of the database
     * query.
     *
     * @param queryName query
     * @return list of players
     */
    private java.util.List<pl.polsl.lab6.pawel.salicki.webServices.Players> showDatabasePlayersList(java.lang.String queryName) {

        pl.polsl.lab6.pawel.salicki.webServices.ManageContainerService port = service.getManageContainerServicePort();
        return port.showDatabasePlayersList(queryName);
    }

    /**
     * The method connects to WebServices and returns the result of the database
     * query.
     *
     * @param queryName query
     * @return list og teams
     */
    private java.util.List<pl.polsl.lab6.pawel.salicki.webServices.Team> showDatabaseTeamList(java.lang.String queryName) {

        pl.polsl.lab6.pawel.salicki.webServices.ManageContainerService port = service.getManageContainerServicePort();
        return port.showDatabaseTeamList(queryName);
    }

}
