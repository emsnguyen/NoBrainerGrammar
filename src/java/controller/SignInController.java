/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.UserDAO;
import dal.UserInfoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;
import model.UserInfo;

/**
 *
 * @author emsnguyen
 */
public class SignInController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        response.getWriter().write("in doGet of signin controller");
        request.getRequestDispatcher("signin.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UserDAO userDB = new UserDAO();
        
        User u = userDB.getUser(username, password);
        if (u != null) {
            UserInfoDAO infoDB = new UserInfoDAO();
            String nickname;
            nickname = infoDB.getNickname(u);
            request.getSession().setAttribute("username", username);
            request.getSession().setAttribute("nickname", nickname);
            response.sendRedirect("trangchu2.jsp");
        } else {
            if (userDB.isUsernameExisted(username)) {
                request.setAttribute("invalidPassword", "Wrong password");
            } else {
                request.setAttribute("invalidUsername", "Wrong username");
            }
            doGet(request, response);
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
