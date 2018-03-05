/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;
import model.UserInfo;

/**
 *
 * @author emsnguyen
 */
public class UserDAO extends BaseDAO<User>{

    @Override
    public ArrayList<User> getAll() {
        ArrayList<User> users = new ArrayList<>();
        try {
            String sql = "SELECT [userID]\n" +
                    "      ,[username]\n" +
                    "      ,[password]\n" +
                    "  FROM [User]";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User u = new User();
                u.setUserID(rs.getInt("userID"));
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                users.add(u);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return users;
    }
    public boolean isUsernameExisted(String username) {
        try {
            String sql = "SELECT [username]\n" +
                    "      ,[password]\n" +
                    "  FROM [User] where username = ? ";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public User getUser(String username, String password) {
        try {
            String sql = "SELECT [userID]\n" +
                    "      ,[username]\n" +
                    "      ,[password]\n" +
                    "  FROM [User] where username = ? and password = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                User u = new User();
                u.setUserID(rs.getInt("userID"));
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                return u;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public boolean delete(User model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(User model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public boolean insert(User model, UserInfo info) {
        try {
            connection.setAutoCommit(false);
            //insert to User
            String query = "INSERT INTO [User]\n" +
                            "           ([username]\n" +
                            "           ,[password])\n" +
                            "     VALUES\n" +
                            "           (?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, model.getUsername());
            ps.setString(2, model.getPassword());
            ps.executeUpdate();
            
            //get UserID as new Identity
            String getUserIDQuery = "SELECT SCOPE_IDENTITY() AS [UserID]";
            ps = connection.prepareStatement(getUserIDQuery);
            ResultSet rs = ps.executeQuery();
            int userID = 0;
            if (rs.next()) {
                userID = rs.getInt("UserID");
            }
            
            
            //insert to UserInfo
            String insertToUserInfo = "INSERT INTO [UserInfo]\n" +
                        "           ([userID]\n" +
                        "           ,[nickname]\n" +
                        "           ,[aboutMe]\n" +
                        "           ,[birthDate]\n" +
                        "           ,[imageFilePath]\n" +
                        "           ,[work]\n" +
                        "           ,[address]\n" +
                        "           ,[preferMale]\n" +
                        "           ,[isOnline])\n" +
                        "     VALUES\n" +
                        "           (?\n" +
                        "           ,?\n" +
                        "           ,?\n" +
                        "           ,?\n" +
                        "           ,?\n" +
                        "		   ,?\n" +
                        "           ,?\n" +
                        "           ,?\n" +
                        "           ,?)";
            ps = connection.prepareStatement(query);
            
            ps.setInt(1, userID);
            ps.setString(2, info.getNickname());
            ps.setString(3, info.getAboutMe());
            ps.setDate(4, (Date) info.getBirthDate());
            ps.setString(5, info.getImageFilePath());
            ps.setString(6, info.getWork());
            ps.setString(7, info.getAddress());
            ps.setBoolean(8, info.isPreferMale());
            ps.executeUpdate();
            connection.commit();
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
            return false;
        }
    }
    
    @Override
    public boolean insert(User model) {
        try {
            String query = "INSERT INTO [User]\n" +
                            "           ([username]\n" +
                            "           ,[password])\n" +
                            "     VALUES\n" +
                            "           (?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, model.getUsername());
            ps.setString(2, model.getPassword());
            int executeUpdate = ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public User get(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
