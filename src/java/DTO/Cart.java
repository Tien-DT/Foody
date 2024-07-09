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
public class Cart {
    private int CartID;
    private int UserID;
    private int FoodID;
    private int ProductID;

    public Cart() {
    }

    public Cart(int CartID, int UserID, int FoodID, int ProductID) {
        this.CartID = CartID;
        this.UserID = UserID;
        this.FoodID = FoodID;
        this.ProductID = ProductID;
    }

    public int getCartID() {
        return CartID;
    }

    public void setCartID(int CartID) {
        this.CartID = CartID;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int UserID) {
        this.UserID = UserID;
    }

    public int getFoodID() {
        return FoodID;
    }

    public void setFoodID(int FoodID) {
        this.FoodID = FoodID;
    }

    public int getProductID() {
        return ProductID;
    }

    public void setProductID(int ProductID) {
        this.ProductID = ProductID;
    }

    
}

  
