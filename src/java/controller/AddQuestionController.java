package controller;
import dal.CategoryDAO;
import dal.QuizDAO;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Answer;
import model.Category;
import model.Quiz;
import model.User;

public class AddQuestionController extends BaseAuthenticationController {

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    @Override
    protected void handleGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User u = (User) session.getAttribute("user");
        if (u == null || u.getRollID() != 1) {
            response.sendRedirect("accessdenied.html");
        } else {
            CategoryDAO catDB = new CategoryDAO();
            ArrayList<Category> cats = catDB.getAll();
            request.setAttribute("cats", cats);
            request.getRequestDispatcher("addquestion.jsp").forward(request, response);
        }
    }

    @Override
    protected void handlePost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String content = request.getParameter("quiz");
        String optA = request.getParameter("optA");
        String optB = request.getParameter("optB");
        String optC = request.getParameter("optC");
        String optD = request.getParameter("optD");
        String selected = request.getParameter("correctOpt");
        String correctOpt;
        int level = Integer.parseInt(request.getParameter("level"));
        int cateID = Integer.parseInt(request.getParameter("categoryID"));
        CategoryDAO catDB = new CategoryDAO();
        Category c = catDB.get(cateID);
        switch(selected) {
            case "B":
                correctOpt = optB;
                break;
            case "C":
                correctOpt = optC;
                break;
            case "D":
                correctOpt = optD;
                break;
            default:
                correctOpt = optA;
                break;
        }
        String explanation = request.getParameter("explanation");
        Quiz q = new Quiz();
        q.setLevel(level);
        q.setContent(content);
        q.setCategory(c);
        Answer a = new Answer();
        a.setOptA(optA);
        a.setOptB(optB);
        a.setOptC(optC);
        a.setOptD(optD);
        a.setCorrectOpt(correctOpt);
        a.setExplanation(explanation);
        QuizDAO quizDB = new QuizDAO();
        response.setContentType("text/html;charset=UTF-8");
        if (quizDB.insert(q, a)) {
            response.getWriter().write("Một câu hỏi mới vừa được thêm vào");
        } else {
            response.getWriter().write("Lỗi chưa thêm được câu hỏi");
        }
    }
}