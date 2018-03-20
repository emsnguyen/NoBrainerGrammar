/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.UserDAO;
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import model.User;
import utils.InputValidator;

/**
 *
 * @author emsnguyen
 */
public class ChangePasswordController extends BaseAuthenticationController {

    @Override
    protected void handleGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User u = (User) request.getSession().getAttribute("user");
        request.setAttribute("username", u.getUsername());
        request.getRequestDispatcher("changepassword.jsp").forward(request, response);
    }

    @Override
    protected void handlePost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String oldPassword = request.getParameter("oldpassword");
        String newPassword = request.getParameter("newpassword");
        String newPasswordCf = request.getParameter("newpasswordcf");
        User u = (User) request.getSession().getAttribute("user");
        System.out.println("old: " + u.getPassword());
        System.out.println("old nhập lại: " + oldPassword);
        if (!u.getPassword().equals(oldPassword)) {
            request.setAttribute("oldPasswordUnmatch", "Mật khẩu cũ không khớp");
            handleGet(request, response);
            return;
        } 
        String isValid = InputValidator.isPasswordValid(newPassword);
        if (!"".equals(isValid)) {
            request.setAttribute("invalidNewPassword", isValid);
            handleGet(request, response);
        } else if (newPassword.equals(oldPassword)) {
            request.setAttribute("invalidNewPassword", "Mật khẩu cũ không nên trùng với mật khẩu mới");
            handleGet(request, response);
        } else if (!newPassword.equals(newPasswordCf)) {
            request.setAttribute("newPasswordUnmatch", "Mật khẩu bạn nhập lại không khớp");
            handleGet(request, response);
        } else {
            u.setPassword(newPassword);
            UserDAO userDB = new UserDAO();
            if (userDB.updatePassword(u)) {
                request.getRequestDispatcher("home2.jsp").forward(request, response);
            }
        }
    }

}
