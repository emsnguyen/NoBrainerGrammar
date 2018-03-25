package controller;
import java.io.*;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.*;
import dal.*;
import javax.servlet.http.HttpSession;
public class StudyController extends BaseAuthenticationController {
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    protected void preProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CategoryDAO catDB = new CategoryDAO();
        ArrayList<Category> cats = catDB.getAll();
        request.getSession().setAttribute("cats", cats);
    }
    @Override
    protected void handleGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        preProcess(request, response);
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String cateID = request.getParameter("categoryID");
        String level = request.getParameter("level");
        if (cateID == null || level == null) {
            response.sendRedirect("select.jsp");
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("cateID", cateID);
            session.setAttribute("level", level);
            prepareWhatToShow(request, response);
        }
    }
    public void prepareWhatToShow(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String cateID = session.getAttribute("cateID").toString();
        String level = session.getAttribute("level").toString();
        
        //choose a suitable quiz to user
        int iCateID = Integer.parseInt(cateID);
        int iLevel = Integer.parseInt(level);
        UserQuizDAO uqDAO = new UserQuizDAO();
        User u = (User) session.getAttribute("user");
        Quiz q = uqDAO.chooseQuizToShowNext(iCateID, iLevel, u);
        if (q == null) {
            request.getSession().setAttribute("cateID", cateID);
            request.getSession().setAttribute("level", level);
            response.sendRedirect("nomorequestions.jsp");
        } else {
            if (!uqDAO.isUserQuizExisted(u.getUserID(), q.getQuizID())) {
                //insert to UserQuiz
                uqDAO.insertNewUserQuiz(u.getUserID(), q.getQuizID());
            } else {
//                System.out.println("User Quiz existed, no need to insert a new one");
            }

            //get Quiz and Answer ready
            AnswerDAO answerDB = new AnswerDAO();
            Answer a = answerDB.get(q.getQuizID());

            //set attributes for request
            request.setAttribute("quiz", q);
            request.setAttribute("answer", a);
            
            //set avatar path 
//            String realPath = "C:\\Users\\emsnguyen\\Documents\\NetBeansProjects\\NoBrainerBeta\\web\\";
            String realPath = getServletContext().getRealPath("/");
            String jpg = realPath + "uploads\\" + u.getUserID() + ".jpg";
            File fileJpg = new File(jpg);
            String png = realPath + "uploads\\" + u.getUserID() + ".png";
            File filePng = new File(png);
            String jpeg = realPath + "uploads\\" + u.getUserID() + ".jpeg";
            File fileJpeg = new File(jpeg);
            System.out.println("fileJpg:" + jpg);
            System.out.println("fileJpg.exists():" + fileJpg.exists());
            if (fileJpg.exists()) {
                request.setAttribute("avatarPath", "uploads\\" + u.getUserID() + ".jpg");
            } else if (filePng.exists()) {
                request.setAttribute("avatarPath", "uploads\\" + u.getUserID() + ".png");
            } else if (fileJpeg.exists()) {
                request.setAttribute("avatarPath", "uploads\\" + u.getUserID() + ".jpeg");
            } else {
                request.setAttribute("avatarPath", "images/nobrainer.jpg");
            }
            //display in study.jsp
            request.getRequestDispatcher("study.jsp").forward(request, response);
        }
    }
    @Override
    protected void handlePost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        int newPoint = Integer.parseInt(request.getParameter("userpoint"));
        String isCorrect = request.getParameter("isCorrect");
        int quizID = Integer.parseInt(request.getParameter("quizID"));
        //insert old result to database
        UserDAO userDB = new UserDAO();
        
        //update point for user
        User u = (User) request.getSession().getAttribute("user");
        if (newPoint != u.getPoint()) {
            u.setPoint(newPoint);
            if (!userDB.update(u)) {
                response.getWriter().write("database error while updating user point in db");
                return;
            }
        } 
        
        //update correct and incorrect answers in UserQuiz
        UserQuizDAO uqDB = new UserQuizDAO();
        if (!uqDB.update(u.getUserID(), quizID, isCorrect)) {
            response.getWriter().write("database error while updating user quiz");
            return;
        }
        
        //fetch new quiz
        prepareWhatToShow(request, response);
    }
}