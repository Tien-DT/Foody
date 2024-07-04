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
    private String orderID;
    private String orderDate;
    private Byte orderStatus;
    private int orderTotalPrice;
    private String userID;
    private int foodPrice;

    public Order() {
    }

    public Order(String orderID, String orderDate, Byte orderStatus, int orderTotalPrice, String userID, int foodPrice) {
        this.orderID = orderID;
        this.orderDate = orderDate;
        this.orderStatus = orderStatus;
        this.orderTotalPrice = orderTotalPrice;
        this.userID = userID;
        this.foodPrice = foodPrice;
    }

    public String getorderID() {
        return orderID;
    }

    public void setorderID(String orderID) {
        this.orderID = orderID;
    }

    public String getorderDate() {
        return orderDate;
    }

    public void setorderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public Byte getorderStatus() {
        return orderStatus;
    }

    public void setorderStatus(Byte orderStatus) {
        this.orderStatus = orderStatus;
    }

    public int getorderTotalPrice() {
        return orderTotalPrice;
    }

    public void setorderTotalPrice(int orderTotalPrice) {
        this.orderTotalPrice = orderTotalPrice;
    }

    public String getuserID() {
        return userID;
    }

    public void setuserID(String userID) {
        this.userID = userID;
    }

    public int getfoodPrice() {
        return foodPrice;
    }

    public void setfoodPrice(int foodPrice) {
        this.foodPrice = foodPrice;
    }
            
}
