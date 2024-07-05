/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Menu;
import DTO.MenuDetail;
import MyLib.DBUtil;
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
public class MenuDAO {

    public ArrayList<Menu> getMenuFood(String userID) {
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
                pst.setString(1, userID);
                ResultSet rs = pst.executeQuery();
                while (rs.next()) {
                    String menuID = rs.getString("MenuID");          
                    String foodID = rs.getString("FoodID");
                    String menuDate = rs.getString("MenuDate");
                    String uID= rs.getString("UserID");
                    String menuName = rs.getNString("MenuName");
                    boolean menuStatus = rs.getBoolean("MenuStatus");
                    Menu menu = new Menu(menuID, foodID, menuDate, uID, menuName, menuStatus);
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
    
    
    
    public ArrayList<Menu> insertNewMenu(String userID) {
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
                pst.setString(1, userID);
                ResultSet rs = pst.executeQuery();
                while (rs.next()) {
                    String menuID = rs.getString("MenuID");          
                    String foodID = rs.getString("FoodID");
                    String menuDate = rs.getString("MenuDate");
                    String uID= rs.getString("UserID");
                    String menuName = rs.getNString("MenuName");
                    boolean menuStatus = rs.getBoolean("MenuStatus");
                    Menu menu = new Menu(menuID, foodID, menuDate, uID, menuName, menuStatus);
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
