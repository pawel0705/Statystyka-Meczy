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

/**
 * Servlet removes one match from the database with the given id.
 *
 * @author Paweł Salicki
 * @version 1.0
 */
@WebServlet(urlPatterns = {"/DeleteOneMatch"})
public class DeleteOneMatch extends HttpServlet {

    /**
     * Match id to delete.
     */
    private int deleteMatchId;

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * The method acquires the match id address to be deleted from the database
     * and then deletes it.
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
            deleteMatchId = Integer.parseInt(request.getParameter("deleteMatchId"));
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Wrong match id!");
        }

        if (database == null) {
            out.println("First add match to database!<br>");
        } else {
            if (!database.hasMatchInData(deleteMatchId)) {
                out.println("This match does not exist in the database!<br>");
            } else {
                database.deleteMatchById(deleteMatchId);
                out.println("The match has been successfully deleted.<br>");
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
        return "Servlet removes the match with the given id from the database.";
    }// </editor-fold>
}
