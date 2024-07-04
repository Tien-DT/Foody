/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Menu;
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

    public Map<String, List<Menu>> getMenuFood(String userID) {
        Map<String, List<Menu>> menuMap = new HashMap<>();
        Connection cn = null;
        try {
            cn = DBUtil.makeConnection();
            if (cn != null) {
                String sql = "SELECT m.MenuID, m.FoodID, m.MenuDate, m.UserID, f.FoodName\n"
                        + "FROM dbo.Menu m\n"
                        + "INNER JOIN dbo.Food f ON m.FoodID = f.FoodID\n"
                        + "WHERE m.UserID=?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, userID);
                ResultSet rs = pst.executeQuery();
                while (rs.next()) {
                    String MenuID = rs.getString("MenuID");
                    String FoodID = rs.getString("FoodName");
                    //String FoodName = rs.getString("FoodName");
                    String MenuDate = rs.getString("MenuDate");
                    String UserID = rs.getString("UserID");
                    Menu menu = new Menu(MenuID, FoodID,MenuDate, UserID);

                    menuMap.computeIfAbsent(MenuDate, k -> new ArrayList<>()).add(menu);
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
        return menuMap;
    }
}
