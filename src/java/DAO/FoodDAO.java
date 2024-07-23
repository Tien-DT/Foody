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
public class FoodDAO implements Serializable {

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
                    String FoodStep = rs.getString("FoodStep");
                    int FoodPrice = rs.getInt("FoodPrice");
                    String FoodImage = rs.getString("FoodImage");
                    Food food = new Food(FoodID, FoodName, FoodStatus, FoodStep, FoodPrice, FoodImage);
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

    public ArrayList<Food> getFoodByID(int foodID) {
        ArrayList<Food> list = new ArrayList<>();
        Connection cn = null;
        try {
            cn = DBUtil.makeConnection();
            if (cn != null) {
                String sql = "select * \n"
                        + "from dbo.Food\n"
                        + "where FoodID =?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, foodID);
                ResultSet rs = pst.executeQuery();
                if (rs != null) {
                    while (rs.next()) {
                        int FoodID = rs.getInt("FoodID");
                        String FoodName = rs.getNString("FoodName");
                        boolean FoodStatus = rs.getBoolean("FoodStatus");
                        String FoodStep = rs.getNString("FoodStep");
                        int FoodPrice = rs.getInt("FoodPrice");

                        String FoodImage = rs.getString("FoodImage");
                        Food food = new Food(FoodID, FoodName, FoodStatus, FoodStep, FoodPrice, FoodImage);
                        list.add(food);

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

    public boolean insertFoodList(String foodName, String foodStep, int foodPrice, String foodImage) {
        Connection cn = null;
        boolean check = false;
        try {
            cn = DBUtil.makeConnection();
            if (cn != null) {
                cn.setAutoCommit(false);

                String sql = "INSERT INTO Food (FoodName,FoodStatus,FoodStep,FoodPrice,FoodImage) VALUES (?, '1', ?, ?, ?)";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setNString(1, foodName);
                pst.setNString(2, foodStep);
                pst.setInt(3, foodPrice);
                pst.setString(4, foodImage);
                int affectedRows = pst.executeUpdate();
                if (affectedRows > 0) {
                    cn.commit();
                    check = true;
                } else {
                    cn.rollback();
                    check = false;
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

    public boolean deleteFoodByID(int foodID) {
        Connection cn = null;
        boolean check = false;

        try {
            cn = DBUtil.makeConnection();
            if (cn != null) {
                String sql = "UPDATE dbo.Food SET FoodStatus='0' WHERE FoodID =?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, foodID);
                int rowsAffected = pst.executeUpdate();
                if (rowsAffected > 0) {
                    check = true;
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

    public boolean enableFoodByID(int foodIDEnable) {
        Connection cn = null;
        boolean check = false;

        try {
            cn = DBUtil.makeConnection();
            if (cn != null) {
                String sql = "UPDATE dbo.Food SET FoodStatus='1' WHERE FoodID =?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, foodIDEnable);
                int rowsAffected = pst.executeUpdate();
                if (rowsAffected > 0) {
                    check = true;
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

    public Food updateFood(int foodIDUpdate) {
        Food foodUpdate = null;
        Connection cn = null;
        try {
            cn = DBUtil.makeConnection();
            if (cn != null) {
                String sql = "select * from dbo.Food where FoodID=?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, foodIDUpdate);
                ResultSet rs = pst.executeQuery();
                while (rs.next()) {
                    int FoodID = rs.getInt("FoodID");
                    String FoodName = rs.getString("FoodName");
                    boolean FoodStatus = rs.getBoolean("FoodStatus");
                    String FoodStep = rs.getString("FoodStep");
                    int FoodPrice = rs.getInt("FoodPrice");
                    String FoodImage = rs.getString("FoodImage");
                    foodUpdate = new Food();
                    foodUpdate.setFoodID(FoodID);
                    foodUpdate.setFoodName(FoodName);
                    foodUpdate.setFoodStatus(FoodStatus);
                    foodUpdate.setFoodStep(FoodStep);
                    foodUpdate.setFoodPrice(FoodPrice);
                    foodUpdate.setFoodImage(FoodImage);
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
        return foodUpdate;
    }
    
    public boolean updateInfoFood(String foodNameUpdate, String foodStepUpdate, int foodPriceUpdate, String foodImageUpdate, int foodIDUpdateNow) {
        Connection cn = null;
        boolean check = false;
        try {
            cn = DBUtil.makeConnection();
            if (cn != null) {
                cn.setAutoCommit(false);

                String sql = "UPDATE dbo.Food SET FoodName=?,FoodStep=?,FoodPrice=?,FoodImage=? WHERE FoodID =?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setNString(1, foodNameUpdate);
                pst.setNString(2, foodStepUpdate);
                pst.setInt(3, foodPriceUpdate);
                pst.setString(4, foodImageUpdate);
                pst.setInt(5, foodIDUpdateNow);
                int affectedRows = pst.executeUpdate();
                if (affectedRows > 0) {
                    cn.commit();
                    check = true;
                } else {
                    cn.rollback();
                    check = false;
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

}
