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
import model.Answer;
import model.Quiz;

/**
 *
 * @author emsnguyen
 */
public class AnswerDAO extends BaseDAO<Answer>{

    @Override
    public ArrayList<Answer> getAll() {
        ArrayList<Answer> answers = new ArrayList<>();
        try {
            String query = "SELECT [QuizID]\n" +
                        "      ,[OptA]\n" +
                        "      ,[OptB]\n" +
                        "      ,[OptC]\n" +
                        "      ,[OptD]\n" +
                        "      ,[CorrectOpt]\n" +
                        "      ,[Explanation]\n" +
                        "  FROM [Answer]";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Answer a = new Answer();
                a.setQuizID(rs.getInt("QuizID"));
                a.setOptA(rs.getString("OptA"));
                a.setOptB(rs.getString("OptB"));
                a.setOptC(rs.getString("OptC"));
                a.setOptD(rs.getString("OptD"));
                a.setCorrectOpt(rs.getString("CorrectOpt"));
                a.setExplanation(rs.getString("Explanation"));
                answers.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return answers;
    }

    @Override
    public boolean insert(Answer model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Answer model) {
        return false;
    }

    @Override
    public boolean update(Answer a) {
        try {
            String updateQuiz = "UPDATE [Answer]\n" +
                                "   SET [OptA] = ?\n" +
                                "      ,[OptB] = ?\n" +
                                "      ,[OptC] = ?\n" +
                                "      ,[OptD] = ?\n" +
                                "      ,[CorrectOpt] = ?\n" +
                                "      ,[Explanation] = ?\n" +
                                " WHERE QuizID = ?";
            PreparedStatement ps = connection.prepareStatement(updateQuiz);
            ps.setString(1, a.getOptA());
            ps.setString(2, a.getOptB());
            ps.setString(3, a.getOptC());
            ps.setString(4, a.getOptD());
            ps.setString(5, a.getCorrectOpt());
            ps.setString(6, a.getExplanation());
            ps.setInt(7, a.getQuizID());
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
    public Answer get(int quizID) {
        try {
            String query = "SELECT [OptA]\n" +
                    "      ,[OptB]\n" +
                    "      ,[OptC]\n" +
                    "      ,[OptD]\n" +
                    "      ,[CorrectOpt]\n" +
                    "      ,[Explanation]\n" +
                    "  FROM [Answer]\n" +
                    "  WHERE QuizID = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, quizID);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Answer a = new Answer();
                a.setQuizID(quizID);
                a.setOptA(rs.getString("OptA"));
                a.setOptB(rs.getString("OptB"));
                a.setOptC(rs.getString("OptC"));
                a.setOptD(rs.getString("OptD"));
                a.setCorrectOpt(rs.getString("CorrectOpt"));
                a.setExplanation(rs.getString("Explanation"));
                return a;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AnswerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean delete(int quizID) {
        try {
            String query = "DELETE FROM [Answer]\n" +
                    "      WHERE QuizID = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, quizID);
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AnswerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
}
