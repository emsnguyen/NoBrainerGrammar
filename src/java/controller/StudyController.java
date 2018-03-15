package controller;
import java.io.IOException;
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
    static int fromIndex = 0;
    static int prevCateID = 0;
    static int prevLevel = 0;
    @Override
    protected void handleGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        preProcess(request, response);
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String cateID = request.getParameter("categoryID");
        String level = request.getParameter("level");
        int iLevel;
        if (level == null) {
            iLevel = 1;
        } else {
            iLevel = Integer.parseInt(level);
        }
        int iCate;
        if (cateID == null) {
            iCate = 5;
        } else {
            iCate = Integer.parseInt(cateID);
        }
        if (prevCateID != iCate || prevLevel != iLevel) {
            fromIndex = 0;
        }
        QuizDAO quizDB = new QuizDAO();
        Quiz q = quizDB.get(iCate, iLevel, fromIndex);
        if (q == null) {
            request.setAttribute("error", "Hết mất câu hỏi rồi :((");
            System.out.println("Không có câu hỏi nào để hiển thị :((");
            fromIndex = 0;
        } else {
            AnswerDAO answerDB = new AnswerDAO();
            Answer a = answerDB.get(q.getQuizID());
            request.setAttribute("quiz", q);
            request.setAttribute("answer", a);
            System.out.println("giải thích: " + a.getExplanation());
            fromIndex = q.getQuizID();
        }
        request.getRequestDispatcher("study.jsp").forward(request, response);
    }
    @Override
    protected void handlePost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    }
}