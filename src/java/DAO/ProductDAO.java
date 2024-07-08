/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Product;
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
public class ProductDAO implements Serializable {

    public ArrayList<Product> getProductByFoodID(int foodID) {
        ArrayList<Product> list = new ArrayList<>();
        Connection cn = null;
        try {
            cn = DBUtil.makeConnection();
            if (cn != null) {
                String sql = "select * from dbo.FoodProduct fp\n"
                        + "INNER JOIN dbo.Product p ON fp.ProductID = p.ProductID\n"
                        + "where FoodID =?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, foodID);
                ResultSet rs = pst.executeQuery();
                if (rs != null) {
                    while (rs.next()) {
                        int productID = rs.getInt("ProductID");
                        String productName = rs.getNString("ProductName");
                        boolean productStatus = rs.getBoolean("ProductStatus");
                        int productPrice = rs.getInt("productPrice");

                        String productImage = rs.getString("ProductImage");
                        Product product = new Product(productID, productName, productStatus, productPrice, productImage);
                        list.add(product);
                    }
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
