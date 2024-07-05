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
public class MenuDetail {
        private String MenuID;
        private String MenuName;
        private String UserID;
        private String FoodID;
        private String FoodName;
        private boolean MenuStatus;      

    public MenuDetail() {
    }

    public MenuDetail(String MenuID, String MenuName, String UserID, String FoodID, String FoodName, boolean MenuStatus) {
        this.MenuID = MenuID;
        this.MenuName = MenuName;
        this.UserID = UserID;
        this.FoodID = FoodID;
        this.FoodName = FoodName;
        this.MenuStatus = MenuStatus;
    }

    public String getMenuID() {
        return MenuID;
    }

    public void setMenuID(String MenuID) {
        this.MenuID = MenuID;
    }

    public String getMenuName() {
        return MenuName;
    }

    public void setMenuName(String MenuName) {
        this.MenuName = MenuName;
    }

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String UserID) {
        this.UserID = UserID;
    }

    public String getFoodID() {
        return FoodID;
    }

    public void setFoodID(String FoodID) {
        this.FoodID = FoodID;
    }

    public String getFoodName() {
        return FoodName;
    }

    public void setFoodName(String FoodName) {
        this.FoodName = FoodName;
    }

    public boolean isMenuStatus() {
        return MenuStatus;
    }

    public void setMenuStatus(boolean MenuStatus) {
        this.MenuStatus = MenuStatus;
    }
        
        
}
