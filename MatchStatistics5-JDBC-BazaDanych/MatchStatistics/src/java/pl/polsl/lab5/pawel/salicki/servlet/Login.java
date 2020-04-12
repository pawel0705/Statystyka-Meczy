package pl.polsl.lab5.pawel.salicki.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet supporting user login.
 *
 * @author Paweł Salicki
 * @version 1.0
 */
@WebServlet(urlPatterns = {"/Login"})
public class Login extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * The method checks using cookies whether an account with the given login
     * and password exists.
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

        int loginCounter = 0;
        String loginName = request.getParameter("name");
        String password = request.getParameter("password");

        Cookie[] cookies = request.getCookies();
 
        boolean userExist = false;
        try {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("login" + loginCounter)) {
                    if (cookie.getValue().equals(loginName + " " + password)) {
                        userExist = true;
                        break;
                    }
                    loginCounter++;
                }
            }
        } catch (NullPointerException e) {
            out.print("There is no account set up yet.");
        }

        if (userExist) {
            out.print("You are logged in " + loginName + ". You can go to the main page.");
            HttpSession session = request.getSession();
            session.setAttribute("name", loginName);
        } else {
            out.print("Wrong username or password! Try again or create account");
            request.getRequestDispatcher("login.html").include(request, response);
        }
        out.close();
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
        return "Servlet supporting user login.";
    }// </editor-fold>

}
