package pl.polsl.lab6.pawel.salicki.servlet;

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
 * Servlet creating a new user account.
 *
 * @author Paweł Salicki
 * @version 1.0
 */
@WebServlet(urlPatterns = {"/Register"})
public class Register extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * The method creates a new user account.
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
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");

        if (name.contains(" ") || password.contains(" ") || confirmPassword.contains(" ") 
                || password.isEmpty() || name.isEmpty() || confirmPassword.isEmpty()) {
            out.print("There must be no spaces in the login and password!");
            request.getRequestDispatcher("register.html").include(request, response);
        } else {
            if (password.equals(confirmPassword)) {

                Cookie[] cookies = request.getCookies();

                boolean userExist = false;
                try {
                    for (Cookie cookie : cookies) {
                        if (cookie.getName().equals("login" + loginCounter)) {
                            if (cookie.getValue().contains(name + " ")) {
                                userExist = true;
                                break;
                            }
                            loginCounter++;
                        }
                    }
                } catch (NullPointerException e) {
                }

                if (!userExist) {
                    Cookie cookieLogin = new Cookie("login" + loginCounter, name + " " + password);
                    response.addCookie(cookieLogin);

                    out.print("Welcome, " + name + "\n Your account has been created");
                    HttpSession session = request.getSession();
                    session.setAttribute("name", name);
                } else {
                    out.print("An account with this login is already registered!");
                    request.getRequestDispatcher("register.html").include(request, response);
                }
            } else {
                out.print("Sorry, passwords do not match.");
                request.getRequestDispatcher("register.html").include(request, response);
            }
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
        doGet(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Servlet for creating user account.";
    }// </editor-fold>

}
