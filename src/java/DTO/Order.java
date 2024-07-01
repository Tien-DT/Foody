/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author USER
 */
public class Order {
    private String OrderID;
    private String OrderDate;
    private Byte OrderStatus;
    private int OrderTotalPrice;
    private String UserID;
    private int FoodPrice;

    public Order() {
    }

    public Order(String OrderID, String OrderDate, Byte OrderStatus, int OrderTotalPrice, String UserID, int FoodPrice) {
        this.OrderID = OrderID;
        this.OrderDate = OrderDate;
        this.OrderStatus = OrderStatus;
        this.OrderTotalPrice = OrderTotalPrice;
        this.UserID = UserID;
        this.FoodPrice = FoodPrice;
    }

    public String getOrderID() {
        return OrderID;
    }

    public void setOrderID(String OrderID) {
        this.OrderID = OrderID;
    }

    public String getOrderDate() {
        return OrderDate;
    }

    public void setOrderDate(String OrderDate) {
        this.OrderDate = OrderDate;
    }

    public Byte getOrderStatus() {
        return OrderStatus;
    }

    public void setOrderStatus(Byte OrderStatus) {
        this.OrderStatus = OrderStatus;
    }

    public int getOrderTotalPrice() {
        return OrderTotalPrice;
    }

    public void setOrderTotalPrice(int OrderTotalPrice) {
        this.OrderTotalPrice = OrderTotalPrice;
    }

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String UserID) {
        this.UserID = UserID;
    }

    public int getFoodPrice() {
        return FoodPrice;
    }

    public void setFoodPrice(int FoodPrice) {
        this.FoodPrice = FoodPrice;
    }
            
}
