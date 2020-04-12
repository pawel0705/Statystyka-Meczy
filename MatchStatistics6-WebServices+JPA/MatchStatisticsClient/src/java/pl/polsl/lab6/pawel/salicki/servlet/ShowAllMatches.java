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
 * Servlet listing basic information about all matches from the database to the
 * user.
 *
 * @author Paweł Salicki
 * @version 2.0
 */
@WebServlet(urlPatterns = {"/ShowAllMatches"})
public class ShowAllMatches extends HttpServlet {
    /**
     * WebService manager.
     */
    @WebServiceRef(wsdlLocation = "http://localhost:8080/MatchStatisticsWebService/ManageContainerService?wsdl")
    private ManageContainerService_Service service;

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

        System.out.println("*--ALL MATCHES STATISTICS IN DATABASE--*");
        int matchNr = 0;

        ArrayList<String> matchesInfo = new ArrayList<>();
        matchesInfo = (ArrayList<String>) getBasicMatchesInfo();

        int i = 1;
        for (int j = 0; j < Integer.parseInt(matchesInfo.get(0)); j++) {
            matchNr++;

            out.format("*--MATCH NR:. %s: --*<br>", matchNr);
            out.format("#Match ID: %s<br>", matchesInfo.get(i++));
            out.format("#Arbiter name: %s<br>", matchesInfo.get(i++));
            out.println("#Arbitrator assistants:<br>");

            int arbitersAmount = Integer.parseInt(matchesInfo.get(i++));
            for (int k = 0; k < arbitersAmount; k++) {
                out.format("-%s<br>", matchesInfo.get(i++));
            }

            out.format("#The length of the match: %smin<br>", matchesInfo.get(i++));
            out.println("HOST TEAM - GUEST TEAM<br>");
            out.format("%s  vs  %s<br>", matchesInfo.get(i++),
                    matchesInfo.get(i++));
            out.format("Place of the match: %s<br>", matchesInfo.get(i++));
            out.format("Fouls in match: %s<br>", matchesInfo.get(i++));
            out.format("Match result: %s-%s<br>", matchesInfo.get(i++),
                    matchesInfo.get(i++));
            out.format("Game status: %s<br>", matchesInfo.get(i++));
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

    /**
     * The method connects to WebServices and returns basic information about
     * matches from the database.
     *
     * @return A container storing match information in the form of strings.
     */
    private java.util.List<java.lang.String> getBasicMatchesInfo() {

        pl.polsl.lab6.pawel.salicki.webServices.ManageContainerService port = service.getManageContainerServicePort();
        return port.getBasicMatchesInfo();
    }

}
