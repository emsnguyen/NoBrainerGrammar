/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.UserDAO;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;

/**
 *
 * @author emsnguyen
 */
public class LogInController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UserDAO userDB = new UserDAO();
        User u = userDB.getUser(username, password);
        if (u == null) {
            request.setAttribute("error", "Sai tên đăng nhập hoặc mật khẩu");
            doGet(request, response);
        } else {
            request.getSession().setAttribute("user", u);
            if (u.getRollID() == 1) {
                response.sendRedirect("home2_admin.jsp");
            } else {
                response.sendRedirect("home2.jsp");
            }
        }
    }
}
