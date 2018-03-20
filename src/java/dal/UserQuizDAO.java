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
import model.Category;
import model.IModel;
import model.Quiz;
import model.User;

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
    
    public Quiz chooseQuizToShowNext(int cateID, int level, User u) {
        try {
            String query = "SELECT TOP 1 [QuizID]\n" +
                    "      ,[Content]\n" +
                    "      ,[Level]\n" +
                    "      ,[CategoryID]\n" +
                    "  FROM [Quiz]\n" +
                    "  WHERE (CategoryID = ? AND LEVEL = ?) \n" +
                    "  AND \n" +
                    "  (\n" +
                    "	  QuizID NOT IN (SELECT QuizID FROM UserQuiz)\n" +
                    "	  OR\n" +
                    "	  QuizID IN \n" +
                    "	  (SELECT [QuizID]\n" +
                    "			  FROM [UserQuiz]\n" +
                    "			  WHERE UserID = ?\n" +
                    "			  AND (\n" +
                    "				  NoOfCorrectAnswers < 2\n" +
                    "				  OR NoOfCorrectAnswers < NoOfIncorrectAnswers\n" +
                    "			  )\n" +
                    "	   )\n" +
                    "  )\n" +
                    "  order by CHECKSUM(NEWID());"; //to get a random record
            System.out.println("Query choose quiz to show next: " + query);
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, cateID);
            ps.setInt(2, level);
            ps.setInt(3, u.getUserID());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Quiz q = new Quiz();
                q.setQuizID(rs.getInt("QuizID"));
                q.setContent(rs.getString("Content"));
                q.setLevel(rs.getInt("Level"));
                CategoryDAO cateDB = new CategoryDAO();
                Category c = cateDB.get(rs.getInt("CategoryID"));
                q.setCategory(c);
                return q;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserQuizDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
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
    
    public boolean reset(int userID, int cateID, int level) {
        try {
            String query = "UPDATE [UserQuiz]\n" +
                    "   SET [NoOfCorrectAnswers] = 0\n" +
                    "      ,[NoOfIncorrectAnswers] = 0\n" +
                    " WHERE UserID = ?\n" +
                    " AND QuizID IN\n" +
                    "			 (\n" +
                    "				SELECT QuizID FROM Quiz\n" +
                    "				WHERE CategoryID = ?\n" +
                    "				AND Level = ?\n" +
                    "			 )";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, userID);
            ps.setInt(2, cateID);
            ps.setInt(3, level);
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserQuizDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    @Override
    public IModel get(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean update(int userID, int quizID, String isCorrect) {
        try {
            String query;
            if (isCorrect.equals("correct")) {
                query = "UPDATE UserQuiz SET NoOfCorrectAnswers "
                        + "= NoOfCorrectAnswers+1 WHERE UserID = ? AND QuizID = ?";
            } else {
                query = "UPDATE UserQuiz SET NoOfInCorrectAnswers "
                        + "= NoOfInCorrectAnswers+1 WHERE UserID = ? AND QuizID = ?";
            }
            System.out.println("update no of answers: " + query);
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, userID);
            ps.setInt(2, quizID);
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserQuizDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
}
