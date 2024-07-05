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

    private int menuID;
    private String menuName;
    private int userID;
    private int foodID;
    private String foodName;
    private boolean menuStatus;

    public MenuDetail() {
    }

    public MenuDetail(int menuID, String menuName, int userID, int foodID, String foodName, boolean menuStatus) {
        this.menuID = menuID;
        this.menuName = menuName;
        this.userID = userID;
        this.foodID = foodID;
        this.foodName = foodName;
        this.menuStatus = menuStatus;
    }

    public int getMenuID() {
        return menuID;
    }

    public void setMenuID(int menuID) {
        this.menuID = menuID;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getFoodID() {
        return foodID;
    }

    public void setFoodID(int foodID) {
        this.foodID = foodID;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public boolean isMenuStatus() {
        return menuStatus;
    }

    public void setMenuStatus(boolean menuStatus) {
        this.menuStatus = menuStatus;
    }
}
