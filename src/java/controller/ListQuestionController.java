/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.CategoryDAO;
import dal.QuizDAO;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Category;
import model.Quiz;

/**
 *
 * @author emsnguyen
 */
public class ListQuestionController extends BaseAuthenticationController {
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    @Override
    protected void handleGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CategoryDAO catDB = new CategoryDAO();
        ArrayList<Category> cats = catDB.getAll();
        
        QuizDAO quizDB = new QuizDAO();
        ArrayList<Quiz> quizzes = quizDB.getAll();
        
        request.setAttribute("cats", cats);
        request.setAttribute("quizzes", quizzes);
        request.getRequestDispatcher("listquestion.jsp").forward(request, response);
    }

    @Override
    protected void handlePost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cateID = request.getParameter("cateID");
        String level = request.getParameter("level");
        String search = request.getParameter("search").trim();
        //choose a suitable quiz to user
        int iCateID = Integer.parseInt(cateID);
        int iLevel = Integer.parseInt(level);
        
        //get all categories to display in select box
        CategoryDAO catDB = new CategoryDAO();
        ArrayList<Category> cats = catDB.getAll();
        
        QuizDAO quizDB = new QuizDAO();
        ArrayList<Quiz> quizzes = quizDB.getAll(iCateID, iLevel, search);
        
        request.setAttribute("cats", cats);
        request.setAttribute("quizzes", quizzes);
        request.getRequestDispatcher("listquestion.jsp").forward(request, response);
    }

}
