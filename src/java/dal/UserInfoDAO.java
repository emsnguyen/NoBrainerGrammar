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
public class UserInfoDAO extends BaseDAO<UserInfo>{

    @Override
    public ArrayList<UserInfo> getAll() {
        ArrayList<UserInfo> userInfos = new ArrayList<>();
        String query = "SELECT [userID]\n" +
                        "      ,[nickname]\n" +
                        "      ,[aboutMe]\n" +
                        "      ,[birthDate]\n" +
                        "      ,[imageFilePath]\n" +
                        "      ,[work]\n" +
                        "      ,[address]\n" +
                        "      ,[preferMale]\n" +
                        "      ,[isOnline]\n" +
                        "  FROM [UserInfo]";
        return userInfos;
    }

    @Override
    public UserInfo get(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(UserInfo model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(UserInfo model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean insert(UserInfo model) {
        String query = "INSERT INTO [UserInfo]\n" +
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
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, model.getUser().getUserID());
            ps.setString(2, model.getNickname());
            ps.setString(3, model.getAboutMe());
            ps.setDate(4, (Date) model.getBirthDate());
            ps.setString(5, model.getImageFilePath());
            ps.setString(6, model.getWork());
            ps.setString(7, model.getAddress());
            ps.setBoolean(8, model.isPreferMale());
            ps.setBoolean(9, model.isIsOnline());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UserInfoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }

    public String getNickname(User u) {
        try {
            String query = "SELECT nickname FROM UserInfo"
                    + "WHERE userID = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, u.getUserID());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString("nickname");
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserInfoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return u.getUsername();
    }
    
}
