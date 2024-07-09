/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Cart;
import DTO.ItemCart;
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

    /*public ArrayList<HashMap<String, Object>> loadCart(int userID) {
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
    } */
    public int checkCart(int UID) {
        Connection cn = null;
        int CartID = 0;
        try {
            cn = DBUtil.makeConnection();
            if (cn != null) {
                String sql = "select * from dbo.Cart \n"
                        + "where UserID=? AND CartType='1'";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, UID);
                ResultSet rs = pst.executeQuery();
                while (rs.next()) {
                    int uid = rs.getInt("UserID");
                    CartID = rs.getInt("CartID");
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
        return CartID;
    }

    public int insertCart(int UID) {
        Connection cn = null;
        int check = 0;
        try {
            cn = DBUtil.makeConnection();
            if (cn != null) {
                String sql = "insert Cart(UserID,CartType) VALUES (?,'1')";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, UID);
                int affectedRows = pst.executeUpdate();
                if (affectedRows > 0) {
                    check = 1;
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

    public int insertFoodCart(int CartID, int foodID) {
        Connection cn = null;
        int check = 0;
        try {
            cn = DBUtil.makeConnection();
            if (cn != null) {
                String sql = "insert FoodCart(CartID,FoodID,Quantity) VALUES (?,?,'1')";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, CartID);
                pst.setInt(2, foodID);
                int affectedRows = pst.executeUpdate();
                if (affectedRows > 0) {
                    check = 1;
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

    public int checkFoodCart(int CartID, int foodID) {
        Connection cn = null;
        int quantity = 0;
        try {
            cn = DBUtil.makeConnection();
            if (cn != null) {
                String sql = "select CartID,FoodID, Quantity from dbo.FoodCart where FoodID=? AND CartID=?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, foodID);
                pst.setInt(2, CartID);
                ResultSet rs = pst.executeQuery();
                while (rs.next()) {
                    int cartID = rs.getInt("CartID");
                    int FoodID = rs.getInt("FoodID");
                    quantity = rs.getInt("Quantity");
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
        return quantity;
    }

    public int updateFoodQuantity(int CartID, int foodID, int quantityUpdate) {
        Connection cn = null;
        int check = 0;
        try {
            cn = DBUtil.makeConnection();
            if (cn != null) {
                String sql = "UPDATE FoodCart\n"
                        + "SET Quantity =? \n"
                        + "WHERE CartID=? AND FoodID =?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, quantityUpdate);
                pst.setInt(2, CartID);
                pst.setInt(3, foodID);
                int affectedRows = pst.executeUpdate();
                if (affectedRows > 0) {
                    check = 1;
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

    public ArrayList<ItemCart> getAllCart(int userID) {
        ArrayList<ItemCart> list = new ArrayList<>();
        String sql = "SELECT f.FoodName, f.FoodPrice, fc.Quantity, f.FoodImage "
                + "FROM dbo.Cart c "
                + "INNER JOIN dbo.FoodCart fc ON c.CartID = fc.CartID "
                + "INNER JOIN dbo.Food f ON fc.FoodID = f.FoodID "
                + "WHERE c.UserID =?";
        try (Connection cn = DBUtil.makeConnection();
                PreparedStatement pst = cn.prepareStatement(sql)) {
            pst.setInt(1, userID);
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    String itemName = rs.getNString("FoodName");
                    int itemPrice = rs.getInt("FoodPrice");
                    int itemQuantity = rs.getInt("Quantity");
                    String itemImage = rs.getString("FoodImage");
                    ItemCart item = new ItemCart(itemName, itemPrice, itemQuantity, itemImage);
                    list.add(item);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

}
