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

    public String getFullName(String email) {
        String fullName = null;
        Connection cn = null;
        try {
            cn = DBUtil.makeConnection();
            if (cn != null) {
                String sql = "select FullName from dbo.[User] where Email = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, email);
                ResultSet rs = pst.executeQuery();
                if (rs != null && rs.next()) {
                    fullName = rs.getNString("FullName");

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
        return fullName;
    }

    public String getUserByEmail(String email) {
        String Email = null;
        Connection cn = null;
        try {
            cn = DBUtil.makeConnection();
            if (cn != null) {
                String sql = "select Email from dbo.[User]\n"
                        + "where Email=?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, email);
                ResultSet rs = pst.executeQuery();
                while (rs.next()) {
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

    public String registerUser(String fullName, String email, String password) {
        Connection cn = null;
        String result = null;
        try {
            cn = DBUtil.makeConnection();
            if (cn != null) {
                // Tắt chế độ tự động commit
                cn.setAutoCommit(false);

                String sql = "INSERT INTO [User] (FullName, Email, Password, UserStatus, Role) VALUES (?, ?, ?, '1', '0')";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setNString(1, fullName);
                pst.setString(2, email);
                pst.setString(3, password);

                // Thực thi lệnh insert và nhận số dòng bị ảnh hưởng
                int affectedRows = pst.executeUpdate();

                if (affectedRows > 0) {
                    // Commit giao dịch nếu insert thành công
                    cn.commit();
                    result = "Insert successful";
                } else {
                    // Rollback giao dịch nếu insert thất bại
                    cn.rollback();
                    result = "Insert failed";
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            try {
                if (cn != null) {
                    cn.rollback();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            result = "An error occurred: " + e.getMessage();
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }

}
