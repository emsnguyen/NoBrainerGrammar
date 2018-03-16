package controller;
import java.io.*;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.*;
import dal.*;
public class StudyController extends BaseAuthenticationController {
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    protected void preProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CategoryDAO catDB = new CategoryDAO();
        ArrayList<Category> cats = catDB.getAll();
        request.setAttribute("cats", cats);
    }
    @Override
    protected void handleGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        preProcess(request, response);
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String cateID = request.getParameter("categoryID");
        String level = request.getParameter("level");
        
    }
    @Override
    protected void handlePost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        
    }
}