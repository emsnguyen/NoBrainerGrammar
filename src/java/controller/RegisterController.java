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
import java.sql.Date;
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
public class RegisterController extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("register.jsp").forward(request, response);
    }
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDAO userDB = new UserDAO();
        String username = request.getParameter("username");
        if (username.isEmpty()) {
            request.setAttribute("invalidUsername", "Username cannot be empty");
            doGet(request, response);
        }
        if (userDB.isUsernameExisted(username)) {
            request.setAttribute("invalidUsername", "Username existed");
            doGet(request, response);
        } else {
            User u = new User();
            u.setUsername(username);
            String password = request.getParameter("password");
            if (password == null) {
                request.setAttribute("invalidPassword", "password cannot be empty");
                doGet(request, response);
            }
            u.setPassword(password);
            UserInfo info = new UserInfo();
            info.setAboutMe("");
            info.setAddress(request.getParameter("address"));
            String birthDate = request.getParameter("birthDate");
            if (birthDate.equals(null) || birthDate.trim().isEmpty()) {
                request.setAttribute("invalidBirthDate", "Birth date is invalid");
                doGet(request, response);
            }
            System.out.println("birthDate: " + birthDate);
            info.setBirthDate(Date.valueOf(birthDate));
            String gender = request.getParameter("gender");
            System.out.println("gender: " + gender);
            if (gender == null) {
                request.setAttribute("invalidGender", "You must choose your gender");
                doGet(request, response);
            }
            if (gender.equals("Male")) {
                info.setGender(UserInfo.GENDER_MALE);
                info.setPreferMale(false);
            } else {
                info.setGender(UserInfo.GENDER_FEMALE);
                info.setPreferMale(true);
            }
            info.setUser(u);
            info.setIsOnline(true);
            info.setImageFilePath("");
            String work = request.getParameter("work");
            if (work.equals(null)) {
                request.setAttribute("invalidWork", "Work is invalid");
                doGet(request, response);
            }
            info.setWork(work);
            String nickname = request.getParameter("nickname");
            if (nickname.equals(null)) {
                request.setAttribute("invalidNickname", "Nick name is invalid");
                doGet(request, response);
            }
            info.setNickname(nickname);
            userDB.insert(u, info);
            UserInfoDAO infoDB = new UserInfoDAO();
            request.getSession().setAttribute("username", username);
            request.getSession().setAttribute("nickname", nickname);
            response.sendRedirect("trangchu2.jsp");
        }
    }

}
