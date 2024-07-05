/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.User;
import MyLib.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class UserDAO {

    public ArrayList<User> getUser() {
        ArrayList<User> list = new ArrayList<>();
        Connection cn = null;
        try {
            cn = DBUtil.makeConnection();
            if (cn != null) {
                String sql = "select * from dbo.User";
                PreparedStatement pst = cn.prepareStatement(sql);
                ResultSet rs = pst.executeQuery();
                while (rs.next()) {
                    String userID = rs.getString("UserID");
                    String email = rs.getString("Email");
                    boolean role = rs.getBoolean("Role");
                    String password = rs.getString("Password");
                    String menuID = rs.getString("MenuID");
                    String orderID = rs.getString("OrderID");
                    boolean userStatus = rs.getBoolean("UserStatus");
                    User user = new User();
                    list.add(user);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    public User getUserLogin(String userName, String password) {
        User userLogin = null;
        Connection cn = null;
        try {

            cn = DBUtil.makeConnection();
            if (cn != null) {

                String sql = "select UserName, Password from dbo.[User]\n"
                        + "where UserName=? and Password=? COLLATE Latin1_General_CS_AS";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, userName);
                pst.setString(2, password);
                ResultSet rs = pst.executeQuery();
                if (rs != null && rs.next()) {

                    String username = rs.getString("UserName");
                    userLogin = new User();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return userLogin;
    }

    public User getUserID(String userName) {
        User user = null;
        Connection cn = null;
        try {
            cn = DBUtil.makeConnection();
            if (cn != null) {
                String sql = "select UserID from dbo.[User] where UserName = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, userName);
                ResultSet rs = pst.executeQuery();
                if (rs != null && rs.next()) {
                    int userID = rs.getInt("UserID");
                    user = new User();
                    user.setUserID(userID); 
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return user;
    }

}
