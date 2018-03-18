/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.UserDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import model.User;
import utils.InputValidator;
import utils.RedirectHelper;

/**
 *
 * @author emsnguyen
 */
public class SignUpController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("signup.jsp").forward(request, response);
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
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UserDAO userDB = new UserDAO();
        String checkUsername = InputValidator.isUsernameValid(username);
        String checkPassword = InputValidator.isPasswordValid(password);
        if (!checkUsername.equals("") || !checkPassword.equals("")) {
            request.setAttribute("wrongUsername", checkUsername);
            request.setAttribute("wrongPassword", checkPassword);
            request.getRequestDispatcher("signup.jsp").forward(request, response);
        } else if (userDB.isUsernameExisted(username.trim())) {
            request.setAttribute("wrongUsername", "Tên đăng nhập đã tồn tại!");
            request.getRequestDispatcher("signup.jsp").forward(request, response);
        } else {
            User u = new User();
            u.setUsername(username);
            u.setPassword(password);
            u.setPoint(0);
            u.setRollID(2);
            if (userDB.insert(u)) {
                request.getSession().setAttribute("user", u);
                response.sendRedirect("home2.jsp");
//                String urlToRedirect = RedirectHelper.redirectAfterAuthentication(u, "addquestion", "study");
//                response.sendRedirect(urlToRedirect);
            } else {
                request.setAttribute("noFileChosen", "Database Error");
                request.getRequestDispatcher("signup.jsp").forward(request, response);
            }
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
