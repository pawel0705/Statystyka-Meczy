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
 * Servlet displaying the main page if the user is logged in.
 *
 * @author Paweł Salicki
 * @version 1.0
 */
@WebServlet(urlPatterns = {"/MainPage"})
public class MainPage extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * Method that checks if the user is logged in. If so, it allows the user to
     * the main page.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        request.getRequestDispatcher("link.html").include(request, response);

        HttpSession session = request.getSession(false);
        if (session != null) {
            String name = (String) session.getAttribute("name");

            request.getRequestDispatcher("mainPage.html").include(request, response);

        } else {
            out.print("You must be logged in to access the main page.");
            request.getRequestDispatcher("login.html").include(request, response);
        }
        out.close();
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
        doPost(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "The servlet redirects the user to the main page if is logged in.";
    }// </editor-fold>

}
