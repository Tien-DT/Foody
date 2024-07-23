/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Order;
import MyLib.DBUtil;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class OrderDAO implements Serializable {

    public String insertNewOrder(int userID, String OrderDetail, String OrderPhone, String OrderAddress) {
        Connection cn = null;
        String result = null;
        try {
            cn = DBUtil.makeConnection();
            if (cn != null) {
                cn.setAutoCommit(false);

                String sql = "INSERT dbo.[Order](OrderDate,OrderStatus,OrderDetail,UserID,OrderPhone,OrderAddress)\n"
                        + "VALUES(GETDATE(),'1',?,?,?,?)";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setNString(1, OrderDetail);
                pst.setInt(2, userID);
                pst.setString(3, OrderPhone);
                pst.setNString(4, OrderAddress);

                int affectedRows = pst.executeUpdate();

                if (affectedRows > 0) {

                    cn.commit();
                    result = "Insert successful";
                } else {

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

    public ArrayList<Order> getUserOrder(int userID) {
        ArrayList<Order> list = new ArrayList<>();
        Connection cn = null;
        try {
            cn = DBUtil.makeConnection();
            if (cn != null) {
                String sql = "select * from dbo.[Order]\n"
                        + "where UserID=? ";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, userID);
                ResultSet rs = pst.executeQuery();
                while (rs.next()) {
                    int OrderID = rs.getInt("OrderID");
                    Timestamp OrderDate = rs.getTimestamp("OrderDate");
                    int OrderStatus = rs.getInt("OrderStatus");
                    String OrderDetail = rs.getNString("OrderDetail");
                    int UserID = rs.getInt("UserID");
                    String OrderPhone = rs.getString("OrderPhone");
                    String OrderAddress = rs.getNString("OrderAddress");
                    Order order = new Order(OrderID, OrderDate, OrderStatus, OrderDetail, UserID, OrderPhone, OrderAddress);
                    list.add(order);
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

    public ArrayList<Order> getAllUserOrder() {
        ArrayList<Order> list = new ArrayList<>();
        Connection cn = null;
        try {
            cn = DBUtil.makeConnection();
            if (cn != null) {
                String sql = "select * from dbo.[Order]";
                PreparedStatement pst = cn.prepareStatement(sql);
                ResultSet rs = pst.executeQuery();
                while (rs.next()) {
                    int OrderID = rs.getInt("OrderID");
                    Timestamp OrderDate = rs.getTimestamp("OrderDate");
                    int OrderStatus = rs.getInt("OrderStatus");
                    String OrderDetail = rs.getNString("OrderDetail");
                    int UserID = rs.getInt("UserID");
                    String OrderPhone = rs.getString("OrderPhone");
                    String OrderAddress = rs.getNString("OrderAddress");
                    Order order = new Order(OrderID, OrderDate, OrderStatus, OrderDetail, UserID, OrderPhone, OrderAddress);
                    list.add(order);
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

    public void updateStatusOrder(int orderStatus, int orderID) {
        Connection cn = null;
        try {
            cn = DBUtil.makeConnection();
            if (cn != null) {
                String sql = "UPDATE [Order]\n"
                        + "SET OrderStatus =? \n"
                        + "WHERE OrderID=?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, orderStatus);
                pst.setInt(2, orderID);
                int affectedRows = pst.executeUpdate();
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

    public void cancelOrder(int orderIDCancel) {
        Connection cn = null;

        int uid = 0;
        try {
            cn = DBUtil.makeConnection();
            if (cn != null) {
                String sql = "DELETE FROM dbo.[Order] WHERE OrderID =? ";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, orderIDCancel);
                int affectedRows = pst.executeUpdate();
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

    public ArrayList<Order> searchOrder(String searchOrder) {
        ArrayList<Order> list = new ArrayList<>();
        Connection cn = null;
        try {
            cn = DBUtil.makeConnection();
            if (cn != null) {
                String sql = "SELECT o.OrderID,o.OrderDate,o.OrderStatus,o.OrderDetail,o.UserID,o.OrderPhone,o.OrderAddress \n"
                        + "FROM dbo.[Order] o\n"
                        + "INNER JOIN  dbo.[User] u ON u.UserID = o.UserID\n"
                        + "WHERE o.OrderID LIKE ? OR o.OrderPhone LIKE ? OR o.OrderAddress LIKE ? OR u.Email LIKE ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                String search = "%" + searchOrder + "%";
                pst.setNString(1, search);
                pst.setNString(2, search);
                pst.setNString(3, search);
                pst.setNString(4, search);
                ResultSet rs = pst.executeQuery();
                while (rs.next()) {
                    int OrderID = rs.getInt("OrderID");
                    Timestamp OrderDate = rs.getTimestamp("OrderDate");
                    int OrderStatus = rs.getInt("OrderStatus");
                    String OrderDetail = rs.getNString("OrderDetail");
                    int UserID = rs.getInt("UserID");
                    String OrderPhone = rs.getString("OrderPhone");
                    String OrderAddress = rs.getNString("OrderAddress");
                    Order order = new Order(OrderID, OrderDate, OrderStatus, OrderDetail, UserID, OrderPhone, OrderAddress);
                    list.add(order);
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
