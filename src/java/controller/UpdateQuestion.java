/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.AnswerDAO;
import dal.CategoryDAO;
import dal.QuizDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Answer;
import model.Category;
import model.Quiz;

/**
 *
 * @author emsnguyen
 */
public class UpdateQuestion extends BaseAuthenticationController {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        
        //get all needed parameter values
        String content = request.getParameter("quiz");
        String optA = request.getParameter("optA");
        String optB = request.getParameter("optB");
        String optC = request.getParameter("optC");
        String optD = request.getParameter("optD");
        String correctOpt = request.getParameter("correctOpt");
        String explanation = request.getParameter("explanation");
        int level = Integer.parseInt(request.getParameter("level"));
        int cateID = Integer.parseInt(request.getParameter("cateID"));
        int quizID = Integer.parseInt(request.getParameter("quizID"));
        
        //update database
        CategoryDAO catDB = new CategoryDAO();
        Category c = catDB.get(cateID);
        QuizDAO quizDB = new QuizDAO();
        AnswerDAO answerDB = new AnswerDAO();
        
        Quiz q = new Quiz();
        q.setQuizID(quizID);
        q.setLevel(level);
        q.setContent(content);
        q.setCategory(c);
        
        Answer a = new Answer();
        a.setQuizID(quizID);
        a.setOptA(optA);
        a.setOptB(optB);
        a.setOptC(optC);
        a.setOptD(optD);
        a.setCorrectOpt(correctOpt);
        a.setExplanation(explanation);
        
        response.setContentType("text/html;charset=UTF-8");
        if (quizDB.update(q) && answerDB.update(a)) {
            response.getWriter().write("Câu hỏi vừa được cập nhật");
        } else {
            response.getWriter().write("Lỗi xảy ra khi cập nhật câu hỏi");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    @Override
    protected void handleGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void handlePost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

}
