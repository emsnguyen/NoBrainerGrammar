/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.AnswerDAO;
import dal.FeedbackDAO;
import dal.QuizDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Feedback;

/**
 *
 * @author emsnguyen
 */
public class ReportQuestionController extends BaseAuthenticationController {

    @Override
    protected void handleGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int quizID = Integer.parseInt(request.getParameter("quizID"));
        QuizDAO quizDB = new QuizDAO();
        AnswerDAO answerDB = new AnswerDAO();
        request.setAttribute("quiz", quizDB.get(quizID));
        request.setAttribute("answer", answerDB.get(quizID));
        request.getRequestDispatcher("reportquestion.jsp").forward(request, response);
    }

    @Override
    protected void handlePost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int quizID = Integer.parseInt(request.getParameter("quizID"));
        String problem = request.getParameter("problem");
        String username = request.getParameter("username");
        int senderID = Integer.parseInt(request.getParameter("userID"));
        Feedback f = new Feedback();
        f.setContent(problem);
        f.setQuizID(quizID);
        f.setSenderID(senderID);
        f.setResolved(false);
        FeedbackDAO fbDB = new FeedbackDAO();
        if (fbDB.insert(f)) {
            response.sendRedirect("thankyou.jsp");
        } else {
            response.getWriter().write("Error inserting feedback");
        }
    }

}
