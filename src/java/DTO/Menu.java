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

    private int menuID;
    private int foodID;
    private int menuDate;
    private int userID;
    private String menuName;
    private boolean menuStatus;

    public Menu() {
    }

    public Menu(int menuID, int foodID, int menuDate, int userID, String menuName, boolean menuStatus) {
        this.menuID = menuID;
        this.foodID = foodID;
        this.menuDate = menuDate;
        this.userID = userID;
        this.menuName = menuName;
        this.menuStatus = menuStatus;
    }

    public int getMenuID() {
        return menuID;
    }

    public void setMenuID(int menuID) {
        this.menuID = menuID;
    }

    public int getFoodID() {
        return foodID;
    }

    public void setFoodID(int foodID) {
        this.foodID = foodID;
    }

    public int getMenuDate() {
        return menuDate;
    }

    public void setMenuDate(int menuDate) {
        this.menuDate = menuDate;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public boolean isMenuStatus() {
        return menuStatus;
    }

    public void setMenuStatus(boolean menuStatus) {
        this.menuStatus = menuStatus;
    }
}
