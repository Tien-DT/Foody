/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Cart;
import MyLib.DBUtil;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author USER
 */
public class CartDAO implements Serializable {

    public ArrayList<HashMap<String, Object>> loadCart(String userID) {
        ArrayList<HashMap<String, Object>> list = new ArrayList<>();
        Connection cn = null;
        try {
            cn = DBUtil.makeConnection();
            if (cn != null) {
                String sql = "SELECT c.CartID, u.UserID,\n"
                        + "       CASE WHEN f.foodID IS NOT NULL THEN f.FoodName END AS FoodName,\n"
                        + "       CASE WHEN f.foodID IS NOT NULL THEN f.FoodPrice END AS FoodPrice,\n"
                        + "	   CASE WHEN f.foodID IS NOT NULL THEN f.FoodPrice END AS FoodImage,\n"
                        + "       CASE WHEN p.productID IS NOT NULL THEN p.ProductName END AS ProductName,\n"
                        + "       CASE WHEN p.productID IS NOT NULL THEN p.ProductPrice END AS ProductPrice,\n"
                        + "	   CASE WHEN p.productID IS NOT NULL THEN p.ProductPrice END AS ProductImage\n"
                        + "FROM Cart c\n"
                        + "INNER JOIN [User] u ON c.userID = u.userID\n"
                        + "LEFT JOIN Food f ON f.foodID = c.foodID\n"
                        + "LEFT JOIN Product p ON p.productID = f.productID\n"
                        + "WHERE u.UserID =?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, userID);
                ResultSet rs = pst.executeQuery();
                while (rs.next()) {
                    HashMap<String, Object> item = new HashMap<>();
                    item.put("CartID", rs.getString("CartID"));
                    item.put("UserID", rs.getString("UserID"));
                    item.put("FoodID", rs.getString("foodID"));
                    item.put("FoodName", rs.getString("FoodName"));
                    item.put("FoodPrice", rs.getInt("FoodPrice"));
                    item.put("FoodImage", rs.getString("FoodImage"));
                    item.put("ProductID", rs.getString("productID"));
                    item.put("ProductName", rs.getString("ProductName"));
                    item.put("ProductPrice", rs.getInt("ProductPrice"));
                    item.put("ProductImage", rs.getString("ProductImage"));
                    list.add(item);
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

    public ArrayList<Cart> insertFoodToCart(String foodID, String userID) {
        ArrayList<Cart> list = new ArrayList<>();
        Connection cn = null;
        try {
            cn = DBUtil.makeConnection();
            if (cn != null) {
                String sql = "select * from dbo.Food";
                PreparedStatement pst = cn.prepareStatement(sql);
                ResultSet rs = pst.executeQuery();
                while (rs.next()) {

                    list.add(cart);
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
