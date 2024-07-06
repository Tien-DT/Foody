package DAO;

import DTO.Food;
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
public class FoodDAO implements Serializable{

    public ArrayList<Food> getAllFood() {
        ArrayList<Food> list = new ArrayList<>();
        Connection cn = null;
        try {
            cn = DBUtil.makeConnection();
            if (cn != null) {
                String sql = "select * from dbo.Food";
                PreparedStatement pst = cn.prepareStatement(sql);
                ResultSet rs = pst.executeQuery();
                while (rs.next()) {
                    int FoodID = rs.getInt("FoodID");
                    String FoodName = rs.getString("FoodName");
                    boolean FoodStatus = rs.getBoolean("FoodStatus");
                    int ProductID = rs.getInt("ProductID");
                    String FoodStep = rs.getString("FoodStep");
                    int FoodPrice = rs.getInt("FoodPrice");
                    String FoodImage = rs.getString("FoodImage");
                    Food food = new Food(FoodID, FoodName, FoodStatus, ProductID, FoodStep, FoodPrice, FoodImage);
                    list.add(food);
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
