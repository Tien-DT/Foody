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
public class Menu {
    private String MenuID;
    private String FoodID;
    private String MenuDate;
    private String UserID;

    public Menu() {
    }

    public Menu(String MenuID, String FoodID, String MenuDate, String UserID) {
        this.MenuID = MenuID;
        this.FoodID = FoodID;
        this.MenuDate = MenuDate;
        this.UserID = UserID;
    }

    public String getMenuID() {
        return MenuID;
    }

    public void setMenuID(String MenuID) {
        this.MenuID = MenuID;
    }

    public String getFoodID() {
        return FoodID;
    }

    public void setFoodID(String FoodID) {
        this.FoodID = FoodID;
    }

    public String getMenuDate() {
        return MenuDate;
    }

    public void setMenuDate(String MenuDate) {
        this.MenuDate = MenuDate;
    }

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String UserID) {
        this.UserID = UserID;
    }
    
    
}
