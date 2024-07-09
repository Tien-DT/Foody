/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Menu;
import DTO.MenuDetail;
import MyLib.DBUtil;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author USER
 */
public class MenuDAO implements Serializable {

    public ArrayList<Menu> getMenuFood(int userID) {
        ArrayList<Menu> list = new ArrayList<>();
        Connection cn = null;
        try {
            cn = DBUtil.makeConnection();
            if (cn != null) {
                String sql = "SELECT * \n"
                        + "FROM dbo.Menu \n"
                        + "WHERE UserID=?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, userID);
                ResultSet rs = pst.executeQuery();
                while (rs.next()) {
                    int menuID = rs.getInt("MenuID");
                    String menuName = rs.getNString("MenuName");
                    int menuDate = rs.getInt("MenuDate");
                    int uID = rs.getInt("UserID");

                    boolean menuStatus = rs.getBoolean("MenuStatus");
                    String menuTag = rs.getNString("MenuTag");
                    boolean menuRole = rs.getBoolean("MenuRole");
                    Menu menu = new Menu(menuID, menuDate, uID, menuName, menuStatus, menuTag, menuRole);
                    list.add(menu);
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

    public ArrayList<Menu> insertNewMenu(int userID) {
        ArrayList<Menu> list = new ArrayList<>();
        Connection cn = null;
        try {
            cn = DBUtil.makeConnection();
            if (cn != null) {
                String sql = "SELECT m.MenuID,m.FoodID, m.MenuDate, m.UserID,m.MenuName, m.MenuStatus\n"
                        + "FROM dbo.Menu m\n"
                        + "INNER JOIN dbo.Food f ON m.FoodID = f.FoodID\n"
                        + "WHERE m.UserID=?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, userID);
                ResultSet rs = pst.executeQuery();
                while (rs.next()) {
                    int menuID = rs.getInt("MenuID");
                    int foodID = rs.getInt("FoodID");
                    int menuDate = rs.getInt("MenuDate");
                    int uID = rs.getInt("UserID");
                    String menuName = rs.getNString("MenuName");
                    boolean menuStatus = rs.getBoolean("MenuStatus");
                    Menu menu = new Menu(menuID, menuDate, uID, menuName, menuStatus);
                    list.add(menu);
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

    public String checkWeekMenu(int userID, int menuWeek) {
        Connection cn = null;
        String check = null; // Assume menu does not exist
        int uid = 0;
        try {
            cn = DBUtil.makeConnection();
            if (cn != null) {
                String sql = "SELECT MenuName, UserID FROM dbo.Menu WHERE UserID=? AND MenuDate=? AND MenuStatus ='1'";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, userID);
                pst.setInt(2, menuWeek);
                ResultSet rs = pst.executeQuery();
                while (rs.next()) {
                    uid = rs.getInt("UserID");
                }
                if (uid > 0) {
                    check = null;
                } else {
                    check = "1";
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
        return check;
    }

    public String insertWeekMenu(int userID, int menuWeek, String newMenuName, String menuTag) {
        Connection cn = null;
        String result = null;
        try {
            cn = DBUtil.makeConnection();
            if (cn != null) {
                // Disable auto-commit mode
                cn.setAutoCommit(false);

                String sql = "INSERT INTO Menu (UserID, MenuDate, MenuName, MenuTag, MenuStatus, MenuRole) VALUES (?, ?, ?, ?, '1','0')";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, userID);
                pst.setInt(2, menuWeek);
                pst.setString(3, newMenuName);
                pst.setString(4, menuTag);

                // Execute update and get affected rows
                int affectedRows = pst.executeUpdate();

                if (affectedRows > 0) {
                    // Commit the transaction if insert is successful
                    cn.commit();
                    result = "Insert successful";
                } else {
                    // Rollback the transaction if insert failed
                    cn.rollback();
                    result = null;
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
