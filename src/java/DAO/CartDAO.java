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

    public int checkCart(int UID, int foodID) {
        Connection cn = null;
        int CartID = 0;
        try {
            cn = DBUtil.makeConnection();
            if (cn != null) {
                String sql = "select * from dbo.Cart \n"
                        + "where UserID=? AND FoodID=?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, UID);
                pst.setInt(2, foodID);
                ResultSet rs = pst.executeQuery();
                while (rs.next()) {
                    CartID = rs.getInt("CartID");
                    int uid = rs.getInt("UserID");

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

    public int insertCart(int UID, int foodID) {
        Connection cn = null;
        int check = 0;
        try {
            cn = DBUtil.makeConnection();
            if (cn != null) {
                String sql = "insert Cart(UserID,FoodID,Quantity) VALUES (?,?,'1')";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, UID);
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

    public int checkFoodCart(int UID, int foodID) {
        Connection cn = null;
        int quantity = 0;
        try {
            cn = DBUtil.makeConnection();
            if (cn != null) {
                String sql = "select CartID,FoodID, Quantity from dbo.Cart where FoodID=? AND UserID=?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, foodID);
                pst.setInt(2, UID);
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

    public int updateFoodQuantity(int UID, int foodID, int quantityUpdate) {
        Connection cn = null;
        int check = 0;
        try {
            cn = DBUtil.makeConnection();
            if (cn != null) {
                String sql = "UPDATE Cart\n"
                        + "SET Quantity =? \n"
                        + "WHERE UserID=? AND FoodID =?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, quantityUpdate);
                pst.setInt(2, UID);
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
        String sql = "SELECT c.CartID, f.FoodName, f.FoodPrice, c.Quantity, f.FoodImage \n"
                + "FROM dbo.Cart c \n"
                + "INNER JOIN dbo.Food f ON c.FoodID = f.FoodID \n"
                + "WHERE c.UserID =?";
        try (Connection cn = DBUtil.makeConnection();
                PreparedStatement pst = cn.prepareStatement(sql)) {
            pst.setInt(1, userID);
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    int CartID = rs.getInt("CartID");
                    String itemName = rs.getNString("FoodName");
                    int itemPrice = rs.getInt("FoodPrice");
                    int itemQuantity = rs.getInt("Quantity");
                    String itemImage = rs.getString("FoodImage");
                    ItemCart item = new ItemCart(CartID, itemName, itemPrice, itemQuantity, itemImage);
                    list.add(item);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void deleteCart(int cartID) {
        Connection cn = null;

        try {
            cn = DBUtil.makeConnection();
            if (cn != null) {
                String sql = "DELETE FROM dbo.Cart WHERE CartID=?";
                PreparedStatement pst = cn.prepareStatement(sql);

                pst.setInt(1, cartID);

                ResultSet rs = pst.executeQuery();
                while (rs.next()) {

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

    }

    public void deleteUserCart(int userID) {
        Connection cn = null;

        try {
            cn = DBUtil.makeConnection();
            if (cn != null) {
                String sql = "DELETE FROM dbo.Cart WHERE userID=?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, userID);
                pst.executeQuery();
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

    }

}
