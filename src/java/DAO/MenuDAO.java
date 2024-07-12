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

    public String checkWeekMenuByEmail(String Email, int menuWeek) {
        Connection cn = null;
        String check = "1";

        try {
            cn = DBUtil.makeConnection();
            if (cn != null) {
                String sql = "SELECT MenuName, Email FROM dbo.[User] u\n"
                        + "INNER JOIN dbo.Menu m ON m.UserID = u.UserID\n"
                        + "WHERE u.Email=? AND m.MenuDate=? AND m.MenuStatus ='1'";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, Email);
                pst.setInt(2, menuWeek);
                ResultSet rs = pst.executeQuery();
                while (rs.next()) {
                    check = null;
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

    public String insertWeekMenuByStaff(String email, int menuWeek, String newMenuName, String menuTag) {
        Connection cn = null;
        String result = null;
        int userID = 0;
        try {
            cn = DBUtil.makeConnection();
            if (cn != null) {

                cn.setAutoCommit(false);
                String sql1 = "Select * from dbo.[User] WHERE Email=?";
                PreparedStatement pst1 = cn.prepareStatement(sql1);
                pst1.setString(1, email);
                ResultSet rs = pst1.executeQuery();
                while (rs.next()) {
                    userID = rs.getInt("UserID");
                }

                String sql2 = "INSERT INTO Menu (UserID, MenuDate, MenuName, MenuTag, MenuStatus, MenuRole) VALUES (?, ?, ?, ?, '1','1')";
                PreparedStatement pst2 = cn.prepareStatement(sql2);
                pst2.setInt(1, userID);
                pst2.setInt(2, menuWeek);
                pst2.setNString(3, newMenuName);
                pst2.setString(4, menuTag);

                // Execute update and get affected rows
                int affectedRows = pst2.executeUpdate();

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

    public ArrayList<MenuDetail> getMenuDetail(int menuID) {
        ArrayList<MenuDetail> list = new ArrayList<>();
        Connection cn = null;
        try {
            cn = DBUtil.makeConnection();
            if (cn != null) {
                String sql = "SELECT \n"
                        + "Menu.MenuID,\n"
                        + "Menu.MenuName,\n"
                        + "MenuDetail.MenuDay,\n"
                        + "Food.FoodName,\n"
                        + "Food.FoodID\n"
                        + "FROM\n"
                        + "Menu\n"
                        + "INNER JOIN \n"
                        + "MenuDetail ON Menu.MenuID = MenuDetail.MenuID\n"
                        + "INNER JOIN \n"
                        + "Food ON MenuDetail.FoodID = Food.FoodID\n"
                        + "WHERE Menu.MenuID =?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, menuID);
                ResultSet rs = pst.executeQuery();
                while (rs.next()) {
                    int MenuID = rs.getInt("MenuID");
                    String menuName = rs.getNString("MenuName");
                    int menuDay = rs.getInt("MenuDay");
                    String foodName = rs.getNString("FoodName");
                    int foodID = rs.getInt("FoodID");
                    MenuDetail menu = new MenuDetail(MenuID, menuName, menuDay, foodName, foodID);
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

    public boolean deleteWeekMenu(int menuID) {
        Connection cn = null;
        boolean check = false;
        int uid = 0;
        try {
            cn = DBUtil.makeConnection();
            if (cn != null) {
                String sql = "DELETE FROM dbo.MenuDetail WHERE MenuID =?\n"
                        + "DELETE FROM dbo.Menu WHERE MenuID =?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, menuID);
                pst.setInt(2, menuID);
                ResultSet rs = pst.executeQuery();
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

    public ArrayList<Menu> getAllMenuFood() {
        ArrayList<Menu> list = new ArrayList<>();
        Connection cn = null;
        try {
            cn = DBUtil.makeConnection();
            if (cn != null) {
                String sql = "SELECT * \n"
                        + "FROM dbo.Menu";
                PreparedStatement pst = cn.prepareStatement(sql);

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
    
    public ArrayList<Menu> searchMenuFood(int userID, String search) {
        ArrayList<Menu> list = new ArrayList<>();
        Connection cn = null;
        try {
            cn = DBUtil.makeConnection();
            if (cn != null) {
                String sql = "SELECT * \n"
                        + "FROM dbo.Menu \n"
                        + "WHERE UserID=? AND MenuName LIKE ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, userID);
                pst.setNString(2, search);
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
}
