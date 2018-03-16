package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;

/**
 *
 * @author emsnguyen
 */
public class UserDAO extends BaseDAO<User>{

    public User getUser(String username, String password) {
        try {
            String query = "SELECT [UserID]\n" +
                            "      ,[Username]\n" +
                            "      ,[Password]\n" +
                            "      ,[RollID]\n" +
                            "      ,[Point]\n" +
                            "  FROM [User] "
                    + "WHERE Username = ? and Password = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                 User u = new User();
                 u.setUserID(rs.getInt("UserID"));
                 u.setUsername(rs.getString("Username"));
                 u.setPoint(rs.getInt("Point"));
                 u.setRollID(rs.getInt("RollID"));
                 u.setPassword(rs.getString("Password"));
                 return u;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public boolean isUsernameExisted(String username) {
        try {
            String query = "SELECT [UserID]\n" +
                            "      ,[Username]\n" +
                            "      ,[Password]\n" +
                            "  FROM [User]";
            query += " WHERE Username = " + username;
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                 return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    @Override
    public ArrayList<User> getAll() {
        ArrayList<User> users = new ArrayList<>();
        try {
            String query = "SELECT [UserID]\n" +
                    "      ,[Username]\n" +
                    "      ,[Password]\n" +
                    "      ,[RollID]\n" +
                    "      ,[Point]\n" +
                    "  FROM [User]\n" +
                    "  ORDER BY Point DESC";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User u = new User();
                u.setPassword(rs.getString("Password"));
                u.setUserID(rs.getInt("UserID"));
                u.setUsername(rs.getString("Username"));
                u.setRollID(rs.getInt("RollID"));
                u.setPoint(rs.getInt("Point"));
                users.add(u);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return users;
    }

    @Override
    public boolean delete(User model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(User model) {
        try {
            String query = "UPDATE [User]\n" +
                    "   SET [Point] = ?\n" +
                    " WHERE UserID = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, model.getPoint());
            ps.setInt(2, model.getUserID());
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected != 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public User get(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean insert(User model) {
        try {
            String insertUser = "INSERT INTO [User]\n" +
                                "           ([Username]\n" +
                                "           ,[Password], RollID\n" +
                                "           ,[Point])\n" +
                                "     VALUES\n" +
                                "           (?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(insertUser);
            ps.setString(1, model.getUsername());
            ps.setString(2, model.getPassword());
            ps.setInt(3, model.getRollID());
            ps.setInt(4, model.getPoint());
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
}