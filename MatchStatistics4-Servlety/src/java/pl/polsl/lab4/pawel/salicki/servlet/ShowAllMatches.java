package pl.polsl.lab4.pawel.salicki.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pl.polsl.lab4.pawel.salicki.model.Database;
import pl.polsl.lab4.pawel.salicki.model.Match;

/**
 * Servlet listing basic information about all matches from the database to the
 * user.
 *
 * @author Paweł Salicki
 * @version 1.0
 */
@WebServlet(urlPatterns = {"/ShowAllMatches"})
public class ShowAllMatches extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * A method that prints basic information about matches from the database.
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
            if(database.getAllMatches().size() == 0){
                out.println("Database empty!");
            }
            
            System.out.println("*--ALL MATCHES STATISTICS IN DATABASE--*");
            int matchNr = 0;

            for (Match match : database.getAllMatches()) {
                matchNr++;

                out.format("*--MATCH NR:. %s: --*<br>", matchNr);
                out.format("#Match ID: %s<br>", match.getMatchId());
                out.format("#Arbiter name: %s<br>", match.getArbiterName());
                out.println("#Arbitrator assistants:<br>");

                match.getArbitratorAssistants().forEach((assistant) -> {
                    out.format("-%s<br>", assistant);
                });

                out.format("#The length of the match: %smin<br>", match.getMatchTime());
                out.println("HOST TEAM - GUEST TEAM<br>");
                out.format("%s  vs  %s<br>", match.getHostTeam().getTeamName(),
                        match.getGuestTeam().getTeamName());
                out.format("Place of the match: %s<br>", match.getPlaceOfTheMatch());
                out.format("Fouls in match: %s<br>", match.calculateFouls());
                out.format("Match result: %s-%s<br>", match.getHostTeam().calculateGoals(),
                        match.getGuestTeam().calculateGoals());
                out.format("Game status: %s<br>", match.chooseTheWinnerTeam());
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
        return "Servlet listing basic information about all matches from the database.";
    }// </editor-fold>

}
