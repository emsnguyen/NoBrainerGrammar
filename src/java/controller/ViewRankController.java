package controller;

import dal.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;

/**
 *
 * @author emsnguyen
 */
public class ViewRankController extends BaseAuthenticationController {

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    @Override
    protected void handleGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDAO userDB = new UserDAO();
        ArrayList<User> users = userDB.getAll();
        request.setAttribute("users", users);
        request.getRequestDispatcher("viewrank.jsp").forward(request, response);
    }

    @Override
    protected void handlePost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    }

}
