/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.UserDAO;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;
import utils.RedirectHelper;

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
//            InputStream is = u.getAvatar();
//            ByteArrayOutputStream buffer = new ByteArrayOutputStream();
//            int nRead;
//            byte[] data = new byte[16384];
//            while ((nRead = is.read(data, 0, data.length)) != -1) {
//              buffer.write(data, 0, nRead);
//              System.out.println("data.length: " + data.length);
//            }
//            
//            ServletOutputStream out = response.getOutputStream();
//            response.setContentType("image/png");
//            response.setContentLength(data.length);
//            response.getOutputStream().write(data);
//            is.close();
//            buffer.flush();
//            buffer.close();
//            out.close();
            request.getSession().setAttribute("user", u);
            String urlToRedirect = RedirectHelper.redirectAfterAuthentication(u, "addquestion", "study");
            response.sendRedirect(urlToRedirect);
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
