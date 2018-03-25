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
import model.Feedback;
import model.User;

/**
 *
 * @author emsnguyen
 */
public class FeedbackDAO extends BaseDAO<Feedback>{

    @Override
    public ArrayList<Feedback> getAll() {
        ArrayList<Feedback> feedbacks = new ArrayList<>();
        try {
            String query = "SELECT [FeedbackID]\n" +
                            "      ,[QuizID]\n" +
                            "      ,[Content]\n" +
                            "      ,[SenderID]\n" +
                            "      ,[Resolved]\n" +
                            "  FROM [Feedback]";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Feedback f = new Feedback();
                f.setQuizID(rs.getInt(1));
                f.setContent(rs.getString(2));
                f.setSenderID(rs.getInt(3));
                f.setResolved(rs.getBoolean(4));
                feedbacks.add(f);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return feedbacks;
    }

    @Override
    public boolean insert(Feedback f) {
        try {
            String insertUser = "INSERT INTO [Feedback]\n" +
                                "           ([QuizID]\n" +
                                "           ,[Content]\n" +
                                "           ,[SenderID]\n" +
                                "           ,[Resolved])\n" +
                                "     VALUES\n" +
                                "           (?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(insertUser);
            ps.setInt(1, f.getQuizID());
            ps.setString(2, f.getContent());
            ps.setInt(3, f.getSenderID());
            ps.setBoolean(4, false);
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected == 0) {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(Feedback model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Feedback model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Feedback get(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
