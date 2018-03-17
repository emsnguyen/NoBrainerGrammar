/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.AnswerDAO;
import dal.QuizDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Answer;
import model.Quiz;
import model.User;

/**
 *
 * @author emsnguyen
 */
public class QuizDetailController extends BaseAuthenticationController {

    @Override
    protected void handleGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User u  = (User) request.getSession().getAttribute("user");
        if (u == null || u.getRollID() != 1) {
            response.sendRedirect("accessdenied.html");
        } else {
            int quizID = Integer.parseInt(request.getParameter("quizID"));
            
            //get quiz and answer list to display
            QuizDAO quizDB = new QuizDAO();
            AnswerDAO answerDB = new AnswerDAO();
            Quiz q = quizDB.get(quizID);
            Answer a = answerDB.get(quizID);
            request.setAttribute("quiz", q);
            request.setAttribute("answer", a);
            request.getRequestDispatcher("quizdetails.jsp").forward(request, response);
        }
    }

    @Override
    protected void handlePost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
