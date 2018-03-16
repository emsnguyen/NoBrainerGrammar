/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.IModel;

/**
 *
 * @author emsnguyen
 */
public class UserQuizDAO extends BaseDAO<IModel>{

    @Override
    public ArrayList<IModel> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public boolean isUserQuizExisted(int userID, int quizID) {
        try {
            String query = "SELECT [UserID]\n" +
                            "      ,[QuizID]\n" +
                            "      ,[NoOfCorrectAnswers]\n" +
                            "      ,[NoOfIncorrectAnswers]\n" +
                            "  FROM [UserQuiz]\n" +
                            "  WHERE UserID = ? \n" +
                            "  AND QuizID = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, userID);
            ps.setInt(2, quizID);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuizDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public boolean insertNewUserQuiz(int userID, int quizID) {
        try {
            String query = "INSERT INTO [UserQuiz]\n" +
                    "           ([UserID]\n" +
                    "           ,[QuizID]\n" +
                    "           ,[NoOfCorrectAnswers]\n" +
                    "           ,[NoOfIncorrectAnswers])\n" +
                    "     VALUES\n" +
                    "           (?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, userID);
            ps.setInt(2, quizID);
            ps.setInt(3, 0);
            ps.setInt(4, 0);
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuizDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean insert(IModel model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(IModel model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(IModel model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IModel get(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
