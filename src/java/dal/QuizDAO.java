package dal;

import com.sun.org.apache.bcel.internal.generic.AALOAD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Answer;
import model.Category;
import model.Quiz;

public class QuizDAO extends BaseDAO<Quiz>{
    public int getMaxQuizID() {
        try {
            String query = "select MAX(QuizID) AS MAX from Quiz";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            return rs.getInt("MAX");
        } catch (SQLException ex) {
            Logger.getLogger(QuizDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    @Override
    public ArrayList<Quiz> getAll() {
        ArrayList<Quiz> quizzes = new ArrayList<>();
        try {
            String query = "SELECT [QuizID]\n" +
                            "      ,[Content]\n" +
                            "      ,[Level]\n" +
                            "      ,[CategoryID]\n" +
                            "  FROM [Quiz]";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            CategoryDAO catDB = new CategoryDAO();
            while (rs.next()) {
                Quiz q = new Quiz();
                q.setQuizID(rs.getInt("QuizID"));
                q.setContent(rs.getString("Content"));
                q.setCategory(catDB.get(rs.getInt("CategoryID")));
                q.setLevel(rs.getInt("Level"));
                quizzes.add(q);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return quizzes;
    }

    @Override
    public boolean insert(Quiz model) {
        return false;
    }
            
    public boolean insert(Quiz model, Answer a) {
        try {
            connection.setAutoCommit(false);
            String insertQuiz = "INSERT INTO [Quiz]\n" +
                    "           ([Content]\n" +
                    "           ,[Level]\n" +
                    "           ,[CategoryID])\n" +
                    "     VALUES\n" +
                    "           (?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(insertQuiz);
            ps.setString(1, model.getContent());
            ps.setInt(2, model.getLevel());
            ps.setInt(3, model.getCategory().getCategoryID());
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected == 0) {
                return false;
            }
            
            String getQuizID = "SELECT @@IDENTITY as QuizID";
            ps = connection.prepareStatement(getQuizID);
            ResultSet rs = ps.executeQuery();
            int quizID = 0;
            if (rs.next()) {
                quizID = rs.getInt("QuizID");
            }
            
            String insertAnswer = "INSERT INTO [Answer]\n" +
                                    "           ([QuizID]\n" +
                                    "           ,[OptA]\n" +
                                    "           ,[OptB]\n" +
                                    "           ,[OptC]\n" +
                                    "           ,[OptD]\n" +
                                    "           ,[CorrectOpt]\n" +
                                    "           ,[Explanation])\n" +
                                    "     VALUES\n" +
                                    "           (?,?,?,?,?,?,?)";
            ps = connection.prepareStatement(insertAnswer);
            ps.setInt(1, quizID);
            ps.setString(2, a.getOptA());
            ps.setString(3, a.getOptB());
            ps.setString(4, a.getOptC());
            ps.setString(5, a.getOptD());
            ps.setString(6, a.getCorrectOpt());
            ps.setString(7, a.getExplanation());
            rowsAffected = ps.executeUpdate();
            if (rowsAffected == 0) {
                return false;
            }
            connection.commit();
            return true;
        } catch (SQLException ex) {
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(QuizDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(QuizDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean delete(Quiz model) {
        return false;
    }

    @Override
    public boolean update(Quiz q) {
        try {
            String updateQuiz = "UPDATE [Quiz]\n" +
                            "   SET [Content] = ?\n" +
                            "      ,[Level] = ?\n" +
                            "      ,[CategoryID] = ?\n" +
                            " WHERE QuizID = ?";
            PreparedStatement ps;
            ps = connection.prepareStatement(updateQuiz);
            ps.setString(1, q.getContent());
            ps.setInt(2, q.getLevel());
            ps.setInt(3, q.getCategory().getCategoryID());
            ps.setInt(4, q.getQuizID());
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
    public Quiz get(int quizID) {
        Quiz q = new Quiz();
        String query = "SELECT [QuizID]\n" +
                        "      ,[Content]\n" +
                        "      ,[Level]\n" +
                        "      ,[CategoryID]\n" +
                        "  FROM [Quiz] WHERE QuizID = " + quizID;
        PreparedStatement ps;
        try {
            ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                q.setQuizID(rs.getInt("QuizID"));
                q.setContent(rs.getString("Content"));
                q.setCategory(new CategoryDAO().get(rs.getInt("CategoryID")));
                q.setLevel(rs.getInt("Level"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuizDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return q;
    }

    public Quiz get(int cateID, int level, int fromIndex) {
        Quiz q = new Quiz();
        try {
            String query = "SELECT TOP 1 [QuizID]\n" +
                        "      ,[Content]\n" +
                        "      ,[Level]\n" +
                        "      ,[CategoryID]\n" +
                        "  FROM [Quiz] WHERE"
                    + " QuizID > ? AND Level = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, fromIndex);
            ps.setInt(2, level);
            if (cateID != -1) {
                query += " AND CategoryID = " + cateID;
            }
            ResultSet rs = ps.executeQuery();
            CategoryDAO catDB = new CategoryDAO();
            if (rs.next()) {
                q.setQuizID(rs.getInt("QuizID"));
                q.setContent(rs.getString("Content"));
                q.setCategory(catDB.get(rs.getInt("CategoryID")));
                q.setLevel(rs.getInt("Level"));
                return q;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Quiz> getAll(int iCateID, int iLevel, String search) {
        ArrayList<Quiz> quizzes = new ArrayList<>();
        HashMap<Integer, Integer> params = new HashMap<>();
        try {
            String query = "SELECT [QuizID]\n" +
                            "      ,[Content]\n" +
                            "      ,[Level]\n" +
                            "      ,[CategoryID]\n" +
                            "  FROM [Quiz]\n" +
                            "  WHERE Content LIKE '%"
                            + search + "%'";
            int index = 0;
            if (iCateID != -1) {
                index++;
                query +=  " AND CategoryID = ?\n";
                params.put(index, iCateID);
            }
            if (iLevel != -1) {
                index++;
                query += " AND Level = ?\n";
                params.put(index, iLevel);
            }
            PreparedStatement ps = connection.prepareStatement(query);
            for (Map.Entry<Integer, Integer> entry : params.entrySet()) {
                Integer idx = entry.getKey();
                Integer value = entry.getValue();
                ps.setInt(idx, value);
            }
            ResultSet rs = ps.executeQuery();
            CategoryDAO catDB = new CategoryDAO();
            while (rs.next()) {
                Quiz q = new Quiz();
                q.setQuizID(rs.getInt("QuizID"));
                q.setContent(rs.getString("Content"));
                q.setCategory(catDB.get(rs.getInt("CategoryID")));
                q.setLevel(rs.getInt("Level"));
                quizzes.add(q);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return quizzes;
    }

    public boolean delete(int quizID) {
        try {
            String query = "DELETE FROM [Quiz]\n" +
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
