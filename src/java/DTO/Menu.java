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
    private String menuID;
    private String foodID;
    private String menuDate;
    private String userID;
    private String menuName;
    private boolean menuStatus;

    public Menu() {
    }

    public Menu(String menuID, String foodID, String menuDate, String userID, String menuName, boolean menuStatus) {
        this.menuID = menuID;
        this.foodID = foodID;
        this.menuDate = menuDate;
        this.userID = userID;
        this.menuName = menuName;
        this.menuStatus = menuStatus;
    }

    public String getmenuID() {
        return menuID;
    }

    public void setmenuID(String menuID) {
        this.menuID = menuID;
    }

    public String getMenuID() {
        return menuID;
    }

    public void setMenuID(String menuID) {
        this.menuID = menuID;
    }

    public String getFoodID() {
        return foodID;
    }

    public void setFoodID(String foodID) {
        this.foodID = foodID;
    }

    public String getMenuDate() {
        return menuDate;
    }

    public void setMenuDate(String menuDate) {
        this.menuDate = menuDate;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getfoodID() {
        return foodID;
    }

    public void setfoodID(String foodID) {
        this.foodID = foodID;
    }

    public String getmenuDate() {
        return menuDate;
    }

    public void setmenuDate(String menuDate) {
        this.menuDate = menuDate;
    }

    public String getuserID() {
        return userID;
    }

    public void setuserID(String userID) {
        this.userID = userID;
    }

    public boolean isMenuStatus() {
        return menuStatus;
    }

    public void setMenuStatus(boolean menuStatus) {
        this.menuStatus = menuStatus;
    }
    
    
}
