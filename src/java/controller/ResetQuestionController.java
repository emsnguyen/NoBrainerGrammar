/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.UserQuizDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.User;

/**
 *
 * @author emsnguyen
 */
public class ResetQuestionController extends BaseAuthenticationController {

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    @Override
    protected void handleGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User u = (User) session.getAttribute("user");
        String cateID = session.getAttribute("cateID").toString();
        String level = session.getAttribute("level").toString();
        int iCateID = Integer.parseInt(cateID);
        int iLevel = Integer.parseInt(level);
        UserQuizDAO uqDB = new UserQuizDAO();
        if (uqDB.update(u.getUserID(), iCateID, iLevel)) {
            response.sendRedirect("select");
        } else {
            response.getWriter().write("Error while resetting questions");
        }
    }

    @Override
    protected void handlePost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
