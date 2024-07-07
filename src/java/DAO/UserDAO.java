/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.User;
import MyLib.DBUtil;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class UserDAO implements Serializable {

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

    public String getUserLogin(String email, String password) {
        String Email = null;
        Connection cn = null;
        try {

            cn = DBUtil.makeConnection();
            if (cn != null) {

                String sql = "select Email, Password from dbo.[User]\n"
                        + "where Email=? and Password=? COLLATE Latin1_General_CS_AS";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, email);
                pst.setString(2, password);
                ResultSet rs = pst.executeQuery();
                if (rs != null && rs.next()) {
                    Email = rs.getString("Email");
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
        return Email;
    }

    public int getUserID(String email) {
        int userID = 0;
        Connection cn = null;
        try {
            cn = DBUtil.makeConnection();
            if (cn != null) {
                String sql = "select UserID from dbo.[User] where Email = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, email);
                ResultSet rs = pst.executeQuery();
                if (rs != null && rs.next()) {
                    userID = rs.getInt("UserID");

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
        return userID;
    }

    public ArrayList<User> getUserByEmail(String email) {
        ArrayList<User> list = new ArrayList<>();
        Connection cn = null;
        try {
            cn = DBUtil.makeConnection();
            if (cn != null) {
                String sql = "select Email, UserName from dbo.[User]\n"
                        + "where UserName =? OR Email =?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1,email);
                ResultSet rs = pst.executeQuery();
                while (rs.next()) {
                    String Email = rs.getString("Email");
                   User user = new User(0, Email, Email, true, sql, 0, 0, true);
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

}
